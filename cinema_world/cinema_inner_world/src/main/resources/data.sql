-- Cinema data:
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (1, 'Magyarorszag', 'Budapest', 'VIII', 'Kerepesi', 9, 'CW Arena', 40);
INSERT INTO cinema(id, country, city, district, street, house_number, name, amenities_charge) 
         VALUES (2, 'Oroszorszag', 'Moszkva', 'XVI', 'Bol''shoy Ovchinnikovskiy Pereulok', 16, 'CW Pyat'' Zvozd', 100);
         
-- User data:
INSERT INTO user(username, password, email, phone_number, admin_right) 
         VALUES ('barackfa', 'barackfa', 'barackfa@almafa.fa', '06302003000', false);
INSERT INTO user(username, password, email, phone_number, admin_right) 
         VALUES ('almafa', 'almafa', 'almafa@barackfa.fa', '06302003005', false);

-- Film data:
INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/thor_ragnarok.jpg', 'Thor: Ragnarok', 'magyar', true, false, true, true, false, 131, '2017-11-01', 12, 'Taika', 'Waititi', 'USA', 2017, 4,
                 'A Marvel Studios uj filmjeben Thort porolyetol megfosztva bebortonzik az univerzum tulso felen.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/star_wars_the_last_jedi.jpg', 'Star Wars: The Last Jedi', 'orosz', true, false, true, true, false, 150, '2017-12-14', 12, 'Rian', 'Johnson', 'USA', 2017, 5,
                 'A Star Wars: Az utolso Jedikben a Skywalker saga folytatodik.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/jungle.jpg', 'Dzsungel', 'angol', true, false, true, true, false, 125, '2017-10-26', 12, 'Greg', 'McLean', 'Ausztrália', 2017, 4,
                 'A valós eseményeken alapuló történet a civilizált életre ráunó, 22 éves Yossi útját követi');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/a_viszkis.jpg', 'A viszkis', 'magyar', true, false, false, false, false, 126, '2017-11-23', 16, 'Nimród', 'Antal', 'Magyarország', 2017, 4,
                 'Aki mindig egy lépéssel a rendőrség előtt járt. És aki minden bankrablása előtt megivott egy pohár viszkit.');

INSERT INTO film(picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES ('../../assets/justice_league.jpg', 'Az igazság ligája', 'angol', true, true, false, false, false, 121, '2017-11-16', 12, 'Zack', 'Snyder', 'USA', 2017, 4,
                 'Bruce Wayne tudja, hogy nem vonulhat vissza. A világnak szüksége van rá, és a hozzá hasonlókra.');

-- Cinema-film join table:
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Thor: Ragnarok', 1);
INSERT INTO cinema_film(film_title, cinema_id)
        VALUES ('Star Wars: The Last Jedi', 2);

-- Trailer data:
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/v7MGUNV8MxU', 'Thor: Ragnarok');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/ue80QwXMRHg', 'Thor: Ragnarok');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/zB4I68XVPzQ', 'Star Wars: The Last Jedi');
INSERT INTO trailer(url, film_title) 
        VALUES ('https://www.youtube.com/embed/Q0CbN8sfihY', 'Star Wars: The Last Jedi');
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
         VALUES (1, 'Thor: Ragnarok', 'Akcio');
INSERT INTO film_category(id, film_title, category) 
         VALUES (2, 'Thor: Ragnarok', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES (3, 'Thor: Ragnarok', 'Fantasy');
INSERT INTO film_category(id, film_title, category) 
         VALUES (4, 'Star Wars: The Last Jedi', 'Kaland');
INSERT INTO film_category(id, film_title, category) 
         VALUES (5, 'Star Wars: The Last Jedi', 'Fantasy');
INSERT INTO film_category(id, film_title, category)
         VALUES (6, 'Star Wars: The Last Jedi', 'Sci-Fi');
INSERT INTO film_category(id, film_title, category)
         VALUES (7, 'Dzsungel', 'Akcio');
INSERT INTO film_category(id, film_title, category)
         VALUES (8, 'Dzsungel', 'Kaland');

-- Room data:
INSERT INTO room(id, cinema_id, name, vip, bed_room, imax, three_dimensional, four_dimensional, row, seat_number) 
         VALUES (1, 1, 'IMAX-ONE', true, false, true, true, false, 10, 30);
INSERT INTO room(id, cinema_id, name, vip, bed_room, imax, three_dimensional, four_dimensional, row, seat_number) 
         VALUES (2, 2, 'IMAX-ODIN', true, false, true, true, false, 15, 30);

-- Screening data:
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (1, 1, 'Thor: Ragnarok', 1, false, true, false, true, 'magyar', false, true, '2017-11-20', '21:00:00');
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (2, 2, 'Star Wars: The Last Jedi', 2, false, true, false, true, 'orosz', false, true, '2017-12-14', '23:30:00');
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (3, 2, 'Star Wars: The Last Jedi', 2, false, false, true, true, 'angol', false, true, '2018-01-05', '14:30:00');

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

