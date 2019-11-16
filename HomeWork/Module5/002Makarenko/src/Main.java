import dao.ConditionerDB;
import dao.DAOFactory;
import entities.Conditioner;
import entities.ElectricityItem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getFactory();
//        Conditioner conditioner = new Conditioner("Mimi", 12, 15, 25);
        ConditionerDB conDB = new ConditionerDB();
//        conDB.add(conditioner);
        conDB.remove(3);
        List<ElectricityItem> conditioners = conDB.getAll();
        for (ElectricityItem item : conditioners)
            System.out.println(item);
    }
}
