package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaName;
import com.example.vga_price_tracker.domain.VgaPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VgaPriceRepository extends JpaRepository<VgaPrice, Long> {
    List<VgaPrice> findByVgaNameAndCreatedAtBetween(VgaName vgaName, LocalDate startDate, LocalDate endDate);
}
