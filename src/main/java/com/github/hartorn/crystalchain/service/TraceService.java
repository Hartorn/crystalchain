package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.dto.TraceDTO;
import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import java.util.List;

/** Service for operation on kind. */
public interface TraceService extends GenericService<TraceEntity, TraceDTO, Long> {

  List<TraceEntity> getAllTraceByOrganization(Long organisationId);

}
