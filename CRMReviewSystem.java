import java.util.*;

class Review {
    private String customerId;
    private String experienceDuration;
    private String reviewText;

    // Constructor
    public Review(String customerId, String experienceDuration, String reviewText) {
        this.customerId = customerId;
        this.experienceDuration = experienceDuration;
        this.reviewText = reviewText;
    }
1
    @Override
    public String toString() {
        return "Customer ID: " + customerId +
                "\nExperience Duration: " + experienceDuration +
                "\nReview: " + reviewText + "\n";
    }
}

public class CRMReviewSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, List<Review>> reviewDB = new HashMap<>();

    // Sample data
    private static final Map<String, List<String>> products = new LinkedHashMap<>();

    static {
        products.put("Laptop", Arrays.asList("HP", "Dell", "Lenovo", "Asus"));
        products.put("Mobile", Arrays.asList("Samsung", "Apple", "OnePlus", "Xiaomi"));
        products.put("Tablet", Arrays.asList("iPad", "Samsung Tab", "Lenovo Tab"));
        products.put("Smartwatch", Arrays.asList("Apple Watch", "Samsung Galaxy Watch", "Fitbit"));
        products.put("Headphones", Arrays.asList("Sony", "Bose", "JBL", "Boat"));
        products.put("Television", Arrays.asList("LG", "Samsung", "Sony", "Panasonic"));
        products.put("Refrigerator", Arrays.asList("LG", "Whirlpool", "Samsung", "Godrej"));
        products.put("Washing Machine", Arrays.asList("Bosch", "IFB", "Samsung", "Whirlpool"));
        products.put("Camera", Arrays.asList("Canon", "Nikon", "Sony", "Fujifilm"));
        products.put("Printer", Arrays.asList("HP", "Canon", "Epson", "Brother"));
    }

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== CRM Review System =====");
            System.out.println("1. Write Review");
            System.out.println("2. View Reviews");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> writeReview();
                case 2 -> viewReviews();
                case 3 -> {
                    System.out.println("Exiting... Thank you!");
                    running = false;
                }
                default -> System.out.println(" Invalid choice! Try again.");
            }
        }
    }

    private static void writeReview() {
        String product = chooseProduct();
        if (product == null) return;

        String model = chooseModel(product);
        if (model == null) return;

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine().trim();

        System.out.print("Enter Experience Duration (e.g., 6 months): ");
        String duration = sc.nextLine().trim();

        System.out.print("Enter your Review: ");
        String reviewText = sc.nextLine().trim();

        String key = product + "-" + model;
        reviewDB.putIfAbsent(key, new ArrayList<>());
        reviewDB.get(key).add(new Review(customerId, duration, reviewText));

        System.out.println(" Review submitted successfully!");
    }

    private static void viewReviews() {
        String product = chooseProduct();
        if (product == null) return;

        String model = chooseModel(product);
        if (model == null) return;

        String key = product + "-" + model;
        List<Review> reviews = reviewDB.getOrDefault(key, new ArrayList<>());

        if (reviews.isEmpty()) {
            System.out.println("⚠️ No reviews found for " + model + " " + product);
        } else {
            System.out.println("\n--- Reviews for " + model + " " + product + " ---");
            for (Review r : reviews) {
                System.out.println(r);
            }
        }
    }

    private static String chooseProduct() {
        System.out.println("\nChoose a Product:");
        List<String> productList = new ArrayList<>(products.keySet());

        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
        System.out.print("Enter choice: ");
        int choice = getIntInput();

        if (choice < 1 || choice > productList.size()) {
            System.out.println(" Invalid product choice!");
            return null;
        }
        return productList.get(choice - 1);
    }

    private static String chooseModel(String product) {
        System.out.println("\nChoose a Model for " + product + ":");
        List<String> models = products.get(product);

        for (int i = 0; i < models.size(); i++) {
            System.out.println((i + 1) + ". " + models.get(i));
        }
        System.out.print("Enter choice: ");
        int choice = getIntInput();

        if (choice < 1 || choice > models.size()) {
            System.out.println(" Invalid model choice!");
            return null;
        }
        return models.get(choice - 1);
    }

    // Utility method to safely read integers
    private static int getIntInput() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine().trim());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("⚠️ Invalid input! Enter a number: ");
            }
        }
    }
}
