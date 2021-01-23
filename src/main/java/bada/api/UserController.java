package bada.api;

import bada.dao.BookingsDao;
import bada.dao.CourtsDao;
import bada.model.Booking;
import bada.model.Court;
import bada.model.User;
import bada.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingsDao bookingsDao;
    @Autowired
    private CourtsDao courtsDAO;


    @GetMapping("/edit")
    public ModelAndView showUserEdit(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByUsername(authentication.getName());
        ModelAndView mav = new ModelAndView("user_edit");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user, @PathParam("id") int id){
        userService.update(user, id);
        return "redirect:/";
    }
}