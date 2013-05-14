package com.gman.kotlin.web.demo.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.validation.constraints.Size
import javax.persistence.Enumerated
import javax.persistence.EnumType

/**
 * @author gman
 * @since 09.05.13 22:09
 */
[Entity]
open class Note(

        [Id] [GeneratedValue(strategy = GenerationType.AUTO)] public open var id: jet.Long = 0,
        [Size(min=1, max=20)] [Column(length=20)] public open var title: jet.String = "",
        [Size(min=1, max=1024)] [Column(length=1024)] public open var body: jet.String = "",
        [Enumerated(EnumType.ORDINAL)] public open var priority: Priority = Priority.MEDIUM

)

