delete from schedules;
delete from tickets;
delete from trains;
delete from stations;
delete from users;


insert into trains (id, capacity, number)
values  (5, '100', '5'),
        (4, '99', '4'),
        (45, '133', '12'),
        (1, '0', '1'),
        (3, '65', '3'),
        (2, '75', '2');

insert into stations (id, name)
values  (1, 'Station1'),
        (2, 'Station2'),
        (3, 'Station3'),
        (4, 'Station4'),
        (5, 'Station5'),
        (6, 'Station6'),
        (7, 'Station7');

insert into schedules (id, arrival, station_name, train_number, station_id, train_id)
values  (28, '2020-10-10 00:00:00.000000', 'Station7', '4', 7, 4),
        (24, '2020-10-07 00:00:00.000000', 'Station7', '1', 7, 1),
        (8, '2020-10-03 00:00:00.000000', 'Station2', '4', 2, 4),
        (9, '2020-10-03 00:00:00.000000', 'Station3', '1', 3, 1),
        (16, '2020-10-05 00:00:00.000000', 'Station5', '1', 5, 1),
        (22, '2020-10-08 00:00:00.000000', 'Station6', '2', 6, 2),
        (27, '2020-10-14 00:00:00.000000', 'Station7', '3', 7, 3),
        (12, '2020-10-10 00:00:00.000000', 'Station3', '3', 3, 3),
        (15, '2020-10-06 00:00:00.000000', 'Station4', '2', 4, 2),
        (26, '2020-10-09 00:00:00.000000', 'Station7', '2', 7, 2),
        (19, '2020-10-05 00:00:00.000000', 'Station5', '4', 5, 4),
        (4, '2020-10-08 00:00:00.000000', 'Station1', '3', 1, 3),
        (11, '2020-10-05 00:00:00.000000', 'Station3', '2', 3, 2),
        (13, '2020-10-04 00:00:00.000000', 'Station4', '1', 4, 1),
        (23, '2020-10-13 00:00:00.000000', 'Station6', '3', 6, 3),
        (3, '2020-10-03 00:00:00.000000', 'Station1', '2', 1, 2),
        (7, '2020-10-04 00:00:00.000000', 'Station2', '2', 2, 2),
        (20, '2020-10-06 00:00:00.000000', 'Station6', '1', 6, 1),
        (5, '2020-10-02 00:00:00.000000', 'Station2', '1', 2, 1),
        (18, '2020-10-07 00:00:00.000000', 'Station5', '2', 5, 2),
        (14, '2020-10-10 00:00:00.000000', 'Station4', '5', 4, 5),
        (10, '2020-10-11 00:00:00.000000', 'Station3', '5', 3, 5),
        (21, '2020-10-08 00:00:00.000000', 'Station6', '5', 6, 5),
        (6, '2020-10-12 00:00:00.000000', 'Station2', '5', 2, 5),
        (25, '2020-10-07 00:00:00.000000', 'Station7', '5', 7, 5),
        (2, '2020-10-13 00:00:00.000000', 'Station1', '5', 1, 5),
        (17, '2020-10-09 00:00:00.000000', 'Station5', '5', 5, 5),
        (1, '2020-10-01 00:00:00.000000', 'Station1', '1', 1, 1);

insert into public.users (id, email, first_name, last_name, login, password, role, status)
values  (2, 'admin@ya.ru', 'Admin', 'Adminov', 'admin', '$2y$12$848m1a67MyM36WfYrSBLHuPUOvVIYJ564SuJ7Mip1f0kU/VRLkPQS', 'ADMIN', 'ACTIVE'),
        (1, 'user@ya.ru', 'User', 'Userov', 'user', '$2y$12$8u7dQmDBKjfUWUe/HZyGEukSHt7YdgHfKkERHVoL0ULgy9cZRajyu', 'USER', 'ACTIVE');

insert into tickets (id, train_id, user_id)
values  (1, 3, 1);

