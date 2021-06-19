CREATE SCHEMA IF NOT EXISTS order_db;

CREATE TABLE IF NOT EXISTS order_db.orders
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(250)   NOT NULL,
    qty   INT            NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);