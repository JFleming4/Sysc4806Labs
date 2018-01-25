package AddressBook;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {
    private String name;
    private String number;
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private AddressBook book;
    public BuddyInfo() {this(null,null);}
    public BuddyInfo(String Name, String Number) {
        this.name = Name;
        this.number = Number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setBook(AddressBook abook) {
        if(!abook.getBuddies().contains(this)) {
            abook.addBuddy(this);
        }
        this.book= abook;
    }

    public AddressBook getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Name: "+this.name + " Number: " + this.number + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof BuddyInfo) {
            BuddyInfo buds = (BuddyInfo) obj;
            return buds.name.equals(this.name) && buds.number.equals(this.number);
        }
        return super.equals(obj);
    }
}
