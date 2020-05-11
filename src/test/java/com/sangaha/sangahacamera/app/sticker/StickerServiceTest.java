package com.sangaha.sangahacamera.app.sticker;

import com.sangaha.sangahacamera.SangahaCameraApplicationTest;
import com.sangaha.sangahacamera.app.model.enums.AccessType;
import com.sangaha.sangahacamera.app.sticker.model.entity.Sticker;
import com.sangaha.sangahacamera.app.sticker.repository.StickerRepository;
import com.sangaha.sangahacamera.app.sticker.service.StickerService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SangahaCameraApplicationTest.class)
public class StickerServiceTest {
    @Autowired
    private StickerService stickerService;
    
    @Autowired
    private StickerRepository stickerRepository;
    
    @Test
    public void 스티커저장테스트() throws Exception {
        Sticker savedSticker = stickerService.insertSticker(Sticker.builder()
            .name("상아하스티커3!!")
        .imgUrl("이미지유알엘!!")
        .accessType(AccessType.PUBLIC)
        .creator(1L).build());
        
        log.info("STICKER!!!! :: {}", savedSticker.toString());
    }
    
    @Test
    public void 스티커가져오기테스트() {
        List<Sticker> stickerList = stickerRepository.findAll();
    
        stickerList.forEach(sticker -> System.out.println(sticker.toString()));
    }
}
