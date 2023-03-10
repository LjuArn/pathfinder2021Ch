package com.example.pathfinder2021ch.web;

import com.example.pathfinder2021ch.domain.ViewDto.UserViewModel;
import com.example.pathfinder2021ch.domain.bidingDto.UserLoginBindingModel;
import com.example.pathfinder2021ch.domain.bidingDto.UserRegisterBindingModel;
import com.example.pathfinder2021ch.domain.serviceDto.UserServiceModel;
import com.example.pathfinder2021ch.service.UserService;
import com.example.pathfinder2021ch.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService,
                          ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;

    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }


    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return  new UserLoginBindingModel();
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


        boolean isNameExist = userService.isNameExistMethod(userRegisterBindingModel.getUsername());

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("isNotExist", false);
        return "login";
    }

    @PostMapping("/login")
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

        UserServiceModel user = userService
               .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                       userLoginBindingModel.getPassword());


        if(user==null){
            redirectAttributes
                    .addFlashAttribute("isNotExist", true)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            return "redirect:login";

        }
        userService.loginUser(user.getId(), user.getUsername());
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logOut(){
        userService.logOut();
        return "redirect:/";
    }


    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model){

        model.addAttribute("user",
                modelMapper.map(userService.findById(id), UserViewModel.class));

        return "profile";
    }

}
