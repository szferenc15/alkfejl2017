-- User data:
INSERT INTO user(id, username, password, email, phone_number, admin_right) 
         VALUES (1, 'barackfa', 'barackfa', 'barackfa@almafa.fa', '06302003000', false);

-- Film data:
INSERT INTO film(id, title, three_dimensional, play_time, premiere, age_limit,
                 director_first_name, director_last_name, country, year, description) 
         VALUES (1, 'Thor: Ragnarok', true, 131, '2017-11-01', 12, 'Taika', 'Waititi', 'USA', 2017, 
                 'Imprisoned, the mighty Thor finds himself in a lethal gladiatorial contest against the Hulk, his former ally. Thor must fight for survival and race against time to prevent the all-powerful Hela from destroying his home and the Asgardian civilization.');
INSERT INTO category(id, film_id, category) 
         VALUES (1, 1, 'Akcio');
INSERT INTO category(id, film_id, category) 
         VALUES (2, 1, 'Kaland');
INSERT INTO category(id, film_id, category) 
         VALUES (3, 1, 'Fantasy');

-- Room data:
INSERT INTO room(id, room_name, four_dimensional, imax, seat_number) 
         VALUES (1, 'IMAX-ONE',false, true, 370);

-- Screening data:
INSERT INTO screening(id, film_id, room_id, screen_day, screen_time) 
         VALUES (1, 1, 1, '2017-11-20', '21:00:00');

-- Reservation data:
INSERT INTO reservation(id, number_of_reservations, screening_id) 
         VALUES (1, 2, 1);

-- User-Reservation join table data:
INSERT INTO user_reservation(user_id, reservation_id)
        VALUES (1, 1);