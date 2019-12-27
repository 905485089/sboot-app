package com.uek.boot.controller;

import com.alibaba.fastjson.JSON;
import com.uek.boot.dao.IAccountDao;
import com.uek.boot.entity.Account;
import com.uek.boot.entity.AccountForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 利用SpringBoot开发第一个控制器
 */

@RestController // 默认情况下你写的方法返回的就是字符串
public class HelloController {

    @Autowired
    private IAccountDao actDao;

    @ApiOperation(value = "测试类", notes = "利用客户名字信息和余额进行开户")
    @GetMapping("/hello")
    public String hello() {
        return "Hello UBDF1907";
    }

    /**
     * 1. 表单传数据访问的接口
     */
    @ApiOperation(value = "账号开户", notes = "利用客户名字信息和余额进行开户")
    @PostMapping("/success")
    public String createAccount(AccountForm act) {
        actDao.save(new Account(act));

        return "success";
    }

    /**
     * 通过访问路径传递数据来访问该接口  Restful格式的
     */
    @ApiOperation(value = "查询账号", notes = "根据账号ID查询对应的账号")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "Path")
    @GetMapping("/account/{id}")
    public String queryAccount(@PathVariable int id) {
        Account act1 = actDao.find(2);
        String act = JSON.toJSONString(act1);
        return act;
    }

    /**
     * 3.通过传递ajax传递接口数据，这是前后端分离最常用的方式
     */
    @ApiOperation(value = "修改账户", notes = "根据账号ID修改对应的账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "Path"),
            @ApiImplicitParam(name = "actForm", value = "账户实体", required = true, dataType = "AccountForm")
    })
    @PostMapping("/modify/{id}")
    public String modifyAccount(@PathVariable("id") int id, @RequestBody AccountForm acrForm) {
        actDao.update(id, acrForm);
        return "success";
    }
}
