package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
            // 영속
            // Member member1 = new Member(150L, "A");
            // Member member2 = new Member(160L, "B");

            // em.persist(member1);
            // em.persist(member2);

            // 저장된 데이터 변경 : dirty checking

            // SEQUENCE
            // Member member = em.find(Member.class, 150L);
            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            // 실제 쿼리가 수행되는 시점
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
