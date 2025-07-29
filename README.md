# CodeAlpha_task4
Hotel Reservation system made in java with Mysql as database
This is a console-based Java application that manages hotel room bookings using a MySQL backend. It allows admins to add different types of rooms (Luxury, Standard, Simple) with rent, and users can view bookings.

📋 Features
🔐 Admin functionality: // Choose 0 to enter the admin side 

Add new rooms by category (Luxury, Standard, Simple)

Set custom rent for each room

Stores room data in corresponding MySQL tables

📄 User functionality:

View bookings (expandable)

🗃 MySQL database integration using JDBC

🧱 Technologies Used
Java (JDK 17+)

MySQL

JDBC API

🗃️ Database Structure
Ensure your MySQL database has the following tables:

sql
Copy
Edit
CREATE DATABASE hotel;

USE hotel;

CREATE TABLE luxury_room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_avaliable BOOLEAN,
    rent DOUBLE
);

CREATE TABLE standard_room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_avaliable BOOLEAN,
    rent DOUBLE
);

CREATE TABLE simple_room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_avaliable BOOLEAN,
    rent DOUBLE
);

CREATE TABLE user_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50),
    contact VARCHAR(15)
);
⚙️ How to Run
Clone the repo or copy the source files.

Ensure MySQL is running and the database is created as shown above.

Update the following fields in your Java code:

java
Copy
Edit
private static final String url = "jdbc:mysql://localhost:3306/hotel";
private static final String username = "your_mysql_username";
private static final String password = "your_mysql_password";
Compile and run the project using your preferred IDE or command line:

bash
Copy
Edit
javac Main.java
java Main
💡 Sample Admin Operation
text
Copy
Edit

Enter your Choice:
1. View Bookings
2. Add Rooms

Enter your choice: 2
Enter the category of room: luxury
Enter rent: 5000
Room added to luxury successfully.
📌 Notes
Ensure JDBC driver is added to your project’s classpath.

Currently, only room addition and structure are implemented; bookings and more features can be added.

🚀 Future Enhancements
Implement user-side booking functionality

Add room availability check and booking confirmation

GUI version using JavaFX or Swing

Admin authentication

🧑‍💻 Author
Haseeb Ahmad
