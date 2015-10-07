/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.CityInfo;
import entity.Company;
import entity.Person;
import entity.Phone;
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

    public Person getPersonById(Long id) {
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

    public Person savePerson(Person p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    public void deletePerson(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Person.class, id));
        em.getTransaction().commit();
    }
    
    public Person updatePerson(Long id){
        EntityManager em = getEntityManager();
        Person p = em.find(Person.class, id);
        em.getTransaction().begin();
        em.refresh(p);
        em.getTransaction().commit();
        return p;
    }

    public Person getPersonByPhone(String number) {
        EntityManager em = getEntityManager();
        Person person;
        try {

            Phone p = em.find(Phone.class, number);
            person = em.find(Person.class, p.getInfoEntity().getId());

        } finally {
            em.close();
        }
        return person;
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
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            personList.set(i, p);
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

    public List<Person> getPersonsByZipCode(String zipCode) {
        EntityManager em = getEntityManager();
        List<Person> personList;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> qu = em.createQuery("SELECT p FROM Person p Join p.address a Join a.cityInfo c WHERE c.zip = :zip", Person.class);
            qu.setParameter("zip", zipCode);
            personList = qu.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return personList;
    }

    public List<Person> getPersonsByCity(String city) {
        EntityManager em = getEntityManager();
        List<Person> personList;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> qu = em.createQuery("SELECT p FROM Person p Join p.address a Join a.cityInfo c WHERE c.city = :city", Person.class);
            qu.setParameter("city", city);
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
