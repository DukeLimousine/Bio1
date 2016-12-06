import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HansYolo on 11/30/2016.
 */
public class Driver {

    private int numRaces = 1;

    //Change these for EXPERIMENTS
    private int raceSize = 1000;
    private int generations = 500;
    //*****************************

    private Random random = new Random();

    public Driver(){

        PopulationGenerator populationGenerator = new PopulationGenerator();
        Predator predator = new Predator();

            //Create the control population
            ArrayList<SpeciesMember> population = populationGenerator.createRace(raceSize);

        int y = 1;
        double avgLength = 0.0;
        double avgWeight = 0.0;
        double avgFat = 0.0;
        double avgBrain = 0.0;
        double minLength = population.get(0).getLength();
        double maxLength = population.get(0).getLength();
        double minWeight = population.get(0).getWeight();
        double maxWeight = population.get(0).getWeight();
        double minFat = population.get(0).getFatPercentage();
        double maxFat = population.get(0).getFatPercentage();
        double minBrain =population.get(0).getBrainSize();
        double maxBrain = population.get(0).getBrainSize();

        //get Stats for control population 1st Generation

            for (SpeciesMember s : population) {
                avgLength += s.getLength();
                avgWeight += s.getWeight();
                avgBrain += s.getBrainSize();
                avgFat += s.getFatPercentage();

                if(s.getLength() < minLength){
                    minLength = s.getLength();
                }
                if(s.getLength() > maxLength){
                    maxLength = s.getLength();
                }
                if(s.getWeight() < minWeight){
                    minWeight = s.getWeight();
                }
                if(s.getWeight() > maxWeight){
                    maxWeight = s.getWeight();
                }
                if(s.getBrainSize() < minBrain){
                    minBrain = s.getBrainSize();
                }
                if(s.getBrainSize() >  maxBrain){
                    maxBrain = s.getBrainSize();
                }
                if(s.getFatPercentage() < minFat){
                    minFat = s.getFatPercentage();
                }
                if(s.getFatPercentage() > maxFat){
                    maxFat = s.getFatPercentage();
                }

            }

        double rand = random.nextDouble();
        double range;
        double scaled;
        double shifted;

        switch (predator.getTraitPreference()){
            case "weight":
                range = maxWeight - minWeight;
                scaled = rand * range;
                shifted = scaled + minWeight;
                predator.setTraitPrefValue(shifted);
                break;

            case "length":
                range = maxLength - minLength;
                scaled = rand * range;
                shifted = scaled + minLength;
                predator.setTraitPrefValue(shifted);
                break;

            case "brain size":
                range = maxBrain - minBrain;
                scaled = rand * range;
                shifted = scaled + minBrain;
                predator.setTraitPrefValue(shifted);
                break;

            case "fat percentage":
                range = maxFat - minFat;
                scaled = rand * range;
                shifted = scaled + minFat;
                predator.setTraitPrefValue(shifted);
                break;
        }

        avgLength = avgLength / (double)population.size();
        avgWeight = avgWeight / (double)population.size();
        avgBrain = avgBrain / (double)population.size();
        avgFat = avgFat / (double)population.size();

        System.out.println("*****Generation 1 (Experimental & Control)*****");
        System.out.println("Species: " + population.get(0).getName());
        System.out.println("Average Length: " + avgLength);
        System.out.println("Average Weight: " + avgWeight);
        System.out.println("Average Brain Size: " + avgBrain);
        System.out.println("Average Fat: " + avgFat);
        System.out.println("Min / max length " + minLength + " - " + maxLength);
        System.out.println("Min / max weight " + minWeight + " - " + maxWeight);
        System.out.println("Min / max brain " + minBrain + " - " + maxBrain);
        System.out.println("Min / max fat " + minFat + " - " + maxFat);


             for(int x = 0; x < generations - 1; x++) {
                 avgLength = 0.0;
                 avgWeight = 0.0;
                 avgFat = 0.0;
                 avgBrain = 0.0;
                 population = populationGenerator.reproduce(population);
                 for (SpeciesMember s : population) {
                     avgLength += s.getLength();
                     avgWeight += s.getWeight();
                     avgBrain += s.getBrainSize();
                     avgFat += s.getFatPercentage();

                 }

                 avgLength = avgLength / (double)population.size();
                 avgWeight = avgWeight / (double)population.size();
                 avgBrain = avgBrain / (double)population.size();
                 avgFat = avgFat / (double)population.size();

                 if(x == 8 || x == 98 || x == 498 || x == 998) {//Change this if you go more generations
                     System.out.println("\n*****Control Generation " + (x + 2) + "*****");
                     System.out.println("Average Length: " + avgLength);
                     System.out.println("Average Weight: " + avgWeight);
                     System.out.println("Average Brain Size: " + avgBrain);
                     System.out.println("Average Fat: " + avgFat);
                 }
             }

        //Create Experimental Population
        ArrayList<SpeciesMember> exPop = (ArrayList<SpeciesMember>)population.clone();
        for(int x = 0; x < generations - 1; x++) {
            avgLength = 0.0;
            avgWeight = 0.0;
            avgFat = 0.0;
            avgBrain = 0.0;

            exPop = predator.predate(exPop, predator.getTraitPreference(), predator.getTraitPrefValue()); //rawr, eat them

            //refil missing members with extra births so they don't go extinct
            if(exPop.size() < raceSize){
                int refil = raceSize - exPop.size();
                for(int z = 0; z < refil ; z++){
                    SpeciesMember newOffspring = exPop.get(random.nextInt(exPop.size()));
                    exPop.add(newOffspring);
                }
            }
            exPop = populationGenerator.reproduce(exPop);
            for (SpeciesMember s : exPop) {
                avgLength += s.getLength();
                avgWeight += s.getWeight();
                avgBrain += s.getBrainSize();
                avgFat += s.getFatPercentage();

            }

            avgLength = avgLength / (double)population.size();
            avgWeight = avgWeight / (double)population.size();
            avgBrain = avgBrain / (double)population.size();
            avgFat = avgFat / (double)population.size();

            if(x == 8 || x == 98 || x == 498 || x == 998) {
                System.out.println("\n*****Experimental Generation " + (x + 2) + "*****");
                System.out.println("Average Length: " + avgLength);
                System.out.println("Average Weight: " + avgWeight);
                System.out.println("Average Brain Size: " + avgBrain);
                System.out.println("Average Fat: " + avgFat);
        }
        }

        System.out.println("\n predator trait: " + predator.getTraitPreference());


        }

public static void main(String[] args){

        Driver driver = new Driver();

        }
        }
