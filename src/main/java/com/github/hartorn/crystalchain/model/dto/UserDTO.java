package com.github.hartorn.crystalchain.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "user")
public class UserDTO extends AbstractAuditedDTO {

  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @ManyToOne(optional = false)
  private KindDTO kind;

  @ManyToOne(optional = false)
  private OrganisationDTO organisation;

}
