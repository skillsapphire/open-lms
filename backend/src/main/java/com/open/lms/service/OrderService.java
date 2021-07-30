package com.open.lms.service;

import com.open.lms.dto.OrderDTO;
import com.open.lms.dto.OrderResponse;
import com.open.lms.exceptions.ApplicationException;
import com.open.lms.mapper.OrderMapper;
import com.open.lms.model.Order;
import com.open.lms.model.OrderStatus;
import com.open.lms.repository.OrderRepository;
import com.open.lms.service.payment.PaymentService;
import com.open.lms.service.payment.PaymentServiceFactory;
import com.paypal.api.payments.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.open.lms.model.PaymentStatus.PROCESSED;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final PaymentServiceFactory paymentServiceFactory;
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    public List<OrderDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(order -> orderMapper.mapToDTO(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    public OrderDTO get(final String id) {
        return orderRepository.findById(id)
                .map(order -> orderMapper.mapToDTO(order, new OrderDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String create(final OrderDTO orderDTO) {
        var paymentService = paymentServiceFactory.get(orderDTO.getPaymentMethod());
        Payment payment = paymentService.createPayment(orderDTO.getFinalPrice());
        var order = new Order();
        order.setPaymentId(payment.getId());
        orderMapper.mapToEntity(orderDTO, order);
        orderRepository.save(order);
        var links = payment.getLinks()
                .stream()
                .filter(link -> link.getRel().equals("approval_url"))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Error"));
        return links.getHref();
    }

    public void update(final String id, final OrderDTO orderDTO) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderMapper.mapToEntity(orderDTO, order);
        orderRepository.save(order);
    }

    public void delete(final String id) {
        orderRepository.deleteById(id);
    }

    public OrderResponse completePaymentOrder(String paymentId, String payerId) {
        var order = orderRepository.findByPaymentId(paymentId)
                .orElseThrow(() -> new ApplicationException("Cannot find order with Payment Id - " + paymentId));
        if (order.getOrderStatus().equals(OrderStatus.PROCESSED)) {
            throw new ApplicationException("Order already completed");
        }
        paymentService.completePayment(paymentId, payerId);
        order.setPaymentStatus(PROCESSED);
        orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setMessage("Order Placed Successfully!");
        orderResponse.setOrderId(orderResponse.getOrderId());
        orderResponse.setPaymentStatus(orderResponse.getPaymentStatus());
        orderResponse.setOrderStatus(orderResponse.getOrderStatus());
        return orderResponse;
    }
}
