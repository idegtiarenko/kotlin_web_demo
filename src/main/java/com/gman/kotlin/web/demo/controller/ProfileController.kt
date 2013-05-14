package com.gman.kotlin.web.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model
import org.springframework.beans.factory.annotation.Autowired
import com.gman.kotlin.web.demo.service.UserService
import com.gman.kotlin.web.demo.controller.dto.ProfileDTO
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ModelAttribute
import javax.validation.Valid
import org.springframework.validation.BindingResult
import com.gman.kotlin.web.demo.entity.User
import com.gman.kotlin.web.demo.entity.Role
import com.gman.kotlin.web.demo.controller.validators.ProfileValidator

/**
 * @author gman
 * @since 12.05.13 10:59
 */
[Controller]
class ProfileController(

        [Autowired] var userService: UserService? = null

) {

    [RequestMapping(value = array("/login"))]
    fun login(model: Model): String {

        model.addAttribute("isFail", false)

        return "login"
    }

    [RequestMapping(value = array("/login/fail"))]
    fun loginFail(model: Model): String {

        model.addAttribute("isFail", true)

        return "login"
    }

    [RequestMapping(value = array("/register"), method = array(RequestMethod.GET))]
    fun register(model: Model): String {

        model.addAttribute("action", "/register")
        model.addAttribute("profile", ProfileDTO())

        return "profile"
    }

    [RequestMapping(value = array("/register"), method = array(RequestMethod.POST))]
    fun registerAction([ModelAttribute("profile")] [Valid] profile: ProfileDTO, bindingResult: BindingResult): String {

        val validator = ProfileValidator(userService!!)
        validator.validate(profile, bindingResult)

        if (bindingResult.hasErrors()) {
            return "profile";
        } else {
            val user = User()
            profile.populateInto(user)
            user.role = Role.ROLE_USER
            userService!!.register(user)
            return "redirect:/notes"
        }
    }

    [RequestMapping(value = array("/profile"), method = array(RequestMethod.GET))]
    fun profile(model: Model): String  {

        val currentUser = userService!!.getCurrentUser()
        val profile = ProfileDTO();
        profile.populateFrom(currentUser)

        model.addAttribute("action", "/profile")
        model.addAttribute("profile", profile)

        return "profile"
    }

    [RequestMapping(value = array("/profile"), method = array(RequestMethod.POST))]
    fun profileAction([ModelAttribute("profile")] [Valid] profile: ProfileDTO, bindingResult: BindingResult): String  {

        val validator = ProfileValidator(userService!!)
        validator.validate(profile, bindingResult)

        if (bindingResult.hasErrors()) {
            return "profile"
        } else {
            val user = userService!!.getCurrentUser()
            profile.populateInto(user)
            userService!!.update(user)
            return "redirect:/notes"
        }
    }
}