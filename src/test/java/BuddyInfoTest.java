import org.junit.Before;
import org.junit.Test;
import AddressBook.BuddyInfo;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo bud;
    BuddyInfo bud2;
    @Before
    public void setUp() throws Exception {
        bud = new BuddyInfo("Justin", "9879879879");
        bud2 = new BuddyInfo("George", "8258252855");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Justin", bud.getName());
    }

    @Test
    public void setName() throws Exception {
        bud.setName("George");
        assertEquals("George", bud.getName());
    }

    @Test
    public void getNumber() throws Exception {
        assertEquals("9879879879", bud.getNumber());
    }
    @Test
    public void testEquals() throws  Exception {
        BuddyInfo bud2 = new BuddyInfo("Justin", "9879879879");
        assertTrue(bud.equals(bud2));
    }
    @Test
    public void setNumber() throws Exception {
        bud.setNumber("789");
        assertEquals("789", bud.getNumber());
    }

    @Test
    public void testPersist() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persister");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(bud);
        em.persist(bud2);
        tx.commit();

        Query q = em.createQuery("SELECT b from BuddyInfo b ");

        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of Buddies");

        for(BuddyInfo b: results) {
            System.out.println(b);
        }
        //assertTrue(results.contains(bud) && results.contains(bud2) && results.size() == 2);
    }
}