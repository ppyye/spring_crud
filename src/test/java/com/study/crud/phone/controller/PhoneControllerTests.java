package com.study.crud.phone.controller;

import com.study.crud.SpringCrudApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {SpringCrudApplication.class})
public class PhoneControllerTests {

    @Autowired
    private PhoneController phoneController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(phoneController).build();
    }

    @Test
    public void 컨트롤러_의존성_주입_테스트() {
        assertNotNull(phoneController);
    }

    @Test
    public void 전체_리스트_조회_컨트롤러_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/phone/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("phone/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void 신규_모델_등록_컨트롤러_테스트() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("phoneName", "컨트롤러 테스트 모델");
        params.add("phonePrice", "100000");

        // when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/phone/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/phone/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void 모델_삭제_컨트롤러_테스트() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("phoneCode", "1");

        // when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/phone/delete").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/phone/list"))
                .andDo(MockMvcResultHandlers.print());
    }
}
