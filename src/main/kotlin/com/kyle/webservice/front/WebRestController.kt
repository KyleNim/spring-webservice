package com.kyle.webservice.front

import com.kyle.webservice.domain.Posts
import com.kyle.webservice.domain.PostsRepository
import com.kyle.webservice.dto.PostsSaveRequestsDto
import com.kyle.webservice.webservice.PostsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebRestController(val postsService: PostsService) {

    @GetMapping("/hello")
    fun hello() = "Hello World!"

    @PostMapping("/posts")
    fun savePosts(@RequestBody dto: PostsSaveRequestsDto) : Long{
        return postsService.save(dto)
    }

}