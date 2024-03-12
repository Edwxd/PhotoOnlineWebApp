USE `photoonlineprinting-db`;

------Customer Table ------

create table if not exists customers (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id VARCHAR(50) UNIQUE NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    street_address VARCHAR (50),
    city VARCHAR (50),
    state VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9)
    );


create table if not exists customer_phonenumbers (
    customer_id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
    );

-------------------------------------

create table if not exists deliveries(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    delivery_id VARCHAR(50),
    company VARCHAR(50),
    delivery_Instructions VARCHAR(75),
    date VARCHAR(50) NOT NULL,
    time VARCHAR(30) NOT NULL
);


------------------------


create table if not exists photos(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    photo_id VARCHAR(50),
    dimensions VARCHAR(50),
    color VARCHAR(50),
    copies INTEGER,
    framing VARCHAR(50),
    gift_wrap VARCHAR(50)
);


-------------------------

create table if not exists purchases(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    purchase_id VARCHAR(50),
    customer_id VARCHAR(50),
    photo_id VARCHAR(50),
    delivery_id VARCHAR(50),
    type_of_payment VARCHAR(50),
    sub_Total VARCHAR(36),
    total VARCHAR(36),
    status VARCHAR(50)


);

