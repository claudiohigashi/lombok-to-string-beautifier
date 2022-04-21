package com.github.claudiohigashi.lombok.beautifier;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class LombokToStringBeautifierTest {

    @Test
    public void beautifyLombokToStringObject() {
        List<Person> siblings = new ArrayList<Person>();
        siblings.add(new Person("Alexandre", 13, new Date(), true, null, null, null));
        siblings.add(new Person("Rogerio", 15, new Date(), true, null, null, null));
        siblings.add(new Person("Silvio", 16, new Date(), true, null, null, null));

        Person me = new Person("John", 18, new Date(), true,
                new Person("Mark", 82, new Date(), true, null, null, null),
                new Person("Anne", 78, new Date(), true, null, null, null),
                siblings
        );
        System.out.println("Lombok toString():");
        System.out.println(me);

        System.out.println("\nBeautified Lombok toString():");
        System.out.println(LombokToStringBeautifier.beautifyLombokToStringObject(me.toString()));
    }
}

@AllArgsConstructor
@ToString
class Person {
    String name;
    int age;
    Date birthdate;
    boolean active;
    Person father;
    Person mother;
    List<Person> siblings;
}