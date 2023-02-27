package main;

import java.util.ArrayList;
import java.util.List;

public class AnnualChanges {
    private Double newSantaBudget;
    private List<Present> newGifts = new ArrayList<>();
    private List<Child> newChildren = new ArrayList<>();
    private List<ChildUpdate> childrenUpdates = new ArrayList<>();
    private String strategy;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<Present> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<Present> newGifts) {
        this.newGifts = newGifts;
    }

    public List<Child> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<Child> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    @Override
    public String toString() {
        return "AnnualChanges{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                '}';
    }
}
