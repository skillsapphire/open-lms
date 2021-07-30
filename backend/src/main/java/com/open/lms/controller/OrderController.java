package com.open.lms.controller;

import com.open.lms.dto.OrderDTO;
import com.open.lms.dto.OrderResponse;
import com.open.lms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable final String id) {
        return orderService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody @Valid final OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable final String id,
                            @RequestBody @Valid final OrderDTO orderDTO) {
        orderService.update(id, orderDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable final String id) {
        orderService.delete(id);
    }

    @GetMapping("/payment/cancel")
    @ResponseStatus(HttpStatus.OK)
    public String paymentCancel() {
        return "Payment Cancelled";
    }

    @GetMapping("/payment/success")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse paymentSuccess(@RequestParam("paymentId") String paymentId,
                                        @RequestParam("PayerID") String payerId) {
        return orderService.completePaymentOrder(paymentId, payerId);
    }

}
