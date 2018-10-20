package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import com.github.hartorn.crystalchain.repository.TraceRepository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
@Repository
public class TraceServiceImpl extends GenericServiceImpl<TraceEntity, Long> implements TraceService {

  public TraceServiceImpl(TraceRepository kindRepository, EntityManager em) {
    super(kindRepository, em);
  }
}
