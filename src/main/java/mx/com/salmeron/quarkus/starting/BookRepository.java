package mx.com.salmeron.quarkus.starting;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1,"Understanding Quarkus","Antonio Goncalves",2020, "IT"),
                new Book(2,"Title 2", "Sergio",2021,"IT"));
    }

    public Optional<Book> getBook(int id)  {
        return getAllBooks().stream().filter(book -> book.id ==id).findFirst();

    }


}
