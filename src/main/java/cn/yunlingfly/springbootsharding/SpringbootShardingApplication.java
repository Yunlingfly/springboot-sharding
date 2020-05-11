package cn.yunlingfly.springbootsharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author yunlingfly
 * @version 1.0
 * @date 2020-5-11
 */
@SpringBootApplication
@MapperScan(value = {"cn.yunlingfly.springbootsharding.infra.mapper"})
public class SpringbootShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShardingApplication.class, args);
    }

}
