package com.github.hartorn.crystalchain.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@javax.persistence.Entity(name = "trace")
public class TraceEntity extends AbstractAuditedEntity implements Entity<Long> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "organisation_name")
  private String organisationName;

  @Column(name = "wool_top_lot_number")
  private String woolTopLotNumber;

  @Column(name = "wool_top_net_weight")
  private Integer woolTopNetWeight;

  @Column(name = "wool_top_gross_weight")
  private Integer woolTopGrossWeight;

  @ManyToOne(optional = false)
  private KindEntity kind;

  @ManyToOne(optional = false)
  private UserEntity user;

  @ManyToOne(optional = false)
  private OrganisationEntity organisation;
}
