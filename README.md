# ecsinterview


1. Clone the project(git clone)
2. Open the project in IDE
3. Open the `application.properites` , update the `project.installed.location`

   suppose, if you installed the project under `/home/software` directory, then value will be 
   
   `project.installed.location = /home/software`

4. Go to carapi directory and run the gradle command `./gradle clean build`
5. Start the server `./gradle bootRun`
6. Open the swagger UI using http://localhost:8080/swagger-ui/index.html
