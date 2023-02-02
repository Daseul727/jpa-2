package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    /*public static void main(String[] args) {

        //1. 어플리케이션 로딩시점에 딱하나 만들어짐
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //2. 사용자가 행동을 할때마다 entity manager 만들어야됨. 한 쓰레드마다 사용하고 버려야됨 공유하면안됨!!!! 절대로
        EntityManager em = emf.createEntityManager();

        //3. 이것만 있으면 단순저장안됨 2번 트랜젝션을 로딩해야지 저장됨
        EntityTransaction ts = em.getTransaction();
        ts.begin();

        Member member = new Member();
        member.setId(2L);
        member.setName("hello-B");
        em.persist(member); //save

        ts.commit();

        em.close();
        emf.close();
    }*/

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); //객체를 대신 저장해주는 역할

        EntityTransaction ts = em.getTransaction();
        ts.begin();
        
        try {

            Member findMember = em.find(Member.class, 1L);

            //persistense 안해도 이 순간 set 변경감지해서 update 쿼리나감
            findMember.setName("sssss");


            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
