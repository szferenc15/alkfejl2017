-- Cinema data:
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (1, 'Magyarorszag', 'Budapest', 'VIII', 'Kerepesi', 9, 'CW Arena', 40);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (2, 'Magyarorszag', 'Budapest', 'XI', 'Oktober huszonharmadika', 8, 'CW Allee', 40);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (3, 'Magyarorszag', 'Budapest', 'X', 'Vaci', 1, 'CW Westend', 40);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (4, 'Magyarorszag', 'Budapest', 'II', 'Lovohaz', 5, 'CW Mammut 2', 40);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (5, 'Magyarorszag', 'Budapest', 'III', 'Becsi', 38, 'CW Bed Cinema', 40);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (6, 'Magyarorszag', 'Kecskemet', 'Belvaros', 'Korona', 2, 'CW Malom', 20);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (7, 'Macedonia', 'Szkopje', 'Bazaar', 'Atanas Babata', 100, 'CW Kurshumli An', 20);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (8, 'Egyesult Kiralysag', 'London', 'No Hill', 'Portobello Rd', 104, 'CW Electric Porto', 60);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (9, 'Egyesult Kiralysag', 'London', 'Sreditch', 'Redchurch St', 65, 'CW Electric Shore', 60);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (10, 'Oroszorszag', 'Moszkva', 'XVI', 'Bol''shoy Ovchinnikovskiy Pereulok', 16, 'CW Pyat'' Zvozd', 100);
         
-- User data:
INSERT INTO user(username, password, email, phone_number, admin_right) 
         VALUES ('barackfa', 'Dr123$,.-', 'barackfa@almafa.fa', '06302003000', false);
INSERT INTO user(username, password, email, phone_number, admin_right) 
         VALUES ('almafa', 'almafa', 'almafa@barackfa.fa', '06302003005', false);
INSERT INTO user(username, password, email, phone_number, admin_right) 
         VALUES ('admin', 'admin', 'admin@barackfa.fa', '06302003010', true);

-- Film data:
INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/star_wars_the_last_jedi.jpg', 'Star Wars: Az utolso Jedik', 'orosz', true, false, true, true, false, 150, '2017-12-14', 12, 'Rian', 'Johnson', 'USA', 2017, 5,
                 'A Star Wars: Az utolso Jedikben a Skywalker saga folytatodik.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/paddington2.jpg', 'Paddington 2', 'angol', true, true, false, false, false, 103, '2017-11-30', 6, 'Paul', 'King', 'UK', 2017, 4,
                 'Mindenki kedvenc macija, a dedelgetni valo Paddington boldogan eldegel a Brown csaladdal Windsor Gardensben.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/a_viszkis.jpg', 'A viszkis', 'magyar', true, false, false, false, false, 126, '2017-11-23', 16, 'Nimrod', 'Antal', 'Magyarorszag', 2017, 4,
                 'Aki mindig egy lepessel a rendorseg elott jart. Es aki minden bankrablasa elott megivott egy pohar viszkit.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/coco.jpg', 'Coco', 'angol', true, true, false, false, false, 109, '2017-11-23', 6, 'Lee', 'Unkrich', 'USA', 2017, 4,
                 'Annak ellenere, hogy csaladja osidok ota megveti a zenet, Miguel arrol abrandozik, hogy egyszer neves muzsikus lesz.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/justice_league.jpg', 'Az igazsag ligaja', 'angol', true, true, false, false, false, 121, '2017-11-16', 12, 'Zack', 'Snyder', 'USA', 2017, 4,
                 'Bruce Wayne tudja, hogy nem vonulhat vissza. A vilagnak szuksege van ra, es a hozza hasonlokra.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/happy_death.jpg', 'Boldog halalnapot!', 'angol', true, true, false, false, false, 96, '2017-11-16', 16, 'Christopher', 'Landon', 'USA', 2017, 4,
                 'Tree csodalatosan bekepzelt teremtes, aki egyetlen embert szeret feltetel nelkul: sajat magat.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/gyilkossag.jpg', 'Gyilkossag az Orient Expresszen', 'angol', true, true, false, false, false, 114, '2017-11-09', 12, 'Kenneth', 'Branagh', 'USA', 2017, 4,
                 'Az Isztambulbol Parizsba tarto luxusvonat utasai mindig kulonleges emberek.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/badmoms_xmas.jpg', 'Rossz anyak karacsonya', 'angol', true, true, false, false, false, 104, '2017-11-09', 16, 'Scott', 'Moore', 'USA', 2017, 4,
                 'Mikor minden pillanat csupa orom es boldogsag... na, ilyenkor kothetik csak fel igazan a gatyajukat az anyukak.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/thor_ragnarok.jpg', 'Thor: Ragnarok', 'magyar', true, false, true, true, false, 131, '2017-11-01', 12, 'Taika', 'Waititi', 'USA', 2017, 4,
                 'A Marvel Studios uj filmjeben Thort porolyetol megfosztva bebortonzik az univerzum tulso felen.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/jungle.jpg', 'Dzsungel', 'angol', true, false, true, true, false, 125, '2017-10-26', 12, 'Greg', 'McLean', 'Ausztralia', 2017, 4,
                 'A valas esemenyeken alapulo tortenet a civilizalt eletre raunó, 22 eves Yossi utjat koveti');

-- Cinema-film join table:
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Boldog halalnapot!', 7);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Boldog halalnapot!', 10);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Gyilkossag az Orient Expresszen', 8);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Gyilkossag az Orient Expresszen', 10);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Az igazsag ligaja', 4);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Az igazsag ligaja', 5);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Az igazsag ligaja', 6);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Thor: Ragnarok', 1);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Thor: Ragnarok', 2);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Thor: Ragnarok', 3);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Coco', 8);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Coco', 9);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Coco', 5);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Paddington 2', 8);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Paddington 2', 9);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('A viszkis', 1);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('A viszkis', 2);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('A viszkis', 3);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('A viszkis', 4);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('A viszkis', 5);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('A viszkis', 6);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Dzsungel', 7);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 1);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 2);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 3);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 4);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 5);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 6);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 7);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 8);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 9);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: Az utolso Jedik', 10);


-- Trailer data:

INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/8BnIfZXDAMk', 'Star Wars: Az utolso Jedik');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/-cJFbqDfBhA', 'Star Wars: Az utolso Jedik');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/K1HAzQotkdU', 'Paddington 2');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/stusfajeKtI', 'A viszkis');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/UXAthAqJ33M', 'A viszkis');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/CCyZP_SdDGk', 'Coco');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/RLXFAaAu8VA', 'Az igazsag ligaja');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/qCZJGxdwS4s', 'Az igazsag ligaja');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/QSVYATiZjF8', 'Boldog halalnapot!');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/Upu7Q08kKbM', 'Gyilkossag az Orient Expresszen');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/iGZeY1qwjLg', 'Gyilkossag az Orient Expresszen');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/7Bj-YfYAtlY', 'Rossz anyak karacsonya');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/GBMCOpMOn8I', 'Rossz anyak karacsonya');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/v7MGUNV8MxU', 'Thor: Ragnarok');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/ue80QwXMRHg', 'Thor: Ragnarok');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/RI_Iz3-88Fw', 'Dzsungel');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/CJIYns1aqzY', 'Dzsungel');

-- Category data:
INSERT INTO category(category) 
         VALUES ('Akcio');
INSERT INTO category(category) 
         VALUES ('Kaland');
INSERT INTO category(category) 
         VALUES ('Fantasy');
INSERT INTO category(category) 
         VALUES ('Sci-Fi');
INSERT INTO category(category) 
         VALUES ('Drama');
INSERT INTO category(category) 
         VALUES ('Bunugyi');
INSERT INTO category(category) 
         VALUES ('Vigjatek');
INSERT INTO category(category) 
         VALUES ('Zenes');
INSERT INTO category(category) 
         VALUES ('Oneletrajzi');
INSERT INTO category(category) 
         VALUES ('Romantikus');
INSERT INTO category(category) 
         VALUES ('Horror');
INSERT INTO category(category) 
         VALUES ('Csaladi');
INSERT INTO category(category) 
         VALUES ('Animacios');
INSERT INTO category(category) 
         VALUES ('Thriller');
INSERT INTO category(category) 
         VALUES ('Misztikus');
INSERT INTO category(category) 
         VALUES ('Tortenelmi');

-- FilmCategory data:
INSERT INTO film_category(id, film_title, category)
         VALUES ( 1, 'Dzsungel', 'Akcio');
INSERT INTO film_category(id, film_title, category)
         VALUES ( 2, 'Dzsungel', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 3, 'Thor: Ragnarok', 'Akcio');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 4, 'Thor: Ragnarok', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 5, 'Thor: Ragnarok', 'Fantasy');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 6, 'Rossz anyak karacsonya', 'Vigjatek');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 7, 'Gyilkossag az Orient Expresszen', 'Drama');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 8, 'Gyilkossag az Orient Expresszen', 'Bunugyi');
INSERT INTO film_category(id, film_title, category) 
         VALUES ( 9, 'Boldog halalnapot!', 'Thriller');
INSERT INTO film_category(id, film_title, category) 
         VALUES (10, 'Az igazsag ligaja', 'Akcio');
INSERT INTO film_category(id, film_title, category) 
         VALUES (11, 'Az igazsag ligaja', 'Fantasy');
INSERT INTO film_category(id, film_title, category) 
         VALUES (12, 'Az igazsag ligaja', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES (13, 'Coco', 'Animacios');
INSERT INTO film_category(id, film_title, category) 
         VALUES (14, 'Coco', 'Csaladi');
INSERT INTO film_category(id, film_title, category) 
         VALUES (15, 'Coco', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES (16, 'A viszkis', 'Akcio');
INSERT INTO film_category(id, film_title, category) 
         VALUES (17, 'Paddington 2', 'Animacios');
INSERT INTO film_category(id, film_title, category) 
         VALUES (18, 'Paddington 2', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES (19, 'Paddington 2', 'Vigjatek');
INSERT INTO film_category(id, film_title, category) 
         VALUES (20, 'Star Wars: Az utolso Jedik', 'Fantasy');
INSERT INTO film_category(id, film_title, category) 
         VALUES (21, 'Star Wars: Az utolso Jedik', 'Kaland');
INSERT INTO film_category(id, film_title, category)
         VALUES (22, 'Star Wars: Az utolso Jedik', 'Sci-Fi');

-- Room data:
INSERT INTO room(id, cinema_id, name, vip, bed_room, imax, three_dimensional, four_dimensional, row, seat_number) 
         VALUES (1, 1, 'IMAX-ONE', true, false, true, true, false, 10, 30);
INSERT INTO room(id, cinema_id, name, vip, bed_room, imax, three_dimensional, four_dimensional, row, seat_number) 
         VALUES (2, 2, 'IMAX-ODIN', true, false, true, true, false, 15, 30);

-- Screening data:
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (1, 1, 'Thor: Ragnarok', 1, false, true, false, true, 'magyar', false, true, '2017-11-20', '21:00:00');
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (2, 2, 'Star Wars: Az utolso Jedik', 2, false, true, false, true, 'orosz', false, true, '2017-12-14', '23:30:00');
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (3, 2, 'Star Wars: Az utolso Jedik', 2, false, false, true, true, 'angol', false, true, '2018-01-05', '14:30:00');

-- Ticket data:
INSERT INTO ticket(type, price) 
        VALUES ('2D Normal', 1760);
INSERT INTO ticket(type, price) 
        VALUES ('3D Normal', 1960);
INSERT INTO ticket(type, price) 
        VALUES ('3D Normal + SZ', 2320);
INSERT INTO ticket(type, price) 
        VALUES ('4D Normal', 2260);
INSERT INTO ticket(type, price) 
        VALUES ('4D Normal + SZ', 2520);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 2D Normal', 2100);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Normal', 2260);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Normal + SZ', 2520);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Normal', 2450);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Normal + SZ', 2860);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 2D Normal', 2350);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Normal', 2670);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Normal + SZ', 3100);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Normal', 2950);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Normal + SZ', 3520);

INSERT INTO ticket(type, price) 
        VALUES ('2D Diak', 1420);
INSERT INTO ticket(type, price) 
        VALUES ('3D Diak', 1640);
INSERT INTO ticket(type, price) 
        VALUES ('3D Diak + SZ', 2010);
INSERT INTO ticket(type, price) 
        VALUES ('4D Diak', 2100);
INSERT INTO ticket(type, price) 
        VALUES ('4D Diak + SZ', 2240);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 2D Diak', 1820);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Diak', 2020);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Diak + SZ', 2350);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Diak', 2200);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Diak + SZ', 2510);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 2D Diak', 2110);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Diak', 2380);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Diak + SZ', 2710);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Diak', 2830);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Diak + SZ', 3310);

INSERT INTO ticket(type, price) 
        VALUES ('2D Junior', 1420);
INSERT INTO ticket(type, price) 
        VALUES ('3D Junior', 1640);
INSERT INTO ticket(type, price) 
        VALUES ('3D Junior + SZ', 2010);
INSERT INTO ticket(type, price) 
        VALUES ('4D Junior', 2100);
INSERT INTO ticket(type, price) 
        VALUES ('4D Junior + SZ', 2240);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 2D Junior', 1820);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Junior', 2020);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Junior + SZ', 2350);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Junior', 2200);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Junior + SZ', 2510);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 2D Junior', 2110);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Junior', 2380);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Junior + SZ', 2710);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Junior', 2830);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Junior + SZ', 3310);

INSERT INTO ticket(type, price) 
        VALUES ('2D Szenior', 1420);
INSERT INTO ticket(type, price) 
        VALUES ('3D Szenior', 1640);
INSERT INTO ticket(type, price) 
        VALUES ('3D Szenior + SZ', 2010);
INSERT INTO ticket(type, price) 
        VALUES ('4D Szenior', 2100);
INSERT INTO ticket(type, price) 
        VALUES ('4D Szenior + SZ', 2240);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 2D Szenior', 1820);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Szenior', 2020);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Szenior + SZ', 2350);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Szenior', 2200);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Szenior + SZ', 2510);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 2D Szenior', 2110);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Szenior', 2380);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Szenior + SZ', 2710);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Szenior', 2830);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Szenior + SZ', 3310);

INSERT INTO ticket(type, price) 
        VALUES ('2D Fogy.elo', 1420);
INSERT INTO ticket(type, price) 
        VALUES ('3D Fogy.elo', 1640);
INSERT INTO ticket(type, price) 
        VALUES ('3D Fogy.elo + SZ', 2010);
INSERT INTO ticket(type, price) 
        VALUES ('4D Fogy.elo', 2100);
INSERT INTO ticket(type, price) 
        VALUES ('4D Fogy.elo + SZ', 2240);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 2D Fogy.elo', 1820);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Fogy.elo', 2020);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 3D Fogy.elo + SZ', 2350);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Fogy.elo', 2200);
INSERT INTO ticket(type, price) 
        VALUES ('IMAX 4D Fogy.elo + SZ', 2510);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 2D Fogy.elo', 2110);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Fogy.elo', 2380);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 3D Fogy.elo + SZ', 2710);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Fogy.elo', 2830);
INSERT INTO ticket(type, price) 
        VALUES ('Agyas 4D Fogy.elo + SZ', 3310);

-- ScreeningTicket data:
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (1, 1, 'IMAX 3D Normal');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (2, 1, 'IMAX 3D Diak');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (3, 1, 'IMAX 3D Junior');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (4, 1, 'IMAX 3D Szenior');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (5, 1, 'IMAX 3D Fogy.elo');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (6, 2, 'IMAX 3D Normal');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (7, 2, 'IMAX 3D Diak');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (8, 2, 'IMAX 3D Junior');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (9, 2, 'IMAX 3D Szenior');
INSERT INTO screening_ticket(id, screening_id, ticket_type)
        VALUES (10, 2, 'IMAX 3D Fogy.elo');

-- Booking data:
INSERT INTO booking(id, screening_id) 
         VALUES (1, 1);
INSERT INTO booking(id, screening_id)
         VALUES (2, 1);

-- User-Booking join table data:
INSERT INTO user_booking(username, booking_id)
        VALUES ('barackfa', 1);
INSERT INTO user_booking(username, booking_id)
        VALUES ('almafa', 1);
INSERT INTO user_booking(username, booking_id)
        VALUES ('barackfa', 2);

-- BookingTicket data:
INSERT INTO booking_ticket(id, username, payment, ticket_type, booking_id, row, chair) 
         VALUES (1, 'almafa', 'Booking', 'IMAX 3D Diak', 1, 6, 21);
INSERT INTO booking_ticket(id, username, payment, ticket_type, booking_id, row, chair) 
         VALUES (2, 'barackfa', 'Booking', 'IMAX 3D Diak', 1, 6, 22);
INSERT INTO booking_ticket(id, username, payment, ticket_type, booking_id, row, chair) 
         VALUES (3, 'barackfa', 'PayPal', 'IMAX 3D Normal', 2, 8, 15);

