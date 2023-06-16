package reservio.ordermanagement.order.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import reservio.common.enums.Status;
import reservio.common.models.Pair;
import reservio.common.models.request.CreateUpdateOrderFormInfo;
import reservio.common.models.response.OrderCreateUpdateResponse;
import reservio.ordermanagement.order.entity.Order;
import reservio.ordermanagement.order.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/orderManagement")
@CrossOrigin("*")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@NonNull @RequestBody final CreateUpdateOrderFormInfo formInfo,@RequestHeader @NonNull String authorization){
        return ResponseEntity.ok(this.orderService.createOrder(formInfo,authorization));
    }
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.orderService.getOrderById(id));
    }
    @PatchMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@NonNull @RequestBody final CreateUpdateOrderFormInfo formInfo, @NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.orderService.updateOrder(formInfo,id));
    }
    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrder(@NonNull @PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    public List<Order> listOrdersByParams(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long restaurantId, @RequestParam(required = false) Status status){
        final List<Pair> pairs = new ArrayList<>();
        if(ObjectUtils.isEmpty(userId) && ObjectUtils.isEmpty(restaurantId)) throw new RuntimeException("Missing parameters!!!");
        if(!ObjectUtils.isEmpty(userId)) pairs.add(Pair.builder().key("relatedUserId").value(String.valueOf(userId)).build());
        if(!ObjectUtils.isEmpty(restaurantId)) pairs.add(Pair.builder().key("relatedRestaurantId").value(String.valueOf(restaurantId)).build());
        if(!ObjectUtils.isEmpty(status)) pairs.add(Pair.builder().key("status").value(status.toString()).build());

        return this.orderService.listOrdersByParams(pairs);

    }

}
