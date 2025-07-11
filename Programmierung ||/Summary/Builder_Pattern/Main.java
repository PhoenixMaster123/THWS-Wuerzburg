package summary.Builder_Pattern;

public class Main {
    public static void main(String[] args) {
        User user = new User().setAge(20)
                .setEmail("email")
                .setFirstName("Vik")
                .setLastName("Aleksandrov");

        System.out.println(user);

        Person p = new Person.PersonBuilder("Max", 22, "Mustermann")
                .withAge(30)
                .withAddress("Musterstadt")
                .build();

        System.out.println(p);

    }
}
