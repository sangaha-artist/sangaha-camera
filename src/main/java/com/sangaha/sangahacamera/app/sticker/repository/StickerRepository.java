package com.sangaha.sangahacamera.app.sticker.repository;

import com.sangaha.sangahacamera.app.sticker.model.entity.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<Sticker, Long> {
    
}
