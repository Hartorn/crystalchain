package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.Entity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.util.Assert;

@Slf4j
@RequiredArgsConstructor
@NoRepositoryBean
@Transactional
public class GenericServiceImpl<T extends Entity<ID>, D extends Entity<ID>, ID>
    implements GenericService<T, D, ID> {

  private final JpaRepository<T, ID> kindRepository;
  private final EntityManager em;
  protected final ModelMapper mapper;
  private final Class<T> klass;

  @Override
  public List<T> getAllEntities() {
    return kindRepository.findAll();
  }

  @Override
  @PostAuthorize("hasRightOrga(returnObject)")
  public T createEntity(D kind) {
    Assert.notNull(kind, "Entity to create cannot be null");
    T toCreate = convertDTOToEntity(kind, this.klass);
    return kindRepository.save(toCreate);
  }

  private void mapDTOToEntity(D dto, T entity) {
    mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    mapper.map(dto, entity);
    mapCustomDTOtoEntity(dto, entity);
  }

  protected void mapCustomDTOtoEntity(D dto, T entity) {
    // to be overrider
  }

  private T convertDTOToEntity(D dto, Class<T> klass) {
    T result;
    if (dto.getId() != null) {
      result = getEntityById(dto.getId());
      mapper.map(dto, result);
    } else {
      result = mapper.map(dto, klass);
    }
    mapCustomDTOtoEntity(dto, result);

    return result;
  }

  @Override
  @PostAuthorize("hasRightOrga(returnObject)")
  public T getEntityById(ID id) {
    Assert.notNull(id, "Id must be filled");
    return kindRepository.getOne(id);
  }

  @Override
  public T mergeEntityById(ID id, D toMerge) {
    Assert.notNull(id, "Id must be filled");
    Assert.notNull(toMerge, "Object to merge cannot be null");
    T loaded = getEntityById(id);
    mapDTOToEntity(toMerge, loaded);
    return em.merge(loaded);
  }

  @Override
  @PostAuthorize("hasRightOrga(returnObject)")
  public T updateEntity(D toUpdate) {
    Assert.notNull(toUpdate, "Object to update cannot be null");
    Assert.notNull(toUpdate.getId(), "Entity must have an id");
    T entity = convertDTOToEntity(toUpdate, this.klass);
    return kindRepository.save(entity);
  }

  @Override
  public void deleteEntityById(ID id) {
    Assert.notNull(id, "Id must be filled");
    kindRepository.deleteById(id);
  }
}
