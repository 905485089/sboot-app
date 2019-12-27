package com.uek.boot.dao;

import com.github.pagehelper.PageHelper;
import com.uek.boot.entity.Account;
import com.uek.boot.entity.AccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountDao实现
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Account act) {
        jdbcTemplate.update(
                "insert into account (name,balance) values (?,?)",
                new Object[]{act.getName(), act.getBalance()});
    }

    @Override
    public Account find(int id) {
        //PageHelper.startPage(1,5);
        return jdbcTemplate.queryForObject(
                "select * from account where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public void update(int id, AccountForm actForm) {
        jdbcTemplate.update("update account set name=?,balance=? where id=?"
                , new Object[]{actForm.getName(), actForm.getBalance(), id});
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(
                "select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
    }
}









