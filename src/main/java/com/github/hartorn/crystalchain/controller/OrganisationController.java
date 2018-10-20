package com.github.hartorn.crystalchain.controller;

import com.github.hartorn.crystalchain.model.entity.OrganisationEntity;
import com.github.hartorn.crystalchain.service.OrganisationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/organisation")
public class OrganisationController extends GenericController<OrganisationEntity, Long> {

  public OrganisationController(OrganisationService kindService) {
    super(kindService);
  }
}
