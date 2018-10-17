package com.github.hartorn.crystalchain.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "organisation")
public class OrganisationDTO extends AbstractAuditedDTO {
  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "country")
  private String country;

  @ManyToOne(optional = false)
  private KindDTO kind;

}
