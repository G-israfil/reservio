package reservio.accountmanagement.account.service;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reservio.accountmanagement.account.dao.AccountRepository;
import reservio.accountmanagement.account.entitiy.Account;
import reservio.accountmanagement.account.messaging.MessageReceiver;
import reservio.accountmanagement.account.messaging.MessageService;
import reservio.common.contant.Contants;
import reservio.common.contant.RelatedEntityName;
import reservio.common.contant.RelatedEntityTypes;
import reservio.common.enums.AccountType;
import reservio.common.enums.Status;
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
@Transactional
public class AccountService {
    private final AccountRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    private final MessageService messageService;
    public AccountCreateUpdateResponse createAccount(@NonNull final CreateUpdateAccountFormInfo formInfo){
        final Account account = modelMapperHelper.map(formInfo, Account.class);
        if (StringUtils.isBlank(account.getType().toString())) {
            account.setType(AccountType.USER_ACCOUNT);
        }
        RelatedEntity userRelatedEntity = CommonUtils.generateRelatedEntity(RelatedEntityName.USER,formInfo.getUserId(), RelatedEntityTypes.USER);
        account.setOwners(Collections.singletonList(userRelatedEntity));
        RelatedEntity paymentMethod = CommonUtils.generateRelatedEntity(RelatedEntityName.DEFAULT_PAYMENT_METHOD,formInfo.getPaymentMethodId(), RelatedEntityTypes.PAYMENT_METHOD);
        account.setPaymentMethods(Collections.singletonList(paymentMethod));
        final Account craetedAccount = repository.save(account);
        messageService.sendAccountCreatedMessage(account.getId());

        return modelMapperHelper.map(craetedAccount,AccountCreateUpdateResponse.class);
    }

    public AccountCreateUpdateResponse getAccount(@NonNull final Long id){
        final Account account = repository.findById(id).orElseThrow(() -> new NotFoundException(Contants.ERROR_MESSAGES.ACCOUNT_NOT_FOUND + id));
        return modelMapperHelper.map(account,AccountCreateUpdateResponse.class);
    }

    public AccountCreateUpdateResponse updateAccount(@NonNull Long id,@NonNull final CreateUpdateAccountFormInfo formInfo){
        return new AccountCreateUpdateResponse();
    }

    public void deleteAccount(@NonNull final Long id){
        repository.deleteById(id);
    }

    public AccountCreateUpdateResponse handleActivateAndDeactivateAccount(@NonNull final Long id,@NonNull final Status status){
        final Optional<Account> optionalAccount = repository.findById(id);
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
