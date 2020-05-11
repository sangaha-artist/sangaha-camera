package com.sangaha.sangahacamera.app.sticker.model.entity;

import com.sangaha.sangahacamera.app.model.entity.BaseEntity;
import com.sangaha.sangahacamera.app.model.enums.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sticker extends BaseEntity {
    
    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stickerId")
    private long id;
    
    /**
     * 스티커
     */
    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT '스티커명'")
    private String name;
    
    /**
     * 스티커 이미지 경로
     */
    @Column(columnDefinition = "TEXT NOT NULL COMMENT '스티커 이미지 경로'")
    private String imgUrl;
    
    /**
     * 제작자
     */
    @Column(columnDefinition = "BIGINT(20) NOT NULL COMMENT '제작자'")
    private long creator;
    
    /**
     * 스티커 접근 가능 범위 (PRIVATE, AUTHORIZED, PUBLIC)
     */
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '접근가능범위'")
    private AccessType accessType;
    
    
    
    
}
