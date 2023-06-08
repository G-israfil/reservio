package reservio.subscriptionmanagement.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reservio.common.exceptions.NotFoundException;
import reservio.common.models.request.CreateUpdateSubscriptionFormInfo;
import reservio.subscriptionmanagement.model.Subscription;
import reservio.subscriptionmanagement.dao.SubscriptionRepository;
import reservio.common.mappers.ModelMapperHelper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {
    private final SubscriptionRepository repository;
    private final ModelMapperHelper modelMapperHelper;

    public Subscription createSubscription(@NonNull @RequestBody final CreateUpdateSubscriptionFormInfo formInfo) {
        final Subscription subscription = modelMapperHelper.map(formInfo, Subscription.class);
        return this.repository.save(subscription);
    }

    public Subscription updateSubscription(@NonNull final Long id, @NonNull @RequestBody final CreateUpdateSubscriptionFormInfo formInfo) {
        final Optional<Subscription> optionalSubscription = this.repository.findById(id);
        if (optionalSubscription.isPresent()) {
            final Subscription subscription = optionalSubscription.get();
            subscription.setName(formInfo.getName());
            subscription.setDescription(formInfo.getDescription());
            subscription.setDuration(formInfo.getDuration());
            subscription.setTerm(formInfo.getTerm());
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
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        // Activate the subscription
        // Update additional fields as needed

        repository.save(subscription);
    }

    public void deactivateSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        // Deactivate the subscription
        // Update additional fields as needed

        repository.save(subscription);
    }

    public void suspendSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        // Suspend the subscription
        // Update additional fields as needed

        repository.save(subscription);
    }

    public void resumeSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        // Resume the subscription
        // Update additional fields as needed

        repository.save(subscription);
    }

    public void renewSubscription(@NonNull Long id) {
        Subscription subscription = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found with given id: " + id));

        // Renew the subscription
        // Update additional fields as needed

        repository.save(subscription);
    }
}
