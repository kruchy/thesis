package pl.edu.agh.kis.kruchy;

import pl.edu.agh.kis.kruchy.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication
{
    @Autowired
    Repository repository;

    public static void main(String[] args)
    {

    }
}
