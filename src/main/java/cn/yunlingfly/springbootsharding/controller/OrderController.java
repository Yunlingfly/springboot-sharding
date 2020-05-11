package cn.yunlingfly.springbootsharding.controller;

import cn.yunlingfly.springbootsharding.domain.entity.Config;
import cn.yunlingfly.springbootsharding.domain.entity.Order;
import cn.yunlingfly.springbootsharding.domain.entity.OrderItem;
import cn.yunlingfly.springbootsharding.infra.mapper.IConfigMapper;
import cn.yunlingfly.springbootsharding.infra.mapper.IOrderItemMapper;
import cn.yunlingfly.springbootsharding.infra.mapper.IOrderMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IOrderItemMapper orderItemMapper;
    @Autowired
    private IConfigMapper configMapper;

    @PostMapping(value = "/saveOrder")
    public Integer saveOrder(@RequestBody Order order) {
        return orderMapper.save(order);
    }

    public Integer saveOrderItem(OrderItem orderItem, Integer userId) {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.addDatabaseShardingValue("t_order_item", userId);
            return orderItemMapper.save(orderItem);
        }
    }

    @GetMapping(value = "/selectByUserId/{userId}")
    public Order selectByUserId(@PathVariable Integer userId) {
        return orderMapper.selectByUserId(userId);
    }

    public List<Order> selectOrderJoinOrderItem(Integer userId, Integer orderId) {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.addDatabaseShardingValue("t_order_item", userId);
            return orderMapper.selectOrderJoinOrderItem(userId, orderId);
        }
    }

    public List<Order> selectOrderJoinOrderItemNoSharding(Integer userId, Integer orderId) {
        return orderMapper.selectOrderJoinOrderItem(userId, orderId);
    }

    public List<Order> selectOrderJoinConfig(Integer userId, Integer orderId) {
        return orderMapper.selectOrderJoinConfig(userId, orderId);
    }

    public Integer saveConfig(Config config) {
        return configMapper.save(config);
    }

    public Config selectConfig(Integer id) {
        return configMapper.selectById(id);
    }
}
