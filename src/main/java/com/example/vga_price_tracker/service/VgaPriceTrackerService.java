package com.example.vga_price_tracker.service;

import com.example.vga_price_tracker.domain.VgaName;
import com.example.vga_price_tracker.domain.VgaPrice;
import com.example.vga_price_tracker.dto.VgaNameDTO;
import com.example.vga_price_tracker.dto.VgaPriceDTO;
import com.example.vga_price_tracker.repository.VgaNameRepository;
import com.example.vga_price_tracker.repository.VgaPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VgaPriceTrackerService {
    private final VgaNameRepository vgaNameRepository;
    private final VgaPriceRepository vgaPriceRepository;

    public List<VgaNameDTO> getVgaNames() {
        List<VgaName> vgaNames = vgaNameRepository.findAll();

        return vgaNames.stream()
                .map(this::convertVgaNameToDTO)
                .toList();
    }

    // 한 달 단위
    public List<VgaPriceDTO> getVgaPricesForMonth(long vgaId) {
        return getVgaPricesForPeriod(vgaId, LocalDate.now().minusMonths(1));
    }

    // 하루 단위
    public List<VgaPriceDTO> getVgaPricesForWeek(long vgaId) {
        return getVgaPricesForPeriod(vgaId, LocalDate.now().minusWeeks(1));
    }

    // 1년 단위
    public List<VgaPriceDTO> getVgaPricesForYear(long vgaId) {
        return getVgaPricesForPeriod(vgaId, LocalDate.now().minusYears(1));
    }

    // 공통된 로직을 처리하는 private 메소드
    private List<VgaPriceDTO> getVgaPricesForPeriod(long vgaId, LocalDate startDate) {
        VgaName vgaName = vgaNameRepository.findById(vgaId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 그래픽카드 이름"));

        LocalDate endDate = LocalDate.now();
        List<VgaPrice> vgaPrices = vgaPriceRepository.findByVgaNameAndCreatedAtBetween(vgaName, startDate, endDate);

        return vgaPrices.stream()
                .map(this::convertVgaPriceToDTO)
                .toList();
    }

    private VgaPriceDTO convertVgaPriceToDTO(VgaPrice vgaPrice) {
        return VgaPriceDTO.builder()
                .vgaName(vgaPrice.getVgaName().getVgaName())
                .vgaPrice(vgaPrice.getVgaPrice())
                .date(vgaPrice.getCreatedAt().toString())
                .build();
    }

    private VgaNameDTO convertVgaNameToDTO(VgaName vgaName) {
        return new VgaNameDTO(vgaName.getId(), vgaName.getVgaName());
    }
}
