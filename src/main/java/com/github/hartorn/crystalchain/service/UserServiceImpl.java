package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.UserEntity;
import com.github.hartorn.crystalchain.repository.UserRepository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
@Repository
public class UserServiceImpl extends GenericServiceImpl<UserEntity, Long> implements UserService {

  public UserServiceImpl(
      UserRepository kindRepository,
      EntityManager em) {
    super(kindRepository, em);
  }
}
