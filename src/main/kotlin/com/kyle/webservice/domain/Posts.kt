package com.kyle.webservice.domain

import javax.persistence.*

@Entity
data class Posts (
        @get:Id
        @get:GeneratedValue
        var id: Long? = null,
        @Column(length = 500, nullable = false)
        var title: String,
        @Column(columnDefinition = "TEXT", nullable = false)
        var content: String,
        var author: String) : BaseTimeEntity()