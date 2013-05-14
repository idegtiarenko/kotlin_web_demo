package com.gman.kotlin.web.demo.service

import com.gman.kotlin.web.demo.entity.User

/**
 * @author gman
 * @since 12.05.13 11:58
 */
trait UserService {

    fun getCurrentUser(): User;
    fun isNameOccupied(name: String): Boolean;
    fun register(user: User);
    fun update(user: User);
}