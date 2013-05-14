package com.gman.kotlin.web.demo.dao

import com.gman.kotlin.web.demo.entity.User

/**
 * @author gman
 * @since 12.05.13 11:50
 */
trait UserDAO {

    fun findAll(): jet.MutableList<User?>

    fun find(id: Long): User?
    fun create(user: User)
    fun update(user: User)
    fun delete(user: User)
    fun delete(id: Long)

    fun findByName(name: String): User;
    fun isNameOccupied(name: String): Boolean;
}