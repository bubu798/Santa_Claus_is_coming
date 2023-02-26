package main;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private List<Children> annualChildren = new ArrayList<>();

    public List<Children> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(List<Children> annualChildren) {
        this.annualChildren = annualChildren;
    }
    public Output(){}
    public Output(List<Children> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
