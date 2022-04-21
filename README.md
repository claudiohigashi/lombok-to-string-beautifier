# lombok-to-string-beautifier
Utility to beautify Lombok's @ToString

# Usage

LombokToStringBeautifier.beautify(string);

Sample usage:

* [LombokToStringBeautifierTest.java](src/test/java/com/github/claudiohigashi/lombok/beautifier/LombokToStringBeautifierTest.java)

Sample output:

```
Original Lombok toString():
Person(name=John, age=51, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=Person(name=Mark, age=82, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), mother=Person(name=Beth, age=78, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), siblings=[Person(name=Alex, age=13, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), Person(name=Roger, age=15, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), Person(name=Syl, age=16, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null)], partner=Person(name=Ly, age=49, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), children=[Person(name=Ann, age=7, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), Person(name=Mary, age=15, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null), Person(name=Happy, age=17, birthdate=Thu Apr 21 11:49:36 CEST 2022, active=true, father=null, mother=null, siblings=null, partner=null, children=null)])

Beautified Lombok toString():
Person(
    name=John,
    age=51,
    birthdate=Thu Apr 21 11:49:36 CEST 2022,
    active=true,
    father=Person(
        name=Mark,
        age=82,
        birthdate=Thu Apr 21 11:49:36 CEST 2022,
        active=true,
        father=null,
        mother=null,
        siblings=null,
        partner=null,
        children=null),
    mother=Person(
        name=Beth,
        age=78,
        birthdate=Thu Apr 21 11:49:36 CEST 2022,
        active=true,
        father=null,
        mother=null,
        siblings=null,
        partner=null,
        children=null),
    siblings=[
        Person(
            name=Alex,
            age=13,
            birthdate=Thu Apr 21 11:49:36 CEST 2022,
            active=true,
            father=null,
            mother=null,
            siblings=null,
            partner=null,
            children=null),
        Person(
            name=Roger,
            age=15,
            birthdate=Thu Apr 21 11:49:36 CEST 2022,
            active=true,
            father=null,
            mother=null,
            siblings=null,
            partner=null,
            children=null),
        Person(
            name=Syl,
            age=16,
            birthdate=Thu Apr 21 11:49:36 CEST 2022,
            active=true,
            father=null,
            mother=null,
            siblings=null,
            partner=null,
            children=null)
        ],
    partner=Person(
        name=Ly,
        age=49,
        birthdate=Thu Apr 21 11:49:36 CEST 2022,
        active=true,
        father=null,
        mother=null,
        siblings=null,
        partner=null,
        children=null),
    children=[
        Person(
            name=Ann,
            age=7,
            birthdate=Thu Apr 21 11:49:36 CEST 2022,
            active=true,
            father=null,
            mother=null,
            siblings=null,
            partner=null,
            children=null),
        Person(
            name=Mary,
            age=15,
            birthdate=Thu Apr 21 11:49:36 CEST 2022,
            active=true,
            father=null,
            mother=null,
            siblings=null,
            partner=null,
            children=null),
        Person(
            name=Happy,
            age=17,
            birthdate=Thu Apr 21 11:49:36 CEST 2022,
            active=true,
            father=null,
            mother=null,
            siblings=null,
            partner=null,
            children=null)
        ]
    )
```

# References
- Project Lombok: https://projectlombok.org/
- Git Hub: https://github.com/claudiohigashi/lombok-to-string-beautifier
