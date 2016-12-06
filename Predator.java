import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HansYolo on 11/30/2016.
 */
public class Predator {

    private String traitPreference;
    private double traitPrefValue;
    private Random random;

    public String getTraitPreference() {
        return traitPreference;
    }

    public void setTraitPreference(String traitPreference) {
        this.traitPreference = traitPreference;
    }

    public Predator(){

        random = new Random();
        setTraitPref();



    }

    public double getTraitPrefValue() {
        return traitPrefValue;
    }

    public void setTraitPrefValue(double traitPrefValue) {
        this.traitPrefValue = traitPrefValue;
    }

    public void setTraitPref() {
        int roll = random.nextInt(4);
        switch (roll) {
            case 0:
                traitPreference = "weight";
                break;
            case 1:
                traitPreference = "length";
                break;
            case 2:
                traitPreference = "brain size";
                break;
            case 3:
                traitPreference = "fat percentage";
                break;
        }
    }

    public ArrayList<SpeciesMember> predate(ArrayList<SpeciesMember> preySpecies, String traitPref, double traitPrefVal) {
        int maxEat = preySpecies.size() / 5; // predator eats at most 1/5 of population
        boolean foundPrey = false;

        for (int x = 0; x < maxEat; x++) {
            SpeciesMember currSubject = preySpecies.get(x);
            foundPrey = false;
            switch (traitPref) {
                case "weight":
                    if ((traitPrefVal - (double) (traitPrefVal * PopulationGenerator.STD_DEV)) < currSubject.getWeight()
                            && currSubject.getWeight() < (traitPrefVal + (double) (traitPrefVal * PopulationGenerator.STD_DEV))) {

                        preySpecies.remove(x);
                        foundPrey = true;
                    }
                    break;

                case "length":
                    if ((traitPrefVal - (double) (traitPrefVal * PopulationGenerator.STD_DEV)) < currSubject.getLength()
                            && currSubject.getLength() < (traitPrefVal + (double) (traitPrefVal * PopulationGenerator.STD_DEV))) {

                        preySpecies.remove(x);
                        foundPrey = true;
                    }
                    break;

                case "brain size":
                    if ((traitPrefVal - (double) (traitPrefVal * PopulationGenerator.STD_DEV)) < currSubject.getBrainSize()
                            && currSubject.getBrainSize() < (traitPrefVal + (double) (traitPrefVal * PopulationGenerator.STD_DEV))) {

                        preySpecies.remove(x);
                        foundPrey = true;
                    }
                    break;

                case "fat percentage":
                    if ((traitPrefVal - (double) (traitPrefVal * PopulationGenerator.STD_DEV)) < currSubject.getFatPercentage()
                            && currSubject.getFatPercentage() < (traitPrefVal + (double) (traitPrefVal * PopulationGenerator.STD_DEV))) {

                        preySpecies.remove(x);
                        foundPrey = true;
                    }
                    break;
            }

            if(!foundPrey){
                break;
            }
        }

        return preySpecies;
    }




}
