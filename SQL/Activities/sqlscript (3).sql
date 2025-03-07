REM   Script: Activity 6,7,8
REM   Activity 6-8

select SUM(purchase_amount) AS "Total sum" from orders;

select SUM(purchase_amount) AS "Total sum" from ORDERS;

select AVG(purchase_amount) AS "Average" from ORDERS;

select MAX(purchase_amount) AS "Maximum" from ORDERS;

select MIN(purchase_amount) AS "Minumum" from ORDERS;

select COUNT(distinct salesman_id) AS "Total count" from ORDERS;

select SUM(purchase_amount) AS "Total sum" from ORDERS;

select AVG(purchase_amount) AS "Average" from ORDERS;

select MAX(purchase_amount) AS "Maximum" from ORDERS;

select MIN(purchase_amount) AS "Minumum" from ORDERS;

select COUNT(distinct salesman_id) AS "Total count" from ORDERS;

create table ORDERS( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO ORDERS VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO ORDERS VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO ORDERS VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO ORDERS VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO ORDERS VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO ORDERS VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO ORDERS VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO ORDERS VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO ORDERS VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO ORDERS VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO ORDERS VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO ORDERS VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select SUM(purchase_amount) AS "Total sum" from ORDERS;

select AVG(purchase_amount) AS "Average" from ORDERS;

select MIN(purchase_amount) AS "Minumum" from ORDERS;

select MAX(purchase_amount) AS "Maximum" from ORDERS;

select COUNT(distinct salesman_id) AS "Total count" from ORDERS;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM ORDERS 
GROUP BY customer_id, order_date 
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM ORDERS GROUP BY customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM ORDERS  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

