package hu.nye.progkor.books.service.impl;

import hu.nye.progkor.books.model.Books;
import hu.nye.progkor.books.model.Hossz;
import hu.nye.progkor.books.model.Kat;
import hu.nye.progkor.books.model.exception.NotFoundException;
import hu.nye.progkor.books.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class BooksServiceimpl implements BooksService {

    private  static final List<Books> Db = new ArrayList<>();
    static{
        Db.add(new Books(1L,"Harry Potter", Kat.Scifi, Hossz.kozepes));
        Db.add(new Books(2L,"AZ", Kat.Horror, Hossz.kozepes));
    }

    @Override
    public List<Books> getAllBooks() {
        return Collections.unmodifiableList(Db);
    }



    @Override
    public Books getBooks(Long id) {
        return Db.stream()
                .filter(books -> books.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Books createBook(Books books){
        books.setId(NextId());
        Db.add(books);
        return books;
    }

    @Override
    public Books updateBook(final Long id, final Books booksUpdate) {
        final Books books = getBooks(id);
        books.setName(booksUpdate.getName());
        books.setKat(booksUpdate.getKat());
        books.setHossz(booksUpdate.getHossz());
        return books;
    }

    @Override
    public void deleteBook(Long id) {
    final Books books =getBooks(id);
    Db.remove(books);
    }
    public long NextId() {
        return getLastId() +1L;
    }
    private Long getLastId(){
        return Db.stream()
                .mapToLong(Books::getId)
                .max()
                .orElse(0);
    }
}
