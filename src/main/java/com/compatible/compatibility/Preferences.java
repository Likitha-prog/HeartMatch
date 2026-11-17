
package com.compatible.compatibility;

public class Preferences {

    int minAge;
    int maxAge;

    String preferredGender;
    String preferredCountry;
    String preferredProfession;
    String preferredPersonality;
    String preferredRelationshipGoal;

    public Preferences(int minAge, int maxAge,
                       String preferredGender,
                       String preferredCountry,
                       String preferredProfession,
                       String preferredPersonality,
                       String preferredRelationshipGoal) {

        this.minAge = minAge;
        this.maxAge = maxAge;
        this.preferredGender = preferredGender;
        this.preferredCountry = preferredCountry;
        this.preferredProfession = preferredProfession;
        this.preferredPersonality = preferredPersonality;
        this.preferredRelationshipGoal = preferredRelationshipGoal;
    }
}
