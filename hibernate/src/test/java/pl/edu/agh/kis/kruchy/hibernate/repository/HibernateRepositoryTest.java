package pl.edu.agh.kis.kruchy.hibernate.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import pl.edu.agh.kis.kruchy.hibernate.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.hibernate.model.builder.UserBuilder.anUser;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class HibernateRepositoryTest {

    @Autowired
    Repository hibernateRepository;

    @Test
    public void returnsUserByName() {
        User user = testUser();
        hibernateRepository.save(user);
        List<User> all = hibernateRepository.findAllByName("John");
        assertThat(all).hasSize(1);
        User result = all.get(0);
        assertThat(user).isEqualTo(result);
    }

    @Test
    public void returnsUserBySurname() {
        User user = testUser();
        hibernateRepository.save(user);
        List<User> all = hibernateRepository.findAllBySurname(user.getSurname());
        assertThat(all).hasSize(1);
        User result = all.get(0);
        assertThat(result).isEqualTo(user);

    }

    @Test
    public void returnsUserByPhoneNumber() {
        User user = testUser();
        hibernateRepository.save(user);
        Optional<User> result = hibernateRepository.findByPhoneNumber(user.getPhoneNumber());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(user);

    }

    private User testUser() {
        return anUser().withAddress("Wadowicka", 99).withName("John").withPhoneNumber("123123123").withSurname("Smith").build();
    }
}
