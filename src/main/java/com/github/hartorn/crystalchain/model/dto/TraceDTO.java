package com.github.hartorn.crystalchain.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "trace")
public class TraceDTO extends AbstractAuditedDTO {
  @Id
  @GeneratedValue
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
  private KindDTO kind;

}
