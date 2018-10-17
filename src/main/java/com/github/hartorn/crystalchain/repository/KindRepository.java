package com.github.hartorn.crystalchain.repository;

import com.github.hartorn.crystalchain.model.dto.KindDTO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kind", path = "kind")
public interface KindRepository extends PagingAndSortingRepository<KindDTO, Long> {}
