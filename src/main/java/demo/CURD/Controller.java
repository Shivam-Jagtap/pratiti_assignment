package demo.CURD;

import demo.CURD.Entity.Book;
import demo.CURD.Entity.BookDto;
import demo.CURD.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("booklibrary")
public class Controller {

    @Autowired
    public BookServiceImpl bookService;

//    @PostMapping("/saveBook")
//      public Boolean saveBook(@RequestBody BookDto book){
//        System.out.println("request recieved...");
//        return bookService.saveBook(book);
//    }

    @PostMapping("saveBook")
    public ResponseEntity<String> saveBook(@RequestBody BookDto book){
        System.out.println("request recieved...");
//        return bookService.saveBook(book);
        if(bookService.saveBook((book))){
            return new ResponseEntity<>("Book saved successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book not saved", HttpStatusCode.valueOf(300));
    }


//    @GetMapping("getBook/{bookId}")
//    public Optional<Book> getbook(@PathVariable Integer bookId){
//        System.out.println("req on setp 1 for getBook...");
//        return bookService.getBook(bookId);
//    }
    @GetMapping("getBook/{bookId}")
    public ResponseEntity<Optional<Book>> getbook(@PathVariable Integer bookId){
        System.out.println("req on setp 1 for getBook...");
        return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.getBook(bookId));
//        return bookService.getBook(bookId);
    }

//    @GetMapping("getAllBooks")
//    public List<Book> getAllbooks(){
//        return bookService.getAllBooks();
//    }
    @GetMapping("getAllBooks")
    public ResponseEntity<List<Book>> getAllbooks(){
//        return bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getAllBooks());
    }

//    @PutMapping("updateBook")
//    public Boolean updateBook(@RequestBody BookDto bookToUpdate){
//        return bookService.updateBook(bookToUpdate);
//    }
    @PutMapping("updateBook")
    public ResponseEntity<Boolean> updateBook(@RequestBody BookDto bookToUpdate){
//        return bookService.updateBook(bookToUpdate);
    	return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(bookToUpdate));
    }

    @DeleteMapping("deleteBook/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook((bookId));
    }

//    @GetMapping("getBookByTitle")
//    public List<BookDto> getByTitle(@RequestParam("bookTitle") String bookTitle){
//        return bookService.getByTitle(bookTitle);
//    }
    @GetMapping("getBookByTitle")
    public ResponseEntity<List<BookDto>> getByTitle(@RequestParam("bookTitle") String bookTitle){
//        return bookService.getByTitle(bookTitle);
    	return ResponseEntity.status(HttpStatus.OK).body(bookService.getByTitle(bookTitle));
    }

}
