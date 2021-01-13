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
    @Autowired
    private ClientsDao clientsDao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    // COURTS

    @RequestMapping("/court_new")
    public String showNewCourtForm(Model model){
        Court court = new Court();
        model.addAttribute("court", court);
        return "court_new";
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

    @RequestMapping(value = "/court_update", method = RequestMethod.POST)
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

    // CLIENTS

    @RequestMapping("/client_list")
    public String showClientsList(Model model) {
        List<Client> clients = clientsDao.get();
        model.addAttribute("clients", clients);
        return "client_list";
    }

    @RequestMapping("/client_new")
    public String showRegisterForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "client_new";
    }

    @RequestMapping("/client_save")
    public String saveClient(@ModelAttribute("client") Client client){
        clientsDao.save(client);
        return "redirect:/client_list";
    }

    @RequestMapping("/client/{id}/edit")
    public ModelAndView showClientEditForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("client_edit");
        Client client = clientsDao.get(id);
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping(value = "/client_update", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute("client") Client client){
        clientsDao.update(client);
        return "redirect:/client_list";
    }

    @RequestMapping("/client/{id}")
    public ModelAndView showBookingsList(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("client");
        Client client = clientsDao.get(id);
        List<Booking> bookings = bookingsDao.getByClient(id);
        bookings.forEach(b -> b.setCourtName(courtsDAO.get(b.getCourtId()).getName()));
        mav.addObject("client", client);
        mav.addObject("bookings", bookings);
        return mav;
    }
}