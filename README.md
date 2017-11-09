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
    1. Adatbázis séma leírása
    2. UML diagramok
```

## Adatbázis séma
| CATEGORY                                                            |
|---------------------|---------------------|-------------------------|
|          ID         |          INT        | A kategória azonosítója |
|       CATEGORY      |      VARCHAR(15)    | A kategória neve        |

|                               FILM                              |
|---------------------|---------------------|---------------------|
|          ID         |          INT        | A film azonosítója  |
|       CATEGORY_ID   |          INT        | A film kategória azonosítója        |
|        TITLE       |      VARCHAR(50)        | A film címe |
|        THREED       |      BOOLEAN        | A film háromdimenzióban is elérhető-e |
|        PLAYTIME       |      INT        | A film játékideje |
|        PREMIERE        |      DATE        | A film premier dátuma |
|        AGELIMIT        |      INT        | A film korhatára |
|        DIRECTORFIRSTNAME       |      VARCHAR(20)        | A rendező vezetékneve |
|        DIRECTORLASTNAME        |      VARCHAR(20)        | A rendező keresztneve |
|        COUNTRY        |      VARCHAR(30)        | Származási ország |
|        YEAR        |      INT        | A film címe |
|        DESCRIPTION        |      VARCHAR(500)        | A film leírása |

|                             FILM_CATEGORY                            |
|---------------------|---------------------|---------------------|
|          FILM_ID         |          INT        | A film azonosítója |
|       CATEGORY_ID      |      INT   | A kategória azonosítója        |

|                             RESERVATION                            |
|---------------------|---------------------|---------------------|
|          ID         |          INT        | A film azonosítója |
|       USER_ID      |      INT   | A kategória azonosítója        |
|       SCREEN_ID      |      INT   | A kategória azonosítója        |
|       NUMBEROFRESERVATIONS      |      INT   | A kategória azonosítója  |

|User                                                                  |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |felhasználó id-ja         |
|USERNAME             |VARCHAR(15)          |felhasználó neve          |
|PASSWORD             |VARCHAR(42)          |felhasználó jelszava      |
|EMAIL                |VARCHAR(50)          |felhasználó email-e       |
|PHONENUMBER          |VARCHAR(11)          |felhazsnáló telefonszama  |
|ADMINRIGHT           |BOOLEAN              |rendelkezik-e admin joggal|


|Screening                                                             |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |vetítés id-ja             |
|ROOM_ID              |INT                  |vetítés terem id-ja       |
|FILM_ID              |INT                  |vetítés film id-ja        |
|SCREENDAY            |DATE                 |vetítés napja             |
|SCREENTIME           |TIME                 |vetítés ideje hh:mm       |

|Room                                                                  |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |terem id-ja               |
|SEATNUMBER           |INT                  |terem üléseinek száma     |
|IMAX                 |BOOLEAN              |terem IMAX-es terem-e     |
|FOURD                |BOOLEAN              |terem 4D-s terem-e        |


## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**