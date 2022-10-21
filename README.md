# BookCase

DISCLAIMER: The final version of the project is located in the MySQL-attempt branch and not the main branch. Make sure you are not in one of the other branches before viewing the project.

### Requirements:
1. The backend is built with Java 17. Make sure to use JDK 17 to run it.
2. Make sure you have the MySql server 8 or above installed on your computer.
3. Make sure you have Node.js 8.5 or above installed on your computer.
4. Make sure you have Angular CLI installed. You can install it on your computer globally by typing "npm install -g @angular/cli" on the cmd. This will not work if you do not have Node.js, so make sure you went over step 3 before attempting this.

### Running The Backend:
The backend application is inside the folder named "library-app". You can open this folder using your preferred Java IDE. It was coded on IntelliJ. Before running it, open the file "application.properties" under src/main/resources. This is where the MySQL configuration is handled. Make sure the username and password matches your own that you use to access your MySQL databases, as well as the port number inside the URL: "jdbc:mysql://localhost:3306/bookmanager" if you are not using the default port 3306 to host your MySQL databases. The "bookmanager" string at the end corresponds with the name of the database. Make sure to create a new database with this name using MySQL Workbench, MySQL Command Line Client etc. If you want to use a different name for your database, then replace "bookmanager" in the URL with that name as well.
