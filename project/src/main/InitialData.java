package main;

import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    private List<Child> children = new ArrayList<>();
    private List<Present> santaGiftsList = new ArrayList<>();
    private List<Cities> listaOrase = new ArrayList<>();

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Present> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(List<Present> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public List<Cities> getListaOrase() {
        return listaOrase;
    }

    public void setListaOrase(List<Cities> listaOrase) {
        this.listaOrase = listaOrase;
    }

    @Override
    public String toString() {
        return "InitialData{" +
                "children=" + children +
                ", santaGiftsList=" + santaGiftsList +
                ", listaOrase=" + listaOrase +
                '}';
    }
}
