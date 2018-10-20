package com.github.hartorn.crystalchain.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@javax.persistence.Entity(name = "user")
public class UserEntity extends AbstractAuditedEntity implements Entity<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private KindEntity kind;

  @ManyToOne(optional = false)
  private OrganisationEntity organisation;
}
