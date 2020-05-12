package cn.yunlingfly.springbootsharding.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "other")
public class Other {
    private String id;
    private String name;
}
