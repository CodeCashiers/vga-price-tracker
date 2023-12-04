package com.example.vga_price_tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
public class VgaPriceDTO {
    private final String vgaName;
    private final int vgaPrice;
    private final String date;

    @Builder
    public VgaPriceDTO(String vgaName, int vgaPrice, String date) {
        this.vgaName = vgaName;
        this.vgaPrice = vgaPrice;
        this.date = date;
    }
}
