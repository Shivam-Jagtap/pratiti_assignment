package demo.CURD.Repository;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import demo.CURD.Entity.Book;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    @Transactional
    @Query("SELECT b FROM Book b WHERE b.name = :title")
    public List<Book> findByName(@Param("title") String title);


//    @Transactional
//    @Modifying
//    @Query("UPDATE book b SET b.name = :bookToUpdate.name , b.prize = :bookToUpdate.prize , b.author = :bookToUpdate.author WHERE b.bookId = :bookId")
//    public void updateBook(Integer bookId, Book bookToUpdate);
    
}
