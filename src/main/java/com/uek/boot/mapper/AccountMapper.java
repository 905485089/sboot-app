package com.uek.boot.mapper;

import com.uek.boot.entity.Account;

import java.util.List;

/**
 * 可以用@Mapper代替主启动类的@MapperScan
 */
public interface AccountMapper {
    void save(Account act);

    List<Account> find();
}
