package com.github.hartorn.crystalchain.config;

import com.github.hartorn.crystalchain.security.CustomMethodSecurityExpressionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

  private final ApplicationContext applicationContext;

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    CustomMethodSecurityExpressionHandler expressionHandler =
        new CustomMethodSecurityExpressionHandler();
     expressionHandler.setApplicationContext(this.applicationContext);
    //    expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
    return expressionHandler;
  }
}
