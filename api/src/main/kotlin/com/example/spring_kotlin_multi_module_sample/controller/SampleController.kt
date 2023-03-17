package com.example.spring_kotlin_multi_module_sample.controller

import com.example.spring_kotlin_multi_module_sample.data.SampleEntity
import com.example.spring_kotlin_multi_module_sample.data.SampleRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZonedDateTime
import java.util.UUID
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("sample")
class SampleController(private val sampleRepository: SampleRepository) {

    @GetMapping
    @Transactional(readOnly = true)
    fun findAll(): List<SampleEntity> = sampleRepository.findAll()

    @PostMapping
    @Transactional
    fun postSample(@RequestBody @Validated req: Req): UUID {
        val id = UUID.randomUUID()
        sampleRepository.save(
            SampleEntity(
                sampleId = id,
                sampleName = req.sampleName!!,
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now()
            )
        )
        return id
    }

    class Req {
        @NotBlank
        var sampleName: String? = null
    }
}
