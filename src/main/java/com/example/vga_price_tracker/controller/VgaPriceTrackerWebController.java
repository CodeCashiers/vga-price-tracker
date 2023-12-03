package com.example.vga_price_tracker.controller;

import com.example.vga_price_tracker.service.VgaPriceTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class VgaPriceTrackerWebController {
    private VgaPriceTrackerService vgaPriceTrackerService;

    @GetMapping("")
    public String getMainPage() {


        return "main.html";
    }
}
