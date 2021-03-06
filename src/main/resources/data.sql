

DROP TABLE IF EXISTS ORDERS cascade;


CREATE TABLE ORDERS (
  ID VARCHAR(100)  PRIMARY KEY,
  ORDER_DATA VARCHAR(1000) NOT NULL,
  CUSTOMER_ID VARCHAR(100) NOT NULL,
  TOTAL_AMOUNT  INT NOT NULL,
  ORDER_DATE DATE NOT NULL,
  STATUS VARCHAR (6) NOT NULL
);

DROP TABLE IF EXISTS BOOK cascade;

CREATE TABLE BOOK (
  ID VARCHAR(100)  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  AUTHOR VARCHAR (250) NOT NULL,
  QUANTITY INT NOT NULL,
  AMOUNT INT NOT NULL
);

DROP TABLE IF EXISTS  CUSTOMER cascade;

CREATE TABLE CUSTOMER (
  ID VARCHAR(100)  PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL,
  ADDRESS VARCHAR(250) NOT NULL,
  PHONE_NUMBER INT NOT NULL

);
