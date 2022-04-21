package com.github.claudiohigashi.lombok.beautifier;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class LombokToStringBeautifierTest {

    /**
     * This is not actually a unit test but more just a usage example
     */
    @Test
    public void testBeautify() {
        List<Person> siblings = new ArrayList<Person>();
        siblings.add(newPerson("Alex", 13));
        siblings.add(newPerson("Roger", 15));
        siblings.add(newPerson("Syl", 16));

        List<Person> children = new ArrayList<Person>();
        children.add(newPerson("Ann", 7));
        children.add(newPerson("Mary", 15));
        children.add(newPerson("Happy", 17));

        Person me = new Person("John", 51, new Date(), true,
                newPerson("Mark", 82),
                newPerson("Beth", 78),
                siblings,
                newPerson("Ly", 49),
                children
        );

        System.out.println("Original Lombok toString():");
        System.out.println(me);

        System.out.println("\nBeautified Lombok toString():");
        System.out.println(LombokToStringBeautifier.beautify(me.toString()));
    }

    private Person newPerson(String name, int age) {
        return new Person(name, age, new Date(), true, null, null, null, null, null);
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
    Person partner;
    List<Person> children;
}