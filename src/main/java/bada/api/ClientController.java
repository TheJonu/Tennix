package bada.api;

import bada.dao.BookingsDao;
import bada.dao.CourtsDao;
import bada.model.Booking;
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
import java.util.List;

@Controller
@RequestMapping("/client")
@PreAuthorize("hasRole('CLIENT')")
public class ClientController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingsDao bookingsDao;
    @Autowired
    private CourtsDao courtsDAO;

    @GetMapping
    public ModelAndView showClientView(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByUsername(authentication.getName());
        ModelAndView mav = new ModelAndView("client");
        List<Booking> bookings = bookingsDao.getByClient(user.getId());
        bookings.forEach(b -> b.setCourtName(courtsDAO.get(b.getCourtId()).getName()));
        mav.addObject("client", user);
        mav.addObject("bookings", bookings);
        return mav;
    }

    @RequestMapping("/cancel")
    public String cancelBooking(@PathParam("id") int id){
        bookingsDao.delete(id);
        return "redirect:/client";
    }
}