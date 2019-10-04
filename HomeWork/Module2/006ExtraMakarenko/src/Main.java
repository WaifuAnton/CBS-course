public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        arrayList.remove(8);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}
