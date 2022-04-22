SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE city;
TRUNCATE TABLE bank;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE city ALTER COLUMN id RESTART WITH 1;
ALTER TABLE bank ALTER COLUMN id RESTART WITH 1;

INSERT INTO city(id, name, city_centre_latitude, city_centre_longitude) VALUES(1, 'Tehran',  35.69439, 51.42151);
INSERT INTO city(id, name, city_centre_latitude, city_centre_longitude) VALUES(2, 'Karaj', 35.83266, 50.99155);

INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Meli Bank', false, 9.2, 1, 'Armita branch', 35.39439, 51.22131);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Mellat Bank', true, 6.3, 1, 'Shemiran branch', 35.99439, 51.62131);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Tejarat Bank', false, 9.8, 1, 'OstadMoin branch', 35.39439, 51.32131);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Ayande Bank', false, 8.7, 1, 'Azadegan branch', 35.19439, 51.12131);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Shahr Bank', true, NULL, 1, 'Azadi branch', 35.99439, 51.52131);

INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Meli Bank', false, 7.3, 2, 'GoharDash branch', 35.83266, 50.99155);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Mellat Bank', true, 3.0, 2, 'SarhadAbaad branch', 35.43266, 50.69155);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Tejarat Bank', true, 4.3, 2, 'Fardis branch', 35.13266, 50.69155);
INSERT INTO bank(name, deleted, rating, city_id, address, latitude, longitude)
VALUES('Shahr Bank', false, 9.6, 2, 'Andishe branch', 35.123266, 50.69155);