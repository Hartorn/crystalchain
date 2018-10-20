package com.github.hartorn.crystalchain.controller;

import com.github.hartorn.crystalchain.model.entity.KindEntity;
import com.github.hartorn.crystalchain.service.KindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/kind")
public class KindController extends GenericController<KindEntity, Long> {

  public KindController(KindService kindService) {
    super(kindService);
  }
}
