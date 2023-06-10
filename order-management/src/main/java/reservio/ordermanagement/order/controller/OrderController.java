package reservio.ordermanagement.order.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateOrderFormInfo;
import reservio.common.models.response.OrderCreateUpdateResponse;
import reservio.ordermanagement.order.entity.Order;
import reservio.ordermanagement.order.service.OrderService;

@Controller
@RequestMapping("/orderManagement")
@CrossOrigin("*")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@NonNull @RequestBody final CreateUpdateOrderFormInfo formInfo){
        return ResponseEntity.ok(this.orderService.createOrder(formInfo));
    }
    @GetMapping("/order/{id}")
    public void getOrderById(@NonNull @PathVariable String id){

    }
    @PatchMapping("/order/{id}")
    public void updateOrder(@NonNull @PathVariable String id){

    }
    @DeleteMapping("/order/{id}")
    public void deleteOrder(@NonNull @PathVariable String id){

    }

}
