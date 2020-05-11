package cn.yunlingfly.springbootsharding.infra.mapper;

import cn.yunlingfly.springbootsharding.domain.entity.Config;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface IConfigMapper extends BaseMapper<Config> {
    @Insert("insert into t_config(id,remark) values(#{id},#{remark})")
    Integer save(Config config);

    @Select("select * from t_config  where id = #{id}")
    Config selectById(Integer id);
}