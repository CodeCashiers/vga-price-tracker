package com.example.vga_price_tracker.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class VgaPriceDTO {
    private final long id;
    private final String vgaName;
    private final int vgaPrice;
    private final String date;

    @Builder
    public VgaPriceDTO(long id, String vgaName, int vgaPrice, String date) {
        this.id = id;
        this.vgaName = vgaName;
        this.vgaPrice = vgaPrice;
        this.date = date;
    }
}
