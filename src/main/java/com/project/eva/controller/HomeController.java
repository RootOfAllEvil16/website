package com.project.eva.controller;

import com.project.eva.service.interfaces.BookService;
import com.project.eva.service.interfaces.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mapping.model.IllegalMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.project.eva.service")
public final class HomeController {

    private final ChapterService chapterService;

    private final BookService bookService;




    @Autowired
    public HomeController(
            final ChapterService chapterService,
            final BookService bookService


    ) {
        this.chapterService = chapterService;
        this.bookService = bookService;


    }


    @RequestMapping(
            value = {"", "/", "/home"},
            method = RequestMethod.GET
    )
    public ModelAndView home() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", this.bookService.getAll());
        /*final int chaptersNumber = 8;*/
      /*не обязательно modelAndView.addObject("chapters", this.chapterService.getAll());*/
        modelAndView.setViewName("home/home");
        return modelAndView;
    }

    @RequestMapping("/reader")
    public ModelAndView about() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reader");
        modelAndView.addObject("chapters",this.chapterService.getAll());
        return modelAndView;
    }

/* Вернёт все главы в книге*/
    @RequestMapping(
            value = "/book/{url}",
            method = RequestMethod.GET
    )
    public ModelAndView viewChaptersInBook(@PathVariable("url")  final String url) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", this.bookService.get(url));
        modelAndView.addObject("chapters", this.chapterService.getByBookUrl(url));
        modelAndView.setViewName("book/one");
        return modelAndView;
    }


    @RequestMapping(
            value = "/chapter/all",
            method = RequestMethod.GET
    )
    public ModelAndView viewAllChapters() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("chapters", this.chapterService.getAll());
        modelAndView.setViewName("chapter/all");
        return modelAndView;
    }

    @RequestMapping(value = "/chapter/{url}", method = RequestMethod.GET)
    public ModelAndView viewChapter(@PathVariable("url") final String url) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("chapter", this.chapterService.getByUrl(url));
        modelAndView.setViewName("chapter/one");
        return modelAndView;


    }

    @RequestMapping(
            value = "/forbidden_exception",
            method = RequestMethod.GET
    )
    public void getIllegalMappingException() throws IllegalMappingException {
        throw new IllegalMappingException(
                "You do not have sufficient permissions to access this page."
        );
    }

   
    @RequestMapping(
            value = { "/admin", "/admin/" },
            method = RequestMethod.GET
    )
    public String redirectToAdminPage() {
        return "redirect:/admin/chapter/all";
    }



}
