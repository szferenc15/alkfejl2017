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
    <th colspan="3">BOOKING</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>foglalás azonosítója (PK)</td>
    </tr>
    <tr>
        <td>SCREENING_ID</td>
        <td>BIGINT</td>
        <td>vetítés azonosítója (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">CATEGORY</th>
    <tr>
        <td>CATEGORY</td>
        <td>VARCHAR2(20)</td>
        <td>kategória neve (PK)</td>
    </tr>
</table>

<table>
    <th colspan="3">CATEGORY_INFORMATION</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>kategória információ azonosítója (PK)</td>
    </tr>
    <tr>
        <td>FILM_TITLE</td>
        <td>VARCHAR2(50)</td>
        <td>film neve (FK)</td>
    </tr>
    <tr>
        <td>CATEGORY</td>
        <td>VARCHAR2(20)</td>
        <td>kategória neve (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">CINEMA</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>mozi azonosítója (PK)</td>
    </tr>
    <tr>
        <td>COUNTRY</td>
        <td>VARCHAR2(50)</td>
        <td>ország neve</td>
    </tr>
        <td>CITY</td>
        <td>VARCHAR2(30)</td>
        <td>város neve</td>
    </tr>
    <tr>
        <td>DISTRICT</td>
        <td>VARCHAR2(8)</td>
        <td>kerület neve</td>
    </tr>
    <tr>
        <td>STREET</td>
        <td>VARCHAR(50)</td>
        <td>utca neve</td>
    </tr>
    <tr>
        <td>HOUSE_NUMBER</td>
        <td>TINYINT</td>
        <td>házszám</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>VARCHAR2(20)</td>
        <td>mozi neve</td>
    </tr>
    <tr>
        <td>AMENITIES_CHARGE</td>
        <td>SMALLINT</td>
        <td>kényelmi díj értéke</td>
    </tr>
</table>

<table>
    <th colspan="3">FILM</th>
    <tr>
        <td>TITLE</td>
        <td>VARCHAR2(50)</td>
        <td>film címe (PK)</td>
    </tr>
    <tr>
        <td>LANGUAGE</td>
        <td>VARCHAR2(30)</td>
        <td>nyelvezete</td>
    </tr>
    <tr>
        <td>SYNCHRON</td>
        <td>BOOLEAN</td>
        <td>elérhető-e szinkronos verzió</td>
    </tr>
    <tr>
        <td>INSCRIPTIVE</td>
        <td>BOOLEAN</td>
        <td>elérhető-e feliratos verzió</td>
    </tr>
    <tr>
        <td>IMAX</td>
        <td>BOOLEAN</td>
        <td>elérhető-e IMAX verzió</td>
    </tr>
    <tr>
        <td>THREE_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>elérhető-e három dimenziós verzió</td>
    </tr>
    <tr>
        <td>FOUR_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>elérhető-e négy dimenziós verzió</td>
    </tr>
    <tr>
        <td>PLAY_TIME</td>
        <td>SMALLINT</td>
        <td>játékideje</td>
    </tr>
    <tr>
        <td>PREMIERE</td>
        <td>DATE</td>
        <td>premier dátuma</td>
    </tr>
    <tr>
        <td>AGE_LIMIT</td>
        <td>TINYINT</td>
        <td>korhatár</td>
    </tr>
    <tr>
        <td>DIRECTOR_FIRST_NAME</td>
        <td>VARCHAR2(30)</td>
        <td>rendező keresztneve</td>
    </tr>
    <tr>
        <td>DIRECTOR_LAST_NAME</td>
        <td>VARCHAR2(30)</td>
        <td>rendező vezetékneve</td>
    </tr>
    <tr>
        <td>COUNTRY</td>
        <td>VARCHAR2(50)</td>
        <td>országa</td>
    </tr>
    <tr>
        <td>YEAR</td>
        <td>SMALLINT</td>
        <td>gyártási éve</td>
    </tr>
    <tr>
        <td>RATE</td>
        <td>DECIMAL</td>
        <td>értékelése</td>
    </tr>
    <tr>
        <td>DESCRIPTION</td>
        <td>VARCHAR2(500)</td>
        <td>leírása</td>
    </tr>
    <tr>
        <td>CINEMA_ID</td>
        <td>BIGINT</td>
        <td>mozi azonosító, melyben vetítik a filmet (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">ROOM</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>terem azonosítója (PK)</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>VARCHAR2(20)</td>
        <td>terem neve</td>
    </tr>
    <tr>
        <td>VIP</td>
        <td>BOOLEAN</td>
        <td>vip szoba-e</td>
    </tr>
    <tr>
        <td>BED_ROOM</td>
        <td>BOOLEAN</td>
        <td>ágyas szoba-e</td>
    </tr>
    <tr>
        <td>IMAX</td>
        <td>BOOLEAN</td>
        <td>ismeri-e az IMAX technológiát</td>
    </tr>
    <tr>
        <td>THREE_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>ismeri-e a három dimenziós technológiát</td>
    </tr>
    <tr>
        <td>FOUR_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>ismeri-e a négy dimenziós technológiát</td>
    </tr>
    <tr>
        <td>CINEMA_ID</td>
        <td>BIGINT</td>
        <td>mozi azonosító, melyben megtalálható a terem (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">ROOM_STRUCTURE</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>szoba struktúra azonósítója (PK)</td>
    </tr>
    <tr>
        <td>ROW</td>
        <td>TINYINT</td>
        <td>sor száma</td>
    </tr>
    <tr>
        <td>SEAT_NUMBER</td>
        <td>TINYINT</td>
        <td>sorban lévő ülése száma</td>
    </tr>
    <tr>
        <td>CINEMA_ID</td>
        <td>BIGINT</td>
        <td>mozi azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
    <tr>
        <td>ROOM_NAME</td>
        <td>BIGINT</td>
        <td>terem azonosító, melyben megtalálható a struktúra (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">SCREENING</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>vetítés azonosítója (PK)</td>
    </tr>
    <tr>
        <td>TWO_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>két dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td>THREE_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>három dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td>FOUR_DIMENSIONAL</td>
        <td>BOOLEAN</td>
        <td>négy dimenziós vetítés-e</td>
    </tr>
    <tr>
        <td>IMAX</td>
        <td>BOOLEAN</td>
        <td>IMAX vetítés-e</td>
    </tr>
    <tr>
        <td>LANGUAGE</td>
        <td>VARCHAR2(30)</td>
        <td>nyelvezete</td>
    </tr>
    <tr>
        <td>INSCRIPTIVE</td>
        <td>BOOLEAN</td>
        <td>szinkronos vetítés-e</td>
    </tr>
    <tr>
        <td>SYNCHRON</td>
        <td>BOOLEAN</td>
        <td>feliratos vetítés-e</td>
    </tr>
    <tr>
        <td>SCREEN_DAY</td>
        <td>DATE</td>
        <td>vetítési dátum</td>
    </tr>
    <tr>
        <td>SCREEN_TIME</td>
        <td>TIME</td>
        <td>vetítési időpont</td>
    </tr>
    <tr>
        <td>CINEMA_ID</td>
        <td>BIGINT</td>
        <td>mozi azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr>
        <td>ROOM_ID</td>
        <td>BIGINT</td>
        <td>terem azonosító, melyben aktuális a vetítés (FK)</td>
    </tr>
    <tr>
        <td>FILM_TITLE</td>
        <td>VARCHAR2(50)</td>
        <td>film cím, melyet vetítenek (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">TICKET</th>
    <tr>
        <td>TYPE</td>
        <td>VARCHAR(30)</td>
        <td>jegy típusa (PK)</td>
    </tr>
    <tr>
        <td>BASIC_PRICE</td>
        <td>SMALLINT</td>
        <td>alapár</td>
    </tr>
    <tr>
        <td>IMAX_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés IMAX esetén</td>
    </tr>
    <tr>
        <td>IMAX_GLASS_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés IMAX + szemüveg esetén</td>
    </tr>
    <tr>
        <td>THREE_DIMENSIONAL_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés három dimenzió esetén</td>
    </tr>
    <tr>
        <td>THREE_DIMENSIONAL_GLASS_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés három dimenzió + szemüveg esetén</td>
    </tr>
    <tr>
        <td>FOUR_DIMENSIONAL_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés négy dimenzió esetén</td>
    </tr>
    <tr>
        <td>FOUR_DIMENSIONAL_GLASS_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés négy dimenzió + szemüveg esetén</td>
    </tr>
    <tr>
        <td>BED_ROOM_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés ágyas szoba esetén</td>
    </tr>
    <tr>
        <td>BED_ROOM_GLASS_PRICE</td>
        <td>SMALLINT</td>
        <td>ráfizetés ágyas szoba + szemüveg esetén</td>
    </tr>
</table>

<table>
    <th colspan="3">TICKET_INFORMATION</th>
    <tr>
        <td>ID</td>
        <td>BIGINT</td>
        <td>jegy információ azonosítója (PK)</td>
    </tr>
    <tr>
        <td>PAYMENT</td>
        <td>VARCHAR2(20)</td>
        <td>fizetési mód</td>
    </tr>
    <tr>
        <td>ROW</td>
        <td>TINYINT</td>
        <td>sor</td>
    </tr>
    <tr>
        <td>CHAIR</td>
        <td>TINYINT</td>
        <td>szék</td>
    </tr>
    <tr>
        <td>BOOKING_ID</td>
        <td>BIGINT</td>
        <td>foglalás azonosítója (FK)</td>
    </tr>
    <tr>
        <td>TICKET_TYPE</td>
        <td>VARCHAR2(30)</td>
        <td>jegy típusa (FK)</td>
    </tr>
</table>

<table>
    <th colspan="3">USER</th>
    <tr>
        <td>USERNAME</td>
        <td>VARCHAR2(15)</td>
        <td>felhasználónév (PK)</td>
    </tr>
    <tr>
        <td>PASSWORD</td>
        <td>VARCHAR2(42)</td>
        <td>jelszó</td>
    </tr>
    <tr>
        <td>EMAIL</td>
        <td>VARCHAR2(50)</td>
        <td>email cím</td>
    </tr>
    <tr>
        <td>PHONE_NUMBER</td>
        <td>VARCHAR2(14)</td>
        <td>telefonszám</td>
    </tr>
    <tr>
        <td>ADMIN_RIGHT</td>
        <td>BOOLEAN</td>
        <td>adminisztrátori jogosultság (FK)</td>
    </tr>
</table>

## Egyed-kapcsolat diagram:
![alt text][ER]

## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**