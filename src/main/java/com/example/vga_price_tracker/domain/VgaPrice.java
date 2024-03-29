package com.example.vga_price_tracker.domain;


import com.example.vga_price_tracker.dto.VgaPriceDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "VGA_PRICE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class VgaPrice {     // 그래픽카드 가격

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VGA_PRICE_ID", updatable = false)
    private Long id;

    // 그래픽카드 종류 외래키
    @ManyToOne
    @JoinColumn(name = "VGA", nullable = false)
    private Vga vga;

    // 그래픽카드 가격
    @Column(name = "VGA_PRICE", nullable = false)
    private float vgaPrice;

    // 그래픽카드 시세 일자
    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;


    public VgaPrice(Vga vga, float vgaPrice) {
        this.vga = vga;
        this.vgaPrice = vgaPrice;
        this.createdAt = LocalDate.now();
    }

    // DTO로 변환
    public VgaPriceDTO convertToDTO() {
        return VgaPriceDTO.builder()
                .vgaName(this.vga.getVgaName())
                .vgaPrice(this.vgaPrice)
                .date(this.createdAt.toString())
                .build();
    }
}
