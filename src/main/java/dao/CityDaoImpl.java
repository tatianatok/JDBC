package dao;

import hibernate.HibernateSessionFactoryUtil;
import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public City save(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City findByIdCity(Integer id) {
        City city = new City("Тюмень");
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            city = session.get(City.class, id);
        }
        return city;
    }

    @Override
    public List<City> findAllCity() {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM City ").list();
        }
    }

    @Override
    public City updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City deleteById(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public List<Employee> findAllEmployeeByCityId(Integer id) {
        City city = new City("Тюмень");
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            city = session.get(City.class, id);
            transaction.commit();
        }
        return city.getEmployees();
    }

}