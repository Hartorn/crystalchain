package com.github.hartorn.crystalchain.model.dto;

import com.github.hartorn.crystalchain.model.entity.Entity;
import com.github.hartorn.crystalchain.model.entity.KindEntity;
import lombok.Data;

@Data
public class KindDTO implements Entity<Long> {

  private Long id;

  private String name;

  private KindEntity.TableType table;
}
