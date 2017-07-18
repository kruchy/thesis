package pl.edu.agh.kis.kruchy.performance.prevayler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.kis.kruchy.prevayler.repository.PrevaylerUserRepository;

@Configuration
public class PrevaylerConfiguration {

    @Bean
//    @Qualifier("prevayler")
    public PrevaylerUserRepository prevaylerUserRepository() throws Exception {
        return new PrevaylerUserRepository();
    }
}
