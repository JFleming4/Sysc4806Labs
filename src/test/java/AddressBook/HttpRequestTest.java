package AddressBook;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void bookShouldReturnArray() throws Exception {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/book",
                String.class);
        assertThat(response).contains("book");
        assertThat(response).contains("addressBook");
        assertThat(response).contains("buddies");
    }

    @Test
    public void buddyShouldReturnArray() throws Exception {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/buddy",
                String.class);
        assertThat(response).contains("buddy");
        assertThat(response).contains("name");
        assertThat(response).contains("number");
        assertThat(response).contains("buddyInfo");
    }
}
