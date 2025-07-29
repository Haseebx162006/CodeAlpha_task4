package hotel_system;

import java.sql.*;
import java.util.Scanner;

public class book_room extends driver_connect{
    Scanner sc = new Scanner(System.in);
    private static final String url = "jdbc:mysql://127.0.0.1:3306/admin";
    private static final String username = "root";
    private static final String password = "jarvis012";
    private double rent_of_room;

    public double getRent_of_room() {
        return rent_of_room;
    }
    public void setRent_of_room(double rent_of_room) {
        this.rent_of_room = rent_of_room;
    }

    public void book_room_luxury(){
        try{
            setRent_of_room(5000);
            int room_id;
            System.out.println("Enter the Room you want to book:");
            room_id=sc.nextInt();
            Connection connection= DriverManager.getConnection(url,username,password);
            String query="Select Id,room_avaliable from luxury_room";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("Id");
                boolean b= resultSet.getBoolean("room_avaliable");
               if (room_id==id && b){
                   String name,phone_number,Roomtype;
                   double bill;
                   int days;
                   sc.nextLine();
                   System.out.println("Enter your name:");
                   name=sc.nextLine();
                   System.out.println("Enter the Phone number:");
                   phone_number=sc.nextLine();
                   System.out.println("Enter the number of days you want to stay:");
                   days=sc.nextInt();
                   String query2="Insert into user_info(Name,Phone_number,Roomtype,check_in_date,total_bill,check_in_time) values(?,?,?,?,?,?)";
                   PreparedStatement p1= connection.prepareStatement(query2);
                   p1.setString(1,name);
                   p1.setString(2,phone_number);
                   p1.setString(3,"Luxury");
                   p1.setDate(4,new java.sql.Date(System.currentTimeMillis()));
                   p1.setDouble(5,getRent_of_room()*days);
                   p1.setTimestamp(6,new java.sql.Timestamp(System.currentTimeMillis()));
                   int row = p1.executeUpdate();

                   String new_query = "UPDATE luxury_room SET room_avaliable = FALSE WHERE Id = ?";
                   PreparedStatement p2 = connection.prepareStatement(new_query);
                   p2.setInt(1, id);
                   int row_1 = p2.executeUpdate();
                   System.out.println("Room Booked Successfully");
                   break;
               }else{
                   System.out.println("Room not avaliable!");
               }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void book_room_Standard(){
        try{
            setRent_of_room(3500);
            int room_id;
            System.out.println("Enter the Room you want to book:");
            room_id=sc.nextInt();
            Connection connection= DriverManager.getConnection(url,username,password);
            String query="Select Id,room_avaliable from Standard_room";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("Id");
                boolean b= resultSet.getBoolean("room_avaliable");
                if (room_id==id && b){
                    String name,phone_number,Roomtype;
                    double bill;
                    int days;
                    sc.nextLine();
                    System.out.println("Enter your name:");
                    name=sc.nextLine();
                    System.out.println("Enter the Phone number:");
                    phone_number=sc.nextLine();
                    System.out.println("Enter the number of days you want to stay:");
                    days=sc.nextInt();
                    String query2="Insert into user_info(Name,Phone_number,Roomtype,check_in_date,total_bill,check_in_time) values(?,?,?,?,?,?)";
                    PreparedStatement p1= connection.prepareStatement(query2);
                    p1.setString(1,name);
                    p1.setString(2,phone_number);
                    p1.setString(3,"Standard");
                    p1.setDate(4,new java.sql.Date(System.currentTimeMillis()));
                    p1.setDouble(5,getRent_of_room()*days);
                    p1.setTimestamp(6,new java.sql.Timestamp(System.currentTimeMillis()));
                    int row = p1.executeUpdate();

                    String new_query = "UPDATE Standard_room SET room_avaliable = FALSE WHERE Id = ?";
                    PreparedStatement p2 = connection.prepareStatement(new_query);
                    p2.setInt(1, id);
                    int row_1 = p2.executeUpdate();
                    System.out.println("Room Booked Successfully");
                    break;
                }else{
                    System.out.println("Room not avaliable!");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void book_room_basic(){
        try{
            setRent_of_room(2500);
            int room_id;
            System.out.print("Enter the Room you want to book:");
            room_id=sc.nextInt();
            Connection connection= DriverManager.getConnection(url,username,password);
            String query="Select Id,room_avaliable from Simple_room";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("Id");
                boolean b= resultSet.getBoolean("room_avaliable");
                if (room_id==id && b){
                    String name,phone_number,Roomtype;
                    double bill;
                    int days;
                    sc.nextLine();
                    System.out.println("Enter your name:");
                    name=sc.nextLine();
                    System.out.println("Enter the Phone number:");
                    phone_number=sc.nextLine();
                    System.out.println("Enter the number of days you want to stay:");
                    days=sc.nextInt();
                    String query2="Insert into user_info(Name,Phone_number,Roomtype,check_in_date,total_bill,check_in_time) values(?,?,?,?,?,?)";
                    PreparedStatement p1= connection.prepareStatement(query2);
                    p1.setString(1,name);
                    p1.setString(2,phone_number);
                    p1.setString(3,"Simple");
                    p1.setDate(4,new java.sql.Date(System.currentTimeMillis()));
                    p1.setDouble(5,getRent_of_room()*days);
                    p1.setTimestamp(6,new java.sql.Timestamp(System.currentTimeMillis()));
                    int row = p1.executeUpdate();

                    String new_query = "UPDATE Simple_room SET room_avaliable = FALSE WHERE Id = ?";
                    PreparedStatement p2 = connection.prepareStatement(new_query);
                    p2.setInt(1, id);
                    int row_1 = p2.executeUpdate();
                    System.out.println("Room Booked Successfully");
                    break;
                }else{
                    System.out.println("Room not avaliable!");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
