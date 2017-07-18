package pl.edu.agh.kis.kruchy.common.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SurnameTest {
    @Test
    public void shouldPassValidationCorrectName() {
        assertThat(Surname.validate("Aaaabb")).isTrue();
    }

    @Test
    public void shouldNotPassValidationInvalidName() {
        assertThat(Surname.validate("AaaaAbsdfbbb")).isFalse();
    }

    @Test
    public void shouldNotPassValidationInvalidCharacters() {
        assertThat(Surname.validate("AaaaAbsd-fbbb!")).isFalse();
    }

}
