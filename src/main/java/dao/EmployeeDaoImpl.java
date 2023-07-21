package dao;

import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final Connection connection;

    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    //Метод добавления
    @Override
    public void create(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (id, first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?), (?))")) {

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirst_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getCity_id());
            statement.executeUpdate();
            //statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Метод получения объекта по id
    @Override
    public Employee findById(int id) {

        Employee employee = new Employee();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id AND id=(?)")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while(resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                // и присваиваем их полим объекта
                employee.setId(Integer.parseInt(resultSet.getString("id")));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity_id(Integer.parseInt(resultSet.getString("city_id")));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    //Метод обновления данных в базе
        @Override
        public void update(Employee employee) {
            try(PreparedStatement statement = connection.prepareStatement(
                    "UPDATE employee SET id = (?), first_name = (?), last_name = (?), age = (?),  city_id = (?) WHERE id = (?);")) {

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    statement.setInt(1, employee.getId());
                    statement.setString(2, employee.getFirst_name());
                    statement.setString(3, employee.getLast_name());
                    statement.setInt(4, employee.getAge());
                    City city = new City(resultSet.getInt("city_id"),
                            resultSet.getString("city_name"));
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    //Метод удаления данных из базы
        @Override
        public void deleteById(int id) {
            try(PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM employee WHERE id=(?)")) {

                statement.setInt(1, id);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    //Получение всех объектов из базы
        @Override
        public List<Employee> findAll() {

        // Создаем список, в который будем укладывать объекты
        List<Employee> employeeList = new ArrayList<>();
            try(PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM employee")) {

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    int id = Integer.parseInt(resultSet.getString("id"));
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String gender = resultSet.getString("gender");
                    int age = resultSet.getInt("age");
                    int city_id = Integer.parseInt(resultSet.getString("city_id"));

                    // Создаем объекты на основе полученных данных
                    // и укладываем их в итоговый список
                    employeeList.add(new Employee(id, firstName, lastName, gender, age, city_id));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return employeeList;
    }
}

