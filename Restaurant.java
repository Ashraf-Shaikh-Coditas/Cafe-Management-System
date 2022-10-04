import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Restaurant {

    public static int twoOccupancyTables = 8;
    public static int fourOccupancyTables = 4;
    public static int sixOccupancyTables = 2;
    public static int eightOccupancyTables = 2;

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static TreeMap<Integer, Integer> treeSet = new TreeMap();

    static int counter = 0;

    public void bookTable() {
        String name;
        int numberOfSeats;

        try {
            System.out.println("Enter the name of Booking Person : ");
            name = bufferedReader.readLine();
            System.out.println("Enter the number of seats required : ");
            numberOfSeats = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (numberOfSeats == 0) {
            System.out.println("Please Enter valid value : ");
        } else if (numberOfSeats <= 2) {
            if (twoOccupancyTables > 0) {
                twoOccupancyTables--;
                counter++;
            } else {
                System.out.println("No Seats available ");
            }
        } else if (numberOfSeats > 2 && numberOfSeats <= 4) {
            if (fourOccupancyTables > 0) {
                fourOccupancyTables--;
                counter++;

            } else {
                System.out.println("No Seats available ");
            }
        } else if (numberOfSeats > 4 && numberOfSeats <= 6) {
            if (sixOccupancyTables > 0) {
                sixOccupancyTables--;
                counter++;

            } else {
                System.out.println("No Seats available ");
            }
        } else {
            if (eightOccupancyTables > 0) {
                eightOccupancyTables--;
                counter++;
            } else {
                System.out.println("No Seats available ");
            }
        }
        System.out.println("Seat No : " + counter + " booked sucessfully .");
    }

    public void placeOrder() {
        Menu.displayMenu();
        System.out.println("Please Enter your table number : ");
        try {
            int tableNumber = Integer.parseInt(bufferedReader.readLine());
            arrayList.add(tableNumber);
            boolean flag = true;
            while (flag) {
                System.out.println("Press 1 to add more or 0 to exit .");
                int choice = Integer.parseInt(bufferedReader.readLine());
                if (choice == 0) {
                    System.out.println("Order Cancelled ");
                    flag = false;
                } else {
                    addItem();
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addItem() throws IOException {
        System.out.println("Enter the serial number of Menu Item : ");
        int menuItem = Integer.parseInt(bufferedReader.readLine());
        if (menuItem > 5 && menuItem < 0) {
            System.out.println("Invalid choice entered. Please " +
                    "select from the above menu");
            placeOrder();
        }
        System.out.println("Enter the quantity of Menu Item : ");
        int quantity = Integer.parseInt(bufferedReader.readLine());
        treeSet.put(menuItem, quantity);

    }

    public void printBill() {
        ArrayList<Menu> menus = new ArrayList<>();
        int totalBill = 0;
        for (Map.Entry<Integer, Integer> map : treeSet.entrySet()) {
            int key = map.getKey();
            Menu menu = Menu.menuHashMap.get(key);
            int price = menu.getPrice() * map.getValue();
            menus.add(new Menu(map.getKey(), menu.getMenuItem(), price));
            totalBill += price;
        }

        Collections.sort(menus, new SortByPrice());
        for (Menu m : menus) {
            System.out.println(m);
        }
        System.out.println("Total Bill : " + totalBill);

    }

}
