import java.time.LocalDate;

public class Guest {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public Guest(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + birthDate + ")";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
