package bada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CourtsDAO courtsDAO;
    @Autowired
    private BookingsDao bookingsDao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        //List<Court> courtList = courtsDAO.get();
        //model.addAttribute("courtList", courtList);
        return "index";
    }

    @RequestMapping("/new_court")
    public String showNewCourtForm(Model model){
        Court court = new Court();
        model.addAttribute("court", court);
        return "new_court";
    }

    @RequestMapping("/save_court")
    public String saveCourt(@ModelAttribute("court") Court court){
        courtsDAO.save(court);
        return "redirect:/court_list";
    }

    @RequestMapping("/edit_court/{id}")
    public ModelAndView showEditCourtForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("edit_court");
        Court court = courtsDAO.get(id);
        mav.addObject("court", court);
        return mav;
    }

    @RequestMapping(value = "/update_court", method = RequestMethod.POST)
    public String updateCourt(@ModelAttribute("court") Court court){
        courtsDAO.update(court);
        return "redirect:/court_list";
    }

    @RequestMapping("delete_court/{id}")
    public String deleteCourt(@PathVariable(name = "id") int id){
        courtsDAO.delete(id);
        return "redirect:/court_list";
    }

    // show a court's timetable
    @RequestMapping("timetable/{id}")
    public ModelAndView showTimetable(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("timetable");
        Court court = courtsDAO.get(id);
        List<Booking> bookings = bookingsDao.getByCourt(id);
        court.refreshTimetable(bookings);
        mav.addObject("court", court);
        return mav;
    }

    // create a booking
    @RequestMapping("/save_booking")
    public String saveBooking(@PathParam("day") int day, @PathParam("hour") int hour){
        //System.out.println(courtId);
        Booking booking = new Booking(day, hour, 23, 1); // temporary client ID
        bookingsDao.save(booking);
        return "redirect:/timetable/" + booking.getCourtId();
    }

    // show court list
    @RequestMapping("/court_list")
    public String showCourtList(Model model) {
        List<Court> courtList = courtsDAO.get();
        model.addAttribute("courtList", courtList);
        return "court_list";
    }
}