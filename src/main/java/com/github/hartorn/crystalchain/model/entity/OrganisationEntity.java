package com.github.hartorn.crystalchain.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@javax.persistence.Entity(name = "organisation")
public class OrganisationEntity extends AbstractAuditedEntity implements Entity<Long> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "country")
  private String country;

  @ManyToOne(optional = false)
  private KindEntity kind;
}
