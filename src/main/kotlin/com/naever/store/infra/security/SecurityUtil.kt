package com.naever.store.infra.security

import org.springframework.security.core.context.SecurityContextHolder

class SecurityUtil {

    companion object{
        fun getLoginUserId():Long?
        {
            return (SecurityContextHolder.getContext()?.authentication?.principal as? UserPrincipal)?.id
        }
    }
}