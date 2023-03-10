package model.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.CompanyEntity;
import model.entity.InternEntity;
import model.entity.InternshipEntity;
import model.entity.TutorEntity;

import java.sql.Date;
import java.util.Collection;

@Stateless
public class InternshipBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void createInternship(TutorEntity tutor, InternEntity intern, CompanyEntity company, String mission, Date startedDate, Date endedDate) {
        entityManager.getTransaction().begin();
        InternshipEntity internship = new InternshipEntity();

        internship.setTutorByIdTutor(tutor);
        internship.setInternByIdIntern(intern);
        internship.setCompanyByIdCompany(company);
        internship.setNoteCom("-");
        internship.setNoteTech("-");
        internship.setMission(mission);
        internship.setStartedDate(startedDate);
        internship.setEndedDate(endedDate);
        internship.setCdc(false);
        internship.setVisitSheet(false);
        internship.setEvalSheet(false);
        internship.setWebSurvey(false);
        internship.setReport(false);
        internship.setDefense(false);

        entityManager.merge(internship);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public Collection<InternshipEntity> getAllInternship() {
        Query query = entityManager.createQuery("select i from InternshipEntity i");
        return query.getResultList();
    }

    public InternshipEntity getInternshipById(int id) {
        Query query = entityManager.createQuery("select i from InternshipEntity i where i.id = :id");
        query.setParameter("id", id);
        return (InternshipEntity) query.getSingleResult();
    }

    public InternshipEntity getInternshipByIdIntern(InternEntity intern, TutorEntity tutor) {
        Query query = entityManager.createQuery("select i from InternshipEntity i where i.internByIdIntern = :id and i.tutorByIdTutor = :tutor");
        query.setParameter("id", intern);
        query.setParameter("tutor", tutor);
        return (InternshipEntity) query.getSingleResult();
    }

    public void updateInternship(int idIntern, boolean cdc,boolean visitSheet,boolean evalSheet,boolean webSurvey,boolean report, boolean defense, String noteTech, String noteCom){
        Query query = entityManager.createQuery("select i from InternshipEntity i where i.id = :id");
        query.setParameter("id", idIntern);
        InternshipEntity internship = (InternshipEntity) query.getSingleResult();
        entityManager.getTransaction().begin();
        internship.setCdc(cdc);
        internship.setVisitSheet(visitSheet);
        internship.setEvalSheet(evalSheet);
        internship.setWebSurvey(webSurvey);
        internship.setReport(report);
        internship.setDefense(defense);
        internship.setNoteTech(noteTech);
        internship.setNoteCom(noteCom);
        entityManager.merge(internship);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

}


