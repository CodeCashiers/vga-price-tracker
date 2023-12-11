package com.example.vga_price_tracker.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VGA")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Vga {      // 그래픽카드 종류

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VGA_ID", updatable = false)
    private Long id;

    // 그래픽카드 이름
    @Column(name = "VGA_NAME", nullable = false)
    private String vgaName;

    // 벤치마킹 점수
    @Column(name = "VGA_SCORE")
    private int vgaScore;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "VGA_CATEGORY")
    private VgaCategory vgaCategory;

    public Vga(String vgaName, int vgaScore, VgaCategory vgaCategory) {
        this.vgaName = vgaName;
        this.vgaScore = vgaScore;
        this.vgaCategory = vgaCategory;
    }
}
