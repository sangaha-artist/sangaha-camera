package com.sangaha.sangahacamera.app.user.model.entity;

import com.sangaha.sangahacamera.app.model.entity.BaseEntity;
import com.sangaha.sangahacamera.app.model.enums.UserGrade;
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
public class User extends BaseEntity {
    
    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long id;
    
    /**
     * 이름
     */
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '이름'")
    private String name;
    
    /**
     * 닉네임
     */
    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '닉네임'")
    private String nickName;
    
    /**
     * 이메일
     */
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '이메일'")
    private String email;
    
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '휴대폰번호'")
    private String phone;
    
    /**
     * 유저 등급 (OWNER, MANAGER, NORMAL)
     */
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'NORMAL' COMMENT '유저등급'")
    private UserGrade userGrade;

}
