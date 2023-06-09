package com.sjtu.rbj.bookstore.dto;

import com.sjtu.rbj.bookstore.entity.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Necessary user info for administrators.
 * DTO for {@link com.sjtu.rbj.bookstore.entity.User}.
 *
 * @author Bojun Ren
 * @data 2023/05/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForAdminDTO {
    private Integer id;
    private String name;
    private UserType userType;
    private String avatarId;
    private String account;
    private String passwd;
}
