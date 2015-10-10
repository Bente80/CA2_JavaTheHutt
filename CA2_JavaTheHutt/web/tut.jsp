<%-- 
    Document   : tut
    Created on : 09-10-2015, 12:17:33
    Author     : Bente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>Tutorial</title>
    </head>
    <body>
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Tutorial</a>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="index.jsp">Index</a></li>
            <li><a href="createEditDelete.jsp">Create, edit or delete</a></li>
            <li><a href="doc.jsp">Documentation</a></li>
        </ul>

        <h1>Tutorial</h1><br>
        <br>
        <pre>
        <h4><b>Komplet beskrivelse af Rest-API, fejlbeskeder og JSON-format:</b></h4>
Vi har lavet et Rest-API, som giver brugere mulighed for at hente informationer om personer fra en database. 
Man har derudover mulighed for at tilføje nye personer, samt ændre, og slette eksisterende personer i databasen. 

<p><b>Oversigt over metoderne i vores Rest-API med type, navn og formål:</b></p>
GET – getPersonById() - Henter én person med et specifikt Id
GET – getAllPersons() - Henter alle personer
GET – getOnePersonWithOnlyContactInfo() - Henter én person kun med kontaktinfo
GET – getAllPersonsWithOnlyContactInfo() - Henter alle personer kun med kontaktinfo
POST – createAPerson() - Opretter en ny person
PUT – editAnExistingPerson() - Ændrer en eksisterende person
DELETE – deletePerson() - Sletter en eksisterende person

Alle metoderne bruger denne URL som basis: http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person.

<p><b>JSON-format</b></p>
Vores Rest-API benytter formatet JSON(JavaScript Object Notation), til at håndtere data. 
Her er et eksempel på et Person-objekt i JSON format:
 {
  "firstName": "Darth",
  "lastName": "Vader",
  "email": "iamyourfather@hotmail.com",
  "street": "Stormtrooper Street",
  "additionalInfo": "2. tv",
  "zipCode": "2760",
  "city": "Cloud City"
}

Som man kan se på dette eksempel, har hver linje et attribut-navn, efterfulgt af en attribut-værdi. 
Vedrørende attribut-navnene, er det vigtigt de altid staves som i eksemplet ovenfor. ”firstname” fremfor ”firstName”,
 vil altså ikke blive godkendt.   


<p><b>Beskrivelse af metoderne i vores Rest-API:</b></p>
<b>getPersonById()</b>
Denne metode bruger et Id fra URL'en, og returnerer personen med dette Id i databasen, som et JSON-objekt. 
Følgende URL vil returnere person nr 1:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/complete/1

<b>getAllPersons()</b>
Denne metode henter alle personer i databasen, laver dem til JSON-objekter, lægger dem ind i et JSON-array, 
og returnerer dette. Følgende URL bruges:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/complete

<b>getOnePersonWithOnlyContactInfo()</b>
Erstatter man ”complete” med ”contactinfo” i URL'en, sker der det samme som ved getPersonById, 
bortset fra at det kun er fornavn, efternavn, email og telefonnumre der returneres. Eksempel på URL:  
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/contactinfo/1

<b>getAllPersonsWithOnlyContactInfo()</b>
Gør det samme som getAllPersons(), men med samme information som ovenstående. 
Følgende URL bruges:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/contactinfo

<b>createAPerson()</b>
Denne metode tager imod et JSON-objekt indeholdende persondata, laver dette om til et Address-, 
CityInfo- og et Person-objekt, gemmer dette i databasen, og returnerer det gemte person-objekt i JSON-format. 
Denne URL bruges:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person
Og følgende format til JSON-objektet skal bruges, erstat * med informationerne du vil gemme:
{
  "firstName": "*",
  "lastName": "*",
  "email": "*",
  "street": "*",
  "additionalInfo": "*",
  "zipCode": "*",
  "city": "*"
}
Som tidligere nævnt, er det vigtigt at alle attribut-navne, eksempelvis ”firstName”, er stavet præcis som i ovenstående eksempel. 

<b>editAnExistingPerson()</b>
Med denne metode kan man ændre navnet på en person i databasen. Den tager imod navnet, som personens navn i databasen skal ændres til. 
Hvilken person der skal ændres, bestemmes i URL'en.
Følgende URL bruges hvis man vil ændre navnet på person nr 1 i databasen:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/1
Dette format bruges til at angive, hvad navnet skal ændres til:
{
 "firstName": "data"
}

<b>deletePerson()</b>
Denne metode tager imod et Id via URL'en, og sletter personen med dette Id fra databasen.
Benyttes følgende URL, bliver person nr 1 i databasen slettet.
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/1


<p><b>Fejlhåndtering:</b></p>
Til Fejlhåndtering har vi lavet vores egen <b>EntityNotFoundException</b> med tilhørende Mapper-klasse. 
Den bliver kastet når man forsøger at finde, rette i eller slette en person, som ikke eksisterer i databasen. 
Selve beskeden ser således ud, hvis man bruger et id der ikke findes:
{"Code":404,"Message":"No person found with requested Id"}
Og hvis man forsøger at at hente alle personer, og der ikke er nogen i databasen:
{"Code":404,"Message":"No persons in database"}

Derudover har vi en <b>NotFoundExceptionMapper</b>. Forsøger man eksempelvis at bruge en URL der ikke findes:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/stormtrooper
Får man denne fejlbesked:
{"Code":404,"Message":"The page/service you requested does not exist"}

Til sidst har vi en <b>GenericExceptionMapper</b>, som implementerer ExceptionMapper Throwable, til at håndtere resten. 
Denne bliver eksempelvis kastet, når man forsøger at finde en person med URL'en, og indtaster bogstaver, i stedet for et tal.
Altså, skriver man dette i URL'en:
http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/api/person/complete/KoOgKylling
får man denne fejlbesked:
{"Code":500,"Message":"Internal server Error, we are very sorry for the inconvenience"}
        </pre>


    </body>
</html>
