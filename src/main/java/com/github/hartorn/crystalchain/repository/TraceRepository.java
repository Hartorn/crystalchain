package com.github.hartorn.crystalchain.repository;

import com.github.hartorn.crystalchain.model.dto.TraceDTO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "trace", path = "trace")
public interface TraceRepository extends PagingAndSortingRepository<TraceDTO, Long> {}
