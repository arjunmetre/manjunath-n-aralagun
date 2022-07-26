# manjunath-n-aralagun

Library college web project is college project

# Queries by :
1. What concepts used in project development ?
Ans : Used Java programming language to develop the project concepts from java Servlet, JSP, IO & JDBC. Which clearly demonstrate 
- how I can read file or property file from location
- how I connect to database to read, write and delete data from database.
- how I handle HTTP request and response demonstration.
- how I display data from response object.
- how I validate user credentials and captcha concept.
- how I handle books in ordered representation
2. 
3. 


# Developed 
- Programing - Java 11
- Database - mariaDB ( extended version of mysql)
- concepts used - Servlet, JSP and basic java knowledge


# working

```mermaid
sequenceDiagram
JSP ->> Serlvet: Jsp sends HTTP request
Note right of Serlvet: Analyse request URI and body to send response.
Serlvet ->> Database : Servlet checks in database if required.
Database ->> Serlvet : DB sends response to servlet if exists
Serlvet ->> JSP : Servlet sends response to JSP 
Note left of JSP: JSP reads response and resolve the view in HTML representation.
JSP -->> Captcha: generate captcha and return 
Captcha -->> JSP : 
JSP ->> Serlvet : Create session and sends captcha in session to validate.
```
