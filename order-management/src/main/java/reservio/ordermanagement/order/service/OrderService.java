package reservio.ordermanagement.order.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateOrderFormInfo;
import reservio.common.models.response.OrderCreateUpdateResponse;
import reservio.ordermanagement.order.dao.OrderRepository;
import reservio.ordermanagement.order.entity.Order;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@ComponentScan({"reservio.ordermanagement", "reservio.common"})
public class OrderService {
    private final OrderRepository repository;
    private  final ModelMapperHelper modelMapperHelper;


    public Order createOrder(@NonNull final CreateUpdateOrderFormInfo formInfo){


//     return modelMapperHelper.map(repository.save(order), OrderCreateUpdateResponse.class);
        return modelMapperHelper.map(formInfo, Order.class);
    }

    public OrderCreateUpdateResponse getOrderById(@NonNull final String id){
        final Optional<Order> optionalOrder = repository.findById(Long.parseLong(id));
        if(optionalOrder.isPresent())
            return modelMapperHelper.map(optionalOrder.get(), OrderCreateUpdateResponse.class);
        throw new NotFoundException("User not found with given id" + id);

    }

    public OrderCreateUpdateResponse updateOrder(@NonNull final CreateUpdateOrderFormInfo formInfo){
        return new OrderCreateUpdateResponse();
    }

    public void deleteOrder(@NonNull final String id) {
        repository.deleteById(Long.parseLong(id));
    }
}
