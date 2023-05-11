package jpabook;


import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        //고객이 DB에 접근하는 한 일관적인 단위를 할때마다 EntitiyManager를 만들어 주어야 한다.

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            tx.commit(); // [트랜잭션] 커밋
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
