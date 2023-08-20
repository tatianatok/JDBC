package dao;

import hibernate.HibernateSessionFactoryUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    //Метод добавления
    @Override
    public void create(Employee employee) {

        try ( Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    //Метод получения объекта по id
    @Override
    public Employee findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }


    //Метод обновления данных в базе
    @Override
    public void update(Employee employee) {
        try (Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }


    //Метод удаления данных из базы
        @Override
        public void deleteById(Employee employee) {
            try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
            }
        }

    //Получение всех объектов из базы
        @Override
        public List<Employee> findAll() {
            List<Employee> users = (List<Employee>)  HibernateSessionFactoryUtil
                    .getSessionFactory().openSession().createQuery("From Employee ").list();
            return users;
        }

}