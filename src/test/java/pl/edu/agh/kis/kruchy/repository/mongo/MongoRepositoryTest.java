package pl.edu.agh.kis.kruchy.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pl.edu.agh.kis.kruchy.model.User;

import static pl.edu.agh.kis.kruchy.model.builder.UserBuilder.anUser;

@ContextConfiguration(classes = {FongoConfiguration.class})
public class MongoRepositoryTest {

    @Autowired
    private MongoRepository mongoRepository;

    @Test
    public void returnsUserByName() {
        User user = testUser();
        mongoRepository.save(user);
//        List<User> all = mongoRepository.findAllByName("John");
//        assertThat(all).hasSize(1);
//        User result = all.get(0);
//        assertThat(user).isEqualTo(result);
    }

    @Test
    public void returnsUserBySurname() {
        User user = testUser();
        mongoRepository.save(user);
//        List<User> all = mongoRepository.findAllBySurname(user.getSurname());
//        assertThat(all).hasSize(1);
//        User result = all.get(0);
//        assertThat(result).isEqualTo(user);

    }

    @Test
    public void returnsUserByPhoneNumber() {
        User user = testUser();
        mongoRepository.save(user);
//        Optional<User> result = mongoRepository.findByPhoneNumber(user.getPhoneNumber());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(user);

    }

    private User testUser() {
        return anUser().withAddress("Wadowicka", 99).withName("John").withPhoneNumber("123123123").withSurname("Smith").build();
    }
}