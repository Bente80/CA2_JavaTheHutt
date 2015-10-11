package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Person;
import javax.ws.rs.core.Context;
import com.google.gson.JsonParser;
import com.oracle.jrockit.jfr.ContentType;
import deploy.DeploymentConfiguration;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Phone;
import exception.EntityNotFoundException;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.persistence.sessions.Project;

/**
 * REST Web Service
 *
 * @author Bente
 */
@Path("person/")
public class RestService
{

    @Context
    private UriInfo context;
    EntityManagerFactory emf;
    EntityManager em;
    Facade f;
    Gson gson;

    public RestService()
    {
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        em = emf.createEntityManager();
        f = new Facade(emf);
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    }

    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public Response getPersonById(@PathParam("id") String id) throws EntityNotFoundException
    {
        return Response.status(Response.Status.OK).entity(makePerson(f.getPersonById(new Long(id))).toString()).build();
    }

    @GET
    @Path("complete")
    @Produces("application/json")
    public Response getAllPersons() throws EntityNotFoundException
    {
        JsonArray out = new JsonArray();
        JsonObject jperson = new JsonObject();
        List<Person> personList = f.getAllPersons();
        System.out.println(personList.size());
        for (Person p : personList)
        {
            jperson = makePerson(p);

            out.add(jperson);
        }
        return Response.status(Response.Status.OK).entity(out.toString()).build();
    }

    @GET
    @Path("contactinfo/{id}")
    @Produces("application/json")
    public Response getOnePersonWithOnlyContactInfo(@PathParam("id") String id) throws EntityNotFoundException
    {
        return Response.status(Response.Status.OK).entity(makePersonSimpleInfo(f.getPersonById(new Long(id))).toString()).build();
    }

    @GET
    @Path("contactinfo")
    @Produces("application/json")
    public Response getAllPersonsWithOnlyContactInfo() throws EntityNotFoundException
    {
        JsonArray out = new JsonArray();
        JsonObject jperson = new JsonObject();
        List<Person> personList = f.getAllPersons();
        System.out.println(personList.size());
        for (Person p : personList)
        {
            jperson = makePersonSimpleInfo(p);

            out.add(jperson);
        }
        return Response.status(Response.Status.OK).entity(out.toString()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createAPerson(String data)
    {
        JsonObject o = new JsonParser().parse(data).getAsJsonObject();
        CityInfo c = new CityInfo(o.get("city").getAsString(),o.get("zipCode").getAsString());
        Address a = new Address(o.get("street").getAsString(), o.get("additionalInfo").getAsString(),c);
        Person p = new Person(o.get("firstName").getAsString(), o.get("lastName").getAsString(), o.get("email").getAsString(), a);

        f.savePerson(p);
        return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).entity(gson.toJson(p)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response EditAnExsistentPerson(@PathParam("id") String id, String data) throws EntityNotFoundException
    {
        JsonObject o = new JsonParser().parse(data).getAsJsonObject();
        String firstname = o.get("firstName").getAsString();
        Person p = f.updatePerson(new Long(id),firstname);
         
        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(gson.toJson(makePerson(p))).build(); 
    }
    
    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") String id) throws EntityNotFoundException
    {
        Person p = f.getPersonById(new Long(id));
        f.deletePerson(new Long(id));
        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(gson.toJson(makePerson(p))).build(); 
    }

    private JsonObject makePerson(Person person)
    {
        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", person.getFirstName());
        jo.addProperty("lastName", person.getLastName());
        jo.addProperty("email", person.getEmail());
        jo.addProperty("street", person.getAddress().getStreet());
        jo.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
        jo.addProperty("zipCode", person.getAddress().getCityInfo().getZip());
        jo.addProperty("city", person.getAddress().getCityInfo().getCity());
        
        JsonArray Jpershobby = new JsonArray();
        JsonObject hobbyObject;
        for (Hobby hobby : person.getHobbyList()){
        hobbyObject = new JsonObject();
        hobbyObject.addProperty("name", hobby.getName());
        hobbyObject.addProperty("description",hobby.getDescription());
        Jpershobby.add(hobbyObject);
        }
        jo.add("Hobbies", Jpershobby);
        
        JsonArray JpersTlf = new JsonArray();
        JsonObject pers;
        for (Phone phone : person.getPhoneList())
        {
            pers = new JsonObject();
            pers.addProperty("number", phone.getNumber());
            pers.addProperty("description", phone.getDescription());
            JpersTlf.add(pers);
        }
        jo.add("PersonTlf", JpersTlf);
        
        return jo;
    }

    private JsonObject makePersonSimpleInfo(Person person)
    {
        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", person.getFirstName());
        jo.addProperty("lastName", person.getLastName());
        jo.addProperty("email", person.getEmail());
        JsonArray JpersTlf = new JsonArray();
        JsonObject pers;
        for (Phone phone : person.getPhoneList())
        {
            pers = new JsonObject();
            pers.addProperty("number", phone.getNumber());
            pers.addProperty("description", phone.getDescription());
            JpersTlf.add(pers);
        }
        jo.add("PersonTlf", JpersTlf);
        return jo;
    }
}
