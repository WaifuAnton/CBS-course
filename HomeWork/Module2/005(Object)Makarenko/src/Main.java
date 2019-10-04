public class Main {
    public static void main(String[] args) {
        Device[] devices1 =
                {
                        new Device(),
                        new Monitor("Samsung", 2000, "AA88B"),
                        new EthernetAdapter("Some company", 300, "A9B67", "AA:BB:C89", 500)
                };
        Device[] devices2 =
                {
                        new Device(),
                        new Monitor("Dell", 3000, "AA88B"),
                        new EthernetAdapter("Some company", 300, "A9B67", "AA:Cd:C89"),
                        new Monitor("Samsung", 2000, "AA90C")
                };
        for (int i = 0; i < devices1.length; i++) {
            for (int j = 0; j < devices2.length; j++) {
                System.out.println(devices1[i]);
                System.out.println("&&");
                System.out.println(devices2[j]);
                System.out.println("=");
                System.out.println(devices1[i].equals(devices2[j]));
                System.out.println();
            }
        }
    }
}
