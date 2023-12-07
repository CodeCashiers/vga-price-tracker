package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.Vga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VgaRepository extends JpaRepository<Vga, Long> {
    /**
     *  종류 ID로 검색
     * @return 그래픽카드 종류
     */
    Optional<Vga> findById(long id);
}
