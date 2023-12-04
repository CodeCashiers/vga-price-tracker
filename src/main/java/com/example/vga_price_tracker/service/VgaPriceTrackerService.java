package com.example.vga_price_tracker.service;

import com.example.vga_price_tracker.domain.VgaName;
import com.example.vga_price_tracker.domain.VgaPrice;
import com.example.vga_price_tracker.dto.VgaPriceDTO;
import com.example.vga_price_tracker.repository.VgaNameRepository;
import com.example.vga_price_tracker.repository.VgaPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VgaPriceTrackerService {
    private final VgaNameRepository vgaNameRepository;
    private final VgaPriceRepository vgaPriceRepository;

    public List<VgaPriceDTO> getVgaPrices(long vgaId) {
        VgaName vgaName = vgaNameRepository.findById(vgaId).orElseThrow(() -> new IllegalArgumentException("잘못된 그래픽카드 이름"));
        List<VgaPrice> vgaPrices = vgaPriceRepository.findByVgaName(vgaName);

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

}
