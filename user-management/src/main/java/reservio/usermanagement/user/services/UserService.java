package reservio.usermanagement.user.services;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reservio.common.clients.RestaurantManagementClientService;
import reservio.common.enums.Status;
import reservio.common.exceptions.NotFoundException;
import reservio.common.exceptions.UnAuthorizedException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.LoginFormInfo;
import reservio.common.models.response.LoginResponse;
import reservio.common.models.response.UserCreateUpdateResponse;
import reservio.common.util.JwtUtils;
import reservio.usermanagement.messaging.MessageService;
import reservio.usermanagement.user.dao.UserRepository;
import reservio.usermanagement.user.entity.User;
import reservio.usermanagement.user.models.UserCreateUpdateFormInfo;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.servlet.RequestDispatcher.ERROR_MESSAGE;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapperHelper modelMapperHelper;
    private final MessageService messageService;
    private final RestaurantManagementClientService restaurantManagementClientService;
    private final JwtUtils jwtUtils;
    public UserCreateUpdateResponse createUser(final UserCreateUpdateFormInfo formInfo) throws UnsupportedEncodingException {
        log.info("User registration started. Form Info: {}",formInfo);
        final User user = this.modelMapperHelper.map(formInfo,User.class);
        user.setHash(DigestUtils.sha256Hex(formInfo.getPassword()));
        user.setStatus(Status.IN_PROGRESS);
        UserCreateUpdateResponse response = this.modelMapperHelper.map(this.userRepository.save(user),UserCreateUpdateResponse.class);
        messageService.sendUserCreatedMessage(response.getId(),response.getStatus());
        final String rolesAsString = response.getRoles().stream().map(Enum::toString).collect(Collectors.joining(","));
        response.setToken(jwtUtils.createTokenWithDuration(response.getId(),response.getUsername(),response.getEmail(),rolesAsString,"","",30));
        response.setRefreshToken(jwtUtils.createTokenWithDuration(response.getId(),response.getUsername(),response.getEmail(),rolesAsString,"","",30));
        return response;
    }

    public LoginResponse login(@NonNull final LoginFormInfo formInfo) throws UnsupportedEncodingException {
        final User user = this.userRepository.findByUsernameOrEmail(formInfo.getEmailOrUsername());

        if(!DigestUtils.sha256Hex(formInfo.getPassword()).equals(user.getHash())) throw new UnAuthorizedException("Password is incorrect!!");
        final String rolesAsString = user.getRoles().stream().map(Enum::toString).collect(Collectors.joining(","));
        String restaurantsAsString = "";
        try {
            final List<Long> relatedRestaurantIds = this.restaurantManagementClientService.getRestaurantByUserId(user.getId());

            if (!ObjectUtils.isEmpty(relatedRestaurantIds)) {
                List<String> stringIds = relatedRestaurantIds.stream()
                        .map(Object::toString)
                        .collect(Collectors.toList());
                restaurantsAsString = String.join(",", stringIds);
            }
        }catch (Exception e){
            log.info("Failed to get restaurants");
        }


        log.info("After the conversion");
        return LoginResponse.builder()
                .token(jwtUtils.createTokenWithDuration(user.getId(),user.getUsername(),user.getEmail(),rolesAsString,restaurantsAsString,"",30))
                .refreshToken(jwtUtils.createTokenWithDuration(user.getId(),user.getUsername(),user.getEmail(),rolesAsString,restaurantsAsString,"",30))
                .tokenType("Bearer")
                .build();
    }

    public UserCreateUpdateResponse updateUser(@NonNull final UserCreateUpdateFormInfo formInfo,@NonNull Long id){
        final User user = this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        if (!StringUtils.isEmpty(formInfo.getEmail())) user.setEmail(formInfo.getEmail());
        if(!StringUtils.isEmpty(formInfo.getPassword())) user.setHash(DigestUtils.sha256Hex(formInfo.getPassword()));
        if(!StringUtils.isEmpty(formInfo.getName())) user.setName(formInfo.getName());
        if(!StringUtils.isEmpty(formInfo.getUsername())) user.setLastname(formInfo.getLastname());
        if(!ObjectUtils.isEmpty(formInfo.getRoles())) user.setRoles(formInfo.getRoles());
        return this.modelMapperHelper.map(this.userRepository.save(user),UserCreateUpdateResponse.class);
    }


    public void deleteUser(@NonNull Long id){
        try {
            this.userRepository.deleteById(id);
        }catch (Exception e){
            log.info("Error occurred while trying to delete user.. " + e.getMessage());
        }
    }
    private void validateRegistration(final UserCreateUpdateFormInfo formInfo){

    }
}
