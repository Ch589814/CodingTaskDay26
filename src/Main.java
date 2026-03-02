import java.util.*;
import java.util.stream.Collectors;
public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<Person> people = new ArrayList<>();

    System.out.print("How many people do you want to enter? ");
    int number_of_people = scanner.nextInt();
    scanner.nextLine();

    for (int i = 1; i <= number_of_people; i++) {

      System.out.println("\nEnter details for person " + (i));

      System.out.print("Name: ");
      String name = scanner.nextLine();

      System.out.print("Age: ");
      int age = scanner.nextInt();
      scanner.nextLine();

      System.out.print("City: ");
      String city = scanner.nextLine();

      people.add(new Person(name, age, city));
    }
    // change second person
    if (people.size() >= 2) {

      Person secondPerson = people.get(1);
      secondPerson.setName("Kevin");
      System.out.println("The name of the second person has been changed.");// change the name

    }

    //  Group by age
    Map<Integer, List<String>> groupByAge =
            people.stream()
                    .collect(Collectors.groupingBy(
                            Person::getAge,
                            Collectors.mapping(Person::getName, Collectors.toList())
                    ));

    // Group by city
    Map<String, Long> groupByCity =
            people.stream()
                    .collect(Collectors.groupingBy(
                            Person::getCity,
                            Collectors.counting()
                    ));

    // Display results
    System.out.println(" \n Grouped by Age: ");
    groupByAge.forEach((age, names) ->
            System.out.println("Age " + age + ": " + names)
    );

    System.out.println("\nGrouped by City:");
    groupByCity.forEach((city, count) ->
            System.out.println(city + ": " + count + " person(s)")
    );

    scanner.close();
  }
}