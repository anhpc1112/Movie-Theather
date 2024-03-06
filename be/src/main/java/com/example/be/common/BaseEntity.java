package com.example.be.common;

import com.example.be.utils.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @JsonFormat(pattern = Constants.DATE_TIME_PATTERN, timezone = Constants.DATE_TIME_ZONE)
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by", nullable = true, updatable = false)
    private String createdBy;

    @LastModifiedDate
    @JsonFormat(pattern = Constants.DATE_TIME_PATTERN, timezone = Constants.DATE_TIME_ZONE)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @LastModifiedDate
    @Column(name = "updated_by", nullable = true, updatable = true)
    private String updatedBy;
}
