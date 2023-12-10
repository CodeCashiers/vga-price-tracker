package com.example.vga_price_tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class VgaPricePerformanceScoreDTO {
    private final long id;
    private final String vgaName;
    private final float score;
    private final float price;

    public VgaPricePerformanceScoreDTO(long id, String vgaName, float price, float score) {
        this.id = id;
        this.vgaName = vgaName;
        this.price = price;
        this.score = score;
    }
}
