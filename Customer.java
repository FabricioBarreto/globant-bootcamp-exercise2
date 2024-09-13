import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String identificationNumber;

    public Customer(String name, String lastName, String birthDate, String email, String phone, String identificationNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastName = lastName;
        this.birthDate = LocalDate.parse(birthDate);
        this.email = email;
        this.phone = phone;
        this.identificationNumber = identificationNumber;
    }

    public Customer(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}