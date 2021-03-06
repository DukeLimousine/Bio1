import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HansYolo on 11/22/2016.
 */
public class PopulationGenerator {

    final static int STD_DEV = 5;
    //Thresholds for standard deviations set according to the 68-95-99.7 rule (Wikipedia)
    final double FIRST_SD_THRESHOLD = .68;
    final double SECOND_SD_THRESHOLD = .95;
    final double THIRD_SD_THRESHOLD = .997;
    private Random random;

    public PopulationGenerator(){

        random = new Random();

    }

    private double percentDiff(){

        return ((double)random.nextInt(STD_DEV) + 1) / 100;
    }

    public ArrayList<SpeciesMember> createRace(int size){
        ArrayList<SpeciesMember> race = new ArrayList<SpeciesMember>();
        Species species = new Species();

        for(int x = 0; x < size; x++){

            SpeciesMember member = new SpeciesMember();
            boolean add;
            double traitVal;
            member.setName(species.getSpeciesName());

            //calculate and set weight
            add = random.nextBoolean(); //if true, add the ST_DEV percentage
            traitVal = species.getMeanWeight() * percentDiff();//value by which this member's weight differs from the mean weight
            if(add){
                member.setWeight(species.getMeanWeight() + traitVal);
            }
            else{
                member.setWeight(species.getMeanWeight() - traitVal);
            }

            //calculate and set length
            add = random.nextBoolean();
            traitVal = species.getMeanLength() * percentDiff();
            if(add){
                member.setLength(species.getMeanLength() + traitVal);
            }
            else{
                member.setLength(species.getMeanLength() - traitVal);
            }

            //calculate and set tail length
            if(species.getMeanTailLength() > 0){//species has a tail
                add = random.nextBoolean();
                traitVal = species.getMeanTailLength() * percentDiff();
                if(add){
                    member.setTailLength(species.getMeanTailLength() + traitVal);
                }
                else{
                    member.setTailLength(species.getMeanTailLength() - traitVal);
                }
            }
            else{//species has no tail
                member.setTailLength(0);
            }

            //calculate and set wing span
            if(species.getMeanWingSpan()>0){//species has wings
                add = random.nextBoolean();
                traitVal = species.getMeanWingSpan() * percentDiff();
                if(add){
                    member.setWingSpan(species.getMeanWingSpan() + traitVal);
                }
                else{
                    member.setWingSpan(species.getMeanWingSpan() - traitVal);
                }
            }
            else{
                member.setWingSpan(0);//species has no wings
            }

            //assign random diet
            member.setDiet(species.getDiet());

            //Assign Breeding Capability
            member.setBreedingCapability(1); //everyone has 1 baby for now

            //calculate and set brain size
            add = random.nextBoolean();
            traitVal = species.getMeanBrainSize() * percentDiff();
            if(add){
                member.setBrainSize(species.getMeanBrainSize() + traitVal);
            }
            else{
                member.setBrainSize(species.getMeanBrainSize() - traitVal);
            }

            //calculate and set fat percentage
            add = random.nextBoolean();
            traitVal = species.getMeanFatPercentage() * percentDiff();
            if(add){
                member.setFatPercentage(species.getMeanFatPercentage() + traitVal);
            }
            else{
                member.setFatPercentage(species.getMeanFatPercentage() - traitVal);
            }

            //after all traits have been set, add member to the species member array
            race.add(member);
        }

        return race;
    }

    public ArrayList<SpeciesMember> reproduce(ArrayList<SpeciesMember> parentGeneration){

        ArrayList<SpeciesMember> offspringGeneration = new ArrayList<SpeciesMember>();
        boolean add;
        double traitVal;
        String spcName = parentGeneration.get(0).getName();

        for(SpeciesMember parent : parentGeneration){

            for(int x = 0; x < parent.getBreedingCapability(); x++){
                SpeciesMember offspring = new SpeciesMember();

                //calculate and set weight
                add = random.nextBoolean(); //if true, add the ST_DEV percentage
                traitVal = parent.getWeight() * percentDiff();//value by which this member's weight differs from the parent weight
                if(add){
                    offspring.setWeight(parent.getWeight() + traitVal);
                }
                else{
                    offspring.setWeight(parent.getWeight() - traitVal);
                }

                //calculate and set length
                add = random.nextBoolean();
                traitVal = parent.getLength() * percentDiff();
                if(add){
                    offspring.setLength(parent.getLength() + traitVal);
                }
                else{
                    offspring.setLength(parent.getLength() - traitVal);
                }

                //calculate and set tail length
                if(parent.getTailLength() > 0){//species has a tail
                    add = random.nextBoolean();
                    traitVal = parent.getTailLength() * percentDiff();
                    if(add){
                        offspring.setTailLength(parent.getTailLength() + traitVal);
                    }
                    else{
                        offspring.setTailLength(parent.getTailLength() - traitVal);
                    }
                }
                else{//species has no tail
                    offspring.setTailLength(0);
                }

                //calculate and set wing span
                if(parent.getWingSpan()>0){//species has wings
                    add = random.nextBoolean();
                    traitVal = parent.getWingSpan() * percentDiff();
                    if(add){
                        offspring.setWingSpan(parent.getWingSpan() + traitVal);
                    }
                    else{
                        offspring.setWingSpan(parent.getWingSpan() - traitVal);
                    }
                }
                else{
                    offspring.setWingSpan(0);//species has no wings
                }

                //assign random diet
                offspring.setDiet(parent.getDiet());

                //Assign Breeding Capability
                offspring.setBreedingCapability(1); //everyone has 1 baby for now

                //calculate and set brain size
                add = random.nextBoolean();
                traitVal = parent.getBrainSize() * percentDiff();
                if(add){
                    offspring.setBrainSize(parent.getBrainSize() + traitVal);
                }
                else{
                   offspring.setBrainSize(parent.getBrainSize() - traitVal);
                }

                //calculate and set fat percentage
                add = random.nextBoolean();
                traitVal = parent.getFatPercentage() * percentDiff();
                if(add){
                    offspring.setFatPercentage(parent.getFatPercentage() + traitVal);
                }
                else{
                    offspring.setFatPercentage(parent.getFatPercentage() - traitVal);
                }

                offspringGeneration.add(offspring);

            }
        }


        return offspringGeneration;

    }
}
