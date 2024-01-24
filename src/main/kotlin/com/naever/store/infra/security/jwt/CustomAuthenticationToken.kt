package com.naever.store.infra.security.jwt

import com.naever.store.infra.security.UserPrincipal
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.web.authentication.WebAuthenticationDetails
import java.io.Serializable

class CustomAuthenticationToken(
    private val principal: UserPrincipal,
    details: WebAuthenticationDetails
) :AbstractAuthenticationToken(principal.authority), Serializable {
    init {
        super.setAuthenticated(true)
        super.setDetails(details)
    }

    override fun getCredentials(): Any {
        TODO("Not yet implemented")
    }

    override fun getPrincipal(): Any {
        return principal
    }

    override fun isAuthenticated(): Boolean {
        return true
    }
}