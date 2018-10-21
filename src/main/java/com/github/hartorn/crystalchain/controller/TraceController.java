package com.github.hartorn.crystalchain.controller;

import com.github.hartorn.crystalchain.model.dto.TraceDTO;
import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import com.github.hartorn.crystalchain.security.SecurityHelper;
import com.github.hartorn.crystalchain.service.TraceService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/trace")
public class TraceController extends GenericController<TraceEntity, TraceDTO, Long> {

  private final TraceService traceService;
  private final SecurityHelper securityHelper;

  public TraceController(TraceService kindService, SecurityHelper securityHelper) {
    super(kindService);
    this.traceService = kindService;
    this.securityHelper = securityHelper;
  }

  @Override
  @GetMapping()
  public List<TraceEntity> getAllEntities() {

    return securityHelper.isAdmin()
        ? traceService.getAllEntities()
        : traceService.getAllTraceByOrganization(securityHelper.getOrganisationId());
  }
}
