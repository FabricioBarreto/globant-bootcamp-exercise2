package model;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Customer(Long id, String name, String lastName, String birthDate, String email, String phone) {
        if (Objects.isNull(id)) throw new IllegalArgumentException("Id cannot be null");
        if (Objects.isNull(name)) throw new IllegalArgumentException("Name cannot be null");
        if (Objects.isNull(birthDate)) throw new IllegalArgumentException("Lastname cannot be null");
        if (Objects.isNull(lastName)) throw new IllegalArgumentException("Birth date cannot be null");
        if (Objects.isNull(email)) throw new IllegalArgumentException("Email cannot be null");
        if (Objects.isNull(phone)) throw new IllegalArgumentException("Phone cannot be null");
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = LocalDate.parse(birthDate);
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getBirthDate(), customer.getBirthDate()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getPhone(), customer.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getBirthDate(), getEmail(), getPhone());
    }

}