import dao.*;
import entities.Conditioner;
import entities.ElectricityItem;
import entities.Kettle;
import entities.WashingMachine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getFactory();
        ElectricityItemDB itemDB = new ElectricityItemDB();
        WashingMachineDB washingMachineDB = new WashingMachineDB();
        KettleDB kettleDB = new KettleDB();
        ConditionerDB conditionerDB = new ConditionerDB();

//        ElectricityItem item1 = new ElectricityItem(12);
//        itemDB.add(item1);
//        ElectricityItem item2 = new ElectricityItem(25);
//        item2.turnOn();
//        itemDB.add(item2);
//
//        WashingMachine washingMachine = new WashingMachine("Bosh", 100, 40);
//        washingMachineDB.add(washingMachine);
//
//        Kettle kettle1 = new Kettle("Bosh", 30, 3);
//        Kettle kettle2 = new Kettle("BiBi", 35, 5);
//        kettle2.turnOn();
//        kettleDB.add(kettle1);
//        kettleDB.add(kettle2);

        List<ElectricityItem> all = new ArrayList<>();
        List<ElectricityItem> conditioners = conditionerDB.getAll();
        List<ElectricityItem> kettles = kettleDB.getAll();
        List<ElectricityItem> washingMachines = washingMachineDB.getAll();
        List<ElectricityItem> items = itemDB.getAll();

        for (int i = 0; i < conditioners.size(); i++)
            all.add(conditioners.get(i));
        for (int i = 0; i < kettles.size(); i++)
            all.add(kettles.get(i));
        for (int i = 0; i < washingMachines.size(); i++)
            all.add(washingMachines.get(i));
        for (int i = 0; i < items.size(); i++)
            all.add(items.get(i));

        all.sort(ElectricityItem::compareTo);
        System.out.println("The most least device is " + all.get(0).getClass() + " " + all.get(0).getName());
        System.out.println("The most powerful device is " + all.get(all.size() - 1).getClass() + " " + all.get(all.size() - 1).getName());

        int overallPower = 0;
        for (ElectricityItem item : all) {
            if (item.isTurnedOn())
                overallPower += item.getPower();
            if (overallPower >= 10) {
                System.out.println("BOOM");
                break;
            }
        }
    }
}
