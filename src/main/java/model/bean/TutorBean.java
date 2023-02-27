package model.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.TutorEntity;

import java.util.Collection;

@Stateless
public class TutorBean {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Collection<TutorEntity> getAllTutors() {
        Query query = entityManager.createQuery("select t from TutorEntity t");
        return query.getResultList();
    }


}