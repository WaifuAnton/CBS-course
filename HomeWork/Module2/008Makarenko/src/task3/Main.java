package task3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int N = 2;
        Price[] prices = new Price[N];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = priceInitializer();
        }
        Arrays.sort(prices, new ShopComparator());
        for (Price price : prices) {
            System.out.println(price);
        }
        System.out.println();
        System.out.print("Enter desired item: ");
        Scanner scanner = new Scanner(System.in);
        String desiredItem = scanner.nextLine();
        try {
            boolean inStock = false;
            for (Price price : prices) {
                if (price.getItemName().equals(desiredItem)) {
                    inStock = true;
                    System.out.println(price);
                }
            }
            if (!inStock)
                throw new PriceException("No such item");
        }
        catch (PriceException priceExc) {
            System.out.println(priceExc.getMessage());
        }
    }

    private static Price priceInitializer() {
        Scanner scanner = new Scanner(System.in);
        String item, shop;
        double price;
        System.out.print("Item: ");
        item = scanner.nextLine();
        System.out.print("Shop: ");
        shop = scanner.nextLine();
        System.out.print("Price: ");
        price = scanner.nextDouble();
        System.out.println();
        return new Price(item, shop, price);
    }
}
