package task3;

import java.util.Comparator;

public class ShopComparator implements Comparator<Price> {
    @Override
    public int compare(Price o1, Price o2) {
        return o1.getShopName().compareTo(o2.getShopName());
    }
}
