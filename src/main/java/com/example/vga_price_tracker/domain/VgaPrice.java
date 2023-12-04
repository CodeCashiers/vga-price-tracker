package com.example.vga_price_tracker.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "VGA_NM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class VgaPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VGA_PRICE_ID", updatable = false)
    private Long id;

    // 내용
    @ManyToOne
    @JoinColumn(name = "VGA", nullable = false)
    private Vga vga;

    // 편지 생성 날짜
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    public VgaPrice(Vga vga) {
        this.vga = vga;
        this.createdAt = LocalDate.now();
    }
}
