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

}
