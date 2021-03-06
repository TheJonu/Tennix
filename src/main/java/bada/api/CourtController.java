package bada.api;

import bada.dao.BookingsDao;
import bada.dao.CourtsDao;
import bada.model.Booking;
import bada.model.Court;
import bada.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/court")
public class CourtController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourtsDao courtsDAO;
    @Autowired
    private BookingsDao bookingsDao;


    @GetMapping("/list")
    public String showCourtsList(Model model) {
        List<Court> courtList = courtsDAO.get();
        model.addAttribute("courtList", courtList);
        return "court_list";
    }

    @GetMapping("/{id}")
    public ModelAndView showCourt(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("court");
        Court court = courtsDAO.get(id);
        List<Booking> bookings = bookingsDao.getByCourt(id);
        court.refreshTimetable(bookings);
        mav.addObject("court", court);
        return mav;
    }

    @RequestMapping("/{id}/book")
    public String book(@PathVariable int id, @PathParam("client") String client, @PathParam("day") int day, @PathParam("hour") int hour){
        int userId = userService.getByUsername(client).getId();
        Booking booking = new Booking(day, hour, id, userId);
        bookingsDao.save(booking);
        return "redirect:/court/" + booking.getCourtId();
    }


}