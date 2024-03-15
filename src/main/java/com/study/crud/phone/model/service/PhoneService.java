package com.study.crud.phone.model.service;

import com.study.crud.phone.model.dao.PhoneMapper;
import com.study.crud.phone.model.dto.PhoneDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneMapper phoneMapper;

    public PhoneService(PhoneMapper phoneMapper) {
        this.phoneMapper = phoneMapper;
    }

    public List<PhoneDTO> selectAllList() {
        return phoneMapper.selectAllList();
    }

    @Transactional
    public void registPhone(PhoneDTO phone) {
        phoneMapper.registPhone(phone);
    }

    @Transactional
    public void deletePhone(PhoneDTO phone) {
        phoneMapper.deletePhone(phone);
    }
}
