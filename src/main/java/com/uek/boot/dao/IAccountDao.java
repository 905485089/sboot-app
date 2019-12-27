package com.uek.boot.dao;

import com.uek.boot.entity.Account;
import com.uek.boot.entity.AccountForm;

import java.util.List;

public interface IAccountDao {
    void save(Account act);

    Account find(int id);

    void update(int id, AccountForm actForm);

    List<Account> findAll();
}

