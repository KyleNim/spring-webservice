package com.kyle.webservice.domain

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class PostRepositoryTest(){

    @Autowired
    lateinit var postsRepository: PostsRepository

    @After
    fun cleanup(){
        /** 이후 테스트 코드에 영향을 끼치지 않기 위해
         * 테스트 메소드가 끝날때 마다 respository 전체 비우는 코드 **/
        postsRepository.deleteAll()
    }

    @Test
    fun 게시글저장_불러오기(){
        //given
        postsRepository.save(
            Posts(title = "테스트 게시글",
                    content = "테스트 본문",
                    author = "kyle.y@kakaobank.com")
        )

        //when
        val postsList: List<Posts> = postsRepository.findAll()

        //then
        val posts = postsList[0]
        assertEquals(posts.title, "테스트 게시글")
        assertEquals(posts.content, "테스트 본문")
    }

    @Test
    fun BaseTimeEntity_등록(){
        //given
        val now = LocalDateTime.now()

        postsRepository.save(
                Posts(title = "테스트 게시글",
                        content = "테스트 본문",
                        author = "kyle.y@kakaobank.com")
        )

        //when
        val postList = postsRepository.findAll()

        //then
        val posts = postList[0]
        assertTrue(posts.createdDate?.isAfter(now)?:false)
        assertTrue(posts.modifiedDate?.isAfter(now)?:false)

        var a = """SELECT p
                    FROM Posts p
                    ORDER BY p.id DESC"""


    }
}