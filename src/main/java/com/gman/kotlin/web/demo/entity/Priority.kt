package com.gman.kotlin.web.demo.entity

/**
 * @author gman
 * @since 12.05.13 9:50
 */
enum class Priority(val style: String) {
    HIGH : Priority("red")
    MEDIUM : Priority("yellow")
    LOW: Priority("green")
}