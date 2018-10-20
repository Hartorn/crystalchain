package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.Entity;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;

@Slf4j
@RequiredArgsConstructor
@NoRepositoryBean
public class GenericServiceImpl<T extends Entity<ID>, ID> implements  GenericService<T, ID> {

  private final JpaRepository<T,ID> kindRepository;
  private final EntityManager em;

  @Override
  public List<T> getAllEntities() {
    return kindRepository.findAll();
  }

  @Override
  public T createEntity(T kind) {
    Assert.notNull(kind, "Entity to create cannot be null");
    return kindRepository.save(kind);
  }

  @Override
  public T getEntityById(ID id) {
    Assert.notNull(id, "Id must be filled");
    return kindRepository.getOne(id);
  }

  @Override
  public T mergeEntityById(ID id, T toMerge) {
    Assert.notNull(id, "Id must be filled");
    Assert.notNull(toMerge, "Kind to merge cannot be null");

    toMerge.setId(id);
    return em.merge(toMerge);
  }

  @Override
  public T updateEntity(T toUpdate) {
    Assert.notNull(toUpdate, "Kind to update cannot be null");
    Assert.notNull(toUpdate.getId(), "Entity must have an id");

    return kindRepository.save(toUpdate);
  }

  @Override
  public void deleteEntityById(ID id) {
    Assert.notNull(id, "Id must be filled");
    kindRepository.deleteById(id);
  }
}
