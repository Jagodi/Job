package edu.devember.Job.controller;

import edu.devember.Job.service.JobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JobOpeningController {

    @Autowired
    private JobOpeningService service;


}
