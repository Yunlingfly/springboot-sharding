package cn.yunlingfly.springbootsharding.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_config")
public class Config {
    @TableId
    private Integer id;

    private String remark;

    private Date createTime;

    private Date lastModifyTime;
}
