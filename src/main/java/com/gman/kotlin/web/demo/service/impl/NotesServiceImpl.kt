package com.gman.kotlin.web.demo.service.impl

import com.gman.kotlin.web.demo.service.NotesService
import org.springframework.stereotype.Service
import com.gman.kotlin.web.demo.entity.Note
import org.springframework.transaction.annotation.Transactional
import com.gman.kotlin.web.demo.dao.NotesDAO
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author gman
 * @since 09.05.13 22:42
 */
[Service]
open class NotesServiceImpl(

        [Autowired] var notesDAO: NotesDAO? = null

): NotesService{

    [Transactional(readOnly = true)]
    override fun getAllNotes(): jet.MutableList<Note?> {
        return notesDAO!!.findAll()
    }

    [Transactional]
    override fun create(note: Note) {
        notesDAO!!.create(note)
    }

    [Transactional(readOnly = true)]
    override fun read(id: Long): Note {
        val note = notesDAO!!.find(id)
        if (note != null) {
            return note
        } else {
            return Note()
        }
    }

    [Transactional]
    override fun update(note: Note) {
        notesDAO!!.update(note)
    }

    [Transactional]
    override fun delete(id: Long) {
        notesDAO!!.delete(id)
    }
}