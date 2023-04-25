package com.sjtu.rbj.bookstore.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.sjtu.rbj.bookstore.constant.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


/**
 * @author Bojun Ren
 * @date 2023/04/08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @NonNull
    @Column(unique = true, nullable = false)
    private String account;

    @NonNull
    @Column(nullable = false)
    private String passwd;

    private String name;

    @Lob
    private byte[] avatar;

    @PrePersist
    void prePersistInitialize() {
        if (this.userType == null) {
            this.userType = UserType.NORMAL;
        }
    }
}
