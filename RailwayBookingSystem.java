import java.util.*;

class RailwayBookingSystem {
    static int totalSeats = 10;
    static Map<Integer, String> bookings = new HashMap<>();
    static int seatCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Book 2.Cancel 3.View 4.Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                if (seatCounter <= totalSeats) {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    bookings.put(seatCounter, name);
                    System.out.println("Booked Seat No: " + seatCounter);
                    seatCounter++;
                } else {
                    System.out.println("No seats available");
                }
            } else if (ch == 2) {
                System.out.print("Enter seat number: ");
                int seat = sc.nextInt();
                if (bookings.containsKey(seat)) {
                    bookings.remove(seat);
                    System.out.println("Cancelled");
                } else {
                    System.out.println("Invalid seat");
                }
            } else if (ch == 3) {
                for (int i = 1; i <= totalSeats; i++) {
                    if (bookings.containsKey(i))
                        System.out.println("Seat " + i + " -> " + bookings.get(i));
                    else
                        System.out.println("Seat " + i + " -> Empty");
                }
            } else {
                break;
            }
        }
    }
}
