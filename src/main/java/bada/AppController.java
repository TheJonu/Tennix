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
    private CourtsDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Court> courtList = dao.list();
        model.addAttribute("courtList", courtList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model){
        Court court = new Court();
        model.addAttribute("court", court);
        return "new_form";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("sale") Court court){
        dao.save(court);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("edit_form");
        Court court = dao.get(id);
        mav.addObject("court", court);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("court") Court court){
        dao.update(court);
        return "redirect:/";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);
        return "redirect:/";
    }
}