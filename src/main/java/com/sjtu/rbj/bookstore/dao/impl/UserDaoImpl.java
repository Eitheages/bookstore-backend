package com.sjtu.rbj.bookstore.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjtu.rbj.bookstore.dao.UserDao;
import com.sjtu.rbj.bookstore.entity.User;
import com.sjtu.rbj.bookstore.repository.UserRepository;

/**
 * @author Bojun Ren
 * @date 2023/04/18
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<User> findByAccount(String account) {
        return repository.findByAccount(account);
    }

    @Override
    public List<User> findByAccountAndPasswd(String account, String passwd) {
        return repository.findByAccountAndPasswd(account, passwd);
    }
}