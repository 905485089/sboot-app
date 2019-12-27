package com.uek.boot.service;

import com.github.pagehelper.PageHelper;
import com.uek.boot.entity.Account;
import com.uek.boot.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountMapper actMapper;

    @Override
    public List<Account> searchAccount(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return actMapper.find();
    }
}
