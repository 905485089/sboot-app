package com.uek.boot;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.uek.boot.dao.IAccountDao;
import com.uek.boot.entity.Account;
import com.uek.boot.mapper.AccountMapper;
import com.uek.boot.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SbootAppApplicationTests {

    @Autowired
    private IAccountDao actDao;
    @Resource //不能使用Autowired idea的问题
    private AccountMapper actMapper;
    @Autowired
    private IAccountService actService;

    @Test
    void accountDaoTest() {
        actDao.save(new Account("zs", 2000.0));
    }

    @Test
    void Test123() {
        System.out.println(actDao.find(2));
    }

    @Test
    void TestAccountMapper() {
        actMapper.save(new Account("zzzzsfds", 200.0));
    }

    @Test
    public void testFindPaged() {
        //-- 1 原理
        PageHelper.startPage(1, 5);
        List<Account> acts = actMapper.find();
        for (Account act : acts) {
            System.out.println(act);
        }
    }

    @Test
    public void testAccountService() {
        //-- 动态代理 继承和多态
        List<Account> acts = actService.searchAccount(1, 6);
        Page<Account> page = (Page<Account>) acts;
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getPageNum());
        for (Account act : page.getResult()) {
            System.out.println(act);
        }
    }
}
