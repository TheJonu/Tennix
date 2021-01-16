package bada.api;

import bada.dao.BookingsDao;
import bada.dao.ClientsDao;
import bada.dao.CourtsDao;
import bada.model.Booking;
import bada.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientsDao clientsDao;
    @Autowired
    private BookingsDao bookingsDao;
    @Autowired
    private CourtsDao courtsDAO;


    @RequestMapping("/client_list")
    public String showClientsList(Model model) {
        List<Client> clients = clientsDao.get();
        model.addAttribute("clients", clients);
        return "/client_list";
    }

    @RequestMapping("/client_new")
    public String showRegisterForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "/client_new";
    }

    @PostMapping("/client_save")
    public String saveClient(@ModelAttribute("client") Client client){
        clientsDao.save(client);
        return "redirect:/client_list";
    }

    @RequestMapping("/client/{id}/edit")
    public ModelAndView showClientEditForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("/client_edit");
        Client client = clientsDao.get(id);
        mav.addObject("client", client);
        return mav;
    }

    @PostMapping(value = "/client_update")
    public String updateClient(@ModelAttribute("client") Client client){
        clientsDao.update(client);
        return "redirect:/client_list";
    }

    @RequestMapping("/client/{id}")
    public ModelAndView showBookingsList(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("/client");
        Client client = clientsDao.get(id);
        List<Booking> bookings = bookingsDao.getByClient(id);
        bookings.forEach(b -> b.setCourtName(courtsDAO.get(b.getCourtId()).getName()));
        mav.addObject("client", client);
        mav.addObject("bookings", bookings);
        return mav;
    }
}