package pl.edu.agh.kis.kruchy.mongo.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.kis.kruchy.common.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.common.model.builder.UserBuilder.anUser;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
@TestPropertySource(value = "classpath:application-test.properties")
public class DefaultMongoRepositoryTest {

    @Autowired
    private
    DefaultMongoRepository defaultMongoRepository;

    @Before
    public void clearRepository() {
        defaultMongoRepository.deleteAll();
    }

    @Test
    public void returnsUserByName() {
        User user = testUser();
        defaultMongoRepository.save(user);
        List<User> all = defaultMongoRepository.findAllByName("John");
        assertThat(all).hasSize(1);
        assertThat(all).contains(user);
    }

    @Test
    public void returnsUserById() {
        User user = testUser();
        user.setId(String.valueOf("123"));
        defaultMongoRepository.save(user);
        Optional<User> found = defaultMongoRepository.findById("123");
        assertThat(found).isPresent();
        assertThat(found).hasValue(user);
    }

    @Test
    public void returnsUserBySurname() {
        User user = testUser();
        defaultMongoRepository.save(user);
        List<User> all = defaultMongoRepository.findAllBySurname(user.getSurname());
        assertThat(all).hasSize(1);
        assertThat(all).contains(user);

    }

    @Test
    public void returnsUserByPhoneNumber() {
        User user = testUser();
        defaultMongoRepository.save(user);
        Optional<User> result = defaultMongoRepository.findByPhoneNumber(user.getPhoneNumber());
        assertThat(result).isPresent();
        assertThat(result).hasValue(user);
    }

    private User testUser() {
        return anUser()
                .withName("John")
                .withSurname("Smith")
                .withAddress("Wadowicka", 99)
                .withPhoneNumber("123123123")
                .withAge(18);
    }


}