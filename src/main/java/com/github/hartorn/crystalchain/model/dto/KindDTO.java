package com.github.hartorn.crystalchain.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "kind")
public class KindDTO extends AbstractAuditedDTO {

  enum TableType {
    USER,
    TRACE,
    ORGANIZATION
  }

  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "table")
  @Enumerated(EnumType.STRING)
  private TableType table;
}
