import java.util.Random;

/**
 * Created by HansYolo on 11/22/2016.
 */
public class Species {

    private double meanWeight;
    private double meanLength;
    private double meanTailLength;
    private double meanWingSpan;
    private enum Diet {HERBIVORE, CARNIVORE, OMNIVORE};
    private Diet diet;
    private int breedingCapability;
    private double meanBrainSize;
    private double meanFatPercentage;
    private Random random;


    public Species(){
        this.random = new Random();
        setSpeciesAttributes();

    }

    public void setSpeciesAttributes(){
        //Set mean weight. This will be between 0 and 1000
        meanWeight = random.nextInt(999) + random.nextDouble();

        //Set Mean Length. This will be between 0 and 50
        meanLength = random.nextInt(49) + random.nextDouble();

        //Set Mean Tail length. 50% chance the species has a tail. Tail length is %10 - %50 of Mean Length
        if(random.nextBoolean()){
            meanTailLength = meanLength * ((random.nextInt(41)+10) / 100);
        }

        //Set Mean Wing Span. 50% chance the species has wings. WingSpan is %100 - %200 of Mean Length
        if(random.nextBoolean()){
            meanWingSpan = meanLength * ((random.nextInt(101)+100) / 100);
        }

        //Set diet.
        switch (random.nextInt(2)){

            case 0: diet = Diet.HERBIVORE;
                break;
            case 1: diet = Diet.CARNIVORE;
                break;
            case 2: diet = Diet.OMNIVORE;
                break;

        }

        //Set Breeding Capability: Can have between 1 and 3 offspring per generation
        breedingCapability = random.nextInt(3) + 1;

        //Set Mean Brain Size. Between 2% and 10% of Length
        meanBrainSize = meanLength * ((random.nextInt(9)+2) / 100);

        //Set Mean Fat percentage. Between %10 and %50
        meanFatPercentage = (random.nextInt(41) + 10) / 100;
    }

    public double getMeanWeight() {
        return meanWeight;
    }

    public void setMeanWeight(double meanWeight) {
        this.meanWeight = meanWeight;
    }

    public double getMeanLength() {
        return meanLength;
    }

    public void setMeanLength(double meanLength) {
        this.meanLength = meanLength;
    }

    public double getMeanTailLength() {
        return meanTailLength;
    }

    public void setMeanTailLength(double meanTailLength) {
        this.meanTailLength = meanTailLength;
    }

    public double getMeanWingSpan() {
        return meanWingSpan;
    }

    public void setMeanWingSpan(double meanWingSpan) {
        this.meanWingSpan = meanWingSpan;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public int getBreedingCapability() {
        return breedingCapability;
    }

    public void setBreedingCapability(int breedingCapability) {
        this.breedingCapability = breedingCapability;
    }

    public double getMeanBrainSize() {
        return meanBrainSize;
    }

    public void setMeanBrainSize(double meanBrainSize) {
        this.meanBrainSize = meanBrainSize;
    }

    public double getMeanFatPercentage() {
        return meanFatPercentage;
    }

    public void setMeanFatPercentage(double meanFatPercentage) {
        this.meanFatPercentage = meanFatPercentage;
    }
}
