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
        siblings.add(newPerson("Alexandre", 13));
        siblings.add(newPerson("Rogerio", 15));
        siblings.add(newPerson("Silvio", 16));

        List<Person> children = new ArrayList<Person>();
        children.add(newPerson("Anniek", 7));
        children.add(newPerson("Mariana", 15));
        children.add(newPerson("Naomi", 17));

        Person me = new Person("Claudio", 51, new Date(), true,
                newPerson("Luiz", 82),
                newPerson("Alzira", 78),
                siblings,
                newPerson("Lili", 49),
                children
        );
        System.out.println("Lombok toString():");
        System.out.println(me);

        System.out.println("\nBeautified Lombok toString():");
        System.out.println(LombokToStringBeautifier.beautifyLombokToStringObject(me.toString()));
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