/**
 * Created by HansYolo on 11/29/2016.
 */
public class SpeciesMember {

    private double weight;
    private double length;
    private double tailLength;
    private double wingSpan;
    private Species.Diet diet;
    private int breedingCapability;
    private double brainSize;
    private double fatPercentage;
    private String name;


    public SpeciesMember(){

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    public Species.Diet getDiet() {
        return diet;
    }

    public void setDiet(Species.Diet diet) {
        this.diet = diet;
    }

    public int getBreedingCapability() {
        return breedingCapability;
    }

    public void setBreedingCapability(int breedingCapability) {
        this.breedingCapability = breedingCapability;
    }

    public double getBrainSize() {
        return brainSize;
    }

    public void setBrainSize(double brainSize) {
        this.brainSize = brainSize;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
