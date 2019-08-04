package com.qoobico.controller;

import com.qoobico.entity.Remind;
import com.qoobico.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RemindController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminders(ModelMap model) {
        return service.getAll();
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveReminder(@RequestBody Remind remind) {
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable long id) {
         service.remove(id);
    }

}
