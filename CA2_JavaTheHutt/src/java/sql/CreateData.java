/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;


import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bente
 */
public class CreateData
{
//static List <String> firstname = new ArrayList();
//static List <String> lastname = new ArrayList();
//static List <Hobby> hobbies = new ArrayList();
//static List <String> email = new ArrayList();

    public static void main(String[] args) {
//        firstname.add("Hans");firstname.add("Peter");firstname.add("Grete");firstname.add("Erik");
//        firstname.add("Lars");firstname.add("Sofus");firstname.add("Bubber");firstname.add("Nikita");
//        
//        lastname.add("Bubbersen");lastname.add("Madsen");lastname.add("Hansen");lastname.add("Andersen");
//        lastname.add("Flumprahsen");lastname.add("McWilliams");lastname.add("Fett");lastname.add("Kabutops");
//        
//        Hobby h1 = new Hobby("Karate","Kampsport");hobbies.add(h1);
//        Hobby h2 = new Hobby("Mountainbike","Udendørsaktivitet");hobbies.add(h2);
//        Hobby h3 = new Hobby("Dans","Skide svært");hobbies.add(h3);
//        Hobby h4 = new Hobby("Programmering","Sjovt, til tider...");hobbies.add(h4);
//        Hobby h5 = new Hobby("Trommer","Meget højt...");hobbies.add(h5);
//        
//        
//        email.add("scooby@hotmail.com");email.add("deathstar@hotmail.com");email.add("cirkus@hotmail.com");email.add("javathehutt@hotmail.com");
//        email.add("bongobob@hotmail.com");email.add("threesome@hotmail.com");email.add("yogibear@hotmail.com");email.add("pooh@hotmail.com");
//        
        CityInfo c = new CityInfo("3487","Bullerby");
        CityInfo c2 = new CityInfo("2720","Oenskebyen");
        CityInfo c3 = new CityInfo("2300","Amager");
        CityInfo c4 = new CityInfo("8000","Aarhus");
        Address a = new Address("Torbenvej","34, 2.tv",c);
        Address a2 = new Address("Carl Holsters Alle","4",c2);
        Address a3 = new Address("Arne Jacobsen Alle","24",c3);
        Address a4 = new Address("Aros Allé","8",c2);
        c.addAddress(a);
        c2.addAddress(a2);
        c3.addAddress(a3);
        c4.addAddress(a4);
        Hobby h6 = new Hobby("Star Wars","Nørdet..");
        Hobby h5 = new Hobby("Trommer","Meget højt...");
        Hobby h4 = new Hobby("Programmering","Sjovt, til tider...");
        Phone p = new Phone("33887590","Mormor");
        Phone p2 = new Phone("29774451","Moster");
        Phone p3 = new Phone("84551239","Tante Anny");
        Phone p4 = new Phone("22222222","Chefen");
        Phone p5 = new Phone("555-7777","Hjemme");
        Phone p6 = new Phone("66345197","Mobil");
        Person person = new Person("Korben","Dallas","Korben@hotmail.com",a);
        Person person2 = new Person("Sille","Jacobsen","Sille@gmail.com",a2);
        Company company = new Company("Fields","Varehus",75897548,100,20000000000.0,"fields@gmail.com",a3);
        Company company2 = new Company("Aros","Museum",88848624,25,17300000.0,"aros@gmail.com",a4);
        person.addPhone(p);
        person2.addPhone(p2);
        person2.addPhone(p3);
        company.addPhone(p4);
        company.addPhone(p5);
        company2.addPhone(p6);
        p.setInfoEntity(person);
        p2.setInfoEntity(person2);
        p3.setInfoEntity(person2);
        p4.setInfoEntity(company);
        p5.setInfoEntity(company);
        p6.setInfoEntity(company2);
        person.addHobby(h6);
        person.addHobby(h5);
        person.addHobby(h4);
        person2.addHobby(h4);
////////////        h6.addPerson(person);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(person);
        em.persist(person2);
        em.persist(company);
        em.persist(company2);
        em.getTransaction().commit();
        em.close();
        
        
    }
}
