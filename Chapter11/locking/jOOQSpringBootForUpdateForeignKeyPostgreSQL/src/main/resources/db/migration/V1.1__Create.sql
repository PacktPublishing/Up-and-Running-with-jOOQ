/*
*********************************************************************
http://www.mysqltutorial.org
*********************************************************************
Name: MySQL Sample Database classicmodels
Link: http://www.mysqltutorial.org/mysql-sample-database.aspx
*********************************************************************

This is a modified version of the original schema for PostgreSQL
*/

/* START */
DROP TABLE IF EXISTS payment CASCADE;
DROP TABLE IF EXISTS bank_transaction CASCADE;
DROP TABLE IF EXISTS orderdetail CASCADE;
DROP TABLE IF EXISTS "order" CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS productline CASCADE;
DROP TABLE IF EXISTS top3product CASCADE;
DROP TABLE IF EXISTS productlinedetail CASCADE;
DROP TABLE IF EXISTS office_has_manager CASCADE;
DROP TABLE IF EXISTS manager CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS customerdetail CASCADE;
DROP TABLE IF EXISTS sale CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS department CASCADE;
DROP TABLE IF EXISTS office CASCADE;

DROP SEQUENCE IF EXISTS manager_seq;
DROP SEQUENCE IF EXISTS product_seq;
DROP SEQUENCE IF EXISTS order_seq;
DROP SEQUENCE IF EXISTS sale_seq;
DROP SEQUENCE IF EXISTS customer_seq;

CREATE EXTENSION IF NOT EXISTS hstore;

/*Table structure for table `office` */

CREATE TABLE office (
  office_code varchar(10) NOT NULL,
  city varchar(50),
  phone varchar(50) NOT NULL,
  address_line_first varchar(50) NOT NULL,
  address_line_second varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  country varchar(50),
  postal_code varchar(15) NOT NULL,
  territory varchar(10) NOT NULL,
  location point DEFAULT NULL,
  PRIMARY KEY (office_code)
) ;

/*Table structure for table `department` */

CREATE TABLE department (
  department_id serial NOT NULL,
  name varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  code smallint DEFAULT 1,
  office_code varchar(10) NOT NULL,
  topic text[] DEFAULT NULL,  
  dep_net_ipv4 inet DEFAULT NULL,
  PRIMARY KEY (department_id)
,
  CONSTRAINT department_ibfk_1 FOREIGN KEY (office_code) REFERENCES office (office_code)
) ;

CREATE INDEX office_code_dep ON department (office_code);
ALTER SEQUENCE department_department_id_seq RESTART WITH 10;

/*Table structure for table `employee` */

CREATE TABLE employee (
  employee_number bigint NOT NULL,
  last_name varchar(50) NOT NULL,
  first_name varchar(50) NOT NULL,
  extension varchar(10) NOT NULL,
  email varchar(100) NOT NULL,
  office_code varchar(10) NOT NULL,
  salary int NOT NULL,
  reports_to bigint DEFAULT NULL,
  job_title varchar(50) NOT NULL,
  employee_of_year int[] DEFAULT NULL,
  monthly_bonus int[] DEFAULT NULL,
  PRIMARY KEY (employee_number)
 ,
  CONSTRAINT employees_ibfk_1 FOREIGN KEY (reports_to) REFERENCES employee (employee_number),
  CONSTRAINT employees_ibfk_2 FOREIGN KEY (office_code) REFERENCES office (office_code)
) ;

CREATE INDEX reports_to ON employee (reports_to);
CREATE INDEX office_code ON employee (office_code);

/*Table structure for table `sale` */

CREATE SEQUENCE sale_seq START 1000000;

CREATE TYPE rate_type AS enum('SILVER', 'GOLD', 'PLATINUM');
CREATE TYPE vat_type AS enum('NONE', 'MIN', 'MAX');

CREATE TABLE sale (
  sale_id bigint NOT NULL DEFAULT NEXTVAL ('sale_seq'),  
  fiscal_year int NOT NULL,  
  sale float NOT NULL,  
  employee_number bigint DEFAULT NULL,  
  hot boolean DEFAULT FALSE,
  rate rate_type DEFAULT NULL,
  vat vat_type DEFAULT NULL,
  trend varchar(10) DEFAULT NULL,
  PRIMARY KEY (sale_id)
 ,  
  CONSTRAINT sales_ibfk_1 FOREIGN KEY (employee_number) REFERENCES employee (employee_number) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE INDEX employee_number ON sale (employee_number);

/*Table structure for table `customer` */

CREATE SEQUENCE customer_seq START 1000000;

CREATE TABLE customer (
  customer_number bigint NOT NULL DEFAULT NEXTVAL ('customer_seq'),
  customer_name varchar(50) NOT NULL,
  contact_last_name varchar(50) NOT NULL,
  contact_first_name varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,  
  sales_rep_employee_number bigint DEFAULT NULL,
  credit_limit decimal(10,2) DEFAULT NULL,
  first_buy_date int DEFAULT NULL,
  PRIMARY KEY (customer_number)
 ,
  CONSTRAINT customers_ibfk_1 FOREIGN KEY (sales_rep_employee_number) REFERENCES employee (employee_number) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE INDEX sales_rep_employee_number ON customer (sales_rep_employee_number);

/* Table structure for table `customerdetail` */

CREATE TABLE customerdetail (
  customer_number bigint NOT NULL,
  address_line_first varchar(50) NOT NULL,
  address_line_second varchar(50) DEFAULT NULL,
  city varchar(50),
  state varchar(50) DEFAULT NULL,
  postal_code varchar(15) DEFAULT NULL,
  country varchar(50),
  PRIMARY KEY (customer_number)
  ,  
  CONSTRAINT customers_details_ibfk_1 FOREIGN KEY (customer_number) REFERENCES customer (customer_number)  
) ;

/*Table structure for table `manager` */

/* Define a type using CREATE TYPE */
CREATE TYPE evaluation_criteria AS (communication_ability int, ethics int, performance int, employee_input int);

CREATE SEQUENCE manager_seq START 1000000;

CREATE TABLE manager (
  manager_id bigint NOT NULL DEFAULT NEXTVAL ('manager_seq'),
  manager_name varchar(50) NOT NULL,
  manager_detail json DEFAULT NULL,
  manager_evaluation evaluation_criteria DEFAULT NULL, 
  PRIMARY KEY (manager_id)
) ;

/*Table structure for table `office_has_manager` */

CREATE TABLE office_has_manager (
  offices_office_code varchar(10) REFERENCES office (office_code) ON UPDATE NO ACTION ON DELETE NO ACTION,
  managers_manager_id bigint REFERENCES manager (manager_id) ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT offices_managers_pkey PRIMARY KEY (offices_office_code, managers_manager_id) 
);

CREATE INDEX fk_offices_has_managers_managers_idx ON office_has_manager (managers_manager_id ASC);
CREATE INDEX fk_offices_has_managers_offices_idx ON office_has_manager (offices_office_code ASC);
  
/*Table structure for table `productline` */

CREATE TABLE productline (
  product_line varchar(50) NOT NULL,
  code bigint NOT NULL,
  text_description varchar(4000) DEFAULT NULL,
  html_description xml,
  image bytea,
  created_on date NOT NULL DEFAULT NOW(),
  PRIMARY KEY (product_line, code),
  CONSTRAINT unique_product_line UNIQUE(product_line)
) ;

/*Table structure for table `productdetail` */

CREATE TABLE productlinedetail (
  product_line varchar(50) NOT NULL,
  code bigint NOT NULL,
  line_capacity varchar(20) NOT NULL,
  line_type int DEFAULT 0,
  PRIMARY KEY (product_line,code),  
  CONSTRAINT unique_product_line_detail UNIQUE(product_line),
  CONSTRAINT productlinedetail_ibfk_1 FOREIGN KEY (product_line,code) REFERENCES productline (product_line,code),
  CONSTRAINT productlinedetail_ibfk_2 FOREIGN KEY (product_line) REFERENCES productline (product_line)
) ;

/*Table structure for table `product` */

CREATE SEQUENCE product_seq START 1000000;

CREATE TABLE product (
  product_id bigint NOT NULL DEFAULT NEXTVAL ('product_seq'),
  product_name varchar(70) DEFAULT NULL,
  product_line varchar(50) DEFAULT NULL,
  product_scale varchar(10) DEFAULT NULL,
  product_vendor varchar(50) DEFAULT NULL,
  product_description text DEFAULT NULL,
  quantity_in_stock smallint DEFAULT 0,
  buy_price decimal(10,2) DEFAULT 0.0,
  msrp decimal(10,2) DEFAULT 0.0,
  specs hstore DEFAULT NULL,
  PRIMARY KEY (product_id)
 ,
  CONSTRAINT products_ibfk_1 FOREIGN KEY (product_line) REFERENCES productline (product_line)
) ;

CREATE INDEX product_line ON product (product_line);

/*Table structure for table `order` */

CREATE SEQUENCE order_seq START 1000000;

CREATE TABLE "order" (
  order_id bigint NOT NULL DEFAULT NEXTVAL ('order_seq'),
  order_date date NOT NULL,
  required_date date NOT NULL,
  shipped_date date DEFAULT NULL,
  status varchar(15) NOT NULL,
  comments text,
  customer_number bigint NOT NULL,
  PRIMARY KEY (order_id)
 ,
  CONSTRAINT orders_ibfk_1 FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
) ;

CREATE INDEX customer_number ON "order" (customer_number);

/*Table structure for table `orderdetail` */

CREATE TABLE orderdetail (
  order_id bigint NOT NULL,
  product_id bigint NOT NULL,
  quantity_ordered int NOT NULL,
  price_each decimal(10,2) NOT NULL,
  order_line_number smallint NOT NULL,
  PRIMARY KEY (order_id,product_id)
 ,
  CONSTRAINT orderdetails_ibfk_1 FOREIGN KEY (order_id) REFERENCES "order" (order_id),
  CONSTRAINT orderdetails_ibfk_2 FOREIGN KEY (product_id) REFERENCES product (product_id)
) ;

CREATE INDEX product_id ON orderdetail (product_id);

/*Table structure for table `top3product` */

CREATE TABLE top3product (  
  product_id bigint NOT NULL,
  product_name varchar(70) DEFAULT NULL,  
  PRIMARY KEY (product_id),  
  CONSTRAINT top3product_ibfk_1 FOREIGN KEY (product_id) REFERENCES product (product_id)
) ;

/*Table structure for table `payment` */

CREATE TABLE payment (
  customer_number bigint NOT NULL,
  check_number varchar(50) NOT NULL,
  payment_date timestamp NOT NULL,
  invoice_amount decimal(10,2) NOT NULL,
  caching_date timestamp DEFAULT NULL,
  PRIMARY KEY (customer_number,check_number),
  CONSTRAINT unique_check_number UNIQUE(check_number),
  CONSTRAINT payments_ibfk_1 FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
) ;

/* Table structure for table 'bank_transaction' */

CREATE TABLE bank_transaction (
  transaction_id serial NOT NULL,
  bank_name varchar(50) NOT NULL,
  bank_iban varchar(50) NOT NULL,  
  transfer_amount decimal(10,2) NOT NULL,
  caching_date timestamp NOT NULL DEFAULT NOW(),
  customer_number bigint NOT NULL,
  check_number varchar(50) NOT NULL, 
  status varchar(50) NOT NULL DEFAULT 'SUCCESS',   
  PRIMARY KEY (transaction_id),    
  CONSTRAINT bank_transaction_ibfk_1 FOREIGN KEY (customer_number,check_number) REFERENCES payment (customer_number,check_number)
) ;

ALTER SEQUENCE bank_transaction_transaction_id_seq RESTART WITH 100;

/* USER-DEFINED FUNCTIONS */

CREATE OR REPLACE FUNCTION get_avg_sale(len_from int, len_to int) 
  RETURNS int LANGUAGE plpgsql AS $$ 
DECLARE avg_count integer; 
BEGIN 
  SELECT avg(sale.sale) 
  INTO   avg_count 
  FROM   sale 
  WHERE  sale.sale BETWEEN len_from AND len_to; 
   
  RETURN avg_count; 
END; 
$$;

CREATE OR REPLACE FUNCTION top_three_sales_per_employee(employee_nr bigint)
  RETURNS TABLE(sales float) LANGUAGE plpgsql AS $$ 
BEGIN
    RETURN QUERY
    SELECT 
      "public"."sale"."sale" AS "sales" 
    FROM 
      "public"."sale" 
    WHERE 
      employee_nr = "public"."sale"."employee_number" 
    ORDER BY
      "public"."sale"."sale" DESC
    LIMIT 3;     
END; 
$$;

/* END */