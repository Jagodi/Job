package edu.devember.Job.controller;

import edu.devember.Job.model.JobOpening;
import edu.devember.Job.service.JobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tmp")
public class JobOpeningController {

    List<JobOpening> testList;

    @Autowired
    private JobOpeningService service;

    @PostConstruct
    private void loadTestData() {

        testList = new ArrayList<>();

        JobOpening jo1 = new JobOpening(
                "Tinkoff",
                100000,
                "https://www.tinkoff.ru/",
                "https://www.hh/tinkoff.ru/",
                LocalDate.of(2020, 1, 23));

        JobOpening jo2 = new JobOpening(
                "Sberbank",
                100000,
                "https://www.sberbank.ru/",
                "https://www.hh/sberbank.ru/",
                LocalDate.of(2020, 3, 4));

        JobOpening jo3 = new JobOpening(
                "Yandex",
                100000,
                "https://www.yandex.ru/",
                "https://www.hh/yandex.ru/",
                LocalDate.of(2020, 6, 30));

        testList.add(jo1);
        testList.add(jo2);
        testList.add(jo3);

    }

    @GetMapping("/list")
    public String openingList(Model theModel) {

        //List<JobOpening> list = service.findAll();

        theModel.addAttribute("jobOpenings", testList);

        return "list";
    }

    @GetMapping("/new")
    public String showNewOpeningPage(Model model) {

        JobOpening theJobOpening = new JobOpening();
        model.addAttribute("newOpening", theJobOpening);

        return "new_opening";
    }

    @PostMapping("/save")
    public String saveNewJobOpening(@RequestParam("newOpening") JobOpening theNewJobOpening) {

        service.save(theNewJobOpening);

        return "list";
    }


}
