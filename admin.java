package hotel_system;

import java.sql.*;
import java.util.Scanner;

public class admin extends driver_connect {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/admin";
    private static final String username = "root";
    private static final String password = "jarvis012";

    Scanner sc = new Scanner(System.in);

    // View all user bookings
    public void viewUserBookings() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM user_info";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.printf("%-15s %-15s %-10s %-15s %-10s %-20s\n", "Name", "Phone", "Type", "Check-in Date", "Bill", "Check-in Time");
            while (rs.next()) {
                System.out.printf("%-15s %-15s %-10s %-15s %-10.2f %-20s\n",
                        rs.getString("Name"),
                        rs.getString("Phone_number"),
                        rs.getString("Roomtype"),
                        rs.getDate("check_in_date"),
                        rs.getDouble("total_bill"),
                        rs.getTimestamp("check_in_time"));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving user bookings: " + e.getMessage());
        }
    }

    // Add a room (luxury / standard / simple)
    public void addRoom(String roomType) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.print("Enter rent: ");
            double rent = sc.nextDouble();

            roomType = roomType.trim().toLowerCase(); // Normalize input

            String tableName;
            if (roomType.equals("luxury")) {
                tableName = "luxury_room";
            } else if (roomType.equals("standard")) {
                tableName = "standard_room";
            } else if (roomType.equals("simple")) {
                tableName = "simple_room";
            } else {
                System.out.println("Invalid room type!");
                return;
            }

            String query = "INSERT INTO " + tableName + " (room_avaliable, rent) VALUES (true, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, rent);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Room added to " + roomType + " successfully.");
            } else {
                System.out.println("Failed to add room.");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
    }

}