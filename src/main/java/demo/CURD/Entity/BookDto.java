package demo.CURD.Entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @NotNull
    private Integer bookId;

    @NotNull(message = "Name must not be null...")
    private String name;

    @Max(value = 10000,message = "Prize of the book must not exceed 10000")
    @NotNull
    private Double prize;

    @NotNull
    private String author;

    @Size(min = 5 , max = 30 , message = "description must be within 5 to 30 letters")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
