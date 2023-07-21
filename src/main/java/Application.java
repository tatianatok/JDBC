import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "1111";

        // Создаем соединение с базой с помощью Connection
        Connection connection = DriverManager.getConnection(url, user, password);

        // Формируем запрос к базе с помощью PreparedStatement
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)"); {

            // Подставляем значение вместо wildcard
            statement.setInt(1, 5);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
                 while (resultSet.next()) {

                     // С помощью методов getInt и getString получаем данные из resultSet
                     String id = "ID: " + resultSet.getInt("id");
                     String firstName = "имя: " + resultSet.getString("first_name");
                     String lastName = "фамилия: " + resultSet.getString("last_name");
                     String gender = "пол: " + resultSet.getString("gender");
                     String age = "возраст: " + resultSet.getInt("age");
                     String city ="город: " + resultSet.getInt("city_id");

                     // Выводим данные в консоль
                     System.out.println(id);
                     System.out.println(firstName);
                     System.out.println(lastName);
                     System.out.println(gender);
                     System.out.println(age);
                     System.out.println(city);

            // Создаем объект класса
            EmployeeDao employeeDao = new EmployeeDaoImpl(connection);

                 //City city1 = new City(1, "Москва");
                 //Employee employee1 = new Employee(6,"Евгений", "Лебедев", "м", 40, city1.getCity_id());

            //Вызываем метод добавления объекта
                 //employeeDao.create(employee1);

            //Вызываем метод удаления объекта
                 //employeeDao.deleteById(11);

            // Создаем список наполняя его объектами, которые получаем
            // путем вызова метода для получения всех элементов таблицы
                 List<Employee> list = new ArrayList<>(employeeDao.findAll());

                     // Выведем список в консоль
                     for (Employee employee : list) {
                         System.out.println(employee);
                     }


            System.out.println(employeeDao.findById(2));

            }
        }
    }
}
