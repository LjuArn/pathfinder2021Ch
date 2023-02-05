package com.example.pathfinder2021ch.web;

import com.example.pathfinder2021ch.domain.bidingDto.UserRegisterBidingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userRegisterBidingModel", userRegisterBidingModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation")

        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
