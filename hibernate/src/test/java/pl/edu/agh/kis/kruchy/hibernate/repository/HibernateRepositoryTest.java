package pl.edu.agh.kis.kruchy.hibernate.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.kis.kruchy.common.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.common.model.builder.UserBuilder.anUser;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = "pl.edu.agh.kis.kruchy.hibernate.repository")
@EntityScan(basePackages = "pl.edu.agh.kis.kruchy.common")
public class HibernateRepositoryTest {

    @Autowired
    HibernateRepository hibernateHibernateRepository;

    @Test
    public void returnsUserByName() {
        User user = testUser();
        hibernateHibernateRepository.save(user);
        List<User> all = hibernateHibernateRepository.findAllByName("John");
        assertThat(all).hasSize(1);
        assertThat(all).contains(user);
    }

    @Test
    public void returnsUserBySurname() {
        User user = testUser();
        hibernateHibernateRepository.save(user);
        List<User> all = hibernateHibernateRepository.findAllBySurname(user.getSurname());
        assertThat(all).hasSize(1);
        assertThat(all).contains(user);

    }

    @Test
    public void returnsUserByPhoneNumber() {
        User user = testUser();
        hibernateHibernateRepository.save(user);
        Optional<User> result = hibernateHibernateRepository.findByPhoneNumber(user.getPhoneNumber());
        assertThat(result).isPresent();
        assertThat(result).hasValue(user);
    }

    private User testUser() {
        return anUser().withName("John")
                .withSurname("Smith")
                .withAddress("Wadowicka", 99)
                .withPhoneNumber("123123123")
                .withAge(new Random().nextInt(50) + 10);
    }


}
