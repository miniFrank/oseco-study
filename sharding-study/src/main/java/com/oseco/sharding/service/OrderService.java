package com.oseco.sharding.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oseco.sharding.entity.Order;
import com.oseco.sharding.entity.OrderItem;
import com.oseco.sharding.mapper.OrderItemMapper;
import com.oseco.sharding.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author panguanghua
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Transactional
    public void create(Order order, List<OrderItem> orderItemList) {
        final int id = orderMapper.insert(order);
        orderItemList.forEach(item -> {
            item.setOrderId(id);
            orderItemMapper.insert(item);
        });
    }

    public List<Order> findAll() {
        QueryWrapper queryWrapper = new QueryWrapper<>().in("store_no", 1, 2);
        return orderMapper.selectList(queryWrapper);
    }

    public List<Order> findAllByUserId() {
        QueryWrapper queryWrapper = new QueryWrapper<>().in("user_id", 1, 2);
        return orderMapper.selectList(queryWrapper);
    }

    public List<Order> findAllByStoreNoAndUserId() {
        QueryWrapper queryWrapper = new QueryWrapper<>()
                .eq("store_no", 1)
                .eq("user_id", 1);
        return orderMapper.selectList(queryWrapper);
    }
}
