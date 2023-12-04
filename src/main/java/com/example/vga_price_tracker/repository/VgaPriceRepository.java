package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaName;
import com.example.vga_price_tracker.domain.VgaPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VgaPriceRepository extends JpaRepository<VgaPrice, Long> {

    List<VgaPrice> findByVgaName(VgaName vgaName);
}
