INSERT INTO photos (photo_id, dimensions, color, copies, framing, gift_wrap)
VALUES ('c5040a89-cb47-4c96-888e-ff96708db6f3', '8x10', 'NO_COLOR', 2, 'WOODEN_WHITE', 0);

INSERT INTO photos (photo_id, dimensions, color, copies, framing, gift_wrap)
VALUES ('2d17cfeb-5d95-4d44-902d-f39e0b4e5099', '5x7', 'WITH_COLOR', 1, 'METALLIC', 1);

INSERT INTO photos (photo_id, dimensions, color, copies, framing, gift_wrap)
VALUES ('937a00bd-7a4d-4995-a434-8cb132620672', '11x14', 'NO_COLOR', 3, 'NON', 0);

INSERT INTO photos (photo_id, dimensions, color, copies, framing, gift_wrap)
VALUES ('a3fe4d7f-9e7a-4a7b-aa15-63b493ca2c86', '16x20', 'NO_COLOR', 1, 'WOODEN_BLACK', 1);

INSERT INTO photos (photo_id, dimensions, color, copies, framing, gift_wrap)
VALUES ('f4d00bc3-2b5d-4e8b-80d6-cd23ddc25a89', '8x12', 'WITH_COLOR', 2, 'METALLIC', 0);

INSERT INTO photos (photo_id, dimensions, color, copies, framing, gift_wrap)
VALUES ('b0911de8-14b4-4827-b85e-63200e19631d', '20x24', 'NO_COLOR', 3, 'METALLIC', 1);


------------------------------------------------------------------

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4d8', 'John', 'Doe', 'johndoe@example.com', '123 Main St', 'Anytown', 'California', 'United States', '12345');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4d9', 'Jane', 'Smith', 'janesmith@example.com', '456 Elm St', 'Othertown', 'New York', 'United States', '54321');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e0', 'Alice', 'Johnson', 'alicejohnson@example.com', '789 Oak St', 'Sometown', 'Texas', 'United States', '67890');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e1', 'Mohammed', 'Abdullah', 'mabdullah@example.com', '321 Pine St', 'Anothercity', 'Dubai', 'United Arab Emirates', '54321');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e2', 'Maria', 'Garcia', 'mariagarcia@example.com', '987 Cedar St', 'Somewhereville', 'Madrid', 'Spain', '87654');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e3', 'Hans', 'Mueller', 'hansmueller@example.com', '654 Birch St', 'Munich', 'Bavaria', 'Germany', '34567');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e4', 'Yuki', 'Tanaka', 'yukitanaka@example.com', '147 Willow St', 'Tokyo', 'Tokyo', 'Japan', '98765');

INSERT INTO customers (customer_id, first_name, last_name, email, street_address, city, state, country, postal_code)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e5', 'Sophie', 'Dupont', 'sophiedupont@example.com', '852 Oak St', 'Paris', 'Île-de-France', 'France', '23456');


INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(1, 'PERSONEl', '310-555-4321');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(2, 'HOME', '415-555-1234');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(3, 'HOME', '512-555-9999');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(4, 'WORK', '717-555-5555');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(4, 'PERSONEl', '717-555-6666');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(5, 'HOME', '212-555-1234');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(5, 'PERSONEl', '212-555-5678');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(6, 'WORK', '808-555-1234');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(6, 'PERSONEl', '808-555-5678');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(7, 'HOME', '213-555-1234');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(7, 'WORK', '213-555-9876');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES(8, 'HOME', '310-555-1234');


-------------------------------------------


INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES ('f6f72dfb-6837-4b77-ba4b-82745e504caa', 'DHL', 'Deliver to back entrance', '2024-03-10', '3:00 PM');

INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES('g3e93a2d-5e43-4186-9ff7-3b6c3a7758d1', 'DHL', 'Leave package with neighbor', '2024-03-11', '9:30 AM');

INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES('h26f1339-d8a5-4a8e-8a3c-67cfc8a4c114', 'UPS', 'Require signature upon delivery', '2024-03-12', '1:00 PM');

INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES('c3540a89-cb47-4c96-888e-ff96708db4e5', 'FedEx', 'Deliver to back entrance', '2024-03-10', '3:00 PM');

INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES('d892f7d1-aa1b-48c2-b9f2-ecfe38c1f533', 'FedEx', 'Leave package with neighbor', '2024-03-11', '9:30 AM');

INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES('e1c8df82-5aef-4a49-9e5f-8f103f22c10a', 'Aramex', 'Require signature upon delivery', '2024-03-12', '1:00 PM');

INSERT INTO deliveries (delivery_id, company, delivery_Instructions, date, time)
VALUES('i7a9464c-1492-4d65-b7e2-e10c18ff9f8f', 'USPS', 'Deliver to side entrance', '2024-03-13', '4:15 PM');


--------------------------------------------

INSERT INTO purchases(purchase_id, customer_id, photo_id, delivery_id, type_of_payment, sub_Total, total, status)
VALUES ('fd8158c8-6a93-4c9d-a2b7-7ff9a33b6aa2', 'c3540a89-cb47-4c96-888e-ff96708db4d8',
        'c5040a89-cb47-4c96-888e-ff96708db6f3', 'f6f72dfb-6837-4b77-ba4b-82745e504caa',
        'Credit_MasterCard', '40.5 $', '55.20 $', 'Accepted');

INSERT INTO purchases(purchase_id, customer_id, photo_id, delivery_id, type_of_payment ,sub_Total, total, status)
VALUES ('7e8ae48e-5674-4cf4-b615-6c7b6e2f8a3d', 'c3540a89-cb47-4c96-888e-ff96708db4d8',
        'b0911de8-14b4-4827-b85e-63200e19631d', 'f6f72dfb-6837-4b77-ba4b-82745e504caa',
        'Credit_Visa', '20.5 $' ,'26.20 $', 'Accepted');

