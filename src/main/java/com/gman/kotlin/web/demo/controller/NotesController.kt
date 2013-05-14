package com.gman.kotlin.web.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model
import com.gman.kotlin.web.demo.service.NotesService
import org.springframework.beans.factory.annotation.Autowired
import com.gman.kotlin.web.demo.dao.impl.NotesDAOImpl
import com.gman.kotlin.web.demo.dao.NotesDAO
import com.gman.kotlin.web.demo.entity.Note
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import javax.validation.Valid
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import com.gman.kotlin.web.demo.entity.Priority

/**
 * @author gman
 * @since 09.05.13 22:09
 */
[Controller]
[RequestMapping(value = array("/notes"))]
class NotesController(

        [Autowired] var notesService: NotesService? = null

) {

    [RequestMapping(value = array("", "/all"))]
            fun notes(model: Model): String {

        model.addAttribute("notes", notesService!!.getAllNotes())

        return "notes"
    }

    [RequestMapping(value = array("/create"), method = array(RequestMethod.GET))]
            fun create(model: Model): String {

        model.addAttribute("action", "/notes/create")
        model.addAttribute("note", Note())
        model.addAttribute("priorities", Priority.values())

        return "note"
    }

    [RequestMapping(value = array("/create"), method = array(RequestMethod.POST))]
            fun createAction([ModelAttribute("note")] [Valid] note: Note, bindingResult: BindingResult): String {

        if (bindingResult.hasErrors()) {
            return "note";
        } else {
            notesService!!.create(note)
            return "redirect:/notes"
        }
    }

    [RequestMapping(value = array("/edit/{id}"), method = array(RequestMethod.GET))]
            fun edit(model: Model, [PathVariable] id: Long): String {

        model.addAttribute("action", "/notes/edit")
        model.addAttribute("note", notesService!!.read(id))
        model.addAttribute("priorities", Priority.values())

        return "note"
    }

    [RequestMapping(value = array("/edit"), method = array(RequestMethod.POST))]
            fun editAction([ModelAttribute("note")] [Valid] note: Note, bindingResult: BindingResult): String {

        if (bindingResult.hasErrors()) {
            return "note";
        } else {
            notesService!!.update(note)
            return "redirect:/notes"
        }
    }

    [RequestMapping(value = array("/delete/{id}"))]
            fun delete([PathVariable] id: Long): String {

        notesService!!.delete(id)

        return "redirect:/notes"
    }
}