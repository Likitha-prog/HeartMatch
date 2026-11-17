
package com.compatible.compatibility;

import java.util.Set;

public class Person {

    String name;
    int age;
    String gender;
    String country;
    String profession;

    Set<String> languages;
    Set<String> hobbies;

    String personality;
    String lifestyle;
    String relationshipGoal;

    Preferences preferences;

    public Person(String name, int age, String gender,
                  String country, String profession,
                  Set<String> languages, Set<String> hobbies,
                  String personality, String lifestyle,
                  String relationshipGoal, Preferences preferences) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.profession = profession;
        this.languages = languages;
        this.hobbies = hobbies;
        this.personality = personality;
        this.lifestyle = lifestyle;
        this.relationshipGoal = relationshipGoal;
        this.preferences = preferences;
    }
}
