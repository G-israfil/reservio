package reservio.ordermanagement.order.service;


import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import reservio.common.enums.Status;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.Pair;
import reservio.common.models.request.CreateUpdateOrderFormInfo;
import reservio.common.models.response.OrderCreateUpdateResponse;
import reservio.common.util.JwtUtils;
import reservio.ordermanagement.order.dao.OrderRepository;
import reservio.ordermanagement.order.entity.Order;
import reservio.ordermanagement.order.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
@ComponentScan({"reservio.ordermanagement", "reservio.common"})
public class OrderService {
    private final OrderRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    private final JwtUtils jwtUtils;
    private final EntityManager entityManager;

    public Order createOrder(@NonNull @Validated final CreateUpdateOrderFormInfo formInfo, String authHeader) {
        final Order order = this.modelMapperHelper.map(formInfo, Order.class);
        order.setRelatedRestaurantId(jwtUtils.extractUserId(authHeader));
        order.setStatus(Status.ACTIVE);
        return this.repository.save(order);
    }

    public Order getOrderById(@NonNull final Long id) {
        final Order order = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found with given id" + id));
        return order;
    }

    public Order updateOrder(@NonNull final CreateUpdateOrderFormInfo formInfo,@NonNull Long id) {
        final Order order = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found with given id" + id));

        if(!StringUtils.isEmpty(formInfo.getDescription())) order.setDescription(formInfo.getDescription());
        if(!StringUtils.isEmpty(formInfo.getType())) order.setType(formInfo.getType());
        if(!ObjectUtils.isEmpty(formInfo.getOrderItems())) order.setOrderItems(modelMapperHelper.mapAll(formInfo.getOrderItems(), OrderItem.class));
        if(Objects.nonNull(formInfo.getStatus())) order.setStatus(formInfo.getStatus());
        return this.repository.save(order);
    }

    public List<Order> listOrdersByParams(List<Pair> pairs){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);

        Root<Order> entityClass = query.from(Order.class);

        List<Predicate> predicates = new ArrayList<>();

        pairs.forEach(pair -> predicates.add(cb.equal(entityClass.get(pair.getKey()), pair.getValue())));
        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }

    public void deleteOrder(@NonNull final Long id) {
        repository.deleteById(id);
    }
}
