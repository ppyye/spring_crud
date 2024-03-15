package com.study.crud.phone.model.dto;

public class PhoneDTO {
    private int phoneCode;
    private String phoneName;
    private int phonePrice;

    public PhoneDTO() {
    }

    public PhoneDTO(int phoneCode, String phoneName, int phonePrice) {
        this.phoneCode = phoneCode;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
    }

    public int getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(int phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "phoneCode=" + phoneCode +
                ", phoneName='" + phoneName + '\'' +
                ", phonePrice=" + phonePrice +
                '}';
    }
}
