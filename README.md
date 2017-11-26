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

[ER]: ./resources/img/Entity_Relationship_diagram.png "Egyed-kapcsolat diagram"
[MVC_architecture]: ./resources/img/MVC_architecture.png "MVC architektúra"

# Alkalmazások fejlesztése - Cinema World

A projekt egy mozi frontend és backend rendszerének megvalósításáról szól, mely [MVC] (Model-View-Controller) architektúrában épül fel:

![alt text][MVC_architecture]

## Célközönség:
Bármely személy, akinek a moziba járás nem csak a filmnézésről szól, hanem az élményekről, a kényelemről és a prémium minőségű finomságokról.

## Szerepkörök:
+ **Vendég**: Filmek adatlapját, illetve előzeteseit tudja megtekinteni.
+ **Felhasználó**: Tud foglalni, jegyet venni, filmet értékelni.
+ **Adminisztrátor**: Új filmeket tud felvenni az adatbázisba, illetve tud törölni is onnan (ha például egy filmet már nem vetítenek).

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
    1. Lombok @Data bug (?)
    2. @Pattern validation for the first insertion
```

## Adatbázis séma:

<table align="center" width="100%">
    <th colspan="3" width="100%">CINEMA</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">mozi azonosítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">COUNTRY</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">ország neve</td>
    </tr>
        <td align="center" width="33%">CITY</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">város neve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">DISTRICT</td>
        <td align="center" width="33%">VARCHAR2(8)</td>
        <td align="justify" width="33%">kerület neve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">STREET</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">utca neve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">HOUSE_NUMBER</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="justify" width="33%">házszám</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">NAME</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="justify" width="33%">mozi neve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">AMENITIES_CHARGE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">kényelmi díj értéke</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">BOOKING</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">foglalás azonosítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">SCREENING_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">vetítés azonosítója (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">CATEGORY</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CATEGORY</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="justify" width="33%">kategória neve (PK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">FILM_CATEGORY</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">kategória információ azonosítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FILM_TITLE</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">film neve (FK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CATEGORY</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="justify" width="33%">kategória neve (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">FILM</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">TITLE</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">film címe (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">LANGUAGE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">nyelvezet</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">SYNCHRON</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">elérhető-e szinkronos verzió</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">INSCRIPTIVE</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">elérhető-e feliratos verzió</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">IMAX</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">elérhető-e IMAX verzió</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">THREE_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">elérhető-e három dimenziós verzió</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FOUR_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">elérhető-e négy dimenziós verzió</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">PLAY_TIME</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">játékidő</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">PREMIERE</td>
        <td align="center" width="33%">DATE</td>
        <td align="justify" width="33%">premier dátuma</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">AGE_LIMIT</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="justify" width="33%">korhatár</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">DIRECTOR_FIRST_NAME</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">rendező keresztneve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">DIRECTOR_LAST_NAME</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">rendező vezetékneve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">COUNTRY</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">ország</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">YEAR</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">gyártási év</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">RATE</td>
        <td align="center" width="33%">DECIMAL</td>
        <td align="justify" width="33%">értékelés</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">DESCRIPTION</td>
        <td align="center" width="33%">VARCHAR2(500)</td>
        <td align="justify" width="33%">leírás</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CINEMA_NAME</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">mozi neve, melyben vetítik a filmet (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">ROOM</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">terem azonosítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">NAME</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="justify" width="33%">terem neve</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">VIP</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">vip szoba-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">BED_ROOM</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">ágyas szoba-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">IMAX</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">ismeri-e az IMAX technológiát</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">THREE_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">ismeri-e a három dimenziós technológiát</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FOUR_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">ismeri-e a négy dimenziós technológiát</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CINEMA_NAME</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">mozi neve, melyben megtalálható a terem (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">ROOM_STRUCTURE</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">terem struktúra azonósítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ROW</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="justify" width="33%">sor száma</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">SEAT_NUMBER</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="justify" width="33%">sorban lévő ülése száma</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CINEMA_NAME</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">mozi neve, melyben megtalálható a struktúra (FK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ROOM_NAME</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">terem azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">SCREENING</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">vetítés azonosítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">TWO_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">két dimenziós vetítés-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">THREE_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">három dimenziós vetítés-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FOUR_DIMENSIONAL</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">négy dimenziós vetítés-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">IMAX</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">IMAX vetítés-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">LANGUAGE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">nyelvezet</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">INSCRIPTIVE</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">szinkronos vetítés-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">SYNCHRON</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">feliratos vetítés-e</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">SCREEN_DAY</td>
        <td align="center" width="33%">DATE</td>
        <td align="justify" width="33%">vetítési dátum</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">SCREEN_TIME</td>
        <td align="center" width="33%">TIME</td>
        <td align="justify" width="33%">vetítési időpont</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CINEMA_NAME</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">mozi neve, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ROOM_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">terem azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FILM_TITLE</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">film cím, melyet vetítenek (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">TICKET</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">TYPE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">jegy típusa (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">BASIC_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">alapár</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">IMAX_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés IMAX esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">IMAX_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés IMAX + szemüveg esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">THREE_DIMENSIONAL_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés három dimenzió esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">THREE_DIMENSIONAL_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés három dimenzió + szemüveg esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FOUR_DIMENSIONAL_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés négy dimenzió esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">FOUR_DIMENSIONAL_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés négy dimenzió + szemüveg esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">BED_ROOM_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés ágyas szoba esetén</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">BED_ROOM_GLASS_PRICE</td>
        <td align="center" width="33%">SMALLINT</td>
        <td align="justify" width="33%">ráfizetés ágyas szoba + szemüveg esetén</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">BOOKING_TICKET</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">jegy információ azonosítója (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">PAYMENT</td>
        <td align="center" width="33%">VARCHAR2(20)</td>
        <td align="justify" width="33%">fizetési mód</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ROW</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="justify" width="33%">sor</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">CHAIR</td>
        <td align="center" width="33%">TINYINT</td>
        <td align="justify" width="33%">szék</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">BOOKING_ID</td>
        <td align="center" width="33%">BIGINT</td>
        <td align="justify" width="33%">foglalás azonosítója (FK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">TICKET_TYPE</td>
        <td align="center" width="33%">VARCHAR2(30)</td>
        <td align="justify" width="33%">jegy típusa (FK)</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">USER</th>
    <tr align="center" width="100%">
        <th width="33%">ATTRIBÚTUM</th>
        <th width="33%">TÍPUS</th>
        <th width="33%">LEÍRÁS</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">USERNAME</td>
        <td align="center" width="33%">VARCHAR2(15)</td>
        <td align="justify" width="33%">felhasználónév (PK)</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">PASSWORD</td>
        <td align="center" width="33%">VARCHAR2(42)</td>
        <td align="justify" width="33%">jelszó</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">EMAIL</td>
        <td align="center" width="33%">VARCHAR2(50)</td>
        <td align="justify" width="33%">email cím</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">PHONE_NUMBER</td>
        <td align="center" width="33%">VARCHAR2(14)</td>
        <td align="justify" width="33%">telefonszám</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%">ADMIN_RIGHT</td>
        <td align="center" width="33%">BOOLEAN</td>
        <td align="justify" width="33%">adminisztrátori jogosultság</td>
    </tr>
</table>

## Egyed-kapcsolat diagram:
![alt text][ER]

## Használat (Backend):
1. CMD: **mvnw spring-boot:run** parancs futtatása a ***./cinema_world/cinema_inner_world*** útvonal alatt
2. Az alkalmazás gyökere a **localhost:8080** socketen érhető el böngészőből
3. Adatbázis elérése és létrehozása: **localhost:8080/h2** címen a következő konfigurálással <br />
-> ***JDBC URL***: **jdbc:h2:mem:testdb** (minden más maradhat alapméretezetten)

## Használat (Frontend):
1. CMD: **ng serve** parancs futtatása a ***./cinema_world/cinema_outer_world*** útvonal alatt
2. Az alkalmazás gyökere a **localhost:4200** socketen érhető el böngészőből

## Az alkalmazás végpontjai:
<table align="center" width="100%">
    <th colspan="3" width="100%">USER</th>
    <tr align="center" width="100%">
        <th width="33%">ÚTVONAL</th>
        <th width="33%">LEÍRÁS</th>
        <th width="33%">BEVITEL</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%"><b>localhost:8080/user/register</b></td>
        <td align="center" width="33%">új felhasználó regisztrálása az adatbázisba</td>
        <td align="center" width="33%">egyedi felhasználónév, jelszó, egyedi email cím, telefonszám</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%"><b>localhost:8080/user/login</b></td>
        <td align="center" width="33%">bejelentkezés</td>
        <td align="center" width="33%">felhasználónév vagy email cím, jelszó</td>
    </tr>
</table>

<table align="center" width="100%">
    <th colspan="3" width="100%">WORLD</th>
    <tr align="center" width="100%">
        <th width="33%">ÚTVONAL</th>
        <th width="33%">LEÍRÁS</th>
        <th width="33%">BEVITEL</th>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%"><b>localhost:8080/world/cinemas</b></td>
        <td align="center" width="33%">az összes mozi kilistázása</td>
        <td align="center" width="33%">nincs</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%"><b>localhost:8080/world/films</b></td>
        <td align="center" width="33%">az összes film kilistázása</td>
        <td align="center" width="33%">nincs</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%"><b>localhost:8080/world/rooms</b></td>
        <td align="center" width="33%">az összes terem kilistázása</td>
        <td align="center" width="33%">nincs</td>
    </tr>
    <tr align="center" width="100%">
        <td align="center" width="33%"><b>localhost:8080/world/screenings</b></td>
        <td align="center" width="33%">az összes vetítés kilistázása</td>
        <td align="center" width="33%">nincs</td>
    </tr>
</table>

## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**