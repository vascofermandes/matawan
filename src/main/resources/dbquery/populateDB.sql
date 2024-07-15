
CREATE TABLE team (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      acronym VARCHAR(3) NOT NULL,
                      budget NUMERIC(10)
);

CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        position VARCHAR(3) NOT NULL,
                        team_id BIGINT REFERENCES team(id)
);


INSERT INTO public.team(
    id, name, acronym, budget)
VALUES (1, 'Olympique Gymnaste Club de Nice', 'NIC', 100);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (2, 'BBB', 'FW', 1);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (1, 'AAA', 'GK', 1);


INSERT INTO public.team(
    id, name, acronym, budget)
VALUES (2, 'Paris Saint Germain', 'PSG', 200);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (3, 'CCC', 'MID', 2);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (4, 'DDD', 'DEF', 2);

INSERT INTO public.team(
    id, name, acronym, budget)
VALUES (3, 'Sport Lisboa e Benfica', 'BEN', 100);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (5, 'EEE', 'FW', 3);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (6, 'FFF', 'FW', 3);

INSERT INTO public.player(
    id, name, "position", team_id)
VALUES (7, 'GGG', 'DEF', 3);
