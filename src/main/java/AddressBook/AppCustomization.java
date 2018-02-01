package AddressBook;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class AppCustomization implements EmbeddedServletContainerCustomizer{
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8087);
    }
}
