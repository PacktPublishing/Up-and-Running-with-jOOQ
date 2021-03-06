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
DROP TABLE IF EXISTS daily_activity CASCADE;
DROP TABLE IF EXISTS token CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS employee_status CASCADE;
DROP TABLE IF EXISTS department CASCADE;
DROP TABLE IF EXISTS office CASCADE;
DROP TABLE IF EXISTS office_flights CASCADE;

DROP SEQUENCE IF EXISTS manager_seq;
DROP SEQUENCE IF EXISTS product_seq;
DROP SEQUENCE IF EXISTS order_seq;
DROP SEQUENCE IF EXISTS sale_seq;
DROP SEQUENCE IF EXISTS customer_seq;

CREATE EXTENSION IF NOT EXISTS hstore;

/*Table structure for table `office` */

-- this is not present in the rest of schemas
CREATE DOMAIN postal_code AS varchar(15)
CHECK(
   VALUE ~ '^\d{5}$'
OR VALUE ~ '^[A-Z]{2}[0-9]{3}[A-Z]{2}$'
);

CREATE TABLE office (
  office_code varchar(10) NOT NULL,
  city varchar(50),
  phone varchar(50) NOT NULL,
  address_line_first varchar(50) NOT NULL,
  address_line_second varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  country varchar(50),
  postal_code postal_code NOT NULL,
  territory varchar(10) NOT NULL,
  location point DEFAULT NULL,
  internal_budget int NOT NULL, 
  CONSTRAINT office_pk PRIMARY KEY (office_code),
  CONSTRAINT office_postal_code_uk UNIQUE (postal_code)
) ;

/*Table structure for table `department` */

CREATE TABLE department (
  department_id serial NOT NULL,
  name varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  code smallint NOT NULL,
  office_code varchar(10) NOT NULL,
  topic text[] DEFAULT NULL,  
  dep_net_ipv4 inet DEFAULT NULL,
  local_budget float DEFAULT NULL,
  profit float DEFAULT NULL,
  forecast_profit float DEFAULT NULL,
  cash float DEFAULT NULL,
  accounts_receivable float DEFAULT NULL,
  inventories float DEFAULT NULL,
  accounts_payable float DEFAULT NULL,
  st_borrowing float DEFAULT NULL,
  accrued_liabilities float DEFAULT NULL,
  CONSTRAINT department_pk PRIMARY KEY (department_id),
  CONSTRAINT department_code_uk UNIQUE (code)
,
  CONSTRAINT department_office_fk FOREIGN KEY (office_code) REFERENCES office (office_code)
) ;

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
  commission int DEFAULT NULL,
  reports_to bigint DEFAULT NULL,
  job_title varchar(50) NOT NULL,
  employee_of_year int[] DEFAULT NULL,
  monthly_bonus int[] DEFAULT NULL,
  CONSTRAINT employee_pk PRIMARY KEY (employee_number)
 ,
  CONSTRAINT employee_employee_fk FOREIGN KEY (reports_to) REFERENCES employee (employee_number),
  CONSTRAINT employees_office_fk FOREIGN KEY (office_code) REFERENCES office (office_code)
) ;

CREATE SEQUENCE employee_seq START 100000 INCREMENT 10 MINVALUE 100000 MAXVALUE 10000000 OWNED BY employee.employee_number;

/*Table structure for table `employee_status` */

CREATE TABLE employee_status (
  id serial NOT NULL,
  employee_number bigint NOT NULL,  
  status varchar(50) NOT NULL,  
  acquired_date date NOT NULL,
  CONSTRAINT id_pk PRIMARY KEY (id),  
  CONSTRAINT employee_status_employee_fk FOREIGN KEY (employee_number) REFERENCES employee (employee_number)
);

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
  fiscal_month int NOT NULL,
  revenue_growth float NOT NULL,
  trend varchar(10) DEFAULT NULL,
  CONSTRAINT sale_pk PRIMARY KEY (sale_id)
 ,  
  CONSTRAINT sale_employee_fk FOREIGN KEY (employee_number) REFERENCES employee (employee_number) ON UPDATE CASCADE
) ;

/*Table structure for table `daily_activity` */

CREATE TABLE daily_activity (
  day_id serial NOT NULL, 
  day_date date NOT NULL,
  sales float NOT NULL,  
  visitors float NOT NULL,    
  conversion float NOT NULL,
  CONSTRAINT daily_activity_pk PRIMARY KEY (day_id)
);

/*Table structure for table `token` */

CREATE SEQUENCE token_seq START 1000000;

CREATE TABLE token (
  token_id bigint NOT NULL DEFAULT NEXTVAL ('sale_seq'),    
  sale_id bigint NOT NULL,
  amount float NOT NULL,   
  updated_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT token_pk PRIMARY KEY (token_id)
 ,  
  CONSTRAINT token_sale_fk FOREIGN KEY (sale_id) REFERENCES sale (sale_id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

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
  CONSTRAINT customer_pk PRIMARY KEY (customer_number),
  CONSTRAINT customer_name_uk UNIQUE (customer_name)
 ,
  CONSTRAINT customer_employee_fk FOREIGN KEY (sales_rep_employee_number) REFERENCES employee (employee_number) ON UPDATE CASCADE
) ;

/* Table structure for table `customerdetail` */

CREATE TABLE customerdetail (
  customer_number bigint NOT NULL,
  address_line_first varchar(50) NOT NULL,
  address_line_second varchar(50) DEFAULT NULL,
  city varchar(50),
  state varchar(50) DEFAULT NULL,
  postal_code varchar(15) DEFAULT NULL,
  country varchar(50),
  CONSTRAINT customerdetail_pk PRIMARY KEY (customer_number),
  CONSTRAINT customer_address_line_first_uk UNIQUE (address_line_first)
  ,  
  CONSTRAINT customerdetail_customer_fk FOREIGN KEY (customer_number) REFERENCES customer (customer_number)  
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
  CONSTRAINT manager_pk PRIMARY KEY (manager_id)
) ;

/*Table structure for table `office_has_manager` */

CREATE TABLE office_has_manager (
  offices_office_code varchar(10) NOT NULL,
  managers_manager_id bigint NOT NULL,
  CONSTRAINT office_manager_uk UNIQUE (offices_office_code, managers_manager_id),
  CONSTRAINT office_fk FOREIGN KEY (offices_office_code) REFERENCES office (office_code) ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT manager_fk FOREIGN KEY (managers_manager_id) REFERENCES manager (manager_id) ON UPDATE NO ACTION ON DELETE NO ACTION  
);
  
/*Table structure for table `productline` */

CREATE TABLE productline (
  product_line varchar(50) NOT NULL,
  code bigint NOT NULL,
  text_description varchar(4000) DEFAULT NULL,
  html_description xml,
  image bytea,
  created_on date NOT NULL DEFAULT NOW(),
  CONSTRAINT productline_pk PRIMARY KEY (product_line, code),
  CONSTRAINT productline_uk UNIQUE(product_line)
) ;

/*Table structure for table `productdetail` */

CREATE TABLE productlinedetail (
  product_line varchar(50) NOT NULL,
  code bigint NOT NULL,
  line_capacity varchar(20) NOT NULL,
  line_type int DEFAULT 0,
  CONSTRAINT productlinedetail_pk PRIMARY KEY (product_line,code),  
  CONSTRAINT productlinedetail_uk UNIQUE(product_line),
  CONSTRAINT productlinedetail_fk FOREIGN KEY (product_line,code) REFERENCES productline (product_line,code)
) ;

/*Table structure for table `product` */

CREATE SEQUENCE product_seq START 1000000;

CREATE TABLE product (
  product_id bigint NOT NULL DEFAULT NEXTVAL ('product_seq'),
  product_name varchar(70) DEFAULT NULL,
  product_line varchar(50) DEFAULT NULL,
  code bigint NOT NULL,
  product_scale varchar(10) DEFAULT NULL,
  product_vendor varchar(50) DEFAULT NULL,
  product_description text DEFAULT NULL,
  quantity_in_stock int DEFAULT 0,
  buy_price decimal(10,2) NOT NULL DEFAULT 0.0,
  msrp decimal(10,2) NOT NULL DEFAULT 0.0,
  specs hstore DEFAULT NULL,
  product_uid bigint GENERATED BY DEFAULT AS IDENTITY (START WITH 10 INCREMENT BY 10),
  CONSTRAINT product_pk PRIMARY KEY (product_id)
 ,
  CONSTRAINT product_productline_fk FOREIGN KEY (product_line,code) REFERENCES productline (product_line,code)
) ;

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
  amount decimal(10,2) NOT NULL,
  CONSTRAINT order_pk PRIMARY KEY (order_id)
 ,
  CONSTRAINT order_customer_fk FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
) ;

/*Table structure for table `orderdetail` */

CREATE TABLE orderdetail (
  orderdetail_id serial NOT NULL, 
  order_id bigint NOT NULL,
  product_id bigint NOT NULL,
  quantity_ordered int NOT NULL,
  price_each decimal(10,2) NOT NULL,
  order_line_number smallint NOT NULL,
  CONSTRAINT orderdetail_pk PRIMARY KEY (orderdetail_id),
  CONSTRAINT orderdetail_uk UNIQUE (order_id, product_id),
  CONSTRAINT orderdetail_order_fk FOREIGN KEY (order_id) REFERENCES "order" (order_id),
  CONSTRAINT orderdetail_product_fk FOREIGN KEY (product_id) REFERENCES product (product_id)
) ;

/*Table structure for table `top3product` */

CREATE TABLE top3product (  
  product_id bigint NOT NULL,
  product_name varchar(70) DEFAULT NULL,  
  CONSTRAINT top3product_pk PRIMARY KEY (product_id),  
  CONSTRAINT top3product_product_fk FOREIGN KEY (product_id) REFERENCES product (product_id)
) ;

/*Table structure for table `payment` */

CREATE TABLE payment (
  customer_number bigint NOT NULL,
  check_number varchar(50) NOT NULL,
  payment_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  invoice_amount decimal(10,2) NOT NULL,
  caching_date timestamp DEFAULT NULL,
  version int NOT NULL DEFAULT 0,
  modified timestamp NOT NULL DEFAULT NOW(),
  CONSTRAINT payment_pk PRIMARY KEY (customer_number,check_number),
  CONSTRAINT check_number_uk UNIQUE(check_number),
  CONSTRAINT payment_customer_fk FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
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
  card_type varchar(50) NOT NULL, 
  status varchar(50) NOT NULL DEFAULT 'SUCCESS',   
  CONSTRAINT bank_transaction_pk PRIMARY KEY (transaction_id),    
  CONSTRAINT bank_transaction_customer_fk FOREIGN KEY (customer_number,check_number) REFERENCES payment (customer_number,check_number)
);

ALTER SEQUENCE bank_transaction_transaction_id_seq RESTART WITH 100;

/*Table structure for table `office_flights` */

CREATE TABLE office_flights (  
  depart_town varchar(32) NOT NULL,
  arrival_town varchar(32) NOT NULL,
  distance_km integer NOT NULL,
  CONSTRAINT office_flights_pk PRIMARY KEY (depart_town, arrival_town)
);

/* USER-DEFINED FUNCTIONS */

CREATE OR REPLACE FUNCTION make_array(anyelement, anyelement) RETURNS anyarray AS $$
    SELECT ARRAY[$1, $2];
$$ LANGUAGE SQL;

CREATE FUNCTION dup (f1 anyelement, OUT f2 anyelement, OUT f3 anyarray)
AS 'select $1, array[$1,$1]' LANGUAGE SQL;

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

create or replace function get_salary_stat(
    out min_sal int,
    out max_sal int,
    out avg_sal numeric) 
language plpgsql
as $$
begin
  
  select min(salary),
         max(salary),
		 avg(salary)::numeric(7,2)
  into min_sal, max_sal, avg_sal
  from employee;

end;
$$;

create or replace function swap(
	inout x int,
	inout y int
) 
language plpgsql	
as $$
begin
   select x,y into y,x;
end; 
$$;

CREATE FUNCTION update_msrp (product_id bigint, debit integer) RETURNS integer AS $$
    UPDATE product
        SET msrp = msrp - debit
        WHERE product_id = update_msrp.product_id
    RETURNING msrp;
$$ LANGUAGE SQL;

CREATE OR REPLACE FUNCTION net_price_each(
    quantity INT,
    list_price DECIMAL(10,2),
    discount DECIMAL(4,2)
)
RETURNS DECIMAL(10,2) LANGUAGE plpgsql AS $$ 
BEGIN
    RETURN quantity * list_price * (1 - discount);
END;
$$;

CREATE OR REPLACE FUNCTION get_customer(cl INT) RETURNS refcursor AS $$
    DECLARE
      cur refcursor;                                                   
    BEGIN
      OPEN cur FOR SELECT * FROM customer WHERE credit_limit > cl ORDER BY customer_name;   
      RETURN cur;                                    
    END;
    $$ LANGUAGE plpgsql;
	
-- Procedure that returns multiple result sets (cursors)
   CREATE OR REPLACE FUNCTION get_offices_multiple() RETURNS SETOF refcursor AS $$
    DECLARE
      ref1 refcursor;           
      ref2 refcursor;                             
    BEGIN
      OPEN ref1 FOR SELECT city, country FROM office WHERE internal_budget < 100000;  
      RETURN NEXT ref1;                                                 
 
      OPEN ref2 FOR SELECT city, country FROM office WHERE internal_budget > 100000;  
      RETURN NEXT ref2;                                                 
    END;
    $$ LANGUAGE plpgsql;	
	  
CREATE OR REPLACE FUNCTION employee_office_array(VARCHAR(10))
RETURNS bigint[] AS $$
  SELECT ARRAY(SELECT "public"."employee"."employee_number"
      FROM "public"."employee" WHERE "public"."employee"."office_code" = $1)
$$
LANGUAGE SQL;

CREATE OR REPLACE FUNCTION department_topic_arr(id bigint)
RETURNS text[] AS $$
  SELECT "public"."department"."topic"
      FROM "public"."department" WHERE "public"."department"."department_id" = id
$$
LANGUAGE SQL;

CREATE OR REPLACE FUNCTION net_price_each(
    quantity INT,
    list_price DECIMAL(10,2),
    discount DECIMAL(4,2)
)
RETURNS DECIMAL(10,2) LANGUAGE plpgsql AS $$ 
BEGIN
    RETURN quantity * list_price * (1 - discount);
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

CREATE OR REPLACE FUNCTION product_of_product_line(p_line_in varchar(50))
  RETURNS TABLE(p_id bigint, p_name varchar(70), p_line varchar(50)) LANGUAGE plpgsql AS $$ 
BEGIN
    RETURN QUERY
    SELECT 
      "public"."product"."product_id" AS "p_id",
      "public"."product"."product_name" AS "p_name",
	  "public"."product"."product_line" AS "p_line"
    FROM 
      "public"."product" 
    WHERE 
      p_line_in = "public"."product"."product_line";     
END; 
$$;

-- VIEWS
CREATE OR REPLACE VIEW customer_master AS
SELECT "public"."customer"."customer_name",
       "public"."customer"."credit_limit",
       "public"."customerdetail"."city",
       "public"."customerdetail"."country",
       "public"."customerdetail"."address_line_first",
       "public"."customerdetail"."postal_code",
       "public"."customerdetail"."state"
FROM "public"."customer"
JOIN "public"."customerdetail" ON "public"."customerdetail"."customer_number" = "public"."customer"."customer_number"
WHERE "public"."customer"."first_buy_date" IS NOT NULL;

CREATE OR REPLACE VIEW office_master AS
SELECT "public"."office"."office_code",
       "public"."office"."city",
       "public"."office"."country",
       "public"."office"."state",
       "public"."office"."phone",
       "public"."office"."postal_code"
FROM "public"."office"
WHERE "public"."office"."city" IS NOT NULL;

CREATE OR REPLACE VIEW product_master AS
SELECT "public"."product"."product_line",
       "public"."product"."product_name",
       "public"."product"."product_scale"       
FROM "public"."product";
/* END */