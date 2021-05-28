package edu.devember.Job.controller;

import edu.devember.Job.model.Job;
import edu.devember.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tmp")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("/list")
    public String jobList(Model theModel) {

        List<Job> list = service.findAll();

        theModel.addAttribute("jobs", list);

        return "list";
    }

    @GetMapping("/new")
    public String showNewJobPage(Model model) {

        Job theJob = new Job();

        model.addAttribute("newJob", theJob);

        return "new_job";
    }

    @PostMapping("/save")
    public String saveNewJob(@ModelAttribute("newJob") Job theNewJob) {

        service.save(theNewJob);

        return "redirect:http://localhost:8080/tmp/list";
    }

    @PostMapping("/delete")
    public String deleteJob(@RequestParam("jobId") Long theId) {

        service.deleteById(theId);

        return "redirect:http://localhost:8080/tmp/list";
    }

    @PostMapping("/update")
    public String updateJob(@RequestParam("jobId") Long theId, Model model) {

        Job theJob;

        Optional<Job> optionalJob = service.findById(theId);
        if (optionalJob.isPresent()) {
            theJob = optionalJob.get();
            model.addAttribute("newJob", theJob);
        } else {
            throw new RuntimeException("Did not find the job id - " + theId);
        }

        return "new_job";
    }
}
