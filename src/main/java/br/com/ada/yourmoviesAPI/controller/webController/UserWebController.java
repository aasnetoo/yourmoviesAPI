package br.com.ada.yourmoviesAPI.controller.webController;

import br.com.ada.yourmoviesAPI.exceptions.UserExistException;
import br.com.ada.yourmoviesAPI.mapper.UserMapper;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;
import br.com.ada.yourmoviesAPI.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserWebController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserMapper mapper;
    @GetMapping()
    public String homeUser(){
        return "open_page";
    }

    @PostMapping()
    public String createUser(UserRequest user) throws UserExistException {
        userService.saveUser(mapper.UserRequestToUserDTO(user));
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        model.addAttribute("users",userService.findAllUsers());

        return "list";
    }


}
