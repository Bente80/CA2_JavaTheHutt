<%-- 
    Document   : doc
    Created on : 09-10-2015, 11:19:59
    Author     : Bente
    <img class="img-responsive" src="image/chat.jpg" alt="chat" />
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Documentation</a>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="index.jsp">Index</a></li>
            <li><a href="createEditDelete.jsp">Create, edit or delete</a></li>
            <li><a href="tut.jsp">Tutorial</a></li>
        </ul>
        <h1>Documentation</h1><br>
        <br>
        <pre>
        <h4><b>CA 2 - Object Relational Mapping, REST, Test, Ajax and JQuery</b></h4>
        <h4><b>Bente Andersen, Steffen Juhl Madsen & Mikkel Vig</b></h4>

            <h4><b>Teststrategi og resultater:</b></h4>
Til dette projekt har vi både lavet almindelige JUnit-tests, og RestAssured-tests.
Vores JUnit-tests er blevet brugt til at teste metoderne i vores Facade-klasse, og vi har benyttet RestAssured-tests, 
til at teste vores Rest-API og fejlhåndtering. Vi har dog undladt at lave RestAssured-tests til POST, PUT og DELETE, 
da vi fik af vide, at dette var besværligt og unødvendigt. Vi har dog afprøvet disse, med Postman og tjek i databasen, 
og bekræftet at de virker.

Resultat af JUnit-tests:
 <img class="img-responsive" src="images/frajunit.png" alt="unit tests" />

Resultat af RestAssured-tests:

<img class="img-responsive" src="images/resttest.png" alt="rest tests" />

<h4><b>Hvem har lavet hvad:</b></h4>
Vores sædvanlige strategi med, så vidt muligt, at lave alt i fællesskab, holdt ikke til denne opgave. 
Vi indså hurtigt at dette ville være for tidskrævende, i forhold til projektets omfang, og vi måtte dele os op. 
Entitets-klasserne lavede vi sammen, og derefter arbejdede vi hver for sig, fordelt på følgende måde: 
Steffen fandt på en måde at generere en større mængde testdata, samt deployment.
Mikkel lavede Facade-klasse, fejlhåndtering, nogle JUnit-tests, dokumentation og tutorial.
Bente lavede Rest-API med tilhørende tests , JUnit-tests og frontend.

I forhold til hvor mange point vi hver skal have for indsats:
I tilfælde af at ovenstående beskrivelse, samt et kig på git commits, fortæller noget andet, er vi i gruppen enige om, 
at alle har ydet ca samme arbejdsindsats. På trods af, at vi denne gang har arbejdet mere hver for sig, 
har vi dog stadig siddet sammen mindst 8 timer alle dagene. Der er ingen der føler sig snydt, eller føler de har båret det tungeste læs, 
derfor er det kun fair, at alle får 5 point.

<h4><b>Implementering af arv:</b></h4>
Eftersom entitets-klasserne Person og Company, begge indeholder Phone og Address, har vi valgt at lade Person og Company 
extende InfoEntity-klassen. Entitets-klassen CityInfo er koblet til Address, og Address og Phone er koblet til InfoEntity, 
med foreign keys. Person og Company er koblet sammen med InfoEntity på samme måde. Det gør at vi kan gemme og tilgå,
samtlige informationer om en given person. 
Vi har besluttet at give Person og Company hver deres tabel i databasen. Det virkede oplagt, eftersom alternativet 
ville give for mange null-værdier i tabellen.

<h4><b>Test af system:</b></h4>
<b>Test cases</b>
Til både vores JUnit-tests og RestAssured-tests, tester vi på specifik data. Vil man have samme resultater som os, er det derfor vigtigt 
at man har samme indhold i sin database som vi har. Det får man ved at trykke Run på vores Datagenerator-klasse i pakken ”sql”, 
og derefter kan man afprøve vores FacadeJUnitTest-klasse og RESTTest-klasse.

<b>Postman</b>
Hvis man vil benytte Postman til at teste vores Rest-API, skal man gøre følgende:

<b>Èn person med et specifikt Id:</b>
Vælg GET, indsæt URL'en: http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/complete/1
Erstat ”1” med et hvilket som helst tal, dette er Id'et på personen der skal vises.

<b>Alle personer:</b>
Vælg GET, indsæt URL'en:  http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/complete

<b>Èn person kun med kontaktinfo:</b>
Vælg GET, indsæt URL'en: http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/contactinfo/1
Erstat ”1” med et hvilket som helst tal, dette er Id'et på personen der skal vises.

<b>Alle personer kun med kontaktinfo:</b>
Vælg GET, indsæt URL'en: http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/contactinfo

<b>Opret ny person:</b>
Vælg POST, indsæt URL'en:  http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person
Vælg ”Body”, tryk på ”raw” og vælg JSON(application/json).
Brug derefter følgende format, og erstat data med egne informationer:
{
  "firstName": "data",
  "lastName": "data",
  "email": "data",
  "street": "data",
  "additionalInfo": "data",
  "zipCode": "data",
  "city": "data"
}

<b>Ændre en eksisterende person:</b>
Vælg PUT, indsæt URL'en: http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/1
Erstat ”1” med et hvilket som helst tal, dette er Id'et på personen der skal ændres.
Vælg ”Body”, tryk på ”raw” og vælg JSON(application/json).
Man har kun mulighed for at ændre en persons fornavn, så brug følgende format, og erstat data med egen information:
{
 "firstName": "data"
}

<b>Slet en eksisterende person:</b>
Vælg DELETE, indsæt URL'en: http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/1
Erstat ”1” med et hvilket som helst tal, dette er Id'et på personen der skal slettes. 

<h4><b>Brug af hjemmeside:</b></h4>
På forsiden har man mulighed for at få vist en specifik persons informationer, ved at indtaste et tal i det lille tekstfelt, 
og derefter trykke på knappen ”Get one person”. Trykker man på ”Get all persons”, vil alle personer fra databasen 
blive vist i en tabel på siden. 

Man kan fra forsiden navigere videre til ”Create, edit or delete” med den øverste menubar. Her har man, som navnet indikerer, 
mulighed for at tilføje, ændre og slette personer i databasen. 
Vil man benytte disse funktioner, er et login påkrævet. Brug ”<b>test</b>” til både brugernavn og password, for at logge ind. 
        </pre>
        
        
        
    </body>
</html>
