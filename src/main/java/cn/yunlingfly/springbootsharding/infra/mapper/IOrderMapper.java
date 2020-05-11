package cn.yunlingfly.springbootsharding.infra.mapper;

import cn.yunlingfly.springbootsharding.domain.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IOrderMapper extends BaseMapper<Order> {
    @Insert("insert into t_order(order_id,user_id,config_id,remark) values(#{orderId},#{userId},#{configId},#{remark})")
    Integer save(Order order);

    @Select("select order_id orderId, user_id userId, config_id configId, remark from t_order  where user_id = #{userId}")
    Order selectByUserId(Integer userId);

    @Select("select o.order_id orderId, o.user_id userId, o.config_id configId, o.remark from " +
            "t_order o inner join t_order_item i on o.order_id = i.order_id " +
            "where o.user_id =#{userId} and o.order_id =#{orderId}")
    List<Order> selectOrderJoinOrderItem(Integer userId, Integer orderId);

    @Select("select  o.order_id orderId, o.user_id userId, o.config_id configId, o.remark " +
            "from t_order o inner join t_config c on o.config_id = c.id " +
            "where o.user_id =#{userId} and o.order_id =#{orderId}")
    List<Order> selectOrderJoinConfig(Integer userId, Integer orderId);
}
