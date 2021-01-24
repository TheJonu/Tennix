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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
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
    public ModelAndView showAdminView(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByUsername(authentication.getName());
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("admin", user);
        return mav;
    }

    // USERS

    @GetMapping("/users")
    public String showUsers(Model model) {
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "user_list";
    }

    @RequestMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable(name = "id") int id){
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit_user/{id}")
    public ModelAndView showUserEdit(@PathVariable("id") int id){
        User user = userService.getById(id);
        ModelAndView mav = new ModelAndView("user_edit");
        mav.addObject("user", user);
        return mav;
    }

    /*
    @PostMapping("/edit_user/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.update(user, id);
        return "redirect:/";
    }
     */

    // COURTS

    @GetMapping("/new_court")
    public String showNewCourtForm(Model model){
        Court court = new Court();
        model.addAttribute("court", court);
        return "court_new";
    }

    @PostMapping("/new_court")
    public String saveCourt(@ModelAttribute("court") Court court){
        courtsDAO.save(court);
        return "redirect:/court/list";
    }

    @GetMapping("/edit_court/{id}")
    public ModelAndView showEditCourtForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("court_edit");
        Court court = courtsDAO.get(id);
        mav.addObject("court", court);
        return mav;
    }

    @PostMapping("/edit_court/{id}")
    public String updateCourt(@ModelAttribute("court") Court court, @PathVariable("id") int id){
        court.setId(id);
        courtsDAO.update(court);
        return "redirect:/court/list";
    }

    @RequestMapping("/delete_court/{id}")
    public String deleteCourt(@PathVariable(name = "id") int id){
        courtsDAO.delete(id);
        return "redirect:/court/list";
    }
}