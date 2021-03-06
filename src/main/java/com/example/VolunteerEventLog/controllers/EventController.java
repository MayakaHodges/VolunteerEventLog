package com.example.VolunteerEventLog.controllers;

import com.example.VolunteerEventLog.data.EventDao;
import com.example.VolunteerEventLog.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Mayaka Hodges
 */

@Controller
public class EventController {

    @Autowired
    private EventDao eventDao;


    @RequestMapping(value = "")
    public String index(Model model)
    {
        model.addAttribute("events", eventDao.findAll());
        model.addAttribute("title", "Events");
        return "events/index.html";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String handledisplayAddEventForm(Model model)
    {
        model.addAttribute("title", "Add Event");
        model.addAttribute(new Event());
        return "events/add.html";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String handleprocessAddEventForm(
            @Valid @ModelAttribute Event newEvent,
            Errors errors,
            Model model)
    {

        if (errors.hasErrors())
        {
            model.addAttribute("title", "Add Event");
            return "events/add";
        }

        eventDao.save(newEvent);
        return "redirect:";
    }

}
