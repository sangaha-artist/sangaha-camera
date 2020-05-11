package com.sangaha.sangahacamera.app.sticker.service;

import com.sangaha.sangahacamera.app.sticker.model.entity.Sticker;
import com.sangaha.sangahacamera.app.sticker.repository.StickerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StickerService {
    @Autowired
    private StickerRepository stickerRepository;
    
    public Sticker insertSticker(Sticker sticker) {
        return stickerRepository.save(sticker);
    }
    
    public Sticker getSticker(long stickerId) {
        return stickerRepository.findById(stickerId).orElse(null);
    }
}
