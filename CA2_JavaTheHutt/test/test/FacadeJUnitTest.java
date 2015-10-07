/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.CityInfo;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import sql.CreateData;

/**
 *
 * @author Bente
 */
public class FacadeJUnitTest
{
        EntityManagerFactory emf;
        EntityManager em;

    public FacadeJUnitTest()
    {
    
    }
    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
    }
    
    @Test
    public void getAllPersonsFromDatabaseTest()
    {
        CreateData.testData(em);
        Facade f = new Facade(emf);
        List<Person> p = f.getAllPersons();
        assertEquals(p.size(), 2);
    }
    
//    @Test
//    public void getonePersonByPhone()
//    {
//        CreateData.testData(em);
//        Facade f = new Facade(emf);
//        Person p = f.getPersonByPhone("33887590");
//        assertEquals(p.getFirstName(), "Korben");
//        
//    }
    @Test
    public void getAllZipFromDatabaseTest()
    {
        CreateData.testData(em);
        Facade f = new Facade(emf);
        List<String> allZipCodes = f.getAllZipCodes();
        assertEquals(allZipCodes.size(), 4);
    }
}
