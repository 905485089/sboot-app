package com.uek.boot.controller;

import com.uek.boot.Util.JsonResult;
import com.uek.boot.dao.IAccountDao;
import com.uek.boot.entity.Account;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账户管理
 */
@RestController
public class AccountController {
    @Autowired
    private IAccountDao actDao;

    /**
     * 返回json类型
     */
    @ApiOperation(value = "查询账户", notes = "该接口可以查询所有的账户")
    @GetMapping("/accounts")
    public ResponseEntity<JsonResult> list() {
        List<Account> all = actDao.findAll();
        JsonResult js = new JsonResult();
        js.setStatus("200");
        js.setData(all);
        return ResponseEntity.ok(js);
    }
}
