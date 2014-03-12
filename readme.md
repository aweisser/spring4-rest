Quickstart
--------------
1. Run tomcat7:run maven goal. This will download all dependencies, compile the webapp and start an embedded tomcat7 instance.
2. Call http://localhost:8080/cloudspace to take a look at your cloud based filesystem.

HowTo
--------------
 This is a minimal restless webservice example with Spring4 simulating a (not really usefull) cloud based filesystem.
 The webservice returns a JSON representation of the requested data.

 You can access your filesystem via REST API and ...
 - list all root folders (GET /cloudspace)
 - access folders with their subfolders (GET /cloudspace/media)
 - add new subfolders (POST /cloudspace/documents/tutorials)
 - remove subfolders (DELETE /cloudspace/documents/tutorials)

Use Postman plugin for chrome or curl or the Rest client of your choice to start requesting the webservice.

Credits
--------------
Some basics taken from http://www.programming-free.com/2014/01/spring-mvc-40-restful-web-services.html
