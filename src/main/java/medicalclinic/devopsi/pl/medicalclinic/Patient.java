package medicalclinic.devopsi.pl.medicalclinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class Patient {

    @NotNull
    public String name;
    @NotNull
    public String lastName;
    @Length(min = 11, max = 11)
    public String pesel;
    @Length(min = 9, max = 9)
    public String phoneNumber;
    public String comment;

}
