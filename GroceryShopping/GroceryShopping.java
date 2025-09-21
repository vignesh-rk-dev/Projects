import java.util.Scanner;

// Custom exception class for item not found
class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
public class GroceryShopping {
    public static void main(String s[]) {
        String[] item = new String[10];
        float[] price = new float[10];

        // grocery items
        item[0] = "Apple";price[0] = 2.89f;
        item[1] = "Orange";price[1] = 2.33f;
        item[2] = "Watermelon";price[2] = 0.99f;
        item[3] = "Banana";price[3] = 2.21f;
        item[4] = "potato";price[4] = 3.874f;
        item[5] = "Bread";price[5] = 0.55f;
        item[6] = "Cake"; price[6] = 0.67f;
        item[7] = "Chilli";price[7] = 0.44f;
        item[8] = "Tomato";price[8] = 0.568f;
        item[9] = "chips";price[9] = 1.87f;

        Scanner scan = new Scanner(System.in);

        // outer loop for multiple users
        while (true) {
            //Reset for each user
            float totalBill = 0.0f; 

            // inner loop for single user's shopping
            while (true) {
                try {
                    System.out.println("Enter the name of the item (or 'exit' to finish shopping):");
                    String userInput = scan.nextLine();

                    if (userInput.equalsIgnoreCase("exit")) {
                        System.out.println("Your Total bill is : INR " + totalBill);
                        System.out.println("Thank you for using the shopping cart. Goodbye!");
                        break; // exit inner loop
                    }
                    int itemIndex = -1;
                    for (int i = 0; i < item.length; i++) {
                        if (item[i].equalsIgnoreCase(userInput)) {
                            itemIndex = i;
                            break;
                        }
                    }

                    if (itemIndex == -1) {
                        throw new ItemNotFoundException("Item '" + userInput + "' not found. Try again!");
                    }

                    System.out.println("Enter the Quantity of " + item[itemIndex] + ":");
                    int quantity = scan.nextInt();
                    scan.nextLine(); // consume newline

                    float itemCost = price[itemIndex] * quantity;
                    totalBill += itemCost;

                    System.out.println("Added " + quantity + " x " + item[itemIndex] +
                            " to the bill. Current total: INR " + totalBill);

                } catch (ItemNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine(); // clear invalid input
                }
            }

            // Asking if another customer wants to shop
            System.out.println("Is there another customer? (yes/no)");
            String moreCustomers = scan.nextLine();
            if (moreCustomers.equalsIgnoreCase("no")) {
                System.out.println("Shop closed. Have a great day!");
                break; // exit outer loop
            }
        }

        scan.close();
    }
}
