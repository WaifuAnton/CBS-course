package command;

import entity.*;
import helper.*;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;

public class RentDeviceCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        User user = (User) req.getAttribute("user");

        int id = Integer.parseInt(req.getParameter("device_id"));
        String type = req.getParameter("device_type");
        String name = req.getParameter("device_name");
        double rentCost = Double.parseDouble(req.getParameter("device_price"));
        double balance = user.getBalance();

        if (balance >= rentCost) {
            user.setBalance(balance - rentCost);
            
            switch (type) {
                case "Conditioner":
                    ConditionerHelper conditionerHelper = new ConditionerHelper();
                    Conditioner conditioner = conditionerHelper.getById(id);
                    conditioner.setUsedBy(user.getLogin());
                    conditionerHelper.update(id, conditioner);
                    break;

                case "Kettle":
                    KettleHelper kettleHelper = new KettleHelper();
                    Kettle kettle = kettleHelper.getById(id);
                    kettle.setUsedBy(user.getLogin());
                    kettleHelper.update(id, kettle);
                    break;

                case "WashingMachine":
                    WashingMachineHelper washingMachineHelper = new WashingMachineHelper();
                    WashingMachine washingMachine = washingMachineHelper.getById(id);
                    washingMachine.setUsedBy(user.getLogin());
                    washingMachineHelper.update(id, washingMachine);
                    break;

                default:
                    ElectricityItemHelper helper = new ElectricityItemHelper();
                    ElectricityItem item = helper.getById(id);
                    item.setUsedBy(user.getLogin());
                    helper.update(id, item);
            }
        }
        return "controller?action=main";
    }
}
