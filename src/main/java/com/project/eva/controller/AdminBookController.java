package com.project.eva.controller;

import com.project.eva.model.Book;
import com.project.eva.model.BookBuilder;
import com.project.eva.service.interfaces.BookService;
import com.project.eva.service.interfaces.UserService;
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
@RequestMapping(value = "/admin/book")
@ComponentScan(basePackages = "com.project.eva.service")
public final class AdminBookController {

    private final BookService bookService;

    private final UserService userService;

    @Autowired
    public AdminBookController(
            final BookService bookService,

            final UserService userService
    ) {
        this.bookService = bookService;

        this.userService = userService;
    }


    @RequestMapping(
            value = {"", "/", "/all"},
            method = RequestMethod.GET
    )
    public ModelAndView viewAllBooks() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", this.bookService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("book/admin/all");
        return modelAndView;
    }


    @RequestMapping(
            value = "/view/{id}",
            method = RequestMethod.GET
    )
    public ModelAndView viewBook(@PathVariable(value = "id") final long id) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", this.bookService.get(id));
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("book/admin/one");
        return modelAndView;
    }


    @RequestMapping(
            value = "/add",
            method = RequestMethod.GET
    )
    public ModelAndView getAddBookPage() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("book/admin/add");
        return modelAndView;
    }

    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST
    )
    public String saveBook(@ModelAttribute("book")Book book,
            @RequestParam final String title,
            @RequestParam final String url,
            @RequestParam final String author,
            @RequestParam final String description,
HttpServletRequest request) {
        final BookBuilder bookBuilder = Book.getBuilder();
        bookBuilder.addTitle(title).addUrl(url).addAuthor(author).addDescription(description);

        MultipartFile bookImage = book.getBookImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "WEB-INF/resources/img/" + book.getTitle() + ".jpg");

        System.out.println(path);

        if (bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Book image saving failed", e);
            }
        }

        this.bookService.add(book);

        return "redirect:/admin/book/all";
    }


    @RequestMapping(
            value = "/save",
            method = RequestMethod.GET
    )
    public void saveCategory() throws IllegalMappingException {
        throw new IllegalMappingException(
                "GET method in \"/admin/book/save\" is not supported!"
        );
    }





    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.GET
    )
    public String deleteBook(@PathVariable(value = "id") final long id) {
        this.bookService.remove(id);
        return "redirect:/admin/book/all";
    }


    @RequestMapping(
            value = "/delete_all",
            method = RequestMethod.GET
    )
    public String deleteAllBooks() {
        this.bookService.removeAll();
        return "redirect:/admin/book/all";
    }
}

