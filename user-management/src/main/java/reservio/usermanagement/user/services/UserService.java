package reservio.usermanagement.user.services;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reservio.common.enums.Status;
import reservio.common.exceptions.UnAuthorizedException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.LoginFormInfo;
import reservio.common.models.response.LoginResponse;
import reservio.common.models.response.UserCreateUpdateResponse;
import reservio.common.util.JwtUtils;
import reservio.usermanagement.user.dao.UserRepository;
import reservio.usermanagement.user.entity.User;
import reservio.usermanagement.user.models.UserCreateUpdateFormInfo;

import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapperHelper modelMapperHelper;
    private final JwtUtils jwtUtils;
    public UserCreateUpdateResponse createUser(final UserCreateUpdateFormInfo formInfo) throws UnsupportedEncodingException {
        log.info("User registration started. Form Info: {}",formInfo);
        final User user = this.modelMapperHelper.map(formInfo,User.class);
        user.setHash(DigestUtils.sha256Hex(formInfo.getPassword()));
        user.setStatus(Status.IN_PROGRESS);
        UserCreateUpdateResponse response = this.modelMapperHelper.map(this.userRepository.save(user),UserCreateUpdateResponse.class);

        final String rolesAsString = response.getRoles().stream().map(Enum::toString).collect(Collectors.joining(","));
        response.setToken(jwtUtils.createTokenWithDuration(response.getId(),response.getUsername(),response.getEmail(),rolesAsString,"","",30));
        response.setRefreshToken(jwtUtils.createTokenWithDuration(response.getId(),response.getUsername(),response.getEmail(),rolesAsString,"","",30));
        return response;
    }

    public LoginResponse login(@NonNull final LoginFormInfo formInfo) throws UnsupportedEncodingException {
        final User user = this.userRepository.findByUsernameOrEmail(formInfo.getEmailOrUsername());

        if(!DigestUtils.sha256Hex(formInfo.getPassword()).equals(user.getHash())) throw new UnAuthorizedException("Password is incorrect!!");
        final String rolesAsString = user.getRoles().stream().map(Enum::toString).collect(Collectors.joining(","));

        return LoginResponse.builder()
                .token(jwtUtils.createTokenWithDuration(user.getId(),user.getUsername(),user.getEmail(),rolesAsString,"","",30))
                .refreshToken(jwtUtils.createTokenWithDuration(user.getId(),user.getUsername(),user.getEmail(),rolesAsString,"","",30))
                .tokenType("Bearer")
                .build();
    }
    private void validateRegistration(final UserCreateUpdateFormInfo formInfo){

    }
}
