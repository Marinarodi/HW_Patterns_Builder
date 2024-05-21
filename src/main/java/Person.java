import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    //    public Person(PersonBuilder personBuilder) {
//        this.name = personBuilder.name;
//        this.surname = personBuilder.surname;
//        this.age = personBuilder.age;
//        this.address = personBuilder.address;
//
//    }
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return this.age;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }

    public void happyBirthday() {
        if (this.age.isPresent()) this.age = OptionalInt.of(age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        if (age.isPresent()) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }


    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        return builder.setAddress(this.address).setSurname(this.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }
}