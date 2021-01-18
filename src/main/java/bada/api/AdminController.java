package bada.api;

import bada.dao.BookingsDao;
import bada.dao.ClientDao;
import bada.dao.CourtsDao;
import bada.model.Booking;
import bada.model.Client;
import bada.model.User;
import bada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingsDao bookingsDao;
    @Autowired
    private CourtsDao courtsDAO;


    @GetMapping
    public String showAdminView(){
        return "admin";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users_list";
    }

    @GetMapping("/users/{id}")
    public String showUser(Model model, @PathVariable("id") int id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user";
    }
}