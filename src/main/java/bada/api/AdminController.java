package bada.api;

import bada.dao.BookingsDao;
import bada.dao.CourtsDao;
import bada.model.Court;
import bada.model.User;
import bada.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping(value = "/edit_court")
    public String updateCourt(@ModelAttribute("court") Court court){
        courtsDAO.update(court);
        return "redirect:/court/list";
    }

    @RequestMapping("/delete_court/{id}")
    public String deleteCourt(@PathVariable(name = "id") int id){
        courtsDAO.delete(id);
        return "redirect:/court/list";
    }
}