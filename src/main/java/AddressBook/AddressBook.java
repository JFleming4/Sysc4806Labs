package AddressBook;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    @Id@GeneratedValue
    private Long id;

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }


    public void addBuddy(BuddyInfo buddy) {

        this.buddies.add(buddy);
        if(buddy.getBook() != this) {
            buddy.setBook(this);
        }
    }
    public void removeBuddy(int index) {
        buddies.remove(index);
    }

    public BuddyInfo getBuddyAt(int index) {
        return buddies.get(index);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public int getSize() { return this.buddies.size(); }

    @Override
    public String toString() {
        String stringOut = "Address Book:\n";
        for(BuddyInfo buddy: this.buddies) {
            stringOut += "\t" + buddy;
        }
        return stringOut;
    }
    public static void main(String[] args) {


        BuddyInfo bud1 = new BuddyInfo("Bob", "45646565456");
        BuddyInfo bud2 = new BuddyInfo("Carl", "123312132");
        BuddyInfo bud3 = new BuddyInfo("Dean", "789789789");
        BuddyInfo bud4 = new BuddyInfo("Edward", "369396396");
        BuddyInfo bud5 = new BuddyInfo("Frank", "174174174");

        AddressBook book = new AddressBook();
        book.addBuddy(bud1);
        book.addBuddy(bud2);
        book.addBuddy(bud3);
        book.addBuddy(bud4);
        book.addBuddy(bud5);
        System.out.println(book);
    }
}

