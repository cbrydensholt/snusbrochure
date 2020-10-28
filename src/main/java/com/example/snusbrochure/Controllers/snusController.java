package com.example.snusbrochure.Controllers;


import com.example.snusbrochure.Models.Snus;
import com.example.snusbrochure.Service.SnusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class snusController {
    
    //update test 2

    @Autowired //binder controlleren sammen med service layer
    SnusService snusService;


    @GetMapping("/")
    public String snusHome(){

        return "snus/index";

    }

    @GetMapping("/createsnus")
    public String createSnus()
    {
    return "snus/createsnus";
    }

    @PostMapping("/createdSnus")
    public String createdSnus(@ModelAttribute Snus snusFromPost){
    snusService.create(snusFromPost);
    return "redirect:/";

    }

    @GetMapping("/crud")
    public String selection(Model model){
     model.addAttribute("selection", snusService.readall());

        return "snus/snusSelection";

    }

    @GetMapping("/deletesnus")
    public String deletesnus(@RequestParam int snusId){
    snusService.delete(snusId);

        return "redirect:/";

    }

    @GetMapping("/updatesnus")
    public String updatesnus(@RequestParam int snusId, Model model){
        Snus snus = snusService.read2(snusId);
        model.addAttribute("snustp", snus);
        return "snus/updatesnus";

    }

    @PostMapping("/updatedsnus")
    public String updatedsnus(@ModelAttribute Snus snusfromPost){
    snusService.update(snusfromPost);
    return "redirect:/";

    }

    @GetMapping("/singlesnus")
    public String singlesnus(@RequestParam int snusId, Model model){
        Snus tempsnus = snusService.read2(snusId);
        model.addAttribute("snus", tempsnus);

        return "snus/singleSnus";
    }

    @GetMapping("/shop")
    public String shop(){

        return "snus/shop";

    }

    @GetMapping("/thmshop")
    public String thymeleafshop(Model model){
        model.addAttribute("selection", snusService.readall());
        return "snus/thmlshop";

    }





}
