package bada.api;

import bada.dao.BookingsDao;
import bada.dao.ClientsDao;
import bada.dao.CourtsDao;
import bada.model.Booking;
import bada.model.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class CourtController {

    @Autowired
    private CourtsDao courtsDAO;
    @Autowired
    private BookingsDao bookingsDao;
    @Autowired
    private ClientsDao clientsDao;


    @RequestMapping("/court_new")
    public String showNewCourtForm(Model model){
        Court court = new Court();
        model.addAttribute("court", court);
        return "/court_new";
    }

    @RequestMapping("/court_save")
    public String saveCourt(@ModelAttribute("court") Court court){
        courtsDAO.save(court);
        return "redirect:/court_list";
    }

    @RequestMapping("/court/{id}/edit")
    public ModelAndView showEditCourtForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("court_edit");
        Court court = courtsDAO.get(id);
        mav.addObject("court", court);
        return mav;
    }

    @PostMapping(value = "/court_update")
    public String updateCourt(@ModelAttribute("court") Court court){
        courtsDAO.update(court);
        return "redirect:/court_list";
    }

    @RequestMapping("/court/{id}/delete")
    public String deleteCourt(@PathVariable(name = "id") int id){
        courtsDAO.delete(id);
        return "redirect:/court_list";
    }

    @RequestMapping("/court/{id}")
    public ModelAndView showCourt(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("court");
        Court court = courtsDAO.get(id);
        List<Booking> bookings = bookingsDao.getByCourt(id);
        court.refreshTimetable(bookings);
        mav.addObject("court", court);
        return mav;
    }

    @RequestMapping("/court/{id}/save_booking")
    public String saveBooking(@PathVariable int id, @PathParam("day") int day, @PathParam("hour") int hour){
        System.out.println(id);
        Booking booking = new Booking(day, hour, 23, 1); // temporary client ID
        bookingsDao.save(booking);
        return "redirect:/court/" + booking.getCourtId();
    }

    @RequestMapping("/court_list")
    public String showCourtsList(Model model) {
        List<Court> courtList = courtsDAO.get();
        model.addAttribute("courtList", courtList);
        return "court_list";
    }
}