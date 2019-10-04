package Task1;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setApartment(123);
        address.setIndex(11111);
        address.setCity("City");
        address.setCountry("Country");
        address.setHouse("House");
        address.setStreet("Street");
        System.out.println(address.getCountry() + '\n'
        + address.getCity() + '\n'
        + address.getStreet() + '\n'
        + address.getHouse() + '\n'
        + address.getApartment() + '\n'
        + address.getIndex());
    }
}
