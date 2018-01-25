package AddressBook;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    private final String XML_PATH = "app-context.xml";
    public void launch() {
        String[] contextPaths = new String[] {XML_PATH};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}
