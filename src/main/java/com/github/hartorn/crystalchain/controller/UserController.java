package com.github.hartorn.crystalchain.controller;

import com.github.hartorn.crystalchain.model.entity.UserEntity;
import com.github.hartorn.crystalchain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController extends GenericController<UserEntity, Long> {

  public UserController(UserService kindService) {
    super(kindService);
  }
}
