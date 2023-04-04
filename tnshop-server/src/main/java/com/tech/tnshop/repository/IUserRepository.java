package com.tech.tnshop.repository;

import com.tech.tnshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM shop_service.user WHERE user_name = :username", nativeQuery = true)
    Optional<User> findUserByUserName(@Param("username") String username);

}
