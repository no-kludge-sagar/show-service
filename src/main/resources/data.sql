INSERT INTO movie (id, title) VALUES 
(1, 'Inception'),
(2, 'The Matrix'),
(3, 'Interstellar'),
(4, 'The Dark Knight');

UPDATE movie SET created_by = 'Sagar';

INSERT INTO town (id, name) VALUES 
(1, 'Springfield'),
(2, 'Karur');

UPDATE town SET created_by = 'Sagar';

INSERT INTO theatre (id, name, town_id) VALUES 
(1, 'Grand Cinema', 1),
(2, 'Royal Theatre', 1),
(3, 'Downtown Movies', 1),
(4, 'Paradise Cinema', 1),
(5, 'Thinnappa', 2),
(6, 'Ajanta', 2),
(7, 'Ellora', 2),
(8, 'Kalaiyarangam', 2),
(9, 'Kavithalaya', 2);

UPDATE theatre SET created_by = 'Sagar';

INSERT INTO show (id, movie_id, theatre_id, date, time) VALUES 
(1, 1, 1, '2025-02-20', '18:30:00'),
(2, 2, 2, '2025-02-21', '20:00:00'),
(3, 3, 3, '2025-02-22', '16:00:00'),
(4, 4, 4, '2025-02-23', '19:45:00');

ALTER TABLE show ALTER COLUMN id RESTART WITH 5;

UPDATE show SET created_by = 'Sagar';