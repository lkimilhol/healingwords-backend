package com.lkimilhol.healingwords.writer.token

import com.lkimilhol.healingwords.writer.domain.Email
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.util.*

@Service
class JwtTokenService(
    @Value("\${spring.jwt.secret}") private val secretKey: String
) {
    companion object {
        private const val TOKEN_VALID_SECOND = 30 * 60 * 1000L
    }

    fun generateToken(email: Email) : String {
        val key = Keys.hmacShaKeyFor((secretKey.toByteArray(StandardCharsets.UTF_8)))
        val claims = Jwts.claims().setSubject(email.contents())
        val now = Date()

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + TOKEN_VALID_SECOND))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun isValid(token: String) : Boolean {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey.toByteArray(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(token)
                .body

            !claims.expiration.before(Date())
        } catch (e: JwtException) {
            false
        } catch (e: IllegalArgumentException) {
            false
        }
    }


}