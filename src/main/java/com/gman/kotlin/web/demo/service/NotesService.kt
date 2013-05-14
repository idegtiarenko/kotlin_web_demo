package com.gman.kotlin.web.demo.service

import com.gman.kotlin.web.demo.entity.Note

/**
 * @author gman
 * @since 09.05.13 22:09
 */
trait NotesService {

    fun getAllNotes(): jet.MutableList<Note?>
    fun create(note: Note)
    fun read(id: Long): Note
    fun update(note: Note)
    fun delete(id: Long)
}