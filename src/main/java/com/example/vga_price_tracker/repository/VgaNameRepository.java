package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VgaNameRepository extends JpaRepository<VgaName, Long> {
}
