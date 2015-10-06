/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.CityInfo;
import entity.Company;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bente
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Person getPersonById(int id) {
        EntityManager em = getEntityManager();
        Person p;
        try {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
    
    public Person getPersonByPhone(String number) {
        EntityManager em = getEntityManager();
        Person p;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> qu = em.createQuery("SELECT p FROM Person p WHERE p.number = :number", Person.class);
            qu.setParameter("number", number);
            qu.setMaxResults(1);
            p = qu.getSingleResult();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    public List<Person> getAllPersons() {
        EntityManager em = getEntityManager();
        List<Person> personList;
        try {
            em.getTransaction().begin();
            personList = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return personList;
    }
    
    public List<Person> getPersonsByHobby(String hobby) {
        EntityManager em = getEntityManager();
        List<Person> personList;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> qu = em.createQuery("SELECT p FROM Person p WHERE p.hobby = :hobby", Person.class);
            qu.setParameter("hobby", hobby);
            personList = qu.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return personList;
    }
    
    public List<String> getAllZipCodes() {
        EntityManager em = getEntityManager();
        List<String> zipList;
        try {
            em.getTransaction().begin();
            zipList = em.createQuery("SELECT c.zip FROM CityInfo c").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return zipList;
    }

    public List<Person> getPersonsByZipCode(int zipCode) {
        EntityManager em = getEntityManager();
        List<Person> personList;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> qu = em.createQuery("SELECT p FROM Person p WHERE p.zip = :zip", Person.class);
            qu.setParameter("zip", zipCode);
            personList = qu.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return personList;
    }

    public Company getCompanyByCVR(int cvr) {
        EntityManager em = getEntityManager();
        Company c;
        try {
            em.getTransaction().begin();
            TypedQuery<Company> qu = em.createQuery("SELECT c FROM Company c WHERE c.cvr = :cvr", Company.class);
            qu.setParameter("cvr", cvr);
            qu.setMaxResults(1);
            c = qu.getSingleResult();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    
    public List<Company> getCompaniesByEmployeeNumber(int amount) {
        EntityManager em = getEntityManager();
        List<Company> companyList;
        try {
            em.getTransaction().begin();
            TypedQuery<Company> qu = em.createQuery("SELECT c FROM Company c WHERE c.numEmployees > :numEmployees", Company.class);
            qu.setParameter("numEmployees", amount);
            companyList = qu.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return companyList;
    }
}
