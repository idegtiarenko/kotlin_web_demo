package com.gman.kotlin.web.demo.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.validation.constraints.Size
import javax.persistence.Column
import javax.persistence.Enumerated
import javax.persistence.EnumType

/**
 * @author gman
 * @since 12.05.13 11:45
 */
[Entity]
open class User(

        [Id] [GeneratedValue(strategy = GenerationType.AUTO)] public open var id: jet.Long = 0,
        [Size(min=5, max=20)] [Column(length=20)] public open var name: jet.String = "",
        [Size(min=1, max=20)] [Column(length=20)] public open var password: jet.String = "",
        [Enumerated(EnumType.STRING)] public open var role: Role = Role.ROLE_ANONYMOUS

)