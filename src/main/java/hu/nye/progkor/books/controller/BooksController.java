package hu.nye.progkor.books.controller;

import hu.nye.progkor.books.model.Books;
import hu.nye.progkor.books.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    //Cruda
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }
    @GetMapping
    Books GetBooks(@PathVariable("id")final Long id){
        return booksService.getBooks(id);
    }
    @PostMapping
    Books createBook(final @RequestBody Books books){
return booksService.createBook(books);
    }
@PutMapping
    Books updateBook(final @PathVariable Long id,final @RequestBody Books booksUpdate) {
    return booksService.updateBook(id, booksUpdate);
}
        @DeleteMapping
    ResponseEntity<Void> deleteBook(final @PathVariable Long id) {
            booksService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
