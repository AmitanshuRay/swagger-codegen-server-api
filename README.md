# Server API
## Introduction
This REST API application was made with the help of [swagger-editor](https://editor.swagger.io/), which generated the server stub of the project in SpringBoot framework using my [openapi file](https://github.com/AmitanshuRay/swagger-codegen-server/blob/master/openapi.json).
The underlying library integrating swagger to SpringBoot is [springdoc-openapi](https://github.com/springdoc/springdoc-openapi).
Start your server as an simple java application.

You can view the api documentation in by pointing to 
http://localhost:8080/api-docs after starting the application.

Change default port value in application.properties

## Project Support Features

* Users can add, view or delete server objects based on a server object's id 
* Apart from id, users can view server object also based on server object's name. It will return all servers objects that have the 'name' string in their name.

## Installation Guide
* Clone [swagger-codedgen-server.jar](https://github.com/AmitanshuRay/swagger-codegen-server/blob/master/swagger-codgen-server.jar) file and cd ino that folder
* Download Java 9 from [here](https://www.oracle.com/in/java/technologies/javase/javase9-archive-downloads.html) and install it
*Check Java version using 

     $ java --version

* Install [mongodb](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/) on your machine

## Usage
* Start mongodb session on your machine 

      $ sudo systemctl start mongod

* Check the status of mongo session and ensure it is active

      $ sudo systemctl status mongod

* Run **.jar** file using:

      $ java -jar swagger-codegen-server.jar

* Connect to the API using Postman on port **8080**.

## API Endpoints
| HTTP Verbs | Endpoints            | Action                                                           |
|------------|----------------------|------------------------------------------------------------------|
| PUT        | /                    | To add a server object                                           |
| GET        | /                    | To retrieve all server objects in the collection                 |
| GET        | /{id}                | To retrieve a server object with this id                         |
| GET        | /name/{name}         | To retrieve all server object with the {name} string in their name |
| DELETE     | /{id}                | To delete a server object with this id                           |

## Examples
### Put a server
#### Request
    PUT / HTTP/1.1
    Content-Type: application/json
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: c5548a84-6cae-4b2d-b0e5-60961d2d6488
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
    Content-Length: 84
    
    {
    "id":"1",
    "name":"s1",
    "language":"python",
    "framework":"django"
    }
#### Response
    HTTP/1.1 200 OK
    Content-Length: 0
    Date: Sat, 25 Mar 2023 11:49:51 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive
### Get all servers
#### Request
    GET / HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: e682f75d-3017-49fc-919f-83f4df046846
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
#### Response
    HTTP/1.1 200 OK
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Sat, 25 Mar 2023 11:51:36 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive

    [
      {
        "id": "1",
        "name": "s1",
        "language": "python",
        "platform": null
      },
      {
        "id": "2",
        "name": "s2",
        "language": "java",
        "platform": null
      },
      {
        "id": "3",
        "name": "s21",
        "language": "C++",
        "platform": null
      }
    ]
### Get a server based on id
**- When a server is found**
#### Request
    GET /1 HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: db968c83-4cf5-48d5-b9ee-c0bd3b55a936
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
##### Response
    HTTP/1.1 200 OK
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Sat, 25 Mar 2023 11:51:46 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive
    
    {"id":"1","name":"s1","language":"python","platform":null}
**- When no server by that id is found**
#### Request
    GET /4 HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: d8301939-7ddc-43ff-ab87-cc2d8e8f86ca
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
#### Response
    HTTP/1.1 404 Not Found
    Content-Length: 0
    Date: Sat, 25 Mar 2023 12:18:29 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive
### Get a list of servers using name
**- When server(s) with that name is found**
#### Request
    GET /name/s2 HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: c789c2a2-fd7f-45c1-a3c2-47bb4b1c7fb6
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
#### Response
    HTTP/1.1 200 OK
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Sat, 25 Mar 2023 11:51:56 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive

    [
      {
        "id": "2",
        "name": "s2",
        "language": "java",
        "platform": null
      },
      {
        "id": "3",
        "name": "s21",
        "language": "C++",
        "platform": null
      }
    ]
**- When no server by name are found**
#### Request
    GET /name/s3 HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: b14cdea9-bfb2-4a19-9198-1b58ed391379
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
#### Response
    HTTP/1.1 404 Not Found
    Content-Length: 0
    Date: Sat, 25 Mar 2023 12:23:11 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive

### Deleting a server by id
**- When a server with the id is found**
#### Request
    DELETE /3 HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: 369b8d31-9912-4b5f-9537-9a3e4855ab58
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
#### Response
    HTTP/1.1 200 OK
    Content-Length: 0
    Date: Sat, 25 Mar 2023 11:52:10 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive
**- When no server by that id is found**
#### Request
    DELETE /4 HTTP/1.1
    User-Agent: PostmanRuntime/7.31.3
    Accept: */*
    Cache-Control: no-cache
    Postman-Token: d1f79436-76c8-4126-b564-3cc13889935f
    Host: localhost:8080
    Accept-Encoding: gzip, deflate, br
    Connection: keep-alive
#### Response
    HTTP/1.1 404 Not Found
    Content-Length: 0
    Date: Sat, 25 Mar 2023 12:26:15 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive

## Technologies Used

* [Swagger Editor](https://editor.swagger.io/) This is open source editor to define an API in openapi standard and to generate server stub.
* [Maven](https://maven.apache.org/) This is a free software project management and comprehension tool.
* [MongoDB](https://www.mongodb.com/) This is a free open source NOSQL document database with scalability and flexibility. Data are stored in flexible JSON-like documents.

## Authors

* [Amitanshu Ray](https://github.com/AmitanshuRay)

### License

This project is available for use under the [MIT License](https://opensource.org/license/mit/).
