package summary.Builder_Pattern;

public class Person {
    private String name;
    private int age;
    private String address;

    private Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person withName(String name) {
        this.name = name;
        return this;
    }
    public Person withAge(int age) {
        this.age = age;
        return this;
    }
    public Person withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private String address;

        public PersonBuilder(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public PersonBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, age, address);
        }
    }
}
