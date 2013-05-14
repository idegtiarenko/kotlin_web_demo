package com.gman.kotlin.web.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model


/**
 * @author gman
 * @since 09.05.13 13:16
 */
[Controller]
class IndexController {

    [RequestMapping(value = array("/", "/index"))]
    fun index(): String {

        return "redirect:/notes"
    }
}