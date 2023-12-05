package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.Optional;

public interface VgaNameRepository extends JpaRepository<VgaName, Long> {
    Optional<VgaName> findById(long id);
}
