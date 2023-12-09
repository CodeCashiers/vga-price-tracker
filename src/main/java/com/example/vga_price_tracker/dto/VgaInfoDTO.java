package com.example.vga_price_tracker.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class VgaInfoDTO {
    private final String vgaName;
    private final float vgaPrice;
    private final int vgaRank;
    private final int G3Dmark;

}
