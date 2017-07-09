package pl.edu.agh.kis.kruchy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import pl.edu.agh.kis.kruchy.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.model.builder.UserBuilder.anUser;

//@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories
public class HibernateRepositoryTest extends AbstractTransactionalTestNGSpringContextTests
{

    @Autowired
    Repository repository;

    @Test
    public void savesAndReturnsUser()
    {
        User user = anUser().withAddress("Wadowicka", 99).withName("John").withPhoneNumber("123123123").withSurname("Smith").build();
        repository.save(user);
        List<User> all = repository.findAllByName("John");
        assertThat(all).hasSize(1);
        User result = all.get(0);
        assertThat(result.getName()).isEqualTo(user.getName());
        assertThat(result.getSurname()).isEqualTo(user.getSurname());
        assertThat(result.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(result.getAddress()).isEqualTo(user.getAddress());

    }


}
