package pl.edu.agh.kis.kruchy.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

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
