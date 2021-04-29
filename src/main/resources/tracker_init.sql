-- Автор Азарков Максим Николаевич
-- Версия 2021-04-12 v.1.1

-- Создадим БД
\c postgres
DROP DATABASE tracker;
CREATE DATABASE tracker;

\c tracker

-- заметки
CREATE TABLE item (
    id_item serial PRIMARY KEY,
    name VARCHAR(20),
    descript VARCHAR(1000),
    time BIGINT
);



