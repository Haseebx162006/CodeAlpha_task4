package hotel_system;

import  java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class driver_connect {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/admin";
    private static final String username = "root";
    private static final String password = "jarvis012";
    public void luxury() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM luxury_room;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Print table header once before the loop
            System.out.printf("%-10s | %-20s | %-10s\n", "Room No", "Room Availability", "Rent");
            System.out.println("-------------------------------------------------------------");

            while (resultSet.next()) {
                int room_id = resultSet.getInt("Id");
                boolean roomAvailable = resultSet.getBoolean("room_avaliable");
                String room_avaliable = roomAvailable ? "Yes" : "No";
                double rent = resultSet.getDouble("rent");

                System.out.printf("%-10d | %-20s | %-10.2f\n", room_id, room_avaliable, rent);
                System.out.println();
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void standard() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Standard_room;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.printf("%-10s | %-20s | %-10s\n", "Room No", "Room Availability", "Rent");
            System.out.println("-------------------------------------------------------------");

            while (resultSet.next()) {
                int room_id = resultSet.getInt("Id");
                boolean roomAvailable = resultSet.getBoolean("room_avaliable");
                String room_avaliable = roomAvailable ? "Yes" : "No";
                double rent = resultSet.getDouble("rent");

                System.out.printf("%-10d | %-20s | %-10.2f\n", room_id, room_avaliable, rent);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void Simple() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Simple_room;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.printf("%-10s | %-20s | %-10s\n", "Room No", "Room Availability", "Rent");
            System.out.println("-------------------------------------------------------------");

            while (resultSet.next()) {
                int room_id = resultSet.getInt("Id");
                boolean roomAvailable = resultSet.getBoolean("room_avaliable");
                String room_avaliable = roomAvailable ? "Yes" : "No";
                double rent = resultSet.getDouble("rent");

                System.out.printf("%-10d | %-20s | %-10.2f\n", room_id, room_avaliable, rent);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}