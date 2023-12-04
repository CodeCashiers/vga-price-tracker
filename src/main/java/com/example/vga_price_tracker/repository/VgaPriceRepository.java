package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VgaPriceRepository extends JpaRepository<VgaPrice, Long> {
}
