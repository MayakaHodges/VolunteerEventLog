package com.example.VolunteerEventLog.controllers;

import com.example.VolunteerEventLog.data.EventDao;
import com.example.VolunteerEventLog.data.VolunteerDao;
import com.example.VolunteerEventLog.models.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDao;

    @Autowired
    private EventDao eventDao;

    // Request path: /volunteer
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Menus");
        model.addAttribute("volunteers", volunteerDao.findAll());
        return "volunteer/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Volunteer");
        model.addAttribute("events", eventDao.findAll());
        model.addAttribute(new Volunteer());
        return "volunteer/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Volunteer menu,
                      Errors errors)
    {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Volunteer");
            return "volunteer/add";
        }


        return "redirect:view/volunteer/" + menu.getId();
    }
}
