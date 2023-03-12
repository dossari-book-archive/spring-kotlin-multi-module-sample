package com.example.spring_kotlin_multi_module_sample

import org.springframework.data.jpa.repository.JpaRepository
import java.time.ZonedDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

interface SampleRepository : JpaRepository<SampleEntity, UUID>

@Entity
@Table(name = "sample")
data class SampleEntity(
    @Id
    @Column(name = "sample_id")
    val sampleId: UUID,
    @Column(name = "sample_name")
    val sampleName: String,
    @Column(name = "created_at")
    val createdAt: ZonedDateTime,
    @Column(name = "updated_at")
    val updatedAt: ZonedDateTime,
)
