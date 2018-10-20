package com.github.hartorn.crystalchain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class AbstractAuditedEntity {
  @Column(name = "created_date", nullable = false, updatable = false)
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Column(name = "modified_date")
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date modifiedDate;
}
