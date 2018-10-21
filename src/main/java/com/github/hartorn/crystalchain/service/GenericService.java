package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.Entity;
import java.util.List;

/** Service for operation on kind. */
public interface GenericService<T extends Entity<ID>, D, ID> {

  List<T> getAllEntities();

  T createEntity(D kind);

  T getEntityById(ID id);

  T mergeEntityById(ID id, D toMerge);

  T updateEntity(D toUpdate);

  void deleteEntityById(ID id);
}
