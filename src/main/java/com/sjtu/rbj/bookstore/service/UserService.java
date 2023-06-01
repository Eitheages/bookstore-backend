package com.sjtu.rbj.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.sjtu.rbj.bookstore.dto.UserInfoDTO;
import com.sjtu.rbj.bookstore.entity.User;
import com.sjtu.rbj.bookstore.entity.UserType;

/**
 * @author Bojun Ren
 * @date 2023/04/18
 */
public interface UserService {
    /**
     * Get all users.
     * @return a list of all users.
     */
    List<User> getAllUsers();

    /**
     * verify account and password
     * @param account
     * @param passwd
     * @return {@code true} on success
     * @see {@link com.sjtu.rbj.bookstore.service.UserService#login}
     */
    @Deprecated
    Boolean enableLogin(String account, String passwd);


    /**
     * Verify account and password, together with the user type.
     * @param account must not be {@literal null}.
     * @param passwd must not be {@literal null}.
     * @return {@code null} if the account or passwd is wrong, else the user's type.
     */
    Optional<UserType> login(String account, String passwd);

    /**
     * get information {userId, orderId} by user's account
     * @param account user's account, unique
     * @return UserInfo {userId, orderId}
     * @throws NoSuchElementException if no such user
     */
    UserInfoDTO getUserInfoByAccount(String account);

    /**
     * Change a user's state (type) by its id aka. primary key.
     * @param id must not be {@literal null}.
     * @param state
     * @return true on success. Iff the user's state equals {@literal state}, return false.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     * @throws UnsupportedOperationException if the target user is a super user.
     * @throws NoSuchElementException if the user doesn't exist.
     */
    Boolean changeState(Integer id, UserType state);

    /**
     * Change passwd by account.
     *
     * @param account must not be {@literal null}.
     * @param newPasswd
     * @return true on success, false indicate the new passwd is the same as the previous.
     * @throws IllegalArgumentException if {@literal account} is {@literal null}.
     * @throws NoSuchElementException if the account doesn't exist.
     */
    Boolean changePasswdByAccount(String account, String newPasswd);

    /**
     * Change passwd by user id.
     *
     * @param id must not be {@literal null}.
     * @param newPasswd
     * @return true on success, false indicate the new passwd is the same as the previous.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     * @throws NoSuchElementException if the user doesn't exist.
     */
    Boolean changePasswdById(Integer id, String newPasswd);
}
