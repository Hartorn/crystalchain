package com.github.hartorn.crystalchain.model.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@javax.persistence.Entity(name = "kind")
public class KindEntity extends AbstractAuditedEntity implements Entity<Long> {

  public enum TableType {
    USER,
    TRACE,
    ORGANIZATION
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "table")
  @Enumerated(EnumType.STRING)
  private TableType table;
}
