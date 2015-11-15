package rules.cardio;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class HIIT implements Cardio {

    private double HIITLower = 0.65;
    private double HIITUpper = 0.85;

    private String name = "HIIT";
    private String fullname = "High-Intensity-Interval Training";
    private String type = "Anaerobic";
    private String duration = "4-20 mins";
    private String benefits = "Increase Metabolism & Strength";
    private String frequency = "1-3 times/week";
    private String average = "20 ~ 60 mins/week";
    private String description = "a training technique in which you give all-out, one hundred percent effort through quick, intense bursts of exercise, followed by short, sometimes active, recovery periods.";

    private double lowerBound;
    private double upperBound;

    private double maxHR;

    public HIIT(double maxHR, boolean isIntense) {
        this.lowerBound = maxHR * HIITLower;
        this.upperBound = maxHR * HIITUpper;
    }

    public String getName() {
        return this.name;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getType() {
        return this.type;
    }

    public String getLowerHR() {
        return ""+this.lowerBound;
    }

    public String getUpperHR() {
        return ""+this.upperBound;
    }

    public String getHR() {
        return String.format("%.0f ~ %.0f times/minutes",this.lowerBound, this.upperBound);
    }

    public String getDuration() {
        return this.duration;
    }

    public String getBenefit() {
        return this.benefits;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String getAverage() {
        return this.average;
    }

    public String getDescription() {
        return this.description;
    }
}
