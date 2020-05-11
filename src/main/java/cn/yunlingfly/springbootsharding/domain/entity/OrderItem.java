package cn.yunlingfly.springbootsharding.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_order_item")
public class OrderItem {

    private Long itemId;

    private Integer orderId;

    private String remark;

    private Date createTime;

    private Date lastModifyTime;
}