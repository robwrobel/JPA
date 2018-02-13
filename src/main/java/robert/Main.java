package robert;

import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
  static EntityManagerFactory factory=Persistence.createEntityManagerFactory("utrwalacz");
  public static void main(String[] args) {

    create(1,"Witaj swiecie");
    create(2,"Witaj JPA");
    create(3,"Witaj Hiberze");

    readAll();
  }

  private static void readAll() {
    EntityManager em = factory.createEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();

/*    em.createNativeQuery("select * from content")
        .getResultList()
        .forEach(System.out::println);*/

    em.createQuery("from Message",Message.class)
        .getResultList()
        .forEach(System.out::println);

    et.commit();



  }

  static void create(int id, String message ) {

    EntityManager em = factory.createEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();

    em.persist( new Message(message));
/*
    Query query = em.createNativeQuery("insert into content ( text) values (:message)", Message.class);
   // query.setParameter("id",id);
    query.setParameter("message",message);
    query.executeUpdate();

*/

    et.commit();

  }
}
