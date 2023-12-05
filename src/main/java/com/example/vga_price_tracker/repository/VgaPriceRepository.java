package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaName;
import com.example.vga_price_tracker.domain.VgaPrice;
import com.example.vga_price_tracker.dto.MonthlyAveragePriceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VgaPriceRepository extends JpaRepository<VgaPrice, Long> {
    /**
     *
     * @return 특정 기간 사이(startDate, endDate)의 그래픽카드 가격 리스트
     */
    List<VgaPrice> findByVgaNameAndCreatedAtBetween(VgaName vgaName, LocalDate startDate, LocalDate endDate);
}
