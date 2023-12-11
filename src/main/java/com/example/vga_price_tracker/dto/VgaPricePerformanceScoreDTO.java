package com.example.vga_price_tracker.dto;

import com.example.vga_price_tracker.domain.VgaCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class VgaPricePerformanceScoreDTO {
    private final long id;
    private final String vgaName;
    private final float score;
    private final float vgaPrice;
    private final VgaCategory vgaCategory;

    public VgaPricePerformanceScoreDTO(long id, String vgaName, float vgaPrice, float score, VgaCategory vgaCategory) {
        this.id = id;
        this.vgaName = vgaName;
        this.vgaPrice = vgaPrice;
        this.score = score;
        this.vgaCategory = vgaCategory;
    }
}
