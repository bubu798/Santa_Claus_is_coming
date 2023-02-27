package main;

import java.util.ArrayList;
import java.util.List;

public class City implements Comparable<City> {
    private String cityName;
    private Double cityScoreSum = 0.0;
    private Double numberOfPeople = 0.0;
    private Double cityAverageScore = 0.0;

    public String getCityName() {
        return cityName;
    }

    public Double getCityAverageScore() {
        return cityAverageScore;
    }

    public void setCityAverageScore(Double cityAverageScore) {
        this.cityAverageScore = cityAverageScore;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getCityScoreSum() {
        return cityScoreSum;
    }

    public void setCityScoreSum(Double cityScoreSum) {
        this.cityScoreSum = cityScoreSum;
    }

    public Double getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Double numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public City() {
    }

    public City(String cityName, Double cityScoreSum, Double numberOfPeople) {
        this.cityName = cityName;
        this.cityScoreSum = cityScoreSum;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int compareTo(City o) {
        if (this.getCityAverageScore() == null || o.getCityAverageScore() == null) {
            return 0;
        }
        Integer compare = cityAverageScore.compareTo(o.getCityAverageScore());
        if (compare == 0) {
            compare = -1 * cityName.compareTo(o.getCityName());
        }
        return compare;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityScoreSum=" + cityScoreSum +
                ", numberOfPeople=" + numberOfPeople +
                ", cityAverageScore=" + cityAverageScore +
                '}';
    }
}
