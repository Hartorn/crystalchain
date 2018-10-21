package com.github.hartorn.crystalchain.model.dto;

import com.github.hartorn.crystalchain.model.entity.Entity;
import lombok.Data;

@Data
public class UserDTO implements Entity<Long> {
  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private Long kindId;

  private Long organisationId;
}
