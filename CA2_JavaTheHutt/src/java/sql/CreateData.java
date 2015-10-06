/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;


import entity.Hobby;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bente
 */
public class CreateData
{
static List <String> firstname = new ArrayList();
static List <String> lastname = new ArrayList();
static List <Hobby> hobbies = new ArrayList();
static List <String> email = new ArrayList();

    public static void main(String[] args) {
        firstname.add("Hans");firstname.add("Peter");firstname.add("Grete");firstname.add("Erik");
        firstname.add("Lars");firstname.add("Sofus");firstname.add("Bubber");firstname.add("Nikita");
        
        lastname.add("Bubbersen");lastname.add("Madsen");lastname.add("Hansen");lastname.add("Andersen");
        lastname.add("Flumprahsen");lastname.add("McWilliams");lastname.add("Fett");lastname.add("Kabutops");
        
        Hobby h1 = new Hobby("Karate","Kampsport");hobbies.add(h1);
        Hobby h2 = new Hobby("Mountainbike","Udendørsaktivitet");hobbies.add(h2);
        Hobby h3 = new Hobby("Dans","Skide svært");hobbies.add(h3);
        Hobby h4 = new Hobby("Programmering","Sjovt, til tider...");hobbies.add(h4);
        Hobby h5 = new Hobby("Trommer","Meget højt...");hobbies.add(h5);
        Hobby h6 = new Hobby("Star Wars","Nørdet..");hobbies.add(h6);
        
        email.add("scooby@hotmail.com");email.add("deathstar@hotmail.com");email.add("cirkus@hotmail.com");email.add("javathehutt@hotmail.com");
        email.add("bongobob@hotmail.com");email.add("threesome@hotmail.com");email.add("yogibear@hotmail.com");email.add("pooh@hotmail.com");
    }
}
