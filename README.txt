//----------------------------------------------------------------------------------------------//
Project Info
//----------------------------------------------------------------------------------------------//
Project: Lab4
Description: Lab4 Booktown RestfulAPI with Java Messaging Service
Submission: lab4.elayman1.zip
Due Date: 4/7/19
Author: Kevin Gary and Elizabeth Layman

//----------------------------------------------------------------------------------------------//
Dependencies
//----------------------------------------------------------------------------------------------//
    1.    Organization: "mysql"
          Name: "mysql-connector-java"
          Version: "8.0.15"
          Link: "https://mvnrepository.com/artifact/mysql/mysql-connector-java"

    2.    Organization: "javax.servlet"
          Name: "javax.servlet-api"
          Version: "3.0.1"
          Link: "https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api"

    3.    Organization: "org.glassfish.jersey.bundles"
          Name: "jaxrs-ri"
          Version: "2.26"
          Link: "https://mvnrepository.com/artifact/org.glassfish.jersey.bundles/jaxrs-ri"

    4.    Organization: "org.glassfish.hk2"
          Name: "hk2"
          Version: "2.5.0"
          Link: "https://mvnrepository.com/artifact/org.glassfish.hk2/hk2"

    5.    Organization: "org.glassfish.hk2"
          Name: "hk2-locator"
          Version: "2.5.0"
          Link: "https://mvnrepository.com/artifact/org.glassfish.hk2/hk2-locator"

    7.    Organization: "com.fasterxml.jackson.core"
          Name: "jackson-core"
          Version: "2.9.0"
          Link: "https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core"

    8.    Organization: "com.fasterxml.jackson.core"
          Name: "jackson-annotations"
          Version: "2.9.0"
          Link: "https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations"

    9.    Organization: "com.fasterxml.jackson.core"
          Name: "jackson-databind"
          Version: "2.9.0"
          Link: "https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind"

    10.    Organization: "javax.jms"
           Name: "javax.jms-api"
           Version: "2.0"
           Link: "https://mvnrepository.com/artifact/javax.jms/javax.jms-api"

    11.    Organization: "org.apache.activemq"
           Name: "activemq-core"
           Version: "5.7.0"
           Link: "https://mvnrepository.com/artifact/org.apache.activemq/activemq-core"

//----------------------------------------------------------------------------------------------//
Prepping to Run Project
//----------------------------------------------------------------------------------------------//
Setting Up database(In MySQL Workbench):
    1.    Open database workbench.
    2.    Drop mysql_phonebook.sql in query.
    3.    Press lightning bolt to execute.
    4.    Refresh schema in bench to make sure it was added.
Setting Up Ivy:
    In CLI:
    1.    ant init-ivy

//----------------------------------------------------------------------------------------------//
Booktown API Doc
//----------------------------------------------------------------------------------------------//
Title: Request list of authors and return json payload
Description:
URL:
/authors/
Method:
GET
URL Params
None
Data Params
None
Success Response:
Code: 200
Content:
[
    {"authorId":1111,"firstName":"Ariel","lastName":"Denham"},
    {"authorId":1212,"firstName":"John","lastName":"Worsley"}
]
//----------------------------------------------------------------------------------------------//
Title: Get Author
Description: Request author by id and return json payload
URL:
/authors/id
Method:
GET
URL Params
Required:
id=[integer]
Data Params
None
Success Response:
Code: 200
Content: {"authorId":1111,"firstName":"Ariel","lastName":"Denham"}
Error Response:
Code: 404 NOT FOUND
Content: { message : No such Author AuthorId }
Code: 500 INTERNAL SERVER ERROR
Content: { message : Internal server error deserializing Author JSON }
//----------------------------------------------------------------------------------------------//
Title: Delete Author
Description: Request author by id, remove author from persistent storage and return json payload
URL:
/authors/id
Method:
Delete
URL Params
Required:
id=[integer]
Data Params
None
Success Response:
Code: 200
Content: {"authorId":1111,"firstName":"Ariel","lastName":"Denham"}
Error Response:
Code: 404 NOT FOUND
Content: { message : No such Author AuthorId }
//----------------------------------------------------------------------------------------------//
Title: Create Author
Description: Request author by id, add author from persistent storage and return json payload
URL:
/authors/
Method:
Post
URL Params
None
Data Params
None
Consumes(Payload with Postman):
Type: text/plain
Content: "Joe Johnson"
Success Response:
Code: 200
Content: { Author : AuthorId }
Error Response:
Code: 404 NOT FOUND
Content: { message : No such Author AuthorId }
Error Response:
Code: 500
Content: { EXCEPTION INSERTING INTO DATABASE! }
Error Response:
Code: 500
Content: { ERROR INSERTING INTO DATABASE! }
//----------------------------------------------------------------------------------------------//
Title: Update Author
Description: Request author by id, update author from persistent storage and return json payload
URL:
/authors/
Method:
PUT
URL Params
None
Data Params
None
Consumes(Payload with Postman):
Type: application/json
Content: {"authorId":1678,"firstName":"Jill","lastName":"Johnson"}
Success Response:
Code: 200
Content: {"authorId":1678,"firstName":"Jill","lastName":"Johnson"}
Error Response:
Code: 404 NOT FOUND
Content: { message : No such Author AuthorId }
Code: 500 INTERNAL SERVER ERROR
Content: { message : Internal server error deserializing Author JSON }
//----------------------------------------------------------------------------------------------//

