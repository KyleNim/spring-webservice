package com.kyle.webservice.dto

import com.kyle.webservice.domain.Posts

data class PostsSaveRequestsDto(var title: String, var content: String, var author: String){
    fun toEntity() = Posts(title = title,
            content = content,
            author = author)
}