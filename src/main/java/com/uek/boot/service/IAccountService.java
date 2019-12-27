package com.uek.boot.service;

import com.uek.boot.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> searchAccount(int pageNum, int pageSize);
}
