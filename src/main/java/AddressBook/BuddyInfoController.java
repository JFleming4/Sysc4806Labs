package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuddyInfoController {

    @Autowired
    BuddyInfoRepository buddyRepo;

    @Autowired
    AddressBookRepository bookRepo;

    @GetMapping("/newbuddy")
    public String newBuddy(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "newbuddy";
    }

    @PostMapping("/newbuddy")
    public String newBuddySubmit(@ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book = bookRepo.findById(new Long(1));
        book.addBuddy(buddy);
        buddyRepo.save(buddy);
        bookRepo.save(book);
        model.addAttribute("buddy", buddy);
        return "buddyinfo";
    }

}
