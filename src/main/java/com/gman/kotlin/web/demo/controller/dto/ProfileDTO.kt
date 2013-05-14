package com.gman.kotlin.web.demo.controller.dto

import javax.validation.constraints.Size
import com.gman.kotlin.web.demo.entity.User
import java.security.NoSuchAlgorithmException
import java.security.MessageDigest

/**
 * @author gman
 * @since 12.05.13 12:23
 */
class ProfileDTO(

        public var id: jet.Long = 0,
        [Size(min=5, max=20)] public var name: jet.String = "",
        [Size(min=5, max=20)] public var password: jet.String = "",
        public var passwordRepeat: jet.String = ""

) {

    fun populateFrom(user: User) {
        this.id = user.id
        this.name = user.name
    }

    fun populateInto(user: User) {
        user.name = this.name
        user.password = this.password
    }

    fun passwordMatchName(): Boolean {
        return password.equals(name)
    }

    fun passwordsMatch(): Boolean {
        return password.equals(passwordRepeat)
    }
}