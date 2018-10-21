package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.dto.UserDTO;
import com.github.hartorn.crystalchain.model.entity.KindEntity;
import com.github.hartorn.crystalchain.model.entity.OrganisationEntity;
import com.github.hartorn.crystalchain.model.entity.UserEntity;
import com.github.hartorn.crystalchain.repository.KindRepository;
import com.github.hartorn.crystalchain.repository.OrganisationRepository;
import com.github.hartorn.crystalchain.repository.UserRepository;
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
public class UserServiceImpl extends GenericServiceImpl<UserEntity, UserDTO, Long>
    implements UserService {

  private final KindRepository kindRepository;
  private final OrganisationRepository organisationRepository;

  public UserServiceImpl(
      UserRepository userRepository,
      EntityManager em,
      ModelMapper mapper,
      KindRepository kindRepository,
      OrganisationRepository organisationRepository) {
    super(userRepository, em, mapper, UserEntity.class);
    this.kindRepository = kindRepository;
    this.organisationRepository = organisationRepository;
  }

  @Override
  protected void mapCustomDTOtoEntity(UserDTO dto, UserEntity entity) {
    KindEntity kind = kindRepository.getOne(dto.getKindId());
    entity.setKind(kind);
    OrganisationEntity orga = organisationRepository.getOne(dto.getOrganisationId());
    entity.setOrganisation(orga);
  }
}
