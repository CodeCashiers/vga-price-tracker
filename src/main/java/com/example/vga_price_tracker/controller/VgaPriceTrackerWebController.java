package com.example.vga_price_tracker.controller;

import com.example.vga_price_tracker.dto.VgaInfoDTO;
import com.example.vga_price_tracker.dto.VgaNameDTO;
import com.example.vga_price_tracker.dto.VgaPriceDTO;
import com.example.vga_price_tracker.service.VgaPriceTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class VgaPriceTrackerWebController {
    private final VgaPriceTrackerService vgaPriceTrackerService;

    // 차트 페이지
    @GetMapping("")
    public String getMain(@RequestParam(required = false, defaultValue = "1") long vgaId, Model model) {
        // 그래픽카드 이름 목록을 가져옴.
        List<VgaNameDTO> vgaNames = vgaPriceTrackerService.getVgaNames();
        // 선택된 그래픽카드의 일주일 사이의 가격 데이터를 가져옴.
        List<VgaPriceDTO> vgaPricesForWeek = vgaPriceTrackerService.getVgaPricesForWeek(vgaId);
        // 선택된 그래픽카드의 한달 사이의 가격 데이터를 가져옴.
        List<VgaPriceDTO> vgaPricesForMonth = vgaPriceTrackerService.getVgaPricesForMonth(vgaId);

        List<VgaPriceDTO> vgaPricesForYear = vgaPriceTrackerService.getVgaPricesForYear(vgaId);

        // 모델에 데이터를 추가.
        model.addAttribute("vgaNames", vgaNames);
        model.addAttribute("vgaPricesForWeek", vgaPricesForWeek);
        model.addAttribute("vgaPricesForMonth", vgaPricesForMonth);
        model.addAttribute("vgaPricesForYear", vgaPricesForYear);

        // "main.html" 템플릿을 반환.
        return "main.html";
    }
    @GetMapping("")
    public String getAllCurrentVGA(Model model) {
        // 그래픽카드 이름 목록을 가져옴.


        List<VgaInfoDTO> vgaInfos = vgaPriceTrackerService.getVgaInfos();
        // 나머지 로직
        model.addAttribute("videoCardData",vgaInfos);
        return "vgaList";
    }


    private boolean isValidType(String type) {
        // type 값이 유효한지 확인하는 로직

        return "expectedType1".equals(type) || "expectedType2".equals(type); // 예시
    }

}
