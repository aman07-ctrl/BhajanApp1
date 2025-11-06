package com.examplespringboot.demo;

import com.examplespringboot.demo.Bhajan;
import com.examplespringboot.demo.Deity;
import com.examplespringboot.demo.BhajanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BhajanController {

    private final BhajanService bhajanService;

    @Autowired
    public BhajanController(BhajanService bhajanService) {
        this.bhajanService = bhajanService;
    }

    // 👇 Updated to return list of Deity objects for the homepage
    @GetMapping("/")
    public String homePage(Model model) {
        List<Deity> deities = bhajanService.getAllDeities();
        model.addAttribute("deities", deities);
        return "index";
    }

    // 👇 No change here unless you want to customize per deity
    @GetMapping("/bhajans/{god}")
    public String bhajansByGod(@PathVariable("god") String god, Model model) {
        List<Bhajan> bhajans = bhajanService.getBhajansFor(god);
        model.addAttribute("god", god);
        model.addAttribute("bhajans", bhajans);
        return "bhajans";
    }

    // ✅ Quick route test (you can remove this once all routes work)
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hi from Bhajan App!";
    }
}
