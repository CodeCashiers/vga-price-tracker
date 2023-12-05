package com.example.vga_price_tracker.controller;

import com.example.vga_price_tracker.dto.VgaNameDTO;
import com.example.vga_price_tracker.service.VgaPriceTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class VgaPriceTrackerWebController {
    private final VgaPriceTrackerService vgaPriceTrackerService;

    @GetMapping("")
    public String getMain(Model model) {
        List<VgaNameDTO> vgaNames = vgaPriceTrackerService.getVgaNames();

        model.addAttribute("vgaNames", vgaNames);
        return "main.html";
    }
}
