package cn.yunlingfly.springbootsharding.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_order")
public class Order {
    @TableId
    private Integer orderId;

    private Integer userId;

    private Integer configId;

    private String remark;

    private Date createTime;

    private Date lastModifyTime;
}