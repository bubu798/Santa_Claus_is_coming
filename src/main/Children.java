package main;

import java.util.ArrayList;
import java.util.List;

public class Children {
    private List<Child> children = new ArrayList<>();

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
    public Children(){}
    public void addToList(List<Child> other) {
        for (Child child: other) {
            Child newChild = new Child(child);
            this.children.add(newChild);
        }
    }
    public Children(List<Child> children) {
        this.children = children;
    }
}
