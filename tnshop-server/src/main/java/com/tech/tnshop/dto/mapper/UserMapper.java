package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.entity.User;
import com.tech.tnshop.dto.request.RegisterRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */

public class UserMapper {
    private UserMapper () {

    }

    private static final BCryptPasswordEncoder bCryptPasswordEncoder;

    static {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

      public static User mapToUserEntity(RegisterRequest registerRequest) {
        return User.builder()
                .userName(registerRequest.getUserName())
                .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
                .build();
    }

}
