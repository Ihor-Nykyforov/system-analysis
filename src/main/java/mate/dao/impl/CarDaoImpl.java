package mate.dao.impl;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;
import mate.dao.CarDao;
import mate.model.Car;
import mate.model.User;
import mate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CarDaoImpl implements CarDao {
    @Override
    public Car addCar(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert car " + car, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Car getCar(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Car.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get a car by id: " + id, e);
        }
    }

    @Override
    public List<Car> getAllCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Car> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Car.class);
            criteriaQuery.from(Car.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all cars", e);
        }
    }

    @Override
    public Optional<Car> getCarByBrandModelYear(String brand, String model, int year) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> query = session.createQuery("from Car c where c.brand = :brand " +
                    "and c.model = :model and c.year = :year", Car.class);
            query.setParameter("brand", brand);
            query.setParameter("model", model);
            query.setParameter("year", year);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}
