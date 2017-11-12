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
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">foglalás azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center">SCREENING_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">vetítés azonosítója (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">CATEGORY</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">CATEGORY</td>
        <td align="center">VARCHAR2(20)</td>
        <td align="center">kategória neve (PK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">CATEGORY_INFORMATION</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">kategória információ azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center">FILM_TITLE</td>
        <td align="center">VARCHAR2(50)</td>
        <td align="center">film neve (FK)</td>
    </tr>
    <tr>
        <td align="center">CATEGORY</td>
        <td align="center">VARCHAR2(20)</td>
        <td align="center">kategória neve (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">CINEMA</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">mozi azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center">COUNTRY</td>
        <td align="center">VARCHAR2(50)</td>
        <td align="center">ország neve</td>
    </tr>
        <td align="center">CITY</td>
        <td align="center">VARCHAR2(30)</td>
        <td align="center">város neve</td>
    </tr>
    <tr>
        <td align="center">DISTRICT</td>
        <td align="center">VARCHAR2(8)</td>
        <td align="center">kerület neve</td>
    </tr>
    <tr>
        <td align="center">STREET</td>
        <td align="center">VARCHAR(50)</td>
        <td align="center">utca neve</td>
    </tr>
    <tr>
        <td align="center">HOUSE_NUMBER</td>
        <td align="center">TINYINT</td>
        <td align="center">házszám</td>
    </tr>
    <tr>
        <td align="center">NAME</td>
        <td align="center">VARCHAR2(20)</td>
        <td align="center">mozi neve</td>
    </tr>
    <tr>
        <td align="center">AMENITIES_CHARGE</td>
        <td align="center">SMALLINT</td>
        <td align="center">kényelmi díj értéke</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">FILM</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">TITLE</td>
        <td align="center">VARCHAR2(50)</td>
        <td align="center">film címe (PK)</td>
    </tr>
    <tr>
        <td align="center">LANGUAGE</td>
        <td align="center">VARCHAR2(30)</td>
        <td align="center">nyelvezete</td>
    </tr>
    <tr>
        <td align="center">SYNCHRON</td>
        <td align="center">BOOLEAN</td>
        <td align="center">elérhető-e szinkronos verzió</td>
    </tr>
    <tr>
        <td align="center">INSCRIPTIVE</td>
        <td align="center">BOOLEAN</td>
        <td align="center">elérhető-e feliratos verzió</td>
    </tr>
    <tr>
        <td align="center">IMAX</td>
        <td align="center">BOOLEAN</td>
        <td align="center">elérhető-e IMAX verzió</td>
    </tr>
    <tr>
        <td align="center">THREE_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">elérhető-e három dimenziós verzió</td>
    </tr>
    <tr>
        <td align="center">FOUR_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">elérhető-e négy dimenziós verzió</td>
    </tr>
    <tr>
        <td align="center">PLAY_TIME</td>
        <td align="center">SMALLINT</td>
        <td align="center">játékideje</td>
    </tr>
    <tr>
        <td align="center">PREMIERE</td>
        <td align="center">DATE</td>
        <td align="center">premier dátuma</td>
    </tr>
    <tr>
        <td align="center">AGE_LIMIT</td>
        <td align="center">TINYINT</td>
        <td align="center">korhatár</td>
    </tr>
    <tr>
        <td align="center">DIRECTOR_FIRST_NAME</td>
        <td align="center">VARCHAR2(30)</td>
        <td align="center">rendező keresztneve</td>
    </tr>
    <tr>
        <td align="center">DIRECTOR_LAST_NAME</td>
        <td align="center">VARCHAR2(30)</td>
        <td align="center">rendező vezetékneve</td>
    </tr>
    <tr>
        <td align="center">COUNTRY</td>
        <td align="center">VARCHAR2(50)</td>
        <td align="center">országa</td>
    </tr>
    <tr>
        <td align="center">YEAR</td>
        <td align="center">SMALLINT</td>
        <td align="center">gyártási éve</td>
    </tr>
    <tr>
        <td align="center">RATE</td>
        <td align="center">DECIMAL</td>
        <td align="center">értékelése</td>
    </tr>
    <tr>
        <td align="center">DESCRIPTION</td>
        <td align="center">VARCHAR2(500)</td>
        <td align="center">leírása</td>
    </tr>
    <tr>
        <td align="center">CINEMA_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">mozi azonosító, melyben vetítik a filmet (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">ROOM</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">terem azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center">NAME</td>
        <td align="center">VARCHAR2(20)</td>
        <td align="center">terem neve</td>
    </tr>
    <tr>
        <td align="center">VIP</td>
        <td align="center">BOOLEAN</td>
        <td align="center">vip szoba-e</td>
    </tr>
    <tr>
        <td align="center">BED_ROOM</td>
        <td align="center">BOOLEAN</td>
        <td align="center">ágyas szoba-e</td>
    </tr>
    <tr>
        <td align="center">IMAX</td>
        <td align="center">BOOLEAN</td>
        <td align="center">ismeri-e az IMAX technológiát</td>
    </tr>
    <tr>
        <td align="center">THREE_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">ismeri-e a három dimenziós technológiát</td>
    </tr>
    <tr>
        <td align="center">FOUR_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">ismeri-e a négy dimenziós technológiát</td>
    </tr>
    <tr>
        <td align="center">CINEMA_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">mozi azonosító, melyben megtalálható a terem (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">ROOM_STRUCTURE</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">szoba struktúra azonósítója (PK)</td>
    </tr>
    <tr>
        <td align="center">ROW</td>
        <td align="center">TINYINT</td>
        <td align="center">sor száma</td>
    </tr>
    <tr>
        <td align="center">SEAT_NUMBER</td>
        <td align="center">TINYINT</td>
        <td align="center">sorban lévő ülése száma</td>
    </tr>
    <tr>
        <td align="center">CINEMA_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">mozi azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
    <tr>
        <td align="center">ROOM_NAME</td>
        <td align="center">BIGINT</td>
        <td align="center">terem azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">SCREENING</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">vetítés azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center">TWO_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">két dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td align="center">THREE_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">három dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td align="center">FOUR_DIMENSIONAL</td>
        <td align="center">BOOLEAN</td>
        <td align="center">négy dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td align="center">IMAX</td>
        <td align="center">BOOLEAN</td>
        <td align="center">IMAX vetítés-e</td>
    </tr>
    <tr>
        <td align="center">LANGUAGE</td>
        <td align="center">VARCHAR2(30)</td>
        <td align="center">nyelvezete</td>
    </tr>
    <tr>
        <td align="center">INSCRIPTIVE</td>
        <td align="center">BOOLEAN</td>
        <td align="center">szinkronos vetítés-e</td>
    </tr>
    <tr>
        <td align="center">SYNCHRON</td>
        <td align="center">BOOLEAN</td>
        <td align="center">feliratos vetítés-e</td>
    </tr>
    <tr>
        <td align="center">SCREEN_DAY</td>
        <td align="center">DATE</td>
        <td align="center">vetítési dátum</td>
    </tr>
    <tr>
        <td align="center">SCREEN_TIME</td>
        <td align="center">TIME</td>
        <td align="center">vetítési időpont</td>
    </tr>
    <tr>
        <td align="center">CINEMA_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">mozi azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr>
        <td align="center">ROOM_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">terem azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr>
        <td align="center">FILM_TITLE</td>
        <td align="center">VARCHAR2(50)</td>
        <td align="center">film cím, melyet vetítenek (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">TICKET</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">TYPE</td>
        <td align="center">VARCHAR(30)</td>
        <td align="center">jegy típusa (PK)</td>
    </tr>
    <tr>
        <td align="center">BASIC_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">alapár</td>
    </tr>
    <tr>
        <td align="center">IMAX_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés IMAX esetén</td>
    </tr>
    <tr>
        <td align="center">IMAX_GLASS_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés IMAX + szemüveg esetén</td>
    </tr>
    <tr>
        <td align="center">THREE_DIMENSIONAL_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés három dimenzió esetén</td>
    </tr>
    <tr>
        <td align="center">THREE_DIMENSIONAL_GLASS_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés három dimenzió + szemüveg esetén</td>
    </tr>
    <tr>
        <td align="center">FOUR_DIMENSIONAL_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés négy dimenzió esetén</td>
    </tr>
    <tr>
        <td align="center">FOUR_DIMENSIONAL_GLASS_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés négy dimenzió + szemüveg esetén</td>
    </tr>
    <tr>
        <td align="center">BED_ROOM_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés ágyas szoba esetén</td>
    </tr>
    <tr>
        <td align="center">BED_ROOM_GLASS_PRICE</td>
        <td align="center">SMALLINT</td>
        <td align="center">ráfizetés ágyas szoba + szemüveg esetén</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">TICKET_INFORMATION</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">ID</td>
        <td align="center">BIGINT</td>
        <td align="center">jegy információ azonosítója (PK)</td>
    </tr>
    <tr>
        <td align="center">PAYMENT</td>
        <td align="center">VARCHAR2(20)</td>
        <td align="center">fizetési mód</td>
    </tr>
    <tr>
        <td align="center">ROW</td>
        <td align="center">TINYINT</td>
        <td align="center">sor</td>
    </tr>
    <tr>
        <td align="center">CHAIR</td>
        <td align="center">TINYINT</td>
        <td align="center">szék</td>
    </tr>
    <tr>
        <td align="center">BOOKING_ID</td>
        <td align="center">BIGINT</td>
        <td align="center">foglalás azonosítója (FK)</td>
    </tr>
    <tr>
        <td align="center">TICKET_TYPE</td>
        <td align="center">VARCHAR2(30)</td>
        <td align="center">jegy típusa (FK)</td>
    </tr>
</table>

<table align="center">
    <th colspan="3">USER</th>
    <tr>
        <th align="center">ATTRIBÚTUM</th>
        <th align="center">TÍPUS</th>
        <th align="center">LEÍRÁS</th>
    </tr>
    <tr>
        <td align="center">USERNAME</td>
        <td align="center">VARCHAR2(15)</td>
        <td align="center">felhasználónév (PK)</td>
    </tr>
    <tr>
        <td align="center">PASSWORD</td>
        <td align="center">VARCHAR2(42)</td>
        <td align="center">jelszó</td>
    </tr>
    <tr>
        <td align="center">EMAIL</td>
        <td align="center">VARCHAR2(50)</td>
        <td align="center">email cím</td>
    </tr>
    <tr>
        <td align="center">PHONE_NUMBER</td>
        <td align="center">VARCHAR2(14)</td>
        <td align="center">telefonszám</td>
    </tr>
    <tr>
        <td align="center">ADMIN_RIGHT</td>
        <td align="center">BOOLEAN</td>
        <td align="center">adminisztrátori jogosultság (FK)</td>
    </tr>
</table>

## Egyed-kapcsolat diagram:
![alt text][ER]

## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**