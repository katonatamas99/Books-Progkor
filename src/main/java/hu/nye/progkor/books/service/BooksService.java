package hu.nye.progkor.books.service;

import hu.nye.progkor.books.model.Books;

import java.util.List;

public interface BooksService {

    List<Books> getAllBooks();

    Books GetBooks(Long id);

    Books getBooks(Long id);

    Books createBook(Books books);

    Books updateBook(Long id,Books booksUpdate);

    void deleteBook(Long id);



}
