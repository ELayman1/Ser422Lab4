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
Setting Up to Run Simple Booktown


Setting Up Database(In MySQL Workbench):
    1.    Open database workbench.
    2.    Drop mysql_phonebook.sql in query.
    3.    Press lightning bolt to execute.
    4.    Refresh schema in bench to make sure it was added.

Setting Up Ivy(Ignore):
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

