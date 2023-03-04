package com.lkimilhol.healingwords.token

import java.lang.annotation.Inherited

@Inherited
@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.FUNCTION])
annotation class LoginCheck {
}