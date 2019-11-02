USE ShopDB;



SELECT Products.ProdID, Description, SUM(Qty) AS count, SUM(TotalPrice) AS TotalSold 
   	  FROM Products
INNER JOIN OrderDetails
      ON Products.ProdID = OrderDetails.ProdID
	  GROUP BY Products.ProdID, Description;



SELECT Products.ProdID, Description, Qty, TotalPrice FROM Products  
			   JOIN OrderDetails
			   ON Products.ProdID = OrderDetails.ProdID;
	  
	  

SELECT FName, LName, MName, SUM(TotalPrice) AS TotalSold FROM Employees 
	     JOIN Orders
			ON Employees.EmployeeID	= Orders.EmployeeID
	     JOIN OrderDetails
			ON Orders.OrderID = OrderDetails.OrderID
GROUP BY  Employees.FName,
		  Employees.LName,  
		  Employees.MName;


		  
SELECT FName, LName, MName, SUM(TotalPrice) AS TotalSold FROM Employees 
	     LEFT JOIN Orders
			ON Employees.EmployeeID	= Orders.EmployeeID
	     LEFT JOIN OrderDetails
			ON Orders.OrderID = OrderDetails.OrderID
GROUP BY  Employees.FName,
		  Employees.LName,  
		  Employees.MName;
	   

SELECT Emp1.FName, Emp1.MName, Emp1.LName, Emp2.FName, Emp2.MName, Emp2.LName  
       FROM Employees AS Emp1 
		 JOIN Employees	Emp2 
		 ON Emp1.EmployeeID = Emp2.ManagerEmpID;
         
         
SELECT c.FName, c.LName, e.FName, e.LName, sum(od.totalPrice) as PriceOfOrder
      FROM customers as c  
       INNER JOIN orders as o
         ON o.CustomerNo = c.CustomerNo
       INNER JOIN employees as e
         ON e.EmployeeID = o.EmployeeID
        INNER JOIN orderdetails as od
          ON od.OrderID = o.OrderID
       group by  c.FName, c.LName, e.FName, e.LName
       HAVING SUM(od.TotalPrice) > 1000;

