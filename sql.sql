Drop database if exists Cruise_company;
CREATE DATABASE if not exists Cruise_company;
USE Cruise_company;
create table Liners
(
    name       varchar(15) not null,
    passengers int         not null,
    crew       int         not null,
    id         BIGINT primary key auto_increment
);
INSERT INTO Liners
values ('Kenobus', 100, 15, 0),
       ('Amogus', 200, 30, 0),
       ('Sus', 300, 45, 0);
UPDATE liners SET name='Asus' WHERE id=3;
DELETE FROM liners WHERE id=5;
INSERT INTO Liners
values ('Kenobus', 100, 15, 5);
create table Routes
(
    start         datetime,
    end           datetime,
    start_point   varchar(20),
    destination   varchar(20),
    regular_stops int,
    liner_id      BIGINT references Liners (id),
    id            BIGINT primary key auto_increment not null
);

INSERT INTO Routes
values ('2022-01-08 18:42:19', '2022-01-19 20:00:00', 'Kyiv', 'Moscow', 5, 1, 0),
       ('2022-01-08 18:42:19', '2022-01-19 20:00:00', 'Kyiv', 'Izyum', 0, 2, 0),
       ('2022-01-08 18:42:19', '2022-01-24 20:00:00', 'Izyum', 'Berlin', 21, 3, 0);
SELECT *
from Routes;