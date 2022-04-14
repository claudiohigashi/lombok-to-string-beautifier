package com.github.claudiohigashi.lombok.beautifier;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

class LombokToStringBeautifierTest {

    @Test
    public void beautifyLombokToStringObject() {
        // TODO: Fix toString for List
//        List<Person> siblings = new ArrayList<Person>();
//        siblings.add(new Person("Alexandre", 13, new Date(), true, null, null, null));
//        siblings.add(new Person("Rogerio", 15, new Date(), true, null, null, null));
//        siblings.add(new Person("Silvio", 16, new Date(), true, null, null, null));
        List<Person> siblings = null;
        Person me = new Person("John", 18, new Date(), true,
                new Person("Mark", 82, new Date(), true, null, null, null),
                new Person("Anne", 78, new Date(), true, null, null, null),
                siblings
        );
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