package model.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entity.CompanyEntity;
import model.entity.InternshipEntity;

@Stateless
public class CompanyBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CompanyEntity createCompany(String company, String address, String postalCode, String city){
        entityManager.getTransaction().begin();
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(company);
        companyEntity.setAddress(address);
        companyEntity.setCity(city);
        companyEntity.setPostalcode(postalCode);

        entityManager.persist(companyEntity);
        entityManager.getTransaction().commit();

        entityManager.clear();

        return companyEntity;

    }
}
