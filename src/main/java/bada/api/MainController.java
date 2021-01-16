package bada.api;

import bada.dao.BookingsDao;
import bada.dao.ClientsDao;
import bada.dao.CourtsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private CourtsDao courtsDAO;
    @Autowired
    private BookingsDao bookingsDao;
    @Autowired
    private ClientsDao clientsDao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

}