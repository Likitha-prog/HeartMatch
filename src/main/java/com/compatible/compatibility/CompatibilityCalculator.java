
package com.compatible.compatibility;

import java.util.Set;

public class CompatibilityCalculator {

    static double same(String a, String b) {
        if (a.equalsIgnoreCase("Any") ||
            b.equalsIgnoreCase("Any") ||
            a.equalsIgnoreCase(b)) {
            return 100;
        }
        return 0;
    }

    static double compareSets(Set<String> a, Set<String> b) {
        if (a.isEmpty() && b.isEmpty()) return 100;
        if (a.isEmpty() || b.isEmpty()) return 0;

        int common = 0;

        for (String item : a) {
            if (b.contains(item)) {
                common++;
            }
        }

        return (double) common /
               Math.max(a.size(), b.size()) * 100;
    }

    public static double calculate(Person a, Person b) {

        double age = (
            (b.age >= a.preferences.minAge &&
             b.age <= a.preferences.maxAge ? 100 : 0)
            +
            (a.age >= b.preferences.minAge &&
             a.age <= b.preferences.maxAge ? 100 : 0)
        ) / 2.0;

        double gender = (
            same(a.preferences.preferredGender, b.gender) +
            same(b.preferences.preferredGender, a.gender)
        ) / 2.0;

        double language =
            compareSets(a.languages, b.languages);

        double hobbies =
            compareSets(a.hobbies, b.hobbies);

        double personality = (
            same(a.preferences.preferredPersonality, b.personality) +
            same(b.preferences.preferredPersonality, a.personality)
        ) / 2.0;

        double lifestyle =
            same(a.lifestyle, b.lifestyle);

        double country = (
            same(a.preferences.preferredCountry, b.country) +
            same(b.preferences.preferredCountry, a.country)
        ) / 2.0;

        double profession = (
            same(a.preferences.preferredProfession, b.profession) +
            same(b.preferences.preferredProfession, a.profession)
        ) / 2.0;

        double relationship = (
            same(a.preferences.preferredRelationshipGoal,
                 b.relationshipGoal) +
            same(b.preferences.preferredRelationshipGoal,
                 a.relationshipGoal)
        ) / 2.0;

        double result =
              age * 0.15
            + gender * 0.10
            + language * 0.10
            + hobbies * 0.20
            + personality * 0.15
            + lifestyle * 0.10
            + country * 0.05
            + profession * 0.05
            + relationship * 0.10;

        return result;
    }
}
