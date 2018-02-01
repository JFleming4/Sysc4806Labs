
import AddressBook.BuddyInfo;
import AddressBook.AddressBook;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    BuddyInfo bud1;
    AddressBook book;
    @Before
    public void setUp() throws Exception {
        book = new AddressBook();
        bud1 = new BuddyInfo("Fred", "456456159");
        book.addBuddy(bud1);
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(1, book.getSize());
    }
    @Test
    public void addBuddy() throws Exception {
        BuddyInfo newBud = new BuddyInfo("Derek", "456981231");
        book.addBuddy(newBud);
        assertEquals(2, book.getSize());
    }

//    @Test
//    public void testPersist() throws Exception {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persister");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        BuddyInfo newBud = new BuddyInfo("Derek", "456981231");
//        book.addBuddy(newBud);
//        tx.begin();
//        em.persist(book);
//        tx.commit();
//
//        Query q = em.createQuery("SELECT ab from AddressBook ab ");
//
//        List<AddressBook> results = q.getResultList();
//
//        System.out.println("List of Buddies");
//
//        for(AddressBook b: results) {
//            System.out.println(b);
//        }
//    }
}