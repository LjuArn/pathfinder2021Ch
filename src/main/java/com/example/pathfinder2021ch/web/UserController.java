package com.example.pathfinder2021ch.web;

import com.example.pathfinder2021ch.domain.bidingDto.UserRegisterBidingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {


    @ModelAttribute
    public UserRegisterBidingModel userRegisterBidingModel(){
        return new UserRegisterBidingModel();
    }



    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

   /* едининия вариант
   @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBidingModel")){
            model.addAttribute("userRegisterBidingModel", new UserRegisterBidingModel());
        }
        return "register";
    }
    */


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userRegisterBidingModel", userRegisterBidingModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                            bindingResult);
            return "redirect:register";
        }

        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
