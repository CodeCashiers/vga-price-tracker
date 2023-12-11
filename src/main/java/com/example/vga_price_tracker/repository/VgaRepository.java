package com.example.vga_price_tracker.repository;

import com.example.vga_price_tracker.domain.Vga;
import com.example.vga_price_tracker.dto.VgaInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VgaRepository extends JpaRepository<Vga, Long> {
    /**
     *  종류 ID로 검색
     * @return 그래픽카드 종류
     */
    Optional<Vga> findById(long id);
    @Query("SELECT VgaInfoDTO(v.vgaName, vp.vgaPrice, v.vgaScore, v.vgaCategory)" +
            "FROM VgaPrice vp JOIN vp.vga v " +
            "WHERE v.id IN :ids AND vp.createdAt = " +
            "(SELECT MAX(vp2.createdAt) FROM VgaPrice vp2 WHERE vp2.vga.id = v.id) " +
            "ORDER BY vp.createdAt DESC")
    List<VgaInfoDTO> findLatestVgaPricesByIds(@Param("ids") List<Long> ids);


}
