package demo.CURD.service;

//import demo.CURD.DAO.BookDao;
import demo.CURD.Entity.Book;
import demo.CURD.Entity.BookDto;
import demo.CURD.Repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl {

    @Autowired
    private BookRepository bookRepository;

//    @Autowired
//    private BookDao bookDao;

    @Autowired
    ModelMapper mapper;

    public Boolean saveBook(BookDto book){
        Book b1 = mapper.map(book,Book.class);

        System.out.println("Book entity : "+b1);
        Book b =  bookRepository.save(b1);
        if(b.equals(b1)){
            return true;
        }
        return false;
    }

    public Optional<Book> getBook(Integer bookId){
        System.out.println("req came to service for id = "+bookId);
        return bookRepository.findById(bookId);
    }

    public List<Book> getAllBooks(){
        List<Book> b =  bookRepository.findAll();
        System.out.println(b.get(0));
        return b;
    }
    public void deleteBook(Integer id){
        bookRepository.deleteById(id);

    }
    public boolean updateBook(BookDto b){
        Integer id = b.getBookId();

        Optional<Book> isBook = bookRepository.findById(id);
        if(isBook.isPresent()){
            Book b1 = isBook.get();

            b1.setAuthor(b.getAuthor());
            b1.setName(b.getName());
            b1.setPrize(b.getPrize());

            bookRepository.save(b1);
        }
        return true;
    }


    public List<BookDto> getByTitle(String title){
        List<Book> b = bookRepository.findByName(title);
        System.out.println(b);

        List<BookDto> books = new ArrayList<>();
        for(Book k : b){
            BookDto n = mapper.map(k,BookDto.class);
            books.add(n);
        }
//        BookDto book = mapper.map(b,BookDto.class);
        return books;
    }
}
