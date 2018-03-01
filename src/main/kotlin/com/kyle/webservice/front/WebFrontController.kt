package com.kyle.webservice.front

import com.kyle.webservice.webservice.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebFrontController(val postsService: PostsService){

    @GetMapping("/")
    fun main(model: Model): String {
        model.addAttribute("posts", postsService.findAllDesc())
        return "main"
    }
}