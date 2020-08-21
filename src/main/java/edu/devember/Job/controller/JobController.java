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

    //List<Job> testList;

    @Autowired
    private JobService service;

    /*@PostConstruct
    private void loadTestData() {

        testList = new ArrayList<>();

        Job jo1 = new Job(
                "Tinkoff",
                100000,
                "https://www.tinkoff.ru/",
                "https://www.hh/tinkoff.ru/",
                LocalDate.of(2020, 1, 23));

        Job jo2 = new Job(
                "Sberbank",
                100000,
                "https://www.sberbank.ru/",
                "https://www.hh/sberbank.ru/",
                LocalDate.of(2020, 3, 4));

        Job jo3 = new Job(
                "Yandex",
                100000,
                "https://www.yandex.ru/",
                "https://www.hh/yandex.ru/",
                LocalDate.of(2020, 6, 30));

        testList.add(jo1);
        testList.add(jo2);
        testList.add(jo3);

    }*/

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
            throw new RuntimeException("Did not find job id - " + theId);
        }


        return "new_job";

    }


}
