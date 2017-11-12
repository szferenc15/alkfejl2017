[MVC]: https://www.tutorialspoint.com/mvc_framework/mvc_framework_introduction.htm
[H2]: http://www.h2database.com/html/tutorial.html
[JPA]: https://www.tutorialspoint.com/jpa/index.htm
[Thymeleaf]: http://www.thymeleaf.org/
[Lombok]: https://projectlombok.org/
[JAVA Spring Boot]: https://projects.spring.io/spring-boot/
[Git]: https://git-scm.com/
[Microsoft Visual Studio Code]: https://code.visualstudio.com/
[Angular 2/4]: https://angular.io/
[JAVA 7/8]: https://en.wikipedia.org/wiki/Java_(programming_language)
[Eötvös Loránd Tudományegyetem Informatikai Kar]: http://inf.elte.hu

[ER]: ./img/Entity_Relationship_diagram.png "Egyed-kapcsolat diagram"

# Alkalmazások fejlesztése - Cinema World

A projekt egy mozi frontend és backend rendszerének megvalósításáról szól, mely [MVC] (Model-View-Controller) architektúrában épül fel.

## Célközönség:
Bármely személy, akinek a moziba járás nem csak a filmnézésről szól, hanem az élményekről, a kényelemről és a prémium minőségű finomságokról.

## Szerepkörök:
+ **Vendég**: Filmek adatlapját, illetve előzeteseit tudja megtekinteni.
+ **Felhasználó**: Tud foglalni, venni jegyet, illetve filmet értékelni.
+ **Adminisztrátor**: Új filmeket tud felvenni az adatbázisba, illetve azokat törölni is tudja (ha például egy filmet már nem vetítenek).

## Funkcionális követelmények:
+ **Vendégként** szeretnék a filmek között szabadon böngészni.
+ **Vendégként** szeretném egy film adatait, leírását, előzeteseit megtekinteni.
+ **Vendégként** szeretnék filmeket keresni.
+ **Vendégként** szeretnék regisztrálni az oldalra.
+ **Felhasználóként** szeretnék bejelentkezni az oldalra.
+ **Felhasználóként** szeretném szerkeszteni a profiladataimat.
+ **Felhasználóként** szeretném a saját foglalásaim, illetve vásárlásaim megtekinteni.
+ **Felhasználóként** szeretném értékelni a filmeket.
+ **Adminisztrátorként** szeretnék új filmeket hozzáadni a műsorlistához, illetve törölni is róla.

## Nem funkcionális követelmények:
+ Használhatóság
+ Teljesítmény
+ Hatékonyság
+ Rendelkezésre állás
+ Biztonság
+ Karbantarthatóság
+ Platformfüggetlenség
+ Felhasználóbarát design

## Használt technológiák, fejlesztői környezetek, programozási nyelvek:
+ **[H2]** - Adatbáziskezelő,
+ **[JPA]** - (Java Persistence API) Relációs adatkezelő
+ **[Thymeleaf]** - Szerveroldali template motor XHTML/HTML5/XML-hez
+ **[Lombok]** - Szerveroldali automatikus erőforrás menedzser
+ **[JAVA Spring Boot]** - JAVA szerveroldali keretrendszer
+ **[Git]** - Verziókezelő rendszer
+ **[Microsoft Visual Studio Code]** - Forráskód szerkesztő
+ **[Angular 2/4]** - Programozási nyelv (HTML, CSS, SCSS, Typescript) (kliensoldal)
+ **[JAVA 7/8]** - Programozási nyelv (szerveroldal)

```
TODO: 
    1. Lombok @Data bug
    2. @Pattern validation for the first insertion
```

## Adatbázis séma:
<table align="center">
    <th colspan="3">BOOKING</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">foglalás azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">SCREENING_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">vetítés azonosítója (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">CATEGORY</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">CATEGORY</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="center" width="33%">kategória neve (PK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">CATEGORY_INFORMATION</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">kategória információ azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">FILM_TITLE</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="center" width="33%">film neve (FK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">CATEGORY</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="center" width="33%">kategória neve (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">CINEMA</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">mozi azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">COUNTRY</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="center" width="33%">ország neve</td>
    </tr>
        <td align="center" width="33%">CITY</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="center" width="33%">város neve</td>
    </tr>
    <tr>
        <td align="center" width="33%">DISTRICT</td>
        <td align="center" width="33%">VARCHAR2(8)</td>
        <td align="center" width="33%">kerület neve</td>
    </tr>
    <tr>
        <td align="center" width="33%">STREET</td>
        <td align="center" width="33%">VARCHAR(50)</td>
        <td align="center" width="33%">utca neve</td>
    </tr>
    <tr>
        <td align="center" width="33%">HOUSE_NUMBER</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="center" width="33%">házszám</td>
    </tr>
    <tr>
        <td align="center" width="33%">NAME</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="center" width="33%">mozi neve</td>
    </tr>
    <tr>
        <td align="center" width="33%">AMENITIES_CHARGE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">kényelmi díj értéke</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">FILM</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">TITLE</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="center" width="33%">film címe (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">LANGUAGE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="center" width="33%">nyelvezete</td>
    </tr>
    <tr>
        <td align="center" width="33%">SYNCHRON</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">elérhető-e szinkronos verzió</td>
    </tr>
    <tr>
        <td align="center" width="33%">INSCRIPTIVE</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">elérhető-e feliratos verzió</td>
    </tr>
    <tr>
        <td align="center" width="33%">IMAX</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">elérhető-e IMAX verzió</td>
    </tr>
    <tr>
        <td align="center" width="33%">THREE_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">elérhető-e három dimenziós verzió</td>
    </tr>
    <tr>
        <td align="center" width="33%">FOUR_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">elérhető-e négy dimenziós verzió</td>
    </tr>
    <tr>
        <td align="center" width="33%">PLAY_TIME</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">játékideje</td>
    </tr>
    <tr>
        <td align="center" width="33%">PREMIERE</td>
        <td align="center" width="33%">DATE</td>
        <td align="center" width="33%">premier dátuma</td>
    </tr>
    <tr>
        <td align="center" width="33%">AGE_LIMIT</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="center" width="33%">korhatár</td>
    </tr>
    <tr>
        <td align="center" width="33%">DIRECTOR_FIRST_NAME</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="center" width="33%">rendező keresztneve</td>
    </tr>
    <tr>
        <td align="center" width="33%">DIRECTOR_LAST_NAME</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="center" width="33%">rendező vezetékneve</td>
    </tr>
    <tr>
        <td align="center" width="33%">COUNTRY</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="center" width="33%">országa</td>
    </tr>
    <tr>
        <td align="center" width="33%">YEAR</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">gyártási éve</td>
    </tr>
    <tr>
        <td align="center" width="33%">RATE</td>
        <td align="center" width="33%">DECIMAL</td>
        <td align="center" width="33%">értékelése</td>
    </tr>
    <tr>
        <td align="center" width="33%">DESCRIPTION</td>
        <td align="center" width="33%">VARCHAR2(500)</td>
        <td align="center" width="33%">leírása</td>
    </tr>
    <tr>
        <td align="center" width="33%">CINEMA_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">mozi azonosító, melyben vetítik a filmet (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">ROOM</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">terem azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">NAME</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="center" width="33%">terem neve</td>
    </tr>
    <tr>
        <td align="center" width="33%">VIP</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">vip szoba-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">BED_ROOM</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">ágyas szoba-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">IMAX</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">ismeri-e az IMAX technológiát</td>
    </tr>
    <tr>
        <td align="center" width="33%">THREE_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">ismeri-e a három dimenziós technológiát</td>
    </tr>
    <tr>
        <td align="center" width="33%">FOUR_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">ismeri-e a négy dimenziós technológiát</td>
    </tr>
    <tr>
        <td align="center" width="33%">CINEMA_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">mozi azonosító, melyben megtalálható a terem (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">ROOM_STRUCTURE</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">szoba struktúra azonósítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">ROW</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="center" width="33%">sor száma</td>
    </tr>
    <tr>
        <td align="center" width="33%">SEAT_NUMBER</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="center" width="33%">sorban lévő ülése száma</td>
    </tr>
    <tr>
        <td align="center" width="33%">CINEMA_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">mozi azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">ROOM_NAME</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">terem azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">SCREENING</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">vetítés azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">TWO_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">két dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">THREE_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">három dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">FOUR_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">négy dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">IMAX</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">IMAX vetítés-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">LANGUAGE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="center" width="33%">nyelvezete</td>
    </tr>
    <tr>
        <td align="center" width="33%">INSCRIPTIVE</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">szinkronos vetítés-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">SYNCHRON</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">feliratos vetítés-e</td>
    </tr>
    <tr>
        <td align="center" width="33%">SCREEN_DAY</td>
        <td align="center" width="33%">DATE</td>
        <td align="center" width="33%">vetítési dátum</td>
    </tr>
    <tr>
        <td align="center" width="33%">SCREEN_TIME</td>
        <td align="center" width="33%">TIME</td>
        <td align="center" width="33%">vetítési időpont</td>
    </tr>
    <tr>
        <td align="center" width="33%">CINEMA_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">mozi azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">ROOM_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">terem azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">FILM_TITLE</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="center" width="33%">film cím, melyet vetítenek (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">TICKET</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">TYPE</td>
        <td align="center" width="33%">VARCHAR(30)</td>
        <td align="center" width="33%">jegy típusa (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">BASIC_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">alapár</td>
    </tr>
    <tr>
        <td align="center" width="33%">IMAX_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés IMAX esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">IMAX_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés IMAX + szemüveg esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">THREE_DIMENSIONAL_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés három dimenzió esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">THREE_DIMENSIONAL_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés három dimenzió + szemüveg esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">FOUR_DIMENSIONAL_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés négy dimenzió esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">FOUR_DIMENSIONAL_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés négy dimenzió + szemüveg esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">BED_ROOM_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés ágyas szoba esetén</td>
    </tr>
    <tr>
        <td align="center" width="33%">BED_ROOM_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="center" width="33%">ráfizetés ágyas szoba + szemüveg esetén</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">TICKET_INFORMATION</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">jegy információ azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">PAYMENT</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="center" width="33%">fizetési mód</td>
    </tr>
    <tr>
        <td align="center" width="33%">ROW</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="center" width="33%">sor</td>
    </tr>
    <tr>
        <td align="center" width="33%">CHAIR</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="center" width="33%">szék</td>
    </tr>
    <tr>
        <td align="center" width="33%">BOOKING_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="center" width="33%">foglalás azonosítója (FK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">TICKET_TYPE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="center" width="33%">jegy típusa (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">USER</th>
    <tr>
        <th align="center" width="33%">ATTRIBÚTUM</th>
        <th align="center" width="33%">TÍPUS</th>
        <th align="center" width="33%">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center" width="33%">USERNAME</td>
        <td align="center" width="33%">VARCHAR2(15)</td>
        <td align="center" width="33%">felhasználónév (PK)</td>
    </tr>
    <tr>
        <td align="center" width="33%">PASSWORD</td>
        <td align="center" width="33%">VARCHAR2(42)</td>
        <td align="center" width="33%">jelszó</td>
    </tr>
    <tr>
        <td align="center" width="33%">EMAIL</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="center" width="33%">email cím</td>
    </tr>
    <tr>
        <td align="center" width="33%">PHONE_NUMBER</td>
        <td align="center" width="33%">VARCHAR2(14)</td>
        <td align="center" width="33%">telefonszám</td>
    </tr>
    <tr>
        <td align="center" width="33%">ADMIN_RIGHT</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="center" width="33%">adminisztrátori jogosultság (FK)</td>
    </tr>
</table>

## Egyed-kapcsolat diagram:
![alt text][ER]

## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**