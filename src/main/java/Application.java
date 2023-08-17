import dao.CityDao;
import dao.CityDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();

        City omsk = new City();
        omsk.setCity_name("Omsk");
        System.out.println(omsk);

        Employee employee3 = new Employee("Иван",
                "Сидоров",
                "муж",
                50);

        employee3.setCity(omsk);

        System.out.println(employee3);

    }

}

