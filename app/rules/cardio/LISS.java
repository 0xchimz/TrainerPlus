package rules.cardio;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class LISS implements Cardio {

    private double LISSLower = 0.6;
    private double LISSUpper = 0.75;

    private String name = "LISS";
    private String fullname = "Low Intensity Steady State";
    private String type = "Aerobic";
    private String duration = "30-60 mins";
    private String benefits = "Burn Fat";
    private String frequency = "2-4 times/week";
    private String average = "60 ~ 200 mins/week";
    private String description = "Walking, swimming, running, cycling, etc with steady Heart Rate.";
    private double lowerBound;
    private double upperBound;

    private double maxHR;

    public LISS(double maxHR, boolean isIntense) {
        this.lowerBound = maxHR * LISSLower;
        this.upperBound = maxHR * LISSUpper;
    }

    public String getName() {
        return this.name;
    }

    public String getFullName() {
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
