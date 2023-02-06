package com.example.pathfinder2021ch.web;

import com.example.pathfinder2021ch.domain.bidingDto.UserLoginBindingModel;
import com.example.pathfinder2021ch.domain.bidingDto.UserRegisterBindingModel;
import com.example.pathfinder2021ch.domain.serviceDto.UserServiceModel;
import com.example.pathfinder2021ch.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
//@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }


    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return  new UserLoginBindingModel();
    }

    @GetMapping("/users/register")
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


    @PostMapping("/users/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                            bindingResult);
            return "redirect:register";
        }


        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }


    @GetMapping("/users/login")
    public String login(Model model){
        return "login";
    }

    @PostMapping("/users/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";

        }

        UserServiceModel userCurrent = userService
               .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                       userLoginBindingModel.getPassword());


        if(userCurrent==null){
            redirectAttributes
                    .addFlashAttribute("isNotExist", true)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";

        }




        return ;
    }

}
