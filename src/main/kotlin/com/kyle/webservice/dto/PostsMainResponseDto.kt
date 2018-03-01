package com.kyle.webservice.dto

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostsMainResponseDto(val id: Long,
                           val title: String,
                           val author: String,
                           val modifiedDate: LocalDateTime
){
    fun toStringDateTime(localDateTime: LocalDateTime) : String{
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return localDateTime?.format(formatter)?:""
    }
}