package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.dto.TraceDTO;
import com.github.hartorn.crystalchain.model.entity.KindEntity;
import com.github.hartorn.crystalchain.model.entity.OrganisationEntity;
import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import com.github.hartorn.crystalchain.model.entity.UserEntity;
import com.github.hartorn.crystalchain.repository.KindRepository;
import com.github.hartorn.crystalchain.repository.OrganisationRepository;
import com.github.hartorn.crystalchain.repository.TraceRepository;
import com.github.hartorn.crystalchain.repository.UserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
@Repository
public class TraceServiceImpl extends GenericServiceImpl<TraceEntity, TraceDTO, Long>
    implements TraceService {

  private final TraceRepository traceRepo;
  private final KindRepository kindRepository;
  private final OrganisationRepository organisationRepository;
  private final UserRepository userRepository;

  public TraceServiceImpl(
      TraceRepository traceRepository,
      EntityManager em,
      ModelMapper mapper,
      KindRepository kindRepository,
      OrganisationRepository organisationRepository,
      UserRepository userRepository) {
    super(traceRepository, em, mapper, TraceEntity.class);
    this.traceRepo = traceRepository;
    this.kindRepository = kindRepository;
    this.organisationRepository = organisationRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<TraceEntity> getAllTraceByOrganization(Long organisationId) {
    OrganisationEntity orgaCrit = new OrganisationEntity();
    orgaCrit.setId(organisationId);
    TraceEntity trace = new TraceEntity();
    trace.setOrganisation(orgaCrit);
    return traceRepo.findAll(Example.of(trace));
  }

  @Override
  protected void mapCustomDTOtoEntity(TraceDTO dto, TraceEntity entity) {
    KindEntity kind = kindRepository.getOne(dto.getKindId());
    entity.setKind(kind);
    OrganisationEntity orga = organisationRepository.getOne(dto.getOrganisationId());
    entity.setOrganisation(orga);
    UserEntity user = userRepository.getOne(dto.getUserId());
    entity.setUser(user);
  }
}
