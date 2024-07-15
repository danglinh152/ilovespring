package test.database.testDatabase.DAO;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.database.testDatabase.entity.sinhVien;


import java.util.List;

@Repository
@Transactional
public class sinhVienDAOImpl implements sinhVienDAO {
    private EntityManager em;

    @Autowired
    public sinhVienDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(sinhVien sv) {
        em.persist(sv);
    }

    @Override
    public List<sinhVien> ListOfSV() {
        String jpql = "SELECT s FROM sinhVien s";
        return em.createQuery(jpql, sinhVien.class).getResultList();
    }

    @Override
    public void delete(int id) {
        sinhVien svDelete = em.find(sinhVien.class, id);
        em.remove(svDelete);
//        String jpql = "DELETE FROM sinhVien s WHERE s.ID = :x";
//        em.createQuery(jpql, sinhVien.class).setParameter(x, sv.getId()).executeUpdate();
    }

    @Override
    public void update(sinhVien sv) {
        em.merge(sv);
    }

    @Override
    public sinhVien getByID(int id) {
        return em.find(sinhVien.class, id);
    }
}
