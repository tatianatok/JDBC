package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {

    //Создание (добавление) сущности Employee в таблицу
    void create(Employee employee);

    //Получение конкретного объекта Employee по id
    Employee findById(int id);

    //Получение списка всех объектов Employee из базы
    List<Employee> findAll();

    //Изменение конкретного объекта Employee в базе по id
    void update (Employee employee);

    //Удаление конкретного объекта Employee из базы по id
    void deleteById(Employee employee);
}
