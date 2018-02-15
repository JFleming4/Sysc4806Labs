package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository bookRepo;

    @GetMapping("/showbook")
    public String newBookForm(Model model) {
        AddressBook book = bookRepo.findById(new Long(1));
        model.addAttribute("book", book);
        return "addressbook";
    }
}
