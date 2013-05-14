package com.gman.kotlin.web.demo.dao.impl

import org.springframework.stereotype.Repository
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import com.gman.kotlin.web.demo.entity.User
import com.gman.kotlin.web.demo.dao.UserDAO
import javax.persistence.NoResultException

/**
 * @author gman
 * @since 12.05.13 11:51
 */
[Repository]
open class UserDAOImpl(

        [PersistenceContext]
        var em: EntityManager? = null,
        val clazz: Class<User> = javaClass<User>()

): UserDAO {

    override fun findAll(): jet.MutableList<User?> {
        return (em!!.createQuery("select u from User u")!!.getResultList() as jet.MutableList<User?>)
    }
    override fun find(id: Long): User? {
        return em!!.find(clazz, id)
    }
    override fun create(user: User) {
        em!!.persist(user)
    }
    override fun update(user: User) {
        em!!.merge(user)
    }
    override fun delete(user: User) {
        em!!.remove(user)
    }
    override fun delete(id: Long) {
        val user = find(id)
        if (user != null) {
            delete(user)
        }
    }
    override fun findByName(name: String): User {
        try {
            return (em!!.createQuery("select u from User u where name = :name")!!.setParameter("name", name)!!.getSingleResult() as User)
        } catch (e: NoResultException) {
            return User();
        }
    }
    override fun isNameOccupied(name: String): Boolean {
        return !em!!.createQuery("select u from User u where name = :name")!!.setParameter("name", name)!!.getResultList()!!.isEmpty()
    }
}