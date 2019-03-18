CREATE DATABASE acmeMVP;
USE acmeMVP;
CREATE TABLE order_table (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  address VARCHAR(250) NOT NULL,
  confirmationDate LONG NOT NULL,
  orderStatus VARCHAR(250) NOT NULL
);
CREATE TABLE orderItem_table (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  unitPrice DOUBLE NOT NULL,
  quantity INT NOT NULL,
  orderId INT(6) UNSIGNED NOT NULL,
  FOREIGN KEY (orderId) REFERENCES order_table(id)
);
CREATE TABLE payment_table (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  status VARCHAR(250) NOT NULL,
  creditCardNumber LONG NOT NULL,
  paymentDate LONG NOT NULL,
  orderId INT(6) UNSIGNED,
  orderItemId INT(6) UNSIGNED,
  FOREIGN KEY (orderId) REFERENCES order_table(id),
  FOREIGN KEY (orderItemId) REFERENCES orderItem_table(id)
);
CREATE TABLE store_table (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  storeName VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL
);