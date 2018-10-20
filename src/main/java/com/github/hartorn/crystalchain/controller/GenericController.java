package com.github.hartorn.crystalchain.controller;

import com.github.hartorn.crystalchain.model.entity.Entity;
import com.github.hartorn.crystalchain.service.GenericService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
public abstract class GenericController<T extends Entity<ID>, ID> {
  private final GenericService<T, ID> kindService;

  @GetMapping()
  public List<T> getAllEntities() {
    return kindService.getAllEntities();
  }

  @PostMapping()
  public T createEntity(T toCreate) {
    return kindService.createEntity(toCreate);
  }

  @GetMapping("{id}")
  public T getEntityById(@PathVariable ID id) {
    return kindService.getEntityById(id);
  }

  @PatchMapping("{id}")
  public T mergeEntityById(@PathVariable ID id, @RequestBody T toMerge) {
    return kindService.mergeEntityById(id, toMerge);
  }

  @PutMapping("{id}")
  public T updateEntity(@PathVariable ID id, @RequestBody T toUpdate) {
    Assert.notNull(toUpdate, "toUpdate object should not be null");
    Assert.notNull(id, "id should not be null");
    toUpdate.setId(id);
    return kindService.updateEntity(toUpdate);
  }

  @DeleteMapping("{id}")
  public void deleteEntityById(@PathVariable ID id) {
    kindService.deleteEntityById(id);
  }
}
