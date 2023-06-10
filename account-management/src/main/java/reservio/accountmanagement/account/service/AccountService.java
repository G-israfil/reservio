package reservio.accountmanagement.account.service;

import io.micrometer.common.util.StringUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import reservio.accountmanagement.account.dao.AccountRepository;
import reservio.accountmanagement.account.entitiy.Account;
import reservio.common.contant.RelatedEntityName;
import reservio.common.contant.RelatedEntityTypes;
import reservio.common.enums.ACCOUNT_TYPE;
import reservio.common.enums.STATUS;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.embeddable.RelatedEntity;
import reservio.common.models.request.CreateUpdateAccountFormInfo;
import reservio.common.models.response.AccountCreateUpdateResponse;
import reservio.common.util.CommonUtils;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@ComponentScan({"reservio.accountmanagement","reservio.common"})
public class AccountService {
    private final AccountRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    public AccountCreateUpdateResponse createAccount(@NonNull final CreateUpdateAccountFormInfo formInfo){
        final Account account = modelMapperHelper.map(formInfo, Account.class);
        if (StringUtils.isBlank(account.getType().toString())) {
            account.setType(ACCOUNT_TYPE.USER_ACCOUNT);
        }
        RelatedEntity userRelatedEntity = CommonUtils.generateRelatedEntity(RelatedEntityName.USER,formInfo.getUserId(), RelatedEntityTypes.USER);
        account.setOwners(Collections.singletonList(userRelatedEntity));
        RelatedEntity paymentMethod = CommonUtils.generateRelatedEntity(RelatedEntityName.DEFAULT_PAYMENT_METHOD,formInfo.getPaymentMethodId(), RelatedEntityTypes.PAYMENT_METHOD);
        account.setPaymentMethods(Collections.singletonList(paymentMethod));

        return modelMapperHelper.map(repository.save(account),AccountCreateUpdateResponse.class);
    }

    public AccountCreateUpdateResponse getAccount(@NonNull final String id){
        final Optional<Account> optionalAccount = repository.findById(Long.parseLong(id));
        if (optionalAccount.isPresent()) return modelMapperHelper.map(optionalAccount.get(),AccountCreateUpdateResponse.class);
        throw new  NotFoundException("User not found with given id: " + id);
    }

    public AccountCreateUpdateResponse updateAccount(@NonNull final CreateUpdateAccountFormInfo formInfo){
        return new AccountCreateUpdateResponse();
    }

    public void deleteAccount(@NonNull final String id){
        repository.deleteById(Long.parseLong(id));
    }

    public AccountCreateUpdateResponse handleActivateAndDeactivateAccount(@NonNull final String id,@NonNull final STATUS status){
        final Optional<Account> optionalAccount = repository.findById(Long.parseLong(id));
        if (optionalAccount.isPresent()){
            optionalAccount.get().setStatus(status);
            return modelMapperHelper.map(optionalAccount.get(),AccountCreateUpdateResponse.class);
        }
        throw new  NotFoundException("User not found with given id: " + id);
    }

    public void suspendAccount(@NonNull final String id){

    }

    public void resumeAccount(@NonNull final String id){

    }
    public void activateAccount(@NonNull final String id){

    }
}
