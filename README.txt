//----------------------------------------------------------------------------------------------//
Project Info
//----------------------------------------------------------------------------------------------//
Project: Lab4
Description: Lab4 Booktown RestfulAPI with Java Messaging Service
Submission: lab4.elayman1.zip
Due Date: 4/7/19
Author: Kevin Gary and Elizabeth Layman

//----------------------------------------------------------------------------------------------//
Prepping to Run Project
//----------------------------------------------------------------------------------------------//

//---Task1---//
Run answers in Task1.txt at: https://api.digitransit.fi/graphiql/hsl?

//---Task2---//
Setting Up Database
    In MySQL Workbench:
    1.    Open database workbench.
    2.    Drop mysql_phonebook.sql in query.
    3.    Press lightning bolt to execute.
    4.    Refresh schema in bench to make sure it was added.
    In Project:
    1.    Open rdbm.properties.
    2.    Change jdbcURL, jdbcUser, jdbcPasswd according to your database.
Running Producer in Project:
    1.    Change build.properties
              a. tomcat_webapps = [Your tomcat_webapps directory path.]
              b. asurite = [Your asurite or username]
Running Consumer:
    1.    Navigate to consumer folder in unzipped folder (Should already be compiled.).
    2.    (In CLI (If Needed)): javac -cp activemq-all-5.15.9.jar Lab4Consumer.java
    3.    (In CLI): java -cp .;activemq-all-5.15.9.jar Lab4Consumer

//---Task3---//
Running Docker
    1.    Navigate to docker directory(Should be in highest level).
    2.    (In CLI): docker build .
    3.    (In CLI): docker container run -p 8080:8080 -p 8081:8081 <ContainerID>
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

