package com.example.spring_kotlin_multi_module_sample.data

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime
import java.util.UUID
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
private class SampleRepositoryTest {

    @Autowired
    lateinit var sampleRepository: SampleRepository

    @Autowired
    lateinit var entityManager: EntityManager

    @Test
    fun test() {
        sampleRepository.save(
            SampleEntity(
                sampleId = UUID.randomUUID(),
                sampleName = "sampleName",
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now(),
            )
        )
        entityManager.flush()
        entityManager.clear()
        println(
            sampleRepository.findAll()
        )
    }
}