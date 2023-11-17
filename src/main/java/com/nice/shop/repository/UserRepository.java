package com.nice.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nice.shop.model.User;


public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUserId(String userid);


//@Modifying
//@Query(value = "UPDATE user set username = :username, userEmail = :userEmail, userAddr = :userAddr, userZipcode = :userZipcode, userPwd = :userPwd where userId = :userId", nativeQuery = true)
//int mUpdate(String username, String userEmail, String userAddr, String userZipcode, String userPwd, String userId);

}
