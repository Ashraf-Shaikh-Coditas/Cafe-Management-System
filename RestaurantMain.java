import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestaurantMain {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true ;
        Menu.addMenu();

        while(flag) {
            System.out.println("\n0) Exit" +
                    "\n1) Book Table" +
                    "\n2) Display Menu" +
                    "\n3) Order Coffee" +
                    "\n4) Print Bill");

            int choice ;
            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 0 :
                    flag = false;
                    break;
                case 1 :
                    new Restaurant().bookTable(); ;
                    break;
                case 2 :
                    Menu.displayMenu();
                    break;
                case 3 :
                    new Restaurant().placeOrder();
                    break;
                case 4 :
                    new Restaurant().printBill();
                    break;

            }
        }
    }
}
