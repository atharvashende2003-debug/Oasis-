package Intership;
import java.util.*;

    class Reservation {
        String pnr;
        String name;
        String trainNumber;
        String trainName;
        String classType;
        String date;
        String from;
        String to;

        public Reservation(String pnr, String name, String trainNumber,
                           String trainName, String classType,
                           String date, String from, String to) {

            this.pnr = pnr;
            this.name = name;
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.classType = classType;
            this.date = date;
            this.from = from;
            this.to = to;
        }
    }

public class Online_Reservation_System {

        static Scanner sc = new Scanner(System.in);
        static ArrayList<Reservation> reservations = new ArrayList<>();

        static String loginId = "atharv@123";
        static String password = "1234";

        public static void main(String[] args) {

            if (login()) {
                int choice;

                do {
                    System.out.println("\n===== ONLINE RESERVATION SYSTEM =====");
                    System.out.println("1. Reservation");
                    System.out.println("2. Cancellation");
                    System.out.println("3. Exit");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            makeReservation();
                            break;
                        case 2:
                            cancelReservation();
                            break;
                        case 3:
                            System.out.println("Thank you!");
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }

                } while (choice != 3);
            }
        }

        static boolean login() {
            System.out.println("===== LOGIN =====");
            System.out.print("Enter Login ID: ");
            String user = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            if (user.equals(loginId) && pass.equals(password)) {
                System.out.println("Login Successful!");
                return true;
            } else {
                System.out.println("Invalid Credentials!");
                return false;
            }
        }

        static void makeReservation() {

            System.out.println("\n===== RESERVATION FORM =====");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Train Number: ");
            String trainNumber = sc.nextLine();

            // Train name auto-fill logic
            String trainName;
            if (trainNumber.equals("101"))
                trainName = "Express";
            else if (trainNumber.equals("102"))
                trainName = "SuperFast";
            else
                trainName = "Local";

            System.out.println("Train Name: " + trainName);

            System.out.print("Enter Class Type (Sleeper/AC): ");
            String classType = sc.nextLine();

            System.out.print("Enter Date of Journey: ");
            String date = sc.nextLine();

            System.out.print("From: ");
            String from = sc.nextLine();

            System.out.print("To: ");
            String to = sc.nextLine();

            String pnr = String.valueOf(new Random().nextInt(900000) + 100000);

            Reservation r = new Reservation(pnr, name, trainNumber,
                    trainName, classType, date, from, to);

            reservations.add(r);

            System.out.println("Reservation Successful!");
            System.out.println("Your PNR Number is: " + pnr);
        }

        static void cancelReservation() {

            System.out.print("\nEnter PNR Number: ");
            String pnr = sc.nextLine();

            for (Reservation r : reservations) {
                if (r.pnr.equals(pnr)) {

                    System.out.println("Reservation Details:");
                    System.out.println("Name: " + r.name);
                    System.out.println("Train: " + r.trainName);
                    System.out.println("From: " + r.from + " To: " + r.to);

                    System.out.print("Confirm Cancellation? (yes/no): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {
                        reservations.remove(r);
                        System.out.println("Reservation Cancelled!");
                    }
                    return;
                }
            }

            System.out.println("PNR Not Found!");
        }
    }

