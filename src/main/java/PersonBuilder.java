import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;


    protected OptionalInt age = OptionalInt.empty();
    protected String address;


    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("No name specified");
        } else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("No surname specified");
        } else this.surname = surname;
        return this;
    }


    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Введите корректный возраст (age)");
        } else this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    private Person getPerson() {
        if (!age.isPresent()) {
            return new Person(name, surname);
        } else {
            return new Person(name, surname, age.getAsInt());
        }

    }

    public Person build() throws IllegalStateException {
        if (name == null || surname == null)
            throw new IllegalStateException("The first or last name is not specified");
        Person person = getPerson();
        person.setAddress(address);
        return person;
    }

}
