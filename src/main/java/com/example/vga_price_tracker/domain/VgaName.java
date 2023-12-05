package com.example.vga_price_tracker.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VGA_NM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class VgaName {      // 그래픽카드 종류

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VGA_ID", updatable = false)
    private Long id;

    // 그래픽카드 이름
    @Column(name = "VGA_NAME", nullable = false)
    private String vgaName;

    public VgaName(String vgaName) {
        this.vgaName = vgaName;
    }
}
