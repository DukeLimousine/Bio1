import java.util.ArrayList;

/**
 * Created by HansYolo on 11/30/2016.
 */
public class Driver {

    private int numRaces = 1;
    private int raceSize = 20;
    private int generations = 200;

    public Driver(){

        PopulationGenerator populationGenerator = new PopulationGenerator();


            ArrayList<SpeciesMember> population = populationGenerator.createRace(raceSize);
            int y = 1;
        double avgLength = 0.0;
        double avgWeight = 0.0;
        double avgFat = 0.0;
        double avgBrain = 0.0;
            for (SpeciesMember s : population) {
                avgLength += s.getLength();
                avgWeight += s.getWeight();
                avgBrain += s.getBrainSize();
                avgFat += s.getFatPercentage();
//                System.out.println("Member #" + y);
//                System.out.println("Species Name: " + s.getName());
//                System.out.println("Length: " + s.getLength());
//                System.out.println("Weight: " + s.getWeight());
//                System.out.println("Tail Length: " + s.getTailLength());
//                System.out.println("Wing Span: " + s.getWingSpan());
//                System.out.println("Diet: " + s.getDiet().toString());
//                System.out.println("Breeding Capability: " + s.getBreedingCapability());
//                System.out.println("Brain Size: " + s.getBrainSize());
//                System.out.println("Fat %: " + s.getFatPercentage() + "\n");
//                y++;
            }

        avgLength = avgLength / (double)population.size();
        avgWeight = avgWeight / (double)population.size();
        avgBrain = avgBrain / (double)population.size();
        avgFat = avgFat / (double)population.size();

        System.out.println("*****Generation 1*****");
        System.out.println("Average Length: " + avgLength);
        System.out.println("Average Weight: " + avgWeight);
        System.out.println("Average Brain Size: " + avgBrain);
        System.out.println("Average Fat: " + avgFat);

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

                 System.out.println("*****Generation " + (x+2) + "*****");
                 System.out.println("Average Length: " + avgLength);
                 System.out.println("Average Weight: " + avgWeight);
                 System.out.println("Average Brain Size: " + avgBrain);
                 System.out.println("Average Fat: " + avgFat);
             }


    }

    public static void main(String[] args){

        Driver driver = new Driver();

    }
}
