CREATE DATABASE IF NOT EXISTS rocket_racoon; 

CREATE TABLE rocket_racoon.franchise (
fran_id INT NOT NULL,
franchise_title VARCHAR(30)  NOT NULL,
office_location VARCHAR(100) NOT NULL,
owner_name VARCHAR(60) NOT NULL,
account_manager VARCHAR(60) NOT NULL,
manager_email VARCHAR(100) NOT NULL,
manager_phone VARCHAR(12) NOT NULL,
PRIMARY KEY(fran_id)
);

CREATE TABLE rocket_racoon.store (
store_id INT NOT NULL,
fk_franchise_id INT NOT NULL, 
store_title VARCHAR(30) NOT NULL,
store_location VARCHAR(100) NOT NULL, 
store_email VARCHAR(100) NOT NULL, 
store_phone VARCHAR(12) NOT NULL, 
store_date DATETIME NOT NULL,
opens_at DATETIME NOT NULL,
closes_at DATETIME NOT NULL,
store_owner VARCHAR(60) NOT NULL, 
PRIMARY KEY(store_id),
FOREIGN KEY(fk_franchise_id) REFERENCES franchise(fran_id)
);

CREATE TABLE rocket_racoon.staff (
staff_id INT NOT NULL,
fk_store_id INT NOT NULL,
staff_name VARCHAR(35) NOT NULL,
staff_surname VARCHAR(35) NOT NULL,
staff_email VARCHAR(100) NOT NULL, 
staff_phone VARCHAR(12) NOT NULL, 
staff_role VARCHAR(50) NOT NULL,
PRIMARY KEY(staff_id),
FOREIGN KEY(fk_store_id) REFERENCES store(store_id)
);

CREATE TABLE rocket_racoon.category (
cat_id INT NOT NULL,
fk_store_id INT NOT NULL,
cat_title VARCHAR(60) NOT NULL, 
cat_desc VARCHAR(255), 
PRIMARY KEY(cat_id),
FOREIGN KEY(fk_store_id) REFERENCES store(store_id)
);

CREATE TABLE rocket_racoon.sub_category (
sub_id INT NOT NULL, 
fk_cat_id INT NOT NULL, 
sub_title VARCHAR(60) NOT NULL,
sub_desc VARCHAR(255),
PRIMARY KEY(sub_id),
FOREIGN KEY(fk_cat_id) REFERENCES category(cat_id)
);

CREATE TABLE rocket_racoon.supplier (
supp_id INT NOT NULL, 
supp_title VARCHAR(60) NOT NULL, 
contact_name VARCHAR(60) NOT NULL, 
contact_email VARCHAR(100) NOT NULL,
contact_phone VARCHAR(12) NOT NULL,
contact_notes VARCHAR(255),
PRIMARY KEY(supp_id)
);

CREATE TABLE rocket_racoon.inventory (
product_id INT NOT NULL,
fk_supp_id INT NOT NULL,
fk_sub_id INT NOT NULL,
product_title VARCHAR(60) NOT NULL,
quantity INT NOT NULL, 
cost DECIMAL(15,2) NOT NULL, 
price DECIMAL(15,2) NOT NULL, 
markup DECIMAL(15,2) NOT NULL, 
created_date DATETIME NOT NULL,
exp_date DATETIME NOT NULL, 
date_in DATETIME NOT NULL, 
product_desc VARCHAR(255), 
PRIMARY KEY(product_id),
FOREIGN KEY(fk_supp_id) REFERENCES supplier(supp_id),
FOREIGN KEY(fk_sub_id) REFERENCES sub_category(sub_id)
);

CREATE TABLE rocket_racoon.product_out (
out_id INT NOT NULL, 
fk_product_id INT NOT NULL,
out_title VARCHAR(30) NOT NULL,
out_date DATETIME NOT NULL,
cost DECIMAL(15,2) NOT NULL, 
price DECIMAL(15,2) NOT NULL, 
markup DECIMAL(15,2) NOT NULL,
reason VARCHAR(255)  NOT NULL, 
PRIMARY KEY(out_id),
FOREIGN KEY(fk_product_id) REFERENCES inventory(product_id)
);
