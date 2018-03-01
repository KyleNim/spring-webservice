package com.kyle.webservice.webservice

import com.kyle.webservice.domain.PostsRepository
import com.kyle.webservice.dto.PostsMainResponseDto
import com.kyle.webservice.dto.PostsSaveRequestsDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostsService(private val postsRepository: PostsRepository){
    @Transactional
    fun save(dto: PostsSaveRequestsDto): Long {
        return postsRepository.save(dto.toEntity()).id!!
    }

    @Transactional(readOnly = true)
    fun findAllDesc() = postsRepository.findAllDesc()
            .map{ PostsMainResponseDto(it.id!!, it.title, it.author, it.modifiedDate!!) }

}