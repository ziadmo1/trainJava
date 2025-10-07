package com.trainJava.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainJava.demo.entities.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, UUID> {

    public Optional<UserAccount> findOneByUsername(String username);

}
