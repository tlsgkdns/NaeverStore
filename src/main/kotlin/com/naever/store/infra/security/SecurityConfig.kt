package com.naever.store.infra.security

import com.naever.store.infra.security.jwt.CustomAuthenticationToken
import com.naever.store.infra.security.jwt.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    private val allowedUrls = arrayOf("/", "/swagger-ui/**", "/v3/**", "/users", "/users/login")
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain = http
        .csrf{it.disable()}
        .authorizeHttpRequests {
            requests -> requests.requestMatchers(*allowedUrls).permitAll()
            requests.anyRequest().authenticated()
        }
        .sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
        .build()!!
}