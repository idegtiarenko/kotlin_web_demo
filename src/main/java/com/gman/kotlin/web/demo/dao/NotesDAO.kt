package com.gman.kotlin.web.demo.dao

import com.gman.kotlin.web.demo.entity.Note

/**
 * @author gman
 * @since 09.05.13 22:09
 */
trait NotesDAO {

    fun findAll(): jet.MutableList<Note?>

    fun find(id: Long): Note?
    fun create(note: Note)
    fun update(note: Note)
    fun delete(note: Note)
    fun delete(id: Long)
}