package pl.edu.agh.kis.kruchy.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class SurnameTest
{
    @Test
    public void shouldPassValidationCorrectName()
    {
        assertThat(Surname.validate("Aaaabb")).isTrue();
    }
    @Test
    public void shouldNotPassValidationInvalidName()
    {
        assertThat(Surname.validate("AaaaAbsdfbbb")).isFalse();
    }
    @Test
    public void shouldNotPassValidationInvalidCharacters()
    {
        assertThat(Surname.validate("AaaaAbsd-fbbb!")).isFalse();
    }

}
