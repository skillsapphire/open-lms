package com.open.lms.service;

import com.open.lms.dto.OrderDTO;
import com.open.lms.mapper.OrderMapper;
import com.open.lms.model.Order;
import com.open.lms.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
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
        var order = new Order();
        orderMapper.mapToEntity(orderDTO, order);
        return orderRepository.save(order).getId();
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

}
