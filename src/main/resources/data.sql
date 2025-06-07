-- Очистка
DELETE FROM exhibition_entry;
DELETE FROM exhibition;
DELETE FROM exhibit;
DELETE FROM location;
DELETE FROM artist;

-- Художники
INSERT INTO artist (id, name, country) VALUES
(1, 'Ivan Petrov', 'Ukraine'),
(2, 'Anna Kowalska', 'Poland'),
(3, 'Chen Wei', 'China'),
(4, 'Carlos Gomez', 'Mexico'),
(5, 'Emily Smith', 'UK');

-- Локації
INSERT INTO location (id, name, address) VALUES
(1, 'Art Gallery', 'Kyiv, Shevchenko Blvd 12'),
(2, 'Modern Museum', 'Lviv, Hnatyuka 3'),
(3, 'Contemporary Space', 'London, Brick Lane 21'),
(4, 'Open Sky Hall', 'Barcelona, Rambla 9');

-- Експонати
INSERT INTO exhibit (id, title, description, artist_id, year_created) VALUES
(1, 'Sunrise', 'Oil painting of a sunrise', 1, 2020),
(2, 'The Future', 'Mixed media about future visions', 2, 2023),
(3, 'Old Streets', 'Watercolor series of old towns', 3, 2019),
(4, 'Silence', 'Abstract installation', 4, 2022),
(5, 'Mirror Mind', 'Conceptual mirror art', 5, 2021),
(6, 'Hope', 'Sculpture of hands', 1, 2018),
(7, 'Chaos Order', 'Digital print on canvas', 3, 2023);

-- Виставки (одна активна, інші минулі/майбутні)
INSERT INTO exhibition (id, title, start_date, end_date, location_id) VALUES
(1, 'Spring Art Show', '2025-04-01', '2025-05-01', 1),
(2, 'Summer Wonders', '2023-06-01', '2023-07-01', 2),
(3, 'Now Exhibition', '2024-01-01', '2026-12-31', 3), -- поточна
(4, 'Digital Era', '2025-07-01', '2025-08-01', 4);

-- Записи участі експонатів
INSERT INTO exhibition_entry (id, exhibition_id, exhibit_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 3, 4),
(5, 3, 5),
(6, 3, 6),
(7, 4, 7);
