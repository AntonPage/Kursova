INSERT INTO artist (id, name, country) VALUES (1, 'Ivan Petrov', 'Ukraine');
INSERT INTO artist (id, name, country) VALUES (2, 'Anna Kowalska', 'Poland');


INSERT INTO location (id, name, address) VALUES (1, 'Art Gallery', 'Kyiv, Shevchenko Blvd 12');
INSERT INTO location (id, name, address) VALUES (2, 'Modern Museum', 'Lviv, Hnatyuka 3');


INSERT INTO exhibit (id, title, description, artist_id, year_created)
VALUES (1, 'Sunrise', 'Oil painting of a sunrise', 1, 2020),
       (2, 'The Future', 'Mixed media about future visions', 2, 2023);


INSERT INTO exhibition (id, title, start_date, end_date, location_id)
VALUES (1, 'Spring Art Show', '2025-04-01', '2025-05-01', 1);


INSERT INTO exhibition_entry (id, exhibition_id, exhibit_id)
VALUES (1, 1, 1);
