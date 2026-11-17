
package com.compatible.compatibility;

import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompatibilityController {

    @PostMapping("/compatibility")
    public Result checkCompatibility(@RequestBody Input input) {

        Person p1 = createPerson(input.person1);
        Person p2 = createPerson(input.person2);

        double score =
            CompatibilityCalculator.calculate(p1, p2);

        String message;

        if (score >= 90) {
            message = "Excellent Match! ❤️";
        } else if (score >= 75) {
            message = "Great Match! 💕";
        } else if (score >= 50) {
            message = "Good Match! 😊";
        } else {
            message = "Different Preferences!";
        }

        return new Result(
            p1.name, p2.name, score, message
        );
    }

    private Person createPerson(PersonInput p) {
        Preferences preferences = new Preferences(
            p.minAge, p.maxAge,
            p.preferredGender,
            p.preferredCountry,
            p.preferredProfession,
            p.preferredPersonality,
            p.preferredRelationshipGoal
        );

        return new Person(
            p.name, p.age, p.gender,
            p.country, p.profession,
            p.languages, p.hobbies,
            p.personality, p.lifestyle,
            p.relationshipGoal, preferences
        );
    }

    public static class Input {
        public PersonInput person1;
        public PersonInput person2;
    }

    public static class PersonInput {
        public String name;
        public int age;
        public String gender;
        public String country;
        public String profession;
        public Set<String> languages;
        public Set<String> hobbies;
        public String personality;
        public String lifestyle;
        public String relationshipGoal;

        public int minAge;
        public int maxAge;
        public String preferredGender;
        public String preferredCountry;
        public String preferredProfession;
        public String preferredPersonality;
        public String preferredRelationshipGoal;
    }

    public static class Result {
        public String person1;
        public String person2;
        public double percentage;
        public String message;

        public Result(String p1, String p2,
                      double score, String message) {
            this.person1 = p1;
            this.person2 = p2;
            this.percentage = score;
            this.message = message;
        }
    }
}
