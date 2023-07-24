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
        // В ресурсах блока try создаем объект сессии с помощью нашего конфиг-файла
        // И открываем сессию
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            // Создаем транзакцию и начинаем ее
            Transaction transaction = session.beginTransaction();
            // вызываем на объекте сессии метод save
            // данный метод внутри себя содержит необходимый запрос к базе
            // для создания новой строки
            session.save(employee);
            // Выполняем коммит, то есть сохраняем изменения,
            // которые совершили в рамках транзакции
            transaction.commit();
        }
    }

    //Метод получения объекта по id
    @Override
    public Employee findById(int id) {
        // С помощью конфиг-файла получаем сессию, открываем ее
        // и через метод get получаем объект
        // В параметре метода get нужно указать объект какого класса нам нужен
        // и его id
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }


    //Метод обновления данных в базе
        @Override
        public void update(Employee employee) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                // Для обновления данных нужно передать в конструктор
                // объект с актуальными данными
                session.update(employee);
                transaction.commit();
            }
        }


    //Метод удаления данных из базы
        @Override
        public void deleteById(Employee employee) {
            try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                // Для удаления объекта из таблицы нужно передать его в метод delete
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