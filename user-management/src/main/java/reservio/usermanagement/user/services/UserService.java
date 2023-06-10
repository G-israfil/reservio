package reservio.usermanagement.user.services;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reservio.common.enums.Status;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.LoginFormInfo;
import reservio.common.models.response.LoginResponse;
import reservio.common.models.response.UserCreateUpdateResponse;
import reservio.usermanagement.user.dao.UserRepository;
import reservio.usermanagement.user.entity.User;
import reservio.usermanagement.user.models.UserCreateUpdateFormInfo;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapperHelper modelMapperHelper;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserCreateUpdateResponse createUser(final UserCreateUpdateFormInfo formInfo){
        log.info("User registration started. Form Info: {}",formInfo);
        final User user = this.modelMapperHelper.map(formInfo,User.class);
//        user.setRoles(formInfo.getRoles());
        user.setHash(passwordEncoder.encode(formInfo.getPassword()));
        user.setStatus(Status.IN_PROGRESS);
        UserCreateUpdateResponse response = this.modelMapperHelper.map(this.userRepository.save(user),UserCreateUpdateResponse.class);
        return response;
    }

    public LoginResponse login(@NonNull final LoginFormInfo formInfo){
        User user = this.userRepository.findByUsernameOrEmail(formInfo.getEmailOrUsername());

        return new LoginResponse("israfil","israil","israfil","israifl");
    }
    private void validateRegistration(final UserCreateUpdateFormInfo formInfo){

    }
}
