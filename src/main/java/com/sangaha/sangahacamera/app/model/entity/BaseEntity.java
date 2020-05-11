package com.sangaha.sangahacamera.app.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    @Column(columnDefinition = "DATETIME NOT NULL DEFAULT NOW() COMMENT '생성일시'")
    private LocalDateTime createdAt;
    
    @Column(columnDefinition = "DATETIME DEFAULT NULL COMMENT '수정일시'")
    private LocalDateTime updatedAt;
    
    @Column(columnDefinition = "BIT(1) NOT NULL DEFAULT 0 COMMENT '삭제여부'")
    private boolean deletedFlags = false;
    
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
