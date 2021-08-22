package mx.com.salmeron.quarkus.starting;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository bookRepository;


    @Inject
    Logger logger;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {

        logger.info("getAllBooks");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return getAllBooks().size();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBook(@PathParam("id") int id)  {
        return bookRepository.getBook(id);

    }


}