package cn.yunlingfly.springbootsharding.infra.mapper;

import cn.yunlingfly.springbootsharding.domain.entity.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface IOrderItemMapper extends BaseMapper<OrderItem> {
    @Insert("insert into t_order_item(order_id,remark) values(#{orderId},#{remark})")
    Integer save(OrderItem orderItem);
}
