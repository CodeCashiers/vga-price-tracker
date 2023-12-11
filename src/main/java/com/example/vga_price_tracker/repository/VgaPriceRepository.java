package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.Vga;
import com.example.vga_price_tracker.domain.VgaPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VgaPriceRepository extends JpaRepository<VgaPrice, Long> {
    /**
     *
     * @return 특정 기간 사이(startDate, endDate)의 그래픽카드 가격 리스트
     */
    List<VgaPrice> findByVgaAndCreatedAtBetween(Vga vga, LocalDate startDate, LocalDate endDate);

    List<VgaPrice> findByCreatedAt(LocalDate today);
}
