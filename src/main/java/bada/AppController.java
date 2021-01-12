package bada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CourtsDAO courtsDAO;
    @Autowired
    private BookingsDao bookingsDao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Court> courtList = courtsDAO.get();
        model.addAttribute("courtList", courtList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewCourtForm(Model model){
        Court court = new Court();
        model.addAttribute("court", court);
        return "new_form";
    }

    @RequestMapping("/save")
    public String saveCourt(@ModelAttribute("court") Court court){
        courtsDAO.save(court);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCourtForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("edit_form");
        Court court = courtsDAO.get(id);
        mav.addObject("court", court);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCourt(@ModelAttribute("court") Court court){
        courtsDAO.update(court);
        return "redirect:/";
    }

    @RequestMapping("delete/{id}")
    public String deleteCourt(@PathVariable(name = "id") int id){
        courtsDAO.delete(id);
        return "redirect:/";
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
    @RequestMapping("/saveBooking")
    public String saveBooking(@ModelAttribute("booking") Booking booking){
        bookingsDao.save(booking);
        return "timetable/" + booking.getCourtId();
    }

}