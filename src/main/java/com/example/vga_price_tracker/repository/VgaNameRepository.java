package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.VgaName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.Optional;

public interface VgaNameRepository extends JpaRepository<VgaName, Long> {
    /**
     *  종류 ID로 검색
     * @return 그래픽카드 종류
     */
    Optional<VgaName> findById(long id);
}
