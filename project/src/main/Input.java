package main;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private int numberOfYears;
    private Double santaBudget;
    private InitialData initialData = new InitialData();
    private List<AnnualChanges> annualChanges = new ArrayList<>();

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(List<AnnualChanges> annualChanges) {
        this.annualChanges = annualChanges;
    }

    @Override
    public String toString() {
        return "Input{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", initialData=" + initialData +
                ", annualChanges=" + annualChanges +
                '}';
    }
}
