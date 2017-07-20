package pl.edu.agh.kis.kruchy.performance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.kis.kruchy.prevayler.repository.PrevaylerUserRepository;

@Configuration
public class PrevaylerConfiguration {

    @Bean
    public PrevaylerUserRepository prevaylerUserRepository() throws Exception {
        return new PrevaylerUserRepository();
    }
}
