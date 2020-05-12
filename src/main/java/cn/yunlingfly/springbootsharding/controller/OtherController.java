package cn.yunlingfly.springbootsharding.controller;

import cn.yunlingfly.springbootsharding.domain.entity.Other;
import cn.yunlingfly.springbootsharding.infra.mapper.IOtherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/other")
public class OtherController {
    @Autowired
    IOtherMapper otherMapper;
    @Autowired
    List<DataSource> dataSources;

    @PostMapping(value = "/insertOne")
    public void insertOne(@RequestBody Other other) {
        otherMapper.insert(other);
    }
}
