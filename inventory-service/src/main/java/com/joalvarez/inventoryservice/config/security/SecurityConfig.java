package com.joalvarez.inventoryservice.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final SecurityProperties properties;
	private final KeycloakRealmRoleConverter keycloakConverter;

	public SecurityConfig(SecurityProperties properties, KeycloakRealmRoleConverter keycloakConverter) {
		this.properties = properties;
		this.keycloakConverter = keycloakConverter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable);

		http.authorizeHttpRequests(auth -> {
			this.properties.getEndpoints().forEach(endpoint -> {
				auth.requestMatchers(endpoint.getPath()).hasAnyRole(endpoint.getAuthorities().toArray(String[]::new));
			});

			auth.requestMatchers(this.properties.getExcludedPaths()).permitAll();

			auth.anyRequest().authenticated();
		});

		http.oauth2ResourceServer(conf -> conf.jwt(jwtConf -> jwtConf.jwtAuthenticationConverter(this.jwtAuthoritiesConverter())));

		return http.build();
	}

	private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthoritiesConverter() {
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(this.keycloakConverter);

		return converter;
	}

}
