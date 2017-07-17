package pl.edu.agh.kis.kruchy.mongo.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.kis.kruchy.mongo.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.mongo.model.builder.UserBuilder.anUser;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class DefaultMongoRepositoryTest {

    @Autowired
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
        User result = all.get(0);
        assertThat(user).isEqualTo(result);
    }

    @Test
    public void returnsUserById() {
        User user = testUser();
        user.setId(String.valueOf("123"));
        defaultMongoRepository.save(user);
        Optional<User> found = defaultMongoRepository.findById("123");
        assertThat(found).isPresent();
        found.ifPresent(user1 -> assertThat(user1).isEqualTo(user));
    }

    @Test
    public void returnsUserBySurname() {
        User user = testUser();
        defaultMongoRepository.insert(user);
        List<User> all = defaultMongoRepository.findAllBySurname(user.getSurname());
        assertThat(all).hasSize(1);
        User result = all.get(0);
        assertThat(result).isEqualTo(user);

    }

    @Test
    public void returnsUserByPhoneNumber() {
        User user = testUser();
        defaultMongoRepository.save(user);
        Optional<User> result = defaultMongoRepository.findByPhoneNumber(user.getPhoneNumber());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(user);

    }

    private User testUser() {
        return anUser().withAddress("Wadowicka", 99).withName("John").withPhoneNumber("123123123").withSurname("Smith").build();
    }


}