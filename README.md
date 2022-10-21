# BookCase

DISCLAIMER: The final version of the project is located in the MySQL-attempt branch and not the main branch. Make sure you are not in one of the other branches before viewing the project.

### Requirements:
1. The backend is built with Java 17. Make sure to use JDK 17 to run it.
2. Make sure you have the MySql server 8 or above installed on your computer.
3. Make sure you have Node.js 8.5 or above installed on your computer.
4. Make sure you have Angular CLI installed. You can install it on your computer globally by typing "npm install -g @angular/cli" on the cmd. This will not work if you do not have Node.js, so make sure you went over step 3 before attempting this.

### Running The Backend:
The backend application is inside the folder named "library-app". You can open this folder using your preferred Java IDE. It was coded on IntelliJ. Before running it, open the file "application.properties" under src/main/resources. This is where the MySQL configuration is handled. Make sure the username and password matches your own that you use to access your MySQL databases, as well as the port number inside the URL: "jdbc:mysql://localhost:3306/bookmanager" if you are not using the default port 3306 to host your MySQL databases. The "bookmanager" string at the end corresponds with the name of the database. Make sure to create a new database with this name using MySQL Workbench, MySQL Command Line Client etc. If you want to use a different name for your database, then replace "bookmanager" in the URL with that name as well. You can then run "LibraryAppApplication.java" under src\main\java\com\bookcase\libraryapp.

### Running the Frontend:
The frontend application is inside the folder named "frontend-application". If you have node.js and Angular CLI installed as told in the requirements and the backend application is already running, then all you need to do is type "ng serve" on the cmd while inside the "bookmanagerapp" folder, which is located in the previously mentioned "frontend-application" folder. Then, you can connect to "http://localhost:4200/" on your browser to use the application. Some example books can be found in the "JSON Samples.txt" file right next to the backend and frontend application folders. You can refer to them as example books you can add, and since they are given in JSON format, you can also use them to test the REST API and HTTP calls directly without using the frontend application via some tool such as Postman. You can look inside the "BookResource.java" class that is right next to "LibraryAppApplication.java" to see how the HTTP requests and methods for adding, editing, deleting books etc. work.
