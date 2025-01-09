package com.gcu.cst339.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.cst339.data.entity.UserEntity;

public interface UsersRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
