package com.lkimilhol.healingwords.token

import com.fasterxml.jackson.databind.ObjectMapper
import com.lkimilhol.healingwords.exception.InvalidTokenException
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

    fun decodeToken(token: String): String {
        val parts = token.split(".")
        val charset = charset("UTF-8")
        val payload = String(Base64.getUrlDecoder().decode(parts[1].toByteArray(charset)), charset)

        val mapper = ObjectMapper()
        val readValue = mapper.readValue(payload, Map::class.java) ?: throw InvalidTokenException()

        return readValue["sub"].toString()
    }

    fun isInvalid(token: String) : Boolean {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey.toByteArray(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(token)
                .body

            claims.expiration.before(Date())
        } catch (e: JwtException) {
            true
        } catch (e: IllegalArgumentException) {
            true
        }
    }

    companion object {
        private const val TOKEN_VALID_SECOND = 30 * 60 * 1000L
    }
}
