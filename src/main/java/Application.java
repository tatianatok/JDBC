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

            Employee employee3 = new Employee("Иван",
                                              "Сидоров",
                                              "муж",
                                              50);

            //employeeDao.create(employee3);

                List<Employee> employeeList = employeeDao.findAll();
        employeeList.stream()
                .forEach(System.out::println);

        City omsk = new City("Omsk");
        cityDao.save(omsk);

        employeeDao.create(employee3);
        employee3.setCity(omsk);


        List<Employee> list = employeeDao.findAll();

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }



        // Изменяем объект
        //employeeDao.update(employee3);

        // Удаляем объект
        //employeeDao.deleteById(employee2);

}

