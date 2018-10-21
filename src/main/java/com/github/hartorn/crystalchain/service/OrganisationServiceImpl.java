package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.dto.OrganisationDTO;
import com.github.hartorn.crystalchain.model.entity.KindEntity;
import com.github.hartorn.crystalchain.model.entity.OrganisationEntity;
import com.github.hartorn.crystalchain.repository.KindRepository;
import com.github.hartorn.crystalchain.repository.OrganisationRepository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
@Repository
public class OrganisationServiceImpl
    extends GenericServiceImpl<OrganisationEntity, OrganisationDTO, Long>
    implements OrganisationService {

  private final KindRepository kindRepository;

  public OrganisationServiceImpl(
      OrganisationRepository orgaRepository,
      EntityManager em,
      ModelMapper mapper,
      KindRepository kindRepository) {
    super(orgaRepository, em, mapper, OrganisationEntity.class);
    this.kindRepository = kindRepository;
  }

  @Override
  protected void mapCustomDTOtoEntity(OrganisationDTO dto, OrganisationEntity entity) {
    KindEntity kind = kindRepository.getOne(dto.getKindId());
    entity.setKind(kind);
  }
}
