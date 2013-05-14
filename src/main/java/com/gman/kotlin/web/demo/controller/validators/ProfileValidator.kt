package com.gman.kotlin.web.demo.controller.validators

import org.springframework.validation.Validator
import org.springframework.validation.Errors
import com.gman.kotlin.web.demo.controller.dto.ProfileDTO
import org.springframework.beans.factory.annotation.Autowired
import com.gman.kotlin.web.demo.service.UserService


/**
 * @author gman
 * @since 12.05.13 14:08
 */
class ProfileValidator(

        val userService: UserService

): Validator {


    public override fun supports(clazz: Class<out Any?>?): Boolean {
        return javaClass<ProfileDTO>().equals(clazz)
    }
    public override fun validate(target: Any?, errors: Errors?) {
        val profile = (target as ProfileDTO)

        if (!profile.passwordsMatch()) {
            errors!!.rejectValue("password", "Match.profile.password")
        }
        if (profile.passwordMatchName()) {
            errors!!.rejectValue("password", "Match.profile.name")
        }
        if (userService.isNameOccupied(profile.name)) {
            errors!!.rejectValue("name", "Occupied.profile.name")
        }
    }
}