package com.kyle.webservice.service

import com.kyle.webservice.domain.PostsRepository
import com.kyle.webservice.dto.PostsSaveRequestsDto
import com.kyle.webservice.webservice.PostsService
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class PostServiceTest{

    @Autowired
    lateinit var postsService: PostsService

    @Autowired
    lateinit var postRepository: PostsRepository

    @After
    fun clean() = postRepository.deleteAll()

    @Test
    fun Dto데이터가_posts데이블에_저장된다(){
        //given
        val dto = PostsSaveRequestsDto(title = "테스트 타이틀",
                author = "kyle",
                content = "테스트")

        //when
        postsService.save(dto)

        //then
        val posts = postRepository.findAll()[0]
        assertThat(posts.author).isEqualTo(dto.author)
        assertThat(posts.content).isEqualTo(dto.content)
        assertThat(posts.title).isEqualTo(dto.title)
    }


}