package cn.yunlingfly.springbootsharding.controller;

import cn.yunlingfly.springbootsharding.domain.entity.ApplyEntity;
import cn.yunlingfly.springbootsharding.infra.mapper.IApplyMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请
 *
 * @author yunlingfly
 * @version 1.0
 * @date 2020-5-9
 */
@RestController
public class ApplyController {
    @Autowired
    IApplyMapper applyMapper;

    @PostMapping("/insertBatch")
    public void insertBatch(@RequestBody List<ApplyEntity> list) {
        applyMapper.insertBatch(list);
    }

    @GetMapping(value = "/getData")
    public List<TestClass> getData() {
        List<TestClass> list=new ArrayList<>();
        TestClass a1=new TestClass();
        a1.setId("131");
        a1.setName("name1");
        a1.setUserId("sjs");
        TestClass2 a2=new TestClass2();
        a2.setId("131");
        a2.setKey1("name1");
        a2.setKey2("sjs");
        a1.setTestClass2(a2);
        list.add(a1);;
        return list;
    }

    @Data
    private class TestClass {
        private String id;
        private String userId;
        private String regulatoryPlatformSysDataTime;
        private String data;
        private String name;
        private TestClass2 testClass2;
    }

    @Data
    private class TestClass2 {
        private String id;
        private String regulatoryPlatformSysDataTime;
        private String inExchangeDhakahdkjF631f587a6ba07f7Id;
        private String key2;
        private String key1;
    }
}
