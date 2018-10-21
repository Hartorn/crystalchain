package com.github.hartorn.crystalchain.model.dto;

import com.github.hartorn.crystalchain.model.entity.Entity;
import lombok.Data;

@Data
public class TraceDTO implements Entity<Long> {
  private Long id;

  private String organisationName;

  private String woolTopLotNumber;

  private Integer woolTopNetWeight;

  private Integer woolTopGrossWeight;

  private Long kindId;

  private Long userId;

  private Long organisationId;
}
