package com.github.hartorn.crystalchain.repository;

import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceRepository extends JpaRepository<TraceEntity, Long> {}
