package com.github.hartorn.crystalchain.security;

import com.github.hartorn.crystalchain.model.entity.KindEntity;
import com.github.hartorn.crystalchain.model.entity.OrganisationEntity;
import com.github.hartorn.crystalchain.model.entity.TraceEntity;
import com.github.hartorn.crystalchain.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

@Slf4j
public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot
    implements MethodSecurityExpressionOperations {

  @Getter @Setter private Object filterObject;
  @Getter @Setter private Object returnObject;
  @Setter private ApplicationContext applicationContext;
  // @Setter private SecurityHelper securityHelper;

  public CustomMethodSecurityExpressionRoot(Authentication authentication) {
    super(authentication);
  }

  @Override
  public Object getThis() {
    return this;
  }

  public SecurityHelper getSecurityHelper() {
    return this.applicationContext.getBean(SecurityHelper.class);
  }

  public boolean hasRightOrga(Object toCheck) {
    if (getSecurityHelper().isAdmin() || toCheck instanceof KindEntity) {
      return true;
    }
    Long orgaId;
    if (toCheck instanceof UserEntity) {
      orgaId = ((UserEntity) toCheck).getOrganisation().getId();
    } else if (toCheck instanceof OrganisationEntity) {
      orgaId = ((OrganisationEntity) toCheck).getId();
    } else if (toCheck instanceof TraceEntity) {
      orgaId = ((TraceEntity) toCheck).getOrganisation().getId();
    } else {
      log.warn("Unhandled entity to secure " + toCheck.getClass().getName());
      return false;
    }

    return getSecurityHelper().getOrganisationId().equals(orgaId);
  }
}
