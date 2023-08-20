package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDao {
    City save(City city);

    City findByIdCity(Integer id);

    City updateCity(City city);


    City deleteById(City city);

    List<City> findAllCity();

    List<Employee> findAllEmployeeByCityId(Integer id);
}
