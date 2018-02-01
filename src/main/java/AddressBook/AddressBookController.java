package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    @Autowired
    private AddressBookRepository bookRepo;

    @Autowired
    private BuddyInfoRepository buddyRepo;
    @RequestMapping(value="/addbuddy")
    public void addBuddy(@RequestParam(value="buddyId")String budId,
                         @RequestParam(value="bookId") String bookId) {
        Long buddyId = new Long(budId);
        Long aBookId = new Long(bookId);
        AddressBook book = bookRepo.findById(aBookId);
        BuddyInfo bud = buddyRepo.findById(buddyId);
        book.addBuddy(bud);
        bookRepo.save(book);
    }
}
