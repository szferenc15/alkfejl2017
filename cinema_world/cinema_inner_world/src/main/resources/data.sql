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
INSERT INTO film(cinema_id, picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES (1, '../../assets/thor_ragnarok.jpg', 'Thor: Ragnarok', 'magyar', true, false, true, true, false, 131, '2017-11-01', 12, 'Taika', 'Waititi', 'USA', 2017, 4,
                 'A Marvel Studios uj filmjeben Thort porolyetol megfosztva bebortonzik az univerzum tulso felen.');

INSERT INTO film(cinema_id, picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES (2, '../../assets/star_wars_the_last_jedi.jpg', 'Star Wars: The Last Jedi', 'orosz', true, false, true, true, false, 150, '2017-12-14', 12, 'Rian', 'Johnson', 'USA', 2017, 5,
                 'A Star Wars: Az utolso Jedikben a Skywalker saga folytatodik.');

INSERT INTO film(cinema_id, picture, title, language, synchron, inscriptive, imax, three_dimensional, four_dimensional, 
            play_time, premiere, age_limit, director_first_name, director_last_name, country, year, rate, description) 
         VALUES (2, '../../assets/jungle.jpg', 'Dzsungel', 'angol', true, false, true, true, false, 125, '2017-12-30', 12, 'Rian', 'Johnson', 'USA', 2017, 4,
                 'A Dzsungel.');

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
INSERT INTO room(id, cinema_id, name, vip, bed_room, imax, three_dimensional, four_dimensional) 
         VALUES (1, 1, 'IMAX-ONE', true, false, true, true, false);
INSERT INTO room(id, cinema_id, name, vip, bed_room, imax, three_dimensional, four_dimensional) 
         VALUES (2, 2, 'IMAX-ODIN', true, false, true, true, false);

-- RoomStructure data:
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (1, 1, 1, 1, 32);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (2, 1, 1, 2, 32);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (3, 1, 1, 3, 33);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (4, 1, 1, 4, 33);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (5, 1, 1, 5, 33);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (6, 1, 1, 6, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (7, 1, 1, 7, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (8, 1, 1, 8, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (9, 1, 1, 9, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (10, 1, 1, 10, 36);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (11, 2, 2, 1, 32);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (12, 2, 2, 2, 32);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (13, 2, 2, 3, 33);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (14, 2, 2, 4, 33);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (15, 2, 2, 5, 33);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (16, 2, 2, 6, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (17, 2, 2, 7, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (18, 2, 2, 8, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (19, 2, 2, 9, 34);
INSERT INTO room_structure(id, cinema_id, room_id, row, seat_number) 
         VALUES (20, 2, 2, 10, 36);

-- Screening data:
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (1, 1, 'Thor: Ragnarok', 1, false, true, false, true, 'magyar', false, true, '2017-11-20', '21:00:00');
INSERT INTO screening(id, cinema_id, film_title, room_id, two_dimensional, three_dimensional, four_dimensional, imax, language, inscriptive, synchron, screen_day, screen_time) 
         VALUES (2, 2, 'Star Wars: The Last Jedi', 2, false, true, false, true, 'orosz', false, true, '2017-12-14', '23:30:00');

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

-- Ticket data:
INSERT INTO ticket(type, basic_price, imax_price, imax_glass_price, 
                         three_dimensional_price, three_dimensional_glass_price, 
                         four_dimensional_price, four_dimensional_glass_price,
                         bed_room_price, bed_room_glass_price) 
         VALUES ('Normal', 1760, 340, 640, 160, 400, 1170, 1410, 1770, 2490);
INSERT INTO ticket(type, basic_price, imax_price, imax_glass_price, 
                         three_dimensional_price, three_dimensional_glass_price, 
                         four_dimensional_price, four_dimensional_glass_price,
                         bed_room_price, bed_room_glass_price) 
        VALUES ('Diak', 1320, 420, 720, 170, 410, 1170, 1410, 1770, 2490);
INSERT INTO ticket(type, basic_price, imax_price, imax_glass_price, 
                         three_dimensional_price, three_dimensional_glass_price, 
                         four_dimensional_price, four_dimensional_glass_price,
                         bed_room_price, bed_room_glass_price) 
        VALUES ('Junior', 1320, 420, 720, 170, 410, 1170, 1410, 1770, 2490);
INSERT INTO ticket(type, basic_price, imax_price, imax_glass_price, 
                         three_dimensional_price, three_dimensional_glass_price, 
                         four_dimensional_price, four_dimensional_glass_price,
                         bed_room_price, bed_room_glass_price) 
        VALUES ('Szenior', 1320, 420, 720, 170, 410, 1170, 1410, 1770, 2490);
INSERT INTO ticket(type, basic_price, imax_price, imax_glass_price, 
                         three_dimensional_price, three_dimensional_glass_price, 
                         four_dimensional_price, four_dimensional_glass_price,
                         bed_room_price, bed_room_glass_price) 
        VALUES ('Fogy elo', 1320, 420, 720, 170, 410, 1170, 1410, 1770, 2490);
        
-- BookingTicket data:
INSERT INTO booking_ticket(id, payment, ticket_type, booking_id, row, chair) 
         VALUES (1, 'Booking', 'Diak', 1, 6, 21);
INSERT INTO booking_ticket(id, payment, ticket_type, booking_id, row, chair) 
         VALUES (2, 'Booking', 'Diak', 1, 6, 22);
INSERT INTO booking_ticket(id, payment, ticket_type, booking_id, row, chair) 
         VALUES (3, 'PayPal', 'Normal', 2, 8, 15);

