package com.github.hartorn.crystalchain.security;

import com.github.hartorn.crystalchain.repository.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class SecurityHelper {

  private static final String ADMIN = "ADMIN";
  private final SecurityContextHolderAwareRequestWrapper securityWrapper;
  private final OrganisationRepository organisationRepository;

  private UserDetails getUserDetails() {
    return (UserDetails) ((Authentication) securityWrapper.getUserPrincipal()).getPrincipal();
  }

  public boolean isAdmin() {
    return ADMIN.equals(organisationRepository.getOne(getOrganisationId()).getKind().getName());
  }

  public Long getOrganisationId() {
    UserDetails user = getUserDetails();
    return Long.parseLong(
        user.getAuthorities()
            .stream()
            .map(elt -> elt.getAuthority())
            .findAny()
            .orElseThrow(() -> new UnsupportedOperationException("No organisation found")));
  }
}
