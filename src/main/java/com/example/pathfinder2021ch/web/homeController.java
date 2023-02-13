package com.example.pathfinder2021ch.web;

import com.example.pathfinder2021ch.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    private final PictureService pictureService;

    public homeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("pictures", pictureService.findAllURLs());

        return "index";
    }


    @GetMapping("/about")
    public  String about(){
        return "about";
    }
}
