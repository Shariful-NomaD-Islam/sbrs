package com.nomad.app.controller;

import com.nomad.app.ApplicationException;
import com.nomad.app.model.Book;
import com.nomad.app.model.ErrorDetails;
import com.nomad.app.model.Reply;
import com.nomad.app.repository.CommonDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/book")
@Api("This is The Book API Documentation")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final CommonDAO commonDAO;

    public BookController(CommonDAO commonDAO) {
        this.commonDAO = commonDAO;
    }

    @GetMapping(value = "/get-all")
    @ApiOperation("Return All Book data from database")
    public Reply<List<Book>> getBookList() {
        List<Book> bookList = commonDAO.getAllBook();
        return Reply.ok(bookList);
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation("Return All Book data from database")
    public Reply<Book> getBook(@PathVariable("id") String id) {
        Book book = null;
        try {
            book = commonDAO.getBook(id);
            return Reply.ok(book);
        } catch (ApplicationException aex) {
            return Reply.error(aex.getErrorDetails().getValue(), aex.getErrorDetails().toString(), book);
        }
    }

    @PostMapping(value = "/add")
    @ApiOperation("Add Book to database")
    public Reply<Boolean> addBook(@RequestBody final Book book) {
        Boolean isAdded = commonDAO.addBook(book);
        return Reply.ok(isAdded);
    }
}
