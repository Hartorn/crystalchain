package com.github.hartorn.crystalchain.service;

import com.github.hartorn.crystalchain.model.entity.Entity;
import java.util.List;

/** Service for operation on kind. */
public interface GenericService<T extends Entity<ID>, ID> {

  List<T> getAllEntities();

  T createEntity(T kind);

  T getEntityById(ID id);

  T mergeEntityById(ID id, T toMerge);

  T updateEntity(T toUpdate);

  void deleteEntityById(ID id);
}
