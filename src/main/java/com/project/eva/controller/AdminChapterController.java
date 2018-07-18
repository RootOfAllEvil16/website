package com.project.eva.controller;


import com.project.eva.model.*;
import com.project.eva.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mapping.model.IllegalMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;

@Controller
@RequestMapping(value = "/admin/chapter")
@ComponentScan(basePackages = "com.project.eva.service")
public final class AdminChapterController {

    private final ChapterService chapterService;

    private final BookService bookService;

    private final UserService userService;




    @Autowired
    public AdminChapterController(
            final ChapterService chapterService,
            final BookService bookService,
            final UserService userService

    ) {
        this.chapterService=chapterService;
        this.bookService=bookService;
        this.userService = userService;

    }


    @RequestMapping(
            value = { "", "/", "/all" },
            method = RequestMethod.GET
    )
    public ModelAndView viewAllChapters() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("chapters", this.chapterService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("chapter/admin/all");
        return modelAndView;
    }


    @RequestMapping(
            value = "/view/{id}",
            method = RequestMethod.GET
    )
    public ModelAndView viewChapter(@PathVariable(value = "id") final long id) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("chapter", this.chapterService.get(id));
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("chapter/admin/one");
        return modelAndView;
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.GET
    )
    public ModelAndView getAddChapterPage() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", this.bookService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("chapter/admin/add");
        return modelAndView;
    }


    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST
    )
    public String saveChapter(
            @RequestParam(value = "chapterTitle") final String chapterTitle,
            @RequestParam(value = "chapterNumber")final String chapterNumber,
            @RequestParam(value = "url") final String url,
            @RequestParam(value = "music")final String music,
            @RequestParam(value = "text")final String text,
            @RequestParam(value = "book") final long bookId,
            @RequestParam(value = "chapterImage") final MultipartFile chapterImage,
            HttpServletRequest request



    ) {
        final Chapter chapter = new Chapter();
        chapter.setChapterTitle(chapterTitle);
        chapter.setChapterNumber(chapterNumber);
        chapter.setUrl(url);
        chapter.setMusic(music);
        chapter.setText(text);


        final Book book = this.bookService.get(bookId);
        chapter.setBook(book);


        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "WEB-INF/resources/img/" + chapter.getChapterTitle() + ".jpg");

        System.out.println(path);

        if (chapterImage != null && !chapterImage.isEmpty()) {
            try {
                chapterImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Chapter image saving failed", e);
            }
        }

        this.chapterService.add(chapter);


        return "redirect:/admin/chapter/all";
    }

    @RequestMapping(
            value = "/save",
            method = RequestMethod.GET
    )
    public void saveChapter() throws IllegalMappingException {
        throw new IllegalMappingException(
                "GET method in \"/admin/chapter/save\" is not supported!"
        );
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.GET
    )
    public String deleteChapter(@PathVariable(value = "id") final long id) {
        this.chapterService.remove(id);
        return "redirect:/admin/chapter/all";
    }

    @RequestMapping(
            value = "/delete_all",
            method = RequestMethod.GET
    )
    public String deleteAllChapters() {
        this.chapterService.removeAll();
        return "redirect:/admin/chapter/all";
    }
}
