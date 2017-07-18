package pl.edu.agh.kis.kruchy.performance.prevayler;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.kis.kruchy.common.model.User;
import pl.edu.agh.kis.kruchy.common.repository.UserRepository;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.common.model.builder.UserBuilder.anUser;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PrevaylerConfiguration.class})
public class PrevaylerTest {

    @Autowired
    private UserRepository prevaylerUserRepository;

    public UserRepository repository() {
        return prevaylerUserRepository;
    }

    @Test
    public void shouldCreateNewUser() throws Exception {
        User user = randomUser();
        User saved = repository().save(user);
        assertThat(saved).isNotNull();
    }

    private User randomUser() {
        Random random = new Random();
        User user = anUser().withName(RandomStringUtils.random(7))
                .withSurname(RandomStringUtils.random(7))
                .withAddress(RandomStringUtils.random(10), random.nextInt(90))
                .withPhoneNumber(RandomStringUtils.random(9))
                .withAge(random.nextInt(70) + 10);
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
