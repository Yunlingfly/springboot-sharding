package cn.yunlingfly.springbootsharding.infra.mapper;

import cn.yunlingfly.springbootsharding.domain.entity.ApplyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 申请mapper
 *
 * @author yunlingfly
 * @version 1.0
 * @date 2020-5-9
 */
@Component
public interface IApplyMapper extends BaseMapper<ApplyEntity> {
    int insertBatch(List<ApplyEntity> list);
}
