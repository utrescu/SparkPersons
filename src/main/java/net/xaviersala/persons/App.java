package net.xaviersala.persons;


import net.xaviersala.persons.DAO.MemoryPersonDAO;
import net.xaviersala.persons.DAO.PersonDAO;
import spark.Spark;

/**
 * SparkPersons
 *
 * Build a simple REST server with Spark to test
 * authentication with Pac4j
 *
 */
public class App
{

    private final static PersonDAO dao = new MemoryPersonDAO();
    private final static Controller controller = new Controller(dao);

    public static void main( String[] args )
    {
      Spark.get("/clients", (request, response) -> {
        response.status(200);
        response.type("application/json");
        return controller.getAllPersons();
      });

      Spark.post("/clients", (request,response) -> {
        response.status(200);
        response.type("application/json");
        return controller.addPerson(request.body());
      });

      Spark.get("/clients/:id", (request,response) -> {
        String id = request.params(":id");
        response.status(200);
        response.type("application/json");
        return controller.getPerson(id);
      });
    }
}
