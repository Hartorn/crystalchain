package com.github.hartorn.crystalchain.repository;

import com.github.hartorn.crystalchain.model.dto.OrganisationDTO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "organisation", path = "organisation")
public interface OrganisationRepository extends PagingAndSortingRepository<OrganisationDTO, Long> {}
