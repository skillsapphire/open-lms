package com.open.lms.mapper;

import com.open.lms.dto.OrderDTO;
import com.open.lms.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public OrderDTO mapToDTO(final Order order, final OrderDTO orderDTO) {
        orderDTO.setId(order.getId());
        orderDTO.setCourseId(order.getCourseId());
        orderDTO.setOrderedDate(order.getOrderedDate());
        orderDTO.setPaymentId(order.getPaymentId());
        orderDTO.setFinalPrice(order.getFinalPrice());
        orderDTO.setOriginalPrice(order.getOriginalPrice());
        orderDTO.setDiscount(order.getDiscount());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setPaymentStatus(order.getPaymentStatus());
        orderDTO.setPaymentMethod(order.getPaymentMethod());
        return orderDTO;
    }

    public Order mapToEntity(final OrderDTO orderDTO, final Order order) {
        order.setId(orderDTO.getId());
        order.setCourseId(orderDTO.getCourseId());
        order.setOrderedDate(orderDTO.getOrderedDate());
        order.setPaymentId(orderDTO.getPaymentId());
        order.setFinalPrice(orderDTO.getFinalPrice());
        order.setOriginalPrice(orderDTO.getOriginalPrice());
        order.setDiscount(orderDTO.getDiscount());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setPaymentStatus(orderDTO.getPaymentStatus());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        return order;
    }
}
