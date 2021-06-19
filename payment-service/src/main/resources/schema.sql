CREATE SCHEMA IF NOT EXISTS payment_db;

CREATE TABLE IF NOT EXISTS payment_db.payments
(
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_status  VARCHAR(250) NOT NULL,
    transaction_id VARCHAR(250) NOT NULL,
    order_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL
);