package beaconFire.d3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    int age;
    String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}
public class StreamAPIDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(19,"Pete"));
        people.add(new Person(15,"Jay"));
        people.add(new Person(9,"Uli"));
        System.out.println(people.stream().filter(person -> person.age>10)
                        .sorted(Comparator.comparingInt(person->person.age))
                        .map(person -> person.name)
                        .collect(Collectors.toList())
                );
    }
}
