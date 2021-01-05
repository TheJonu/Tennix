package bada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CourtsDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        //List<Sale> listSale = dao.list();
        //model.addAttribute("listSale", listSale);

        List<Court> courtList = dao.list();
        model.addAttribute("courtList", courtList);

        return "index";
    }

}