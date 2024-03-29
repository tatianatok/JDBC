import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        // Создаем объект класса ДАО
        EmployeeDao employeeDao = new EmployeeDaoImpl();

            Employee employee2 = new Employee("Евгений",
                                              "Лебедев",
                                              "м",
                                              40,
                                              5);

        // Создаем объект
        //employeeDao.create(employee2);

        // Получаем объект по id
        System.out.println(employeeDao.findById(13));

        // Получаем полный список объектов
        List<Employee> list = employeeDao.findAll();

              for (Employee employee : list) {
                  System.out.println(employee);
                  }

        Employee employee3 = employeeDao.findAll().get(0);
        employee3.setFirst_name("Денис");

        // Изменяем объект
        employeeDao.update(employee3);

        // Удаляем объект
        //employeeDao.deleteById(employee2);

    }
}
