package com.gman.kotlin.web.demo.dao.impl

import com.gman.kotlin.web.demo.dao.NotesDAO
import org.springframework.stereotype.Repository
import com.gman.kotlin.web.demo.entity.Note
import javax.persistence.EntityManager
import java.util.Collections
import javax.persistence.PersistenceContext

/**
 * @author gman
 * @since 09.05.13 22:17
 */
[Repository]
open class NotesDAOImpl(

        [PersistenceContext]
        var em: EntityManager? = null,
        val clazz: Class<Note> = javaClass<Note>()

): NotesDAO {

    override fun findAll(): jet.MutableList<Note?> {
        return (em!!.createQuery("select n from Note n")!!.getResultList() as jet.MutableList<Note?>)
    }
    override fun find(id: Long): Note? {
        return em!!.find(clazz, id)
    }
    override fun create(note: Note) {
        em!!.persist(note)
    }
    override fun update(note: Note) {
        em!!.merge(note)
    }
    override fun delete(note: Note) {
        em!!.remove(note)
    }
    override fun delete(id: Long) {
        val note = find(id)
        if (note != null) {
            delete(note)
        }
    }
}