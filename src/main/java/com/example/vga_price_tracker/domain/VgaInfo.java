package com.example.vga_price_tracker.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class VgaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VGA_NAME")
    private String vgaName;
    @Column(name = "VGA_CATEGORY")
    private int CAT;

    @Column(name = "vga_price")
    private float vgaPrice;

    @Column(name = "VGA_SCORE")
    private int value;

}
