import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Item> requestItems = createList("Enter no of items  that your mother orderd");
        List<Item> responseItems = createList(" Enter no of items that you have  brought");
        checking(requestItems, responseItems);
    }

    private static void checking(List<Item> requestItems, List<Item> responseItems) {
        Map<String, Integer> missingItems = check(requestItems, responseItems);
        System.out.print("Mother ordered : { ");
        for (Item item : requestItems) {
            System.out.print(item.getName() + " =" + item.getQuantity() + " ");
        }
        System.out.println("}");
        System.out.print("you purchased items : {");
        for (Item item : responseItems) {
            System.out.print(item.getName() + " =" + item.getQuantity() + " ");
        }
        System.out.println("}");
        print(missingItems);
    }

    private static List<Item> createList(String message) {
        List<Item> requestItem = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int size = scanner.nextInt();
        int index = 1;
        while (size != 0) {
            System.out.println("Enter " + index + " item:");
            System.out.println("Item name :");
            scanner.nextLine();
            String itemName = scanner.nextLine();

            System.out.println("enter " + itemName + " quantity :  ");
            int quantity = scanner.nextInt();
            requestItem.add(new Item(itemName, quantity));
            index++;
            size--;
        }
        return requestItem;
    }

    public static Map<String, Integer> check(List<Item> requestItems, List<Item> responseItems) {
        HashMap<String, Integer> missingItems = new HashMap<>();
        for (Item item : requestItems) {
            missingItems.put(item.getName(), item.getQuantity());
        }
        for (Item item : responseItems) {
            String name = item.getName();
            int quantity = item.getQuantity();
            if (missingItems.containsKey(name)) {
                if (missingItems.get(name) <= quantity) {
                    missingItems.remove(name);
                } else {
                    missingItems.put(name, missingItems.get(name) - quantity);
                }
            }

        }
        return missingItems;
    }

    public static void print(Map<String, Integer> missingItems) {
        System.out.println("missing items : " + missingItems);
    }

}

