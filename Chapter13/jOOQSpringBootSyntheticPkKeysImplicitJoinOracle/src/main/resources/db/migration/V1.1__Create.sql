/*
*********************************************************************
http://www.mysqltutorial.org
*********************************************************************
Name: MySQL Sample Database classicmodels
Link: http://www.mysqltutorial.org/mysql-sample-database.aspx
*********************************************************************

This is a modified version of the original schema for Oracle
*/

/* START */

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "PAYMENT" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "BANK_TRANSACTION" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "ORDERDETAIL" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "ORDER" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "PRODUCT" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "PRODUCTLINE" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "TOP3PRODUCT" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "PRODUCTLINEDETAIL" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "OFFICE_HAS_MANAGER" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "MANAGER" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "CUSTOMER" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "CUSTOMERDETAIL" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "TOKEN" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "SALE" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "EMPLOYEE" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "DEPARTMENT" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE "OFFICE" CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
COMMIT;

/*Table structure for table `office` */

CREATE TABLE office (
  office_code varchar2(10) NOT NULL,
  city varchar2(50),
  phone varchar2(50) NOT NULL,
  address_line_first varchar2(50) NOT NULL,
  address_line_second varchar2(50) DEFAULT NULL,
  state varchar2(50) DEFAULT NULL,
  country varchar2(50),
  postal_code varchar2(15) NOT NULL,
  territory varchar2(10) NOT NULL,
  location sdo_geometry DEFAULT NULL,
  CONSTRAINT office_pk PRIMARY KEY (office_code),
  CONSTRAINT office_postal_code_uk UNIQUE (postal_code)
) ;

/*Table structure for table `employee` */

BEGIN
   EXECUTE IMMEDIATE 'CREATE TYPE employeeOfYearArr AS VARRAY(100) OF INTEGER;';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'CREATE TYPE monthlyBonusArr AS VARRAY(100) OF INTEGER;';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE employee (
  employee_number number(10) NOT NULL,
  last_name varchar2(50) NOT NULL,
  first_name varchar2(50) NOT NULL,
  extension varchar2(10) NOT NULL,
  email varchar2(100) NOT NULL,
  office_code varchar2(10) NOT NULL,
  salary int NOT NULL,
  reports_to number(10) DEFAULT NULL,
  job_title varchar2(50) NOT NULL,
  employee_of_year employeeOfYearArr DEFAULT NULL,
  monthly_bonus monthlyBonusArr DEFAULT NULL,
  CONSTRAINT employee_pk PRIMARY KEY (employee_number)
 ,
  CONSTRAINT employee_employee_fk FOREIGN KEY (reports_to) REFERENCES employee (employee_number),
  CONSTRAINT employee_office_fk FOREIGN KEY (office_code) REFERENCES office (office_code)
) ;

-- Generate ID using sequence
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "EMPLOYEE_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE employee_seq START WITH 100000 INCREMENT BY 10 MINVALUE 100000 MAXVALUE 10000000000;

/*Table structure for table `sale` */

CREATE TABLE sale (
  sale_id number(20) NOT NULL, 
  fiscal_year int NOT NULL, 
  sale float NOT NULL,    
  employee_number number(10) DEFAULT NULL,  
  hot number(1,0) DEFAULT 0,
  rate varchar2(10) DEFAULT NULL,
  vat varchar2(10) DEFAULT NULL,
  trend varchar2(10) DEFAULT NULL,
  sale_index number(10) NOT NULL,
  CONSTRAINT sale_pk PRIMARY KEY (sale_id)
,  
  CONSTRAINT sale_employee_fk FOREIGN KEY (employee_number) REFERENCES employee (employee_number),
  CONSTRAINT enum_rate_check CHECK (rate IN('SILVER', 'GOLD', 'PLATINUM')),
  CONSTRAINT enum_vat_check CHECK (vat IN('NONE', 'MIN', 'MAX'))
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "SALE_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE sale_seq START WITH 1000000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER sale_seq_tr
 BEFORE INSERT ON sale FOR EACH ROW
 WHEN (NEW.sale_id IS NULL)
BEGIN
 SELECT sale_seq.NEXTVAL INTO :NEW.sale_id FROM DUAL;
END;
/

-- Generate an IDENTITY, non-primary key
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "SALE_INDEX_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE sale_index_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER sale_index_seq_tr
 BEFORE INSERT ON sale FOR EACH ROW
 WHEN (NEW.sale_index IS NULL)
BEGIN
 SELECT sale_index_seq.NEXTVAL INTO :NEW.sale_index FROM DUAL;
END;
/

/*Table structure for table token */

CREATE TABLE token (
  token_id number(20) NOT NULL,    
  sale_id number(20) NOT NULL,
  amount float NOT NULL,    
  updated_on timestamp DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT token_pk PRIMARY KEY (token_id)
 ,  
  CONSTRAINT token_sale_fk FOREIGN KEY (sale_id) REFERENCES sale (sale_id) ON DELETE CASCADE
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "TOKEN_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE token_seq START WITH 1000000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER token_seq_tr
 BEFORE INSERT ON token FOR EACH ROW
 WHEN (NEW.token_id IS NULL)
BEGIN
 SELECT token_seq.NEXTVAL INTO :NEW.token_id FROM DUAL;
END;
/

/*Table structure for table `customer` */

CREATE TABLE customer (
  customer_number number(10) NOT NULL,
  customer_name varchar2(50) NOT NULL,
  contact_last_name varchar2(50) NOT NULL,
  contact_first_name varchar2(50) NOT NULL,
  phone varchar2(50) NOT NULL,
  sales_rep_employee_number number(10) DEFAULT NULL,
  credit_limit number(10,2) DEFAULT NULL,
  first_buy_date int DEFAULT NULL,
  CONSTRAINT customer_pk PRIMARY KEY (customer_number),
  CONSTRAINT customer_name_uk UNIQUE (customer_name)
 ,
  CONSTRAINT customer_employee_fk FOREIGN KEY (sales_rep_employee_number) REFERENCES employee (employee_number)
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "CUSTOMER_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE customer_seq START WITH 1000000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER customer_seq_tr
 BEFORE INSERT ON customer FOR EACH ROW
 WHEN (NEW.customer_number IS NULL)
BEGIN
 SELECT customer_seq.NEXTVAL INTO :NEW.customer_number FROM DUAL;
END;
/

/*Table structure for table `customerdetail` */

CREATE TABLE customerdetail (
  customer_number number(10) NOT NULL,
  address_line_first varchar2(50) NOT NULL,
  address_line_second varchar2(50) DEFAULT NULL,
  city varchar2(50),
  state varchar2(50) DEFAULT NULL,
  postal_code varchar2(15) DEFAULT NULL,
  country varchar2(50),
  CONSTRAINT customerdetail_pk PRIMARY KEY (customer_number),
  CONSTRAINT customerdetail_address_line_first_uk UNIQUE (address_line_first)
 ,
  CONSTRAINT customerdetail_customer_fk FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
) ; 

/* Table structure for table `department` */

BEGIN
   EXECUTE IMMEDIATE 'CREATE TYPE topicArr AS VARRAY(100) OF VARCHAR2(100 CHAR);';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE department (
  department_id number(10) NOT NULL,
  name varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  code number(5) DEFAULT 1,
  office_code varchar(10) NOT NULL,
  topic topicArr DEFAULT NULL,  
  dep_net_ipv4 varchar(16) DEFAULT NULL,
  CONSTRAINT department_pk PRIMARY KEY (department_id),
  CONSTRAINT department_code_uk UNIQUE (code)
,
  CONSTRAINT department_office_fk FOREIGN KEY (office_code) REFERENCES office (office_code)
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "DEPARTMENT_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE department_seq START WITH 10 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER department_seq_tr
 BEFORE INSERT ON department FOR EACH ROW
 WHEN (NEW.department_id IS NULL)
BEGIN
 SELECT department_seq.NEXTVAL INTO :NEW.department_id FROM DUAL;
END;
/

/*Table structure for table `manager` */

/* Define a type using CREATE TYPE */
BEGIN
   EXECUTE IMMEDIATE 'CREATE OR REPLACE TYPE evaluation_criteria AS OBJECT (
   communication_ability number(6), ethics number(6), performance number(6), employee_input number(6))';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
COMMIT;

CREATE TABLE manager (
  manager_id number(10) NOT NULL,
  manager_name varchar2(50) NOT NULL,  
  manager_detail varchar2(4000),  
  -- for large JSON, use manager_detail blob,
  manager_evaluation evaluation_criteria DEFAULT NULL, 
  CONSTRAINT manager_pk PRIMARY KEY (manager_id),
  CONSTRAINT ENSURE_JSON CHECK (manager_detail IS JSON)
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "MANAGER_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE manager_seq START WITH 1000000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER manager_seq_tr
 BEFORE INSERT ON manager FOR EACH ROW
 WHEN (NEW.manager_id IS NULL)
BEGIN
 SELECT manager_seq.NEXTVAL INTO :NEW.manager_id FROM DUAL;
END;
/

/*Table structure for table `office_has_manager` */

CREATE TABLE office_has_manager (
  offices_office_code varchar2(10) NOT NULL,
  managers_manager_id number(10) NOT NULL,
  CONSTRAINT office_manager_uk UNIQUE (offices_office_code, managers_manager_id),
  CONSTRAINT office_fk FOREIGN KEY (offices_office_code) REFERENCES office (office_code),
  CONSTRAINT manager_fk FOREIGN KEY (managers_manager_id) REFERENCES manager (manager_id)  
);

/*Table structure for table `productline` */

CREATE TABLE productline (
  product_line varchar2(50) NOT NULL,
  code number(10) NOT NULL,
  text_description varchar2(4000) DEFAULT NULL,
  html_description xmltype,
  image blob,
  created_on date DEFAULT SYSDATE NOT NULL,
  CONSTRAINT productline_pk PRIMARY KEY (product_line, code),
  CONSTRAINT productline_uk UNIQUE(product_line)
);

/*Table structure for table `productdetail` */

CREATE TABLE productlinedetail (
  product_line varchar2(50) NOT NULL,
  code number(10) NOT NULL,
  line_capacity varchar2(20) NOT NULL,
  line_type number(1) DEFAULT 0,
  CONSTRAINT productlinedetail_pk PRIMARY KEY (product_line,code),  
  CONSTRAINT productlinedetail_uk UNIQUE(product_line),
  CONSTRAINT productlinedetail_productline_fk FOREIGN KEY (product_line,code) REFERENCES productline (product_line,code)
) ;

/*Table structure for table `product` */

CREATE TABLE product (
  product_id number(10) NOT NULL,
  product_name varchar2(70) DEFAULT NULL,
  product_line varchar2(50) DEFAULT NULL,
  code number(10) NOT NULL,
  product_scale varchar2(10) DEFAULT NULL,
  product_vendor varchar2(50) DEFAULT NULL,
  product_description clob DEFAULT NULL,
  quantity_in_stock number(5) DEFAULT 0,
  buy_price number(10,2) DEFAULT 0.0,
  msrp number(10,2) DEFAULT 0.0,
  specs clob DEFAULT NULL,
  CONSTRAINT product_pk PRIMARY KEY (product_id)
 ,
  CONSTRAINT product_productline_fk FOREIGN KEY (product_line, code) REFERENCES productline (product_line, code)
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "PRODUCT_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE product_seq START WITH 1000000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER product_seq_tr
 BEFORE INSERT ON product FOR EACH ROW
 WHEN (NEW.product_id IS NULL)
BEGIN
 SELECT product_seq.NEXTVAL INTO :NEW.product_id FROM DUAL;
END;
/

/*Table structure for table `order` */

CREATE TABLE "ORDER" (
  order_id number(10) NOT NULL,
  order_date date NOT NULL,
  required_date date NOT NULL,
  shipped_date date DEFAULT NULL,
  status varchar2(15) NOT NULL,
  comments clob,
  customer_number number(10) NOT NULL,
  CONSTRAINT order_pk PRIMARY KEY (order_id)
 ,
  CONSTRAINT order_customer_fk FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
);

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "ORDER_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE order_seq START WITH 1000000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER order_seq_tr
 BEFORE INSERT ON "ORDER" FOR EACH ROW
 WHEN (NEW.order_id IS NULL)
BEGIN
 SELECT order_seq.NEXTVAL INTO :NEW.order_id FROM DUAL;
END;
/

/*Table structure for table `orderdetail` */

CREATE TABLE orderdetail (
  orderdetail_id number(10) NOT NULL,
  order_id number(10) NOT NULL,
  product_id number(10) NOT NULL,
  quantity_ordered number(10) NOT NULL,
  price_each number(10,2) NOT NULL,
  order_line_number number(5) NOT NULL,
  CONSTRAINT orderdetail_pk PRIMARY KEY (orderdetail_id)
 ,
  CONSTRAINT orderdetail_order_fk FOREIGN KEY (order_id) REFERENCES "ORDER" (order_id),
  CONSTRAINT orderdetail_product__fk FOREIGN KEY (product_id) REFERENCES product (product_id)
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "ORDERDETAIL_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE orderdetail_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER orderdetail_seq_tr
 BEFORE INSERT ON "ORDERDETAIL" FOR EACH ROW
 WHEN (NEW.orderdetail_id IS NULL)
BEGIN
 SELECT orderdetail_seq.NEXTVAL INTO :NEW.orderdetail_id FROM DUAL;
END;
/

/*Table structure for table `top3product` */

CREATE TABLE top3product (  
  product_id number(10) NOT NULL,
  product_name varchar2(70) DEFAULT NULL,  
  CONSTRAINT top3product_pk PRIMARY KEY (product_id),  
  CONSTRAINT top3product_product_fk FOREIGN KEY (product_id) REFERENCES product (product_id)
) ;

/*Table structure for table `payment` */

CREATE TABLE payment (
  customer_number number(10) NOT NULL,
  check_number varchar2(50) NOT NULL,
  payment_date timestamp DEFAULT CURRENT_TIMESTAMP,
  invoice_amount number(10,2) NOT NULL,
  caching_date timestamp DEFAULT NULL,
  version int DEFAULT 0,
  modified timestamp DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT payment_pk PRIMARY KEY (customer_number,check_number),
  CONSTRAINT check_number_uk UNIQUE (check_number),
  CONSTRAINT payment_customer_fk FOREIGN KEY (customer_number) REFERENCES customer (customer_number)
) ;

/* Table structure for table 'bank_transaction' */

CREATE TABLE bank_transaction (
  transaction_id number(10) NOT NULL,
  bank_name varchar2(50) NOT NULL,
  bank_iban varchar2(50) NOT NULL,  
  transfer_amount number(10,2) NOT NULL,
  caching_date timestamp DEFAULT SYSTIMESTAMP,
  customer_number number(10) NOT NULL,
  check_number varchar2(50) NOT NULL, 
  status varchar(50) DEFAULT 'SUCCESS',
  CONSTRAINT bank_transaction_pk PRIMARY KEY (transaction_id),  
  CONSTRAINT bank_transaction_customer_fk FOREIGN KEY (customer_number,check_number) REFERENCES payment (customer_number,check_number)
) ;

-- Generate ID using sequence and trigger
BEGIN
   EXECUTE IMMEDIATE 'DROP SEQUENCE "BANK_TRANSACTION_SEQ"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE bank_transaction_seq START WITH 100 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER bank_transaction_seq_tr
 BEFORE INSERT ON bank_transaction FOR EACH ROW
 WHEN (NEW.transaction_id IS NULL)
BEGIN
 SELECT bank_transaction_seq.NEXTVAL INTO :NEW.transaction_id FROM DUAL;
END;
/

COMMIT;

/* USER-DEFINED FUNCTIONS */

CREATE OR REPLACE FUNCTION get_total_sales(
    in_year PLS_INTEGER
) 
RETURN NUMBER
IS
    l_total_sales NUMBER := 0;
BEGIN
    -- get total sales
    SELECT SUM(PRICE_EACH * QUANTITY_ORDERED)
    INTO l_total_sales
    FROM ORDERDETAIL
    INNER JOIN "ORDER" USING (ORDER_ID)
    WHERE STATUS = 'Shipped'
    GROUP BY EXTRACT(YEAR FROM ORDER_DATE)
    HAVING EXTRACT(YEAR FROM ORDER_DATE) = in_year;
    
    -- return the total sales
    RETURN l_total_sales;
END;
/

-- Create Object of your table
BEGIN
   EXECUTE IMMEDIATE 'CREATE TYPE TABLE_RES_OBJ AS OBJECT (SALES FLOAT);';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

--Create a type of your object 
BEGIN
   EXECUTE IMMEDIATE 'CREATE TYPE TABLE_RES AS TABLE OF TABLE_RES_OBJ;';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE OR REPLACE NONEDITIONABLE FUNCTION top_three_sales_per_employee (
    employee_nr IN NUMBER
) RETURN TABLE_RES IS
    table_result TABLE_RES;
BEGIN
    SELECT
        TABLE_RES_OBJ("SYSTEM"."SALE"."SALE") "sales"
    BULK COLLECT
    INTO table_result
    FROM
        "SYSTEM"."SALE"
    WHERE
        employee_nr = "SYSTEM"."SALE"."EMPLOYEE_NUMBER"
    ORDER BY
        "SYSTEM"."SALE"."SALE" DESC
    FETCH NEXT 3 ROWS ONLY;

    RETURN table_result;
END;
/

-- VIEWS
CREATE OR REPLACE VIEW CUSTOMER_MASTER AS
SELECT "SYSTEM"."CUSTOMER"."CUSTOMER_NAME",
       "SYSTEM"."CUSTOMER"."CREDIT_LIMIT",
       "SYSTEM"."CUSTOMERDETAIL"."CITY",
       "SYSTEM"."CUSTOMERDETAIL"."COUNTRY",
       "SYSTEM"."CUSTOMERDETAIL"."ADDRESS_LINE_FIRST",
       "SYSTEM"."CUSTOMERDETAIL"."POSTAL_CODE",
       "SYSTEM"."CUSTOMERDETAIL"."STATE"
FROM "SYSTEM"."CUSTOMER"
JOIN "SYSTEM"."CUSTOMERDETAIL" ON "SYSTEM"."CUSTOMERDETAIL"."CUSTOMER_NUMBER" = "SYSTEM"."CUSTOMER"."CUSTOMER_NUMBER"
WHERE "SYSTEM"."CUSTOMER"."FIRST_BUY_DATE" IS NOT NULL;

CREATE OR REPLACE VIEW OFFICE_MASTER AS
SELECT "SYSTEM"."OFFICE"."CITY",
       "SYSTEM"."OFFICE"."COUNTRY",
       "SYSTEM"."OFFICE"."STATE",
       "SYSTEM"."OFFICE"."PHONE",
	   "SYSTEM"."OFFICE"."POSTAL_CODE"
FROM "SYSTEM"."OFFICE"
WHERE "SYSTEM"."OFFICE"."CITY" IS NOT NULL;

/* END */
/* END */