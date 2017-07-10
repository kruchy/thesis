package pl.edu.agh.kis.kruchy.hibernate.model;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberTest
{
    @Test
    public void givenOnlyNumbersNothingChanges()
    {
        String number = "555233111";
        PhoneNumber phoneNumber = new PhoneNumber(number);
        assertThat(phoneNumber.getNumber()).isEqualTo(number);
    }

    @Test
    public void givenNumberWithDashesRemovesThem()
    {
        String number = "555233111";
        String numberWithDashes = "555-233-111";
        PhoneNumber phoneNumber = new PhoneNumber(numberWithDashes);
        assertThat(phoneNumber.getNumber()).isEqualTo(number);
    }

}
