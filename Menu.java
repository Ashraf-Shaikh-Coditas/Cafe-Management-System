import java.util.HashMap;

public class Menu {

    private int id;
    private String menuItem;
    private int price;

    public Menu(int id, String menuItem, int price) {
        this.id = id;
        this.menuItem = menuItem;
        this.price = price;
    }

    public Menu() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuItem='" + menuItem + '\'' +
                ", price=" + price +
                '}';
    }

    public static final HashMap<Integer,Menu> menuHashMap = new HashMap<>();

    public static void displayMenu() {
        System.out.println("1. Noodles   --> Rs.50" +
                "\n2. Tea  --> Rs.10" +
                "\n3. Coffe  --> Rs.20" +
                "\n4. Cold Coffe  --> Rs.30" +
                "\n5. Burger  --> Rs.50");
    }

    public static void addMenu() {
        menuHashMap.put(1,new Menu(1,"Noodles",50));
        menuHashMap.put(2,new Menu(2,"Tea",10));
        menuHashMap.put(3,new Menu(3,"Coffee",20));
        menuHashMap.put(4,new Menu(4,"Cold Coffee",30));
        menuHashMap.put(5,new Menu(5,"Burger",50));
    }


}
