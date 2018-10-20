package com.github.hartorn.crystalchain.repository;

import com.github.hartorn.crystalchain.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}
