package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.dto.KindDTO;
import com.github.hartorn.crystalchain.model.entity.KindEntity;
import com.github.hartorn.crystalchain.repository.KindRepository;
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
public class KindServiceImpl extends GenericServiceImpl<KindEntity, KindDTO, Long>
    implements KindService {

  public KindServiceImpl(KindRepository kindRepository, EntityManager em, ModelMapper mapper) {
    super(kindRepository, em, mapper, KindEntity.class);
  }
}
