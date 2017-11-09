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
TODO: -
```

## Adatbázis séma
|CATEGORY             |                     |                          |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |kategória azonosítója     |
|CATEGORY             |VARCHAR(15)          |kategória neve            |

|FILM                 |                     |                          |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |film azonosítója          |
|CATEGORY_ID          |INT                  |kategória azonosítója     |
|TITLE                |VARCHAR(50)          |film címe                 |
|THREE_D              |BOOLEAN              |film van-e 3D-ben         |
|PLAYTIME             |INT                  |film játékideje           |
|PREMIERE             |DATE                 |film premier dátuma       |
|AGELIMIT             |INT                  |film korhatára            |
|DIRECTORFIRSTNAME    |VARCHAR(20)          |rendező vezetékneve       |
|DIRECTORLASTNAME     |VARCHAR(20)          |rendező keresztneve       |
|COUNTRY              |VARCHAR(30)          |film származási országa   |
|YEAR                 |INT                  |film címe                 |
|DESCRIPTION          |VARCHAR(500)         |film leírása              |

|FILM_CATEGORY        |                     |                          |
|---------------------|---------------------|--------------------------|
|FILM_ID              |INT                  |film azonosítója          |
|CATEGORY_ID          |INT                  |kategória azonosítója     |

|RESERVATION          |                     |                          |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |foglalás azonosítója      |
|USER_ID              |INT                  |felhasználó azonosítója   |
|SCREEN_ID            |INT                  |vetítés azonosítója       |
|NUMBEROFRESERVATIONS |INT                  |1 fő foglalásainak száma  |

|USER                 |                     |                          |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |felhasználó id-ja         |
|USERNAME             |VARCHAR(15)          |felhasználó neve          |
|PASSWORD             |VARCHAR(42)          |felhasználó jelszava      |
|EMAIL                |VARCHAR(50)          |felhasználó email-e       |
|PHONENUMBER          |VARCHAR(11)          |felhasználó telefonszáma  |
|ADMIN_RIGHT          |BOOLEAN              |rendelkezik-e admin joggal|


|SCREENING            |                     |                          |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |vetítés id-ja             |
|ROOM_ID              |INT                  |vetítés terem id-ja       |
|FILM_ID              |INT                  |vetítés film id-ja        |
|SCREENDAY            |DATE                 |vetítés napja             |
|SCREENTIME           |TIME                 |vetítés ideje hh:mm       |

|ROOM                 |                     |                          |
|---------------------|---------------------|--------------------------|
|ID                   |INT                  |terem id-ja               |
|SEATNUMBER           |INT                  |terem üléseinek száma     |
|IMAX                 |BOOLEAN              |terem IMAX-es terem-e     |
|FOUR_D               |BOOLEAN              |terem 4D-s terem-e        |


## Egyed-kapcsolat diagram:
![alt text](https://github.com/szferenc15/alkfejl2017/blob/master/img/Entity_Relationship_diagram.png Egyed-kapcsolat diagram)

## Szerzők:
+ **Kapás Dorina Anita H5BG9F**
+ **Szendrei Ferenc UBRPLU**

**[Eötvös Loránd Tudományegyetem Informatikai Kar]**