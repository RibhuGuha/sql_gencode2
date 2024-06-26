package com.mycompany.group234.repository;

import com.mycompany.group234.model.OtherDetails;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class OtherDetailsRepository extends SimpleJpaRepository<OtherDetails, String> {
    private final EntityManager em;
    public OtherDetailsRepository(EntityManager em) {
        super(OtherDetails.class, em);
        this.em = em;
    }
    @Override
    public List<OtherDetails> findAll() {
        return em.createNativeQuery("Select * from exclusiveaccess.OtherDetails", OtherDetails.class).getResultList();
    }
}