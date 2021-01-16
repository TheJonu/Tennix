package bada.api;

import bada.dao.BookingsDao;
import bada.dao.ClientsDao;
import bada.dao.CourtsDao;
import bada.security.User;
import bada.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "/index";
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "/login";
    }

    @GetMapping("/register")
    public String getRegisterView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        //model.addAttribute("user", user);
        userService.registerUser(user);
        return "redirect:/?registered=true";
    }
}