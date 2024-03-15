package com.study.crud.phone.model.service;

import com.study.crud.SpringCrudApplication;
import com.study.crud.phone.model.dto.PhoneDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {SpringCrudApplication.class})
public class PhoneServiceTests {

    @Autowired
    private PhoneService phoneService;

    @Test
    public void 서비스_의존성_주입_테스트() {
        assertNotNull(phoneService);
    }

    @Test
    public void 전체_리스트_조회_서비스_테스트() {
        // given
        // when
        List<PhoneDTO> phoneList = phoneService.selectAllList();
        // then
        assertNotNull(phoneList);
    }

    @Test
    @Transactional
    public void 신규_모델_등록_서비스_테스트() {
        // given
        PhoneDTO phone = new PhoneDTO();
        phone.setPhoneName("Test Model Name");
        phone.setPhonePrice(1000000);
        // when & then
        assertDoesNotThrow(() -> phoneService.registPhone(phone));
    }

    @Test
    @Transactional
    public void 모델_삭제_서비스_테스트() {
        // given
        PhoneDTO phone = new PhoneDTO();
        phone.setPhoneCode(1);
        // when & then
        assertDoesNotThrow(() -> phoneService.deletePhone(phone));
    }
}
