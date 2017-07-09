package pl.edu.agh.kis.kruchy.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("pl.edu.agh.kis.kruchy.repository.mongo")
@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
@PropertySource(value = {"classpath:application.properties"})

public class MongoConfiguration extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private Integer port;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.password}")
    private String password;


    @Override
    public String getDatabaseName() {
        return database;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(host, port);
    }

}
