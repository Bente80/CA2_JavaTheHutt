/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import entity.Phone;
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

    /**
     * Creates a new instance of RestService
     */
    public RestService()
    {
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
        f = new Facade(emf);
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    }

    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public Response getPersonById(@PathParam("id") String id)
    {
        return Response.status(Response.Status.OK).entity(makePerson(f.getPersonById(new Long(id))).toString()).build();
    }

    @GET
    @Path("complete")
    @Produces("application/json")
    public Response getAllPersons()
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
    public Response getOnePersonWithOnlyContactInfo(@PathParam("id") String id)
    {
        return Response.status(Response.Status.OK).entity(makePersonSimpleInfo(f.getPersonById(new Long(id))).toString()).build();
    }

    @GET
    @Path("contactinfo")
    @Produces("application/json")
    public Response getAllPersonsWithOnlyContactInfo()
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
    public Response createAPerson(String person)
    {
        Person p = gson.fromJson(person, Person.class);
        f.savePerson(p);
        return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).entity(gson.toJson(p)).build();
    }

    /**
     * PUT method for updating or creating an instance of RestService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response EditAnExsistentPerson(@PathParam("id") String id)
    {
      f.updatePerson(new Long(id)); 
        return Response.status(Response.Status.OK).entity(makePerson(f.getPersonById(new Long(id))).toString()).build(); 
    }
    
    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") String id)
    {
        f.deletePerson(new Long(id));
        return Response.status(Response.Status.OK).build();
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
