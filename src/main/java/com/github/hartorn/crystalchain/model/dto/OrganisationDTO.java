package com.github.hartorn.crystalchain.model.dto;

import com.github.hartorn.crystalchain.model.entity.Entity;
import lombok.Data;

@Data
public class OrganisationDTO implements Entity<Long> {
  private Long id;

  private String name;

  private String country;

  private Long kindId;
}
