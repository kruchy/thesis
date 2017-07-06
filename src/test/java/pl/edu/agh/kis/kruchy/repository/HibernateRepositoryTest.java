package pl.edu.agh.kis.kruchy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import pl.edu.agh.kis.kruchy.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories
public class HibernateRepositoryTest extends AbstractTransactionalTestNGSpringContextTests
{

    @Autowired
    Repository repository;

    @Test
    public void findById()
    {
        Optional<User> byId = repository.findOne(1L);
        assertThat(byId).isNotNull();
    }

}
