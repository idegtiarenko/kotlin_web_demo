package com.gman.kotlin.web.demo.service.impl

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.gman.kotlin.web.demo.dao.UserDAO
import com.gman.kotlin.web.demo.service.UserService
import com.gman.kotlin.web.demo.entity.User
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.transaction.annotation.Transactional

/**
 * @author gman
 * @since 12.05.13 12:00
 */
[Service]
open class UserServiceImpl(

        [Autowired] var userDAO: UserDAO? = null

): UserService {

    [Transactional(readOnly = true)]
    override fun getCurrentUser(): User {
        val name = SecurityContextHolder.getContext()!!.getAuthentication()!!.getName()!!
        return userDAO!!.findByName(name)
    }

    [Transactional(readOnly = true)]
    override fun isNameOccupied(name: String): Boolean {
        return userDAO!!.isNameOccupied(name)
    }

    [Transactional]
    override fun register(user: User) {
        return userDAO!!.create(user)
    }

    [Transactional]
    override fun update(user: User) {
        return userDAO!!.update(user)
    }
}