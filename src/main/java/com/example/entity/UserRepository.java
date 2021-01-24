package com.example.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByCharId(String charId);
//    @Query("select p from User p where p.charId = ?1 and p.account = ?2")
//    User getByCharIdAndAccount(String charId, String account);
}