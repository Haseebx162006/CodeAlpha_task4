package hotel_system;
import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;
class show_and_book_rooms extends driver_connect{
    int choice;
    Scanner sc= new Scanner(System.in);
    public void view_rooms(){
        while(true) {
            System.out.println("===========================================");
            System.out.println("        Welcome to Haseeb Hotel System      ");
            System.out.println("===========================================");
            System.out.println("1. View Description of Rooms");
            System.out.println("2. View All Rooms");
            System.out.println("3. Book a Room");
            System.out.println("4. Exit");
            System.out.println("===========================================");
            System.out.print("Enter your Choice: ");

            choice=sc.nextInt();
            System.out.println("===========================================");
            if (choice==0){
                int choice;
                System.out.println("1.View Bookings:");
                System.out.println("2.Add Rooms");
                System.out.print("Enter your choice:");
                choice=sc.nextInt();
                if (choice==1){
                    admin a = new admin();
                    a.viewUserBookings();
                }
                else{
                    String type;
                    System.out.print("Enter the category of room:");
                    sc.nextLine();
                    type=sc.nextLine();
                    admin b= new admin();
                    type = type.trim().toLowerCase();
                    b.addRoom(type);
                }
            }
            if (choice==1){
                System.out.println("===========================================");
                System.out.println("             ROOM CATEGORIES               ");
                System.out.println("===========================================");

                System.out.println("\n1. Luxury Room");
                System.out.println("-------------------------------------------");
                System.out.println("- King-size Bed");
                System.out.println("- Air Conditioning");
                System.out.println("- Price: PKR 5,000/night");

                System.out.println("\n2. Standard Room");
                System.out.println("-------------------------------------------");
                System.out.println("Features:");
                System.out.println("- Queen-size Bed");
                System.out.println("- Air Conditioning");
                System.out.println("- Price: PKR 3,500/night");

                System.out.println("\n3. Simple Room");
                System.out.println("-------------------------------------------");
                System.out.println("Features:");
                System.out.println("- Single Bed");
                System.out.println("- Ceiling Fan");
                System.out.println("- Price: PKR 2,500/night");
                System.out.println("\n===========================================");
            } else if (choice==2) {
                int choice_for_room;
                System.out.println("1.Luxury Rooms");
                System.out.println("2.Standard Rooms");
                System.out.println("3.Simple Rooms");
                System.out.println("Enter Choice:");
                choice_for_room=sc.nextInt();
                if (choice_for_room==1){
                    driver_connect a= new driver_connect();
                    this.luxury();
                } else if (choice_for_room==2) {
                    driver_connect b= new driver_connect();
                    this.standard();
                } else if (choice_for_room==3) {
                    driver_connect c = new driver_connect();
                    this.Simple();
                }
                } else if (choice==3) {
                    sc.nextLine();
                    int choice;
                    System.out.println("1.Luxury Room");
                    System.out.println("2.Standard Room");
                    System.out.println("3.Simple Room");
                    System.out.println("Enter your choice:");
                    choice=sc.nextInt();
                    if (choice==1){
                        book_room a= new book_room();
                        a.book_room_luxury();
                    } else if (choice==2) {
                        book_room b= new book_room();
                        b.book_room_Standard();
                    }
                    else if (choice==3){
                        book_room c= new book_room();
                        c.book_room_basic();
                    }
                }
              else if (choice==4) {
                System.out.println("Exiting");
                break;
            }
        }
    }

}
public class manager {
    public static void main(String[] args) {
        try {
            show_and_book_rooms a = new show_and_book_rooms();
            a.view_rooms();
        } catch (Exception e) {
            System.out.println("Error in main: " + e.getMessage());
        }

    }
}
