import dao.ConditionerDB;
import dao.DAOFactory;
import entities.Conditioner;

public class Main {
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getFactory();
        Conditioner conditioner = new Conditioner("Mimi", 12, 15, 25);
        ConditionerDB conDB = new ConditionerDB();
        conDB.add(conditioner);
    }
}
