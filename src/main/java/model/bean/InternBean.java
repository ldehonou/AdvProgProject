package model.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.InternEntity;

import java.util.Collection;

@Stateless
public class InternBean {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        public void createIntern(String lastname, String firstname, String phone, String address, String postalcode, String city, String email) {
            InternEntity internEntity = new InternEntity();
            internEntity.setLastname(lastname);
            internEntity.setFirstname(firstname);
            internEntity.setPhone(phone);
            internEntity.setAddress(address);
            internEntity.setPostalcode(postalcode);
            internEntity.setCity(city);
            internEntity.setEmail(email);

            entityManager.getTransaction().begin();
            entityManager.persist(internEntity);
            entityManager.getTransaction().commit();
        }

        public Collection<InternEntity> getAllInterns() {
            Query query = entityManager.createQuery("select i from InternEntity i");
            return query.getResultList();
        }

        public InternEntity getInternById(int id) {
            Query query = entityManager.createQuery("select i from InternEntity i where i.id = :id");
            query.setParameter("id", id);
            return (InternEntity) query.getSingleResult();
        }
}
