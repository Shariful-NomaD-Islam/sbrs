package com.nomad.app.repository;

import com.nomad.app.ApplicationException;
import com.nomad.app.model.Book;
import com.nomad.app.model.ErrorDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CommonDAOImpl implements CommonDAO {

    private static final Logger logger = LoggerFactory.getLogger(CommonDAOImpl.class);

    @Autowired
    @Qualifier("jdbc-01")
    private JdbcTemplate jdbcTemplate01;

    @Override
    public List<Book> getAllBook() {
        String sql = "Select id,name,author_name from book";

        List<Book> bookList = jdbcTemplate01.query(sql, (rs, i) -> new Book()
                .setId(rs.getString("id"))
                .setName(rs.getString("name"))
                .setAuthorName(rs.getString("author_name")));
        return bookList;
    }

    @Override
    public Book getBook(String id) throws ApplicationException {
        String sql = "Select id,name,author_name from book Where id = ?";

        Book book = null;
        try {
            book = jdbcTemplate01.queryForObject(sql, (rs, i) -> new Book()
                            .setId(rs.getString("id"))
                            .setName(rs.getString("name"))
                            .setAuthorName(rs.getString("author_name"))
                    , id);
        } catch (EmptyResultDataAccessException eex) {
            throw new ApplicationException(ErrorDetails.BOOK_ID_NOT_FOUND, eex);
        }
        return book;
    }

    @Override
    public boolean addBook(Book book) {
        String sql = "insert into book(id,name,author_name) values(?,?,?)";
        jdbcTemplate01.update(sql, book.getId(), book.getName(), book.getAuthorName());
        return true;
    }


}
