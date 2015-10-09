/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bente
 */
public class Datagenerater {

    private static EntityManagerFactory emf;
   
    private static Hobby hb;
    private static List<Object> sms;
    private static Phone e;
    private static Hobby f;
    private static Address a;
    private static Person h;
    public static List<String> city;
    public static List<String> post;
    public static List<String> street;
    public static List<String> additionalInfo;
    public static List<String> phone;
    public static List<String> addphoneinfo;
    public static List<String> hobby;
    public static List<String> hobbydec;
    public static List<String> person;
    public static List<String> efternavn;
    public static List<String> email;
    private static CityInfo c;

    public static void main(String[] args) {
        
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
                try {
            File postfile = new File("city.txt");
            FileReader fileReader = new FileReader(postfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            city = new ArrayList();

            while (true) {
                line = bufferedReader.readLine();

                stringBuffer.append(line);
                stringBuffer.append("\n");
                city.add(line);

                fileReader.close();

            }
        } catch (IOException e) {
        }
      
        
        try {
            File cityfile = new File("post.txt");
            FileReader fileReader1 = new FileReader(cityfile);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            StringBuffer stringBuffer1 = new StringBuffer();
            String line1 = null;
            post = new ArrayList();

            while (true) {
                line1 = bufferedReader1.readLine();

                stringBuffer1.append(line1);
                stringBuffer1.append("\n");
                post.add(line1);

                fileReader1.close();
            }

        } catch (IOException e) {
        }
        try {
            File streetfile = new File("Street.txt");
            FileReader fileReader3 = new FileReader(streetfile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            street = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                street.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }
        try {
            File additionalInfofile = new File("additionalInfo.txt");
            FileReader fileReader3 = new FileReader(additionalInfofile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            additionalInfo = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                additionalInfo.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }

        try {
            File additionalInfofile = new File("phone.txt");
            FileReader fileReader3 = new FileReader(additionalInfofile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            phone = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                phone.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }

        try {
            File additionalInfofile = new File("adphoneinfo.txt");
            FileReader fileReader3 = new FileReader(additionalInfofile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            addphoneinfo = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                addphoneinfo.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }
        try {
            File additionalInfofile = new File("hobby.txt");
            FileReader fileReader3 = new FileReader(additionalInfofile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            hobby = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                hobby.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }
        try {
            File additionalInfofile = new File("hobbydec.txt");
            FileReader fileReader3 = new FileReader(additionalInfofile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            hobbydec = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                hobbydec.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }

        try {
            File personfile = new File("person.txt");
            FileReader fileReader3 = new FileReader(personfile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            person = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                person.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }

        try {
            File efternavnfile = new File("efternavn.txt");
            FileReader fileReader3 = new FileReader(efternavnfile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            efternavn = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                efternavn.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }

        try {
            File efternavnfile = new File("email.txt");
            FileReader fileReader3 = new FileReader(efternavnfile);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            StringBuffer stringBuffer3 = new StringBuffer();
            String line3 = null;
            email = new ArrayList();

            while (true) {

                line3 = bufferedReader3.readLine();

                stringBuffer3.append(line3);
                stringBuffer3.append("\n");
                email.add(line3);

                fileReader3.close();
            }
        } catch (IOException e) {
        }


        int count = 0;
        

        for (int i = 0; i < 59; i++) {
            
            String citynavn = city.get(count);
            String postnummer = post.get(count);


            c = new CityInfo(postnummer, citynavn);

            count++;
            em.persist(c);
            em.flush();

        }

        int count1 = 0;

        for (int i = 0; i < 59; i++) {

            String streetnavn = street.get(count1);
            String additionalInfotal = additionalInfo.get(count1);

            String neupost = post.get(count1);
            Object ms = em.find(CityInfo.class, neupost);

            count1++;

            a = new Address(streetnavn, additionalInfotal, (CityInfo) ms);

            em.persist(a);
            em.flush();
        }

        
                int count9 = 0;
            for (int i = 0; i < 14; i++) {
            String hoby = hobby.get(count9);
            String hobydec = hobbydec.get(count9);

            hb = new Hobby(hoby, hobydec);

            count9++;
            
            em.persist(hb);

        }
        
             int count8 = 0;
             for (int i = 0; i < 59; i++) {

            String personname = person.get(count8);
            String personefternavnl = efternavn.get(count8);
            String nextemeil = email.get(count8);

            String neuper = street.get(count8);
            Object mineadres = em.find(Address.class, neuper);

            h = new Person(personname, personefternavnl, nextemeil, (Address) mineadres);

            h.addHobby(hb);
            count8++;

            em.persist(h);
            em.flush();

        }
//        int count10 = 0;
//        for (int i = 0; i < 14; i++) {
//        
//          String hobyprimkey = hobby.get(count10);
//          Hobby hobbynr = em.find(Hobby.class, hobyprimkey);
//          
//         
//          hobbynr.getName();
//            System.out.println("" + hobbynr.getName());
//
//          count10++;
//
//        }
             
             
//        int count5 = 0;
//        for (int i = 0; i < 15; i++) {
//            String phonenr = phone.get(count5);
//            String addphoneinfo = additionalInfo.get(count5);
//
//            e = new Phone(phonenr, addphoneinfo);
//
//            count5++;
//            em.persist(e);
//
//        }

        em.persist(c);
        em.getTransaction().commit();
    }


//    public int counter(){
//        
//        
//        Random rd = new Random();
//        int nextvalue = rd.nextInt(15);
//
//        return nextvalue;
//
//        }
//    
//    
//    public int antalafhobby(int i){
//    
//        Random rnd = new Random();
//        int nexthobbyvalue = rnd.nextInt(15);
//       
//        
//        
//        return nexthobbyvalue;
//    }
}
