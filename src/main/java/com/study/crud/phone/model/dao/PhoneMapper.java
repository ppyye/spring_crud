package com.study.crud.phone.model.dao;

import com.study.crud.phone.model.dto.PhoneDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhoneMapper {
    List<PhoneDTO> selectAllList();

    void registPhone(PhoneDTO phone);

    void deletePhone(PhoneDTO phone);
}
