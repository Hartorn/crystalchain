package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.OrganisationEntity;
import com.github.hartorn.crystalchain.repository.OrganisationRepository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
@Repository
public class OrganisationServiceImpl extends GenericServiceImpl<OrganisationEntity, Long>
    implements OrganisationService {

  public OrganisationServiceImpl(OrganisationRepository kindRepository, EntityManager em) {
    super(kindRepository, em);
  }
}
