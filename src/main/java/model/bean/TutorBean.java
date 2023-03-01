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

    public TutorEntity getTutorByEmail(String email){
        TutorEntity tutor = entityManager.createQuery("SELECT t FROM TutorEntity t WHERE t.email = :email", TutorEntity.class)
                .setParameter("email", email)
                .getSingleResult();
        entityManager.clear();
        return tutor;
    }

    public TutorEntity getTutors(String identifiant, String password) {
        TutorEntity tutor = entityManager.createQuery("SELECT t FROM TutorEntity t WHERE t.email = :identifiant AND t.password = :password", TutorEntity.class)
                .setParameter("identifiant", identifiant)
                .setParameter("password", password)
                .getSingleResult();
        return tutor;
    }

}
