package com.example.vga_price_tracker.dto;

import lombok.Getter;

@Getter
public class VgaInfoDTO {
    private final String vgaName;
    private final float vgaPrice;
    private final int category; // CAT 필드를 category로 명명
    private final int value;    // value 필드 추가

    public VgaInfoDTO(String vgaName, float vgaPrice, int category, int value) {
        this.vgaName = vgaName;
        this.vgaPrice = vgaPrice;
        this.category = category;
        this.value = value;
    }
}
