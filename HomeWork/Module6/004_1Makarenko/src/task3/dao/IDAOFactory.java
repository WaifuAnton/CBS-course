package task3.dao;

import java.sql.Connection;

/**
 * Created by Asus on 31.01.2018.
 */
public interface IDAOFactory {

    CarDAO getCarDAO();

    ClientDAO getClientDAO();


}
