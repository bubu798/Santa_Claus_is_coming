package main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private Integer id;
    private String lastName;
    private String firstName;
    private String city;
    private Integer age;
    private List<String> giftsPreferences = new ArrayList<>();
    private Double averageScore = 0.0;
    @JsonIgnore
    private Double niceScore = 0.0;
    @JsonIgnore
    private String elf;
    @JsonIgnore
    private Double niceScoreBonus = 0.0;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget = 0.0;
    private List<Present> receivedGifts = new ArrayList<>();

    public List<Present> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(List<Present> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonIgnore
    public String getElf() {
        return elf;
    }
    @JsonProperty
    public void setElf(String elf) {
        this.elf = elf;
    }
    @JsonIgnore
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }
    @JsonProperty
    public void setNiceScoreBonus(Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
    @JsonIgnore
    public Double getNiceScore() {
        return niceScore;
    }
    @JsonProperty
    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public Child() {

    }

    public Child(Integer id, String lastName, String firstName, String city, Integer age, List<String> giftsPreferences, Double averageScore, Double niceScore, String elf, Double niceScoreBonus, List<Double> niceScoreHistory, Double assignedBudget, List<Present> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScore = niceScore;
        this.elf = elf;
        this.niceScoreBonus = niceScoreBonus;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }

    public Child(Child other) {
        this.id = other.getId();
        this.age = other.getAge();
        this.firstName = other.getFirstName();
        this.lastName = other.getLastName();
        this.city = other.getCity();
        this.niceScoreBonus = other.getNiceScoreBonus();
        this.elf = other.getElf();
        List<String> newGiftPref = new ArrayList<>();
        newGiftPref.addAll(other.getGiftsPreferences());
        this.setGiftsPreferences(newGiftPref);
        this.niceScore = other.getNiceScore();
        List<Double> newNiceScoreList = new ArrayList<>();
        newNiceScoreList.addAll(other.getNiceScoreHistory());
        this.setNiceScoreHistory(newNiceScoreList);
        this.setAverageScore(other.getAverageScore());
        this.setAssignedBudget(other.getAssignedBudget());
        List<Present> newGiftList = new ArrayList<>();
        for (Present present: other.getReceivedGifts()) {
            Present newPresent = new Present(present);
            newGiftList.add(newPresent);
        }
        this.receivedGifts = newGiftList;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city=" + city +
                ", age=" + age +
                ", giftsPreferences=" + giftsPreferences +
                ", niceScore=" + niceScore +
                ", niceScoreList=" + niceScoreHistory +
                ", averageScore=" + averageScore +
                ", allocatedBudget=" + assignedBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }
}
