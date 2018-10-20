package com.github.hartorn.crystalchain.controller;

import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import com.github.hartorn.crystalchain.service.TraceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/trace")
public class TraceController extends GenericController<TraceEntity, Long> {

  public TraceController(TraceService kindService) {
    super(kindService);
  }
}
