package com.lkimilhol.healingwords.token

import com.lkimilhol.healingwords.exception.InvalidTokenException
import com.lkimilhol.healingwords.writer.domain.Email
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class RequestAspect(
    val jwtTokenService: JwtTokenService,
    val writerRepository: WriterRepository
) {

    @Before("@annotation(com.lkimilhol.healingwords.token.LoginCheck)")
    fun validateToken(joinPoint: JoinPoint) {
        val servletRequestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val token = servletRequestAttributes.request.getHeader("current-user")

        // TODO 개발 용도 추후 화이트리스트 방법으로 개발 되어야 한다.
        if (token == "test-manager") {
            return
        }

        if (jwtTokenService.isInvalid(token)) {
            throw InvalidTokenException()
        }

        val email = jwtTokenService.decodeToken(token)

        if (!writerRepository.existsByEmail(Email.create(email))) {
            throw InvalidTokenException()
        }
    }
}
