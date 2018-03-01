package com.kyle.webservice.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebControllerTest{

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

//    @Test
//    fun 메인페이지_로딩(){
////        //when
////        val body = this.restTemplate.getForObject("/", String::class.java)
////
////        //then
////        assertThat(body).contains("스프링부트로 시작하는 웹 서비스")
//    }



}

