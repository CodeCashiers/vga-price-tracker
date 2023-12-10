package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.Vga;
import com.example.vga_price_tracker.domain.VgaPrice;
import com.example.vga_price_tracker.dto.VgaPricePerformanceScoreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VgaPriceRepository extends JpaRepository<VgaPrice, Long> {
    /**
     *
     * @return 특정 기간 사이(startDate, endDate)의 그래픽카드 가격 리스트
     */
    List<VgaPrice> findByVgaAndCreatedAtBetween(Vga vga, LocalDate startDate, LocalDate endDate);

    List<VgaPrice> findByCreatedAt(LocalDate today);

    @Query(value =
            "SELECT new com.example.vga_price_tracker.dto.VgaPricePerformanceScoreDTO(" +
                    "vp.id, vp.vga.vgaName, vp.vgaPrice, ROUND(vp.vga.vgaScore / vp.vgaPrice, 2), vp.vga.vgaCategory)" +
            "FROM VgaPrice vp " +
            "WHERE (vp.vga, vp.createdAt) IN (SELECT vp.vga, max(vp.createdAt) FROM VgaPrice vp GROUP BY vp.vga)" +
            "ORDER BY ROUND(vp.vga.vgaScore / vp.vgaPrice, 2) DESC"
    )
    List<VgaPricePerformanceScoreDTO> getPricePerformanceRanking();
}
