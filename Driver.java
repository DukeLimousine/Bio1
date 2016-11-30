import java.util.ArrayList;

/**
 * Created by HansYolo on 11/30/2016.
 */
public class Driver {

    private int numRaces = 2;
    private int raceSize = 100;

    public Driver(){

        PopulationGenerator populationGenerator = new PopulationGenerator();

        for(int x = 0; x < numRaces; x++) {
            ArrayList<SpeciesMember> population = populationGenerator.createRace(raceSize);
            int y = 1;
            for (SpeciesMember s : population) {
                System.out.println("Member #" + y);
                System.out.println("Species Name: " + s.getName());
                System.out.println("Length: " + s.getLength());
                System.out.println("Weight: " + s.getWeight());
                System.out.println("Tail Length: " + s.getTailLength());
                System.out.println("Wing Span: " + s.getWingSpan());
                System.out.println("Diet: " + s.getDiet().toString());
                System.out.println("Breeding Capability: " + s.getBreedingCapability());
                System.out.println("Brain Size: " + s.getBrainSize());
                System.out.println("Fat %: " + s.getFatPercentage() + "\n");
                y++;

            }
        }

    }

    public static void main(String[] args){

        Driver driver = new Driver();

    }
}
