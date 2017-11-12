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
<table>
    <th>BOOKING</th>
    <tr>
        <td>ID</td>
        <td>SCREENING_ID</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>BIGINT</td>
    </tr>
    <tr>
        <td>foglalás azonosítója (PK)</td>
        <td>vetítés azonosítója (FK)</td>
    </tr>
</table>

<table>
    <th>CATEGORY</th>
    <tr>
        <td>CATEGORY</td>
    </tr>
    <tr>
        <td>VARCHAR2(20)</td>
    </tr>
    <tr>
        <td>kategória neve (PK)</td>
    </tr>
</table>

<table>
    <th>CATEGORY_INFORMATION</th>
    <tr>
        <td>ID</td>
        <td>FILM_TITLE</td>
        <td>CATEGORY</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>VARCHAR2(50)</td>
        <td>VARCHAR2(20)</td>
    </tr>
    <tr>
        <td>kategória információ azonosítója (PK)</td>
        <td>film neve (FK)</td>
        <td>kategória neve (FK)</td>
    </tr>
</table>

<table>
    <th>CINEMA</th>
    <tr>
        <td>ID</td>
        <td>COUNTRY</td>
        <td>CITY</td>
        <td>DISTRICT</td>
        <td>STREET</td>
        <td>HOUSE_NUMBER</td>
        <td>NAME</td>
        <td>AMENITIES_CHARGE</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>VARCHAR2(50)</td>
        <td>VARCHAR2(30)</td>
        <td>VARCHAR2(8)</td>
        <td>VARCHAR(50)</td>
        <td>TINYINT</td>
        <td>VARCHAR2(20)</td>
        <td>SMALLINT</td>
    </tr>
    <tr>
        <td>mozi azonosítója (PK)</td>
        <td>ország neve</td>
        <td>város neve</td>
        <td>kerület neve</td>
        <td>utca neve</td>
        <td>mozi neve</td>
        <td>házszám</td>
        <td>kényelmi díj értéke</td>
    </tr>
</table>

<table>
    <th>FILM</th>
    <tr>
        <td>TITLE</td>
        <td>LANGUAGE</td>
        <td>SYNCHRON</td>
        <td>INSCRIPTIVE</td>
        <td>IMAX</td>
        <td>THREE_DIMENSIONAL</td>
        <td>FOUR_DIMENSIONAL</td>
        <td>PLAY_TIME</td>
        <td>PREMIERE</td>
        <td>AGE_LIMIT</td>
        <td>DIRECTOR_FIRST_NAME</td>
        <td>DIRECTOR_LAST_NAME</td>
        <td>COUNTRY</td>
        <td>YEAR</td>
        <td>RATE</td>
        <td>DESCRIPTION</td>
        <td>CINEMA_ID</td>
    </tr>
    <tr>
        <td>VARCHAR2(50)</td>
        <td>VARCHAR2(30)</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>SMALLINT</td>
        <td>DATE</td>
        <td>TINYINT</td>
        <td>VARCHAR2(30)</td>
        <td>VARCHAR2(30)</td>
        <td>VARCHAR2(50)</td>
        <td>SMALLINT</td>
        <td>DECIMAL</td>
        <td>VARCHAR2(500)</td>
        <td>BIGINT</td>
    </tr>
    <tr>
        <td>film címe (PK)</td>
        <td>nyelvezete</td>
        <td>elérhető-e szinkronos verzió</td>
        <td>elérhető-e feliratos verzió</td>
        <td>elérhető-e IMAX verzió</td>
        <td>elérhető-e három dimenziós verzió</td>
        <td>elérhető-e négy dimenziós verzió</td>
        <td>játékideje</td>
        <td>premier dátuma</td>
        <td>korhatár</td>
        <td>rendező keresztneve</td>
        <td>rendező vezetékneve</td>
        <td>országa</td>
        <td>gyártási éve</td>
        <td>értékelése</td>
        <td>leírása</td>
        <td>mozi azonosító, melyben vetítik a filmet (FK)</td>
    </tr>
</table>

<table>
    <th>ROOM</th>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>VIP</td>
        <td>BED_ROOM</td>
        <td>IMAX</td>
        <td>THREE_DIMENSIONAL</td>
        <td>FOUR_DIMENSIONAL</td>
        <td>CINEMA_ID</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>VARCHAR2(20)</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN)</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BIGINT</td>
    </tr>
    <tr>
        <td>terem azonosítója (PK)</td>
        <td>terem neve</td>
        <td>vip szoba-e</td>
        <td>ágyas szoba-e</td>
        <td>ismeri-e az IMAX technológiát</td>
        <td>ismeri-e a három dimenziós technológiát</td>
        <td>ismeri-e a négy dimenziós technológiát</td>
        <td>mozi azonosító, melyben megtalálható a terem (FK)</td>
    </tr>
</table>

<table>
    <th>ROOM_STRUCTURE</th>
    <tr>
        <td>ID</td>
        <td>ROW</td>
        <td>SEAT_NUMBER</td>
        <td>CINEMA_ID</td>
        <td>ROOM_NAME</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>TINYINT</td>
        <td>TINYINT</td>
        <td>BIGINT</td>
        <td>BIGINT</td>
    </tr>
    <tr>
        <td>szoba struktúra azonósítója (PK)</td>
        <td>sor száma</td>
        <td>sorban lévő ülése száma</td>
        <td>mozi azonosító, melyben megtalálható a struktúra (FK)</td>
        <td>terem azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
</table>

<table>
    <th>SCREENING</th>
    <tr>
        <td>ID</td>
        <td>TWO_DIMENSIONAL</td>
        <td>THREE_DIMENSIONAL</td>
        <td>FOUR_DIMENSIONAL</td>
        <td>IMAX</td>
        <td>LANGUAGE</td>
        <td>INSCRIPTIVE</td>
        <td>SYNCHRON</td>
        <td>SCREEN_DAY</td>
        <td>SCREEN_TIME</td>
        <td>CINEMA_ID</td>
        <td>ROOM_ID</td>
        <td>FILM_TITLE</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>VARCHAR2(30)</td>
        <td>BOOLEAN</td>
        <td>BOOLEAN</td>
        <td>DATE</td>
        <td>TIME</td>
        <td>BIGINT</td>
        <td>BIGINT</td>
        <td>VARCHAR2(50)</td>
    </tr>
    <tr>
        <td>vetítés azonosítója (PK)</td>
        <td>két dimenziós vetítés-e</td>
        <td>három dimenziós vetítés-e</td>
        <td>négy dimenziós vetítés-e</td>
        <td>IMAX vetítés-e</td>
        <td>nyelvezete</td>
        <td>szinkronos vetítés-e</td>
        <td>feliratos vetítés-e</td>
        <td>vetítési dátum</td>
        <td>vetítési időpont</td>
        <td>mozi azonosító, melyben aktuális a vetítés (FK)</td>
        <td>terem azonosító, melyben aktuális a vetítés (FK)</td>
        <td>film cím, melyet vetítenek (FK)</td>
    </tr>
</table>

<table>
    <th>TICKET</th>
    <tr>
        <td>TYPE</td>
        <td>BASIC_PRICE</td>
        <td>IMAX_PRICE</td>
        <td>IMAX_GLASS_PRICE</td>
        <td>THREE_DIMENSIONAL_PRICE</td>
        <td>THREE_DIMENSIONAL_GLASS_PRICE</td>
        <td>FOUR_DIMENSIONAL_PRICE</td>
        <td>FOUR_DIMENSIONAL_GLASS_PRICE</td>
        <td>BED_ROOM_PRICE</td>
        <td>BED_ROOM_GLASS_PRICE</td>
    </tr>
    <tr>
        <td>VARCHAR(30)</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
        <td>SMALLINT</td>
    </tr>
    <tr>
        <td>jegy típusa (PK)</td>
        <td>alapár</td>
        <td>ráfizetés IMAX esetén</td>
        <td>ráfizetés IMAX + szemüveg esetén</td>
        <td>ráfizetés három dimenzió esetén</td>
        <td>ráfizetés három dimenzió + szemüveg esetén</td>
        <td>ráfizetés négy dimenzió esetén</td>
        <td>ráfizetés négy dimenzió + szemüveg esetén</td>
        <td>ráfizetés ágyas szoba esetén</td>
        <td>ráfizetés ágyas szoba + szemüveg esetén</td>
    </tr>
</table>

<table>
    <th>TICKET_INFORMATION</th>
    <tr>
        <td>ID</td>
        <td>PAYMENT</td>
        <td>ROW</td>
        <td>CHAIR</td>
        <td>BOOKING_ID</td>
        <td>TICKET_TYPE</td>
    </tr>
    <tr>
        <td>BIGINT</td>
        <td>VARCHAR2(20)</td>
        <td>TINYINT</td>
        <td>TINYINT</td>
        <td>BIGINT</td>
        <td>VARCHAR2(30)</td>
    </tr>
    <tr>
        <td>jegy információ azonosítója (PK)</td>
        <td>fizetési mód</td>
        <td>sor</td>
        <td>szék</td>
        <td>foglalás azonosítója (FK)</td>
        <td>jegy típusa (FK)</td>
    </tr>
</table>

<table>
    <th>USER</th>
    <tr>
        <td>USERNAME</td>
        <td>PASSWORD</td>
        <td>EMAIL</td>
        <td>PHONE_NUMBER</td>
        <td>ADMIN_RIGHT</td>
    </tr>
    <tr>
        <td>VARCHAR2(15)</td>
        <td>VARCHAR2(42)</td>
        <td>VARCHAR2(50)</td>
        <td>VARCHAR2(14)</td>
        <td>BOOLEAN</td>
    </tr>
    <tr>
        <td>felhasználónév (PK)</td>
        <td>jelszó</td>
        <td>email cím</td>
        <td>telefonszám</td>
        <td>adminisztrátori jogosultság (FK)</td>
    </tr>
</table>

## Egyed-kapcsolat diagram:
![alt text][ER]

## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**