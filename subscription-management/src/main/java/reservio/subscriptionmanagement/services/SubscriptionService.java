package reservio.subscriptionmanagement.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reservio.common.enums.TERMS;
import reservio.common.enums.STATUS;
import reservio.common.exceptions.NotFoundException;
import reservio.common.models.request.CreateUpdateSubscriptionFormInfo;
import reservio.subscriptionmanagement.entity.Subscription;
import reservio.subscriptionmanagement.dao.SubscriptionRepository;
import reservio.common.mappers.ModelMapperHelper;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {
    private final SubscriptionRepository repository;
    private final ModelMapperHelper modelMapperHelper;

    public Subscription createSubscription(@NonNull @RequestBody final CreateUpdateSubscriptionFormInfo formInfo) {
        final Subscription subscription = modelMapperHelper.map(formInfo, Subscription.class);
        subscription.setStatus(STATUS.ACTIVE);
        return this.repository.save(subscription);
    }

    public Subscription updateSubscription(@NonNull final Long id, @NonNull @RequestBody final CreateUpdateSubscriptionFormInfo formInfo) {
        final Optional<Subscription> optionalSubscription = this.repository.findById(id);
        if (optionalSubscription.isPresent()) {
            final Subscription subscription = optionalSubscription.get();
            subscription.setName(formInfo.getName());
            subscription.setDescription(formInfo.getDescription());
            return this.repository.save(subscription);
        }

        throw new NotFoundException("Subscription not found with given id: " + id);
    }


    public void deleteSubscription(@PathVariable @NonNull final Long id) {
        final Optional<Subscription> optionalSubscription = this.repository.findById(Long.parseLong(String.valueOf(id)));
        if (optionalSubscription.isPresent()) {
            this.repository.deleteById(Long.parseLong(String.valueOf(id)));
            return;
        }  {
            throw new NotFoundException("Subscription not found with given id: " + id);
        }
    }

    public void activateSubscription(@NonNull Long id) {
        final Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));
        subscription.setStatus(STATUS.ACTIVE);
        repository.save(subscription);
    }
    public Subscription getSubscription(@NonNull Long id) {
        final Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        return subscription;
    }

    public void deactivateSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        subscription.setStatus(STATUS.DEACTIVATED);
        repository.save(subscription);
    }

    public void suspendSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        subscription.setStatus(STATUS.SUSPENDED);
        repository.save(subscription);
    }

    public void resumeSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        subscription.setStatus(STATUS.ACTIVE);
        repository.save(subscription);
    }

    public void renewSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));
        final Long duration = subscription.getPeriod().getDuration();
        final TERMS term = subscription.getPeriod().getTerm();
        subscription.setExpectedExpiryDate(getExpectedExpireDate(term,duration,subscription.getExpectedExpiryDate()));
            repository.save(subscription);
    }

    private LocalDateTime getExpectedExpireDate(final TERMS term,final Long duration,final LocalDateTime expectedExpireDate){

        switch (term){
            case DAILY -> {
                return expectedExpireDate.plusDays(duration);
            }
            case WEEKLY -> {
                return expectedExpireDate.plusWeeks(duration);
            }
            case MONTHLY -> {
                return expectedExpireDate.plusMonths(duration);
            }
            case YEARLY -> {
                return expectedExpireDate.plusYears(duration);
            }
        }

        throw new NotFoundException("Term is not proper to our criteria acceptable!!!");
    }
}
