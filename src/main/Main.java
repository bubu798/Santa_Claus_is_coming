package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        Double iterator = 1.0;
        Double sumPonder = 0.0;
        Double averageSum;

        Double budgetUnit;
        Double spent = 0.0;

        Input input = new Input();

        List<String> cityNameList = new ArrayList<>();
        List<Score> scoreListNew = new ArrayList<>();
        List<Child> newList = new ArrayList<>();
        List<City> cityList = new ArrayList<>();
        List<Present> listaCadouri = new ArrayList<>();

        Output output = new Output();
        for(int i = 1; i <= 30; i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                input = objectMapper.readValue(new File("tests/test" + i + ".json"), Input.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            averageSum = 0.0;
            //average niceScore
            for(int j = 0; j <= input.getNumberOfYears(); j++) {
                if (j > 0) {
                    for (Child child: input.getAnnualChanges().get(j - 1).getNewChildren()) {
                        input.getInitialData().getChildren().add(child);
                    }

                    for (ChildUpdate childUpdate: input.getAnnualChanges().get(j - 1).getChildrenUpdates()) {
                        for (Child child: input.getInitialData().getChildren()) {
                            // se face update-ul daca id-urile coincid
                            if (child.getId().equals(childUpdate.getId())) {
                                // se adauga nice score-ul in lista cu nice score-uri
                                if (childUpdate.getNiceScore() != null)
                                    child.getNiceScoreHistory().add(childUpdate.getNiceScore());
                                child.setElf(childUpdate.getElf());
                                // se adauga preferinta in lista de preferinte daca nu exista deja
                                Collections.reverse(childUpdate.getGiftsPreferences());
                                for (String preference: childUpdate.getGiftsPreferences()) {
                                    if (!child.getGiftsPreferences().contains(preference))
                                        child.getGiftsPreferences().add(0, preference);
                                    else  {
                                        child.getGiftsPreferences().remove(preference);
                                        child.getGiftsPreferences().add(0, preference);
                                    }
                                }
                            }
                        }
                    }
                    // se modifica bugetul mosului
                    input.setSantaBudget(input.getAnnualChanges().get(j - 1).getNewSantaBudget());

                    // se adauga cadourile noi in lista de cadouri
                    for (Present present: input.getAnnualChanges().get(j - 1).getNewGifts()) {
                        input.getInitialData().getSantaGiftsList().add(present);
                    }
                }

                for(Child child : input.getInitialData().getChildren()) {
                    //child
                    City city = new City();
                    Score childScore = new Score();
                    if(child.getAge() > 18) child.setId(999);
                    if(child.getAge() <= 18) {
                        if (child.getNiceScoreHistory().size() == 0)
                            child.getNiceScoreHistory().add(child.getNiceScore());

                        //baby
                        if (child.getAge() < 5) {
                            child.setAverageScore(10.0);
                            //kid
                        } else if (child.getAge() >= 5 && child.getAge() < 12) {
                            for (Double niceScore : child.getNiceScoreHistory()) {
                                child.setAverageScore(child.getAverageScore() + niceScore);
                            }
                            child.setAverageScore(child.getAverageScore() / child.getNiceScoreHistory().size());
                        }
                        //teen
                        else if (child.getAge() >= 12 && child.getAge() <= 18) {
                            for (Double niceScore : child.getNiceScoreHistory()) {
                                child.setAverageScore(child.getAverageScore() + niceScore * iterator);
                                sumPonder += iterator;
                                iterator++;
                            }
                            iterator = 1.0;
                            child.setAverageScore(child.getAverageScore() / sumPonder);
                            sumPonder = 0.0;
                        }
                        if (child.getNiceScoreBonus() > 0) {
                            child.setAverageScore(child.getAverageScore() + child.getAverageScore() * child.getNiceScoreBonus() / 100);
                            if (child.getAverageScore() > 10) child.setAverageScore(10.0);
                        }
                        averageSum += child.getAverageScore(); //suma scorurilor average de la toți copiii
                        childScore.setId(child.getId());
                        childScore.setAverageScore(child.getAverageScore());
                        scoreListNew.add(childScore);
                        if (!cityNameList.contains(child.getCity())) {
                            cityNameList.add(child.getCity());
                            city.setCityName(child.getCity());
                            city.setCityScoreSum(city.getCityScoreSum() + child.getAverageScore());
                            city.setNumberOfPeople(city.getNumberOfPeople() + 1);
                            cityList.add(city);
                        }
                        else {
                            for (City cityToFind: cityList) {
                                if (cityToFind.getCityName().equals(child.getCity())) {
                                    cityToFind.setCityScoreSum(cityToFind.getCityScoreSum() + child.getAverageScore());
                                    cityToFind.setNumberOfPeople(cityToFind.getNumberOfPeople() + 1);
                                }
                            }
                        }
                    }
                }

                for(City city: cityList) {
                    city.setCityAverageScore(city.getCityScoreSum() / city.getNumberOfPeople());
                }

                Collections.sort(cityList);
                Collections.reverse(cityList);

                budgetUnit = input.getSantaBudget() / averageSum;
                averageSum = 0.0;

                Collections.sort(scoreListNew);
                Collections.reverse(scoreListNew);

                Present cheapestPresent;
                for(Child child : input.getInitialData().getChildren()) {
                    if (child.getAge() <= 18) {
                        child.setAssignedBudget(child.getAverageScore() * budgetUnit); //bugetul alocat unui copil
                        switch (child.getElf()) {
                            case "white":
                                break;
                            case "black":
                                child.setAssignedBudget(child.getAssignedBudget() - child.getAssignedBudget() * 30 / 100);
                                break;
                            case "pink":
                                child.setAssignedBudget(child.getAssignedBudget() + child.getAssignedBudget() * 30 / 100);
                        }
                    }
                }

                if (j > 0 && input.getAnnualChanges().get(j - 1).getStrategy().equals("niceScore")) {
                    for(Score score : scoreListNew) {
                        for(Child child : input.getInitialData().getChildren()) {
                            if (score.getId().equals(child.getId())) {
                                assignGifts(spent, input, listaCadouri, child);
                            }

                        }
                    }
                }
                else  {
                    if (j > 0 && input.getAnnualChanges().get(j - 1).getStrategy().equals("niceScoreCity")) {
                        for(City city : cityList) {
                            for(Child child : input.getInitialData().getChildren()) {
                                if (child.getCity().equals(city.getCityName())) {
                                    assignGifts(spent, input, listaCadouri, child);
                                }
                            }
                        }
                    }
                    else{
                        for(Child child : input.getInitialData().getChildren()) {
                            assignGifts(spent, input, listaCadouri, child);
                        }
                    }
                }
                for (Child child: input.getInitialData().getChildren()) {
                    if (child.getAge() <= 18) {
                        if (child.getElf().equals("yellow") && child.getReceivedGifts().isEmpty()) {
                            for (String prefrence: child.getGiftsPreferences()) {
                                // completeaza lista de cadouri care coincide cu preferintele copilului
                                for (Present present: input.getInitialData().getSantaGiftsList()) {
                                    if(present.getCategory().equals(prefrence)) listaCadouri.add(present);
                                }
                                if (listaCadouri.size() > 0) {
                                    cheapestPresent = listaCadouri.get(0);
                                    // ia cel mai ieftin cadou din lista daca exista mai multe
                                    if (listaCadouri.size() > 1) {
                                        for(Present present: listaCadouri) {
                                            if(present.getPrice() < cheapestPresent.getPrice()){
                                                cheapestPresent = present;
                                            }
                                        }
                                    }

                                    if (cheapestPresent.getQuantity() > 0 && child.getReceivedGifts().isEmpty()) {
                                        child.getReceivedGifts().add(cheapestPresent);
                                        cheapestPresent.setQuantity(cheapestPresent.getQuantity() - 1);
                                    }
                                    listaCadouri.clear();
                                }
                            }
                        }
                    }
                }


                for (Child child: input.getInitialData().getChildren()) {
                    if(child.getAge()<= 18) {
                        Child newChild = new Child(child);
                        newList.add(newChild);
                    }
                }

                Children children = new Children();
                children.addToList(newList);
                output.getAnnualChildren().add(children);

                cityList.clear();
                cityNameList.clear();
                newList.clear();
                scoreListNew.clear();

                for (Child child : input.getInitialData().getChildren()) {
                    child.setAge(child.getAge() + 1);
                    child.setAverageScore(0.0);
                    child.setAssignedBudget(0.0);
                    child.getReceivedGifts().clear();
                }
            }
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("output/out_" + i + ".json"), output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            output.getAnnualChildren().clear();
        }
        Checker.calculateScore();
    }

    private static void assignGifts(Double spent, Input input, List<Present> listaCadouri, Child child) {
        Present cheapestPresent;
        if (child.getAge() <= 18) {
            // assign gifts
            for (String prefrence: child.getGiftsPreferences()) {
                // completeaza lista de cadouri care coincide cu preferintele copilului
                for (Present present: input.getInitialData().getSantaGiftsList()) {
                    if(present.getCategory().equals(prefrence) && present.getQuantity() > 0) listaCadouri.add(present);
                }
                if (listaCadouri.size() > 0) {
                    cheapestPresent = listaCadouri.get(0);
                    // ia cel mai ieftin cadou din lista daca exista mai multe
                    if (listaCadouri.size() > 1) {
                        for(Present present: listaCadouri) {
                            if(present.getPrice() < cheapestPresent.getPrice()){
                                cheapestPresent = present;
                            }
                        }
                    }
                    if (child.getAssignedBudget() >= cheapestPresent.getPrice()) {
                        child.getReceivedGifts().add(cheapestPresent);
                        child.setAssignedBudget(child.getAssignedBudget() - cheapestPresent.getPrice());
                        spent += cheapestPresent.getPrice();
                        cheapestPresent.setQuantity(cheapestPresent.getQuantity() - 1);
                    }
                    listaCadouri.clear();
                }
            }
            child.setAssignedBudget(child.getAssignedBudget() + spent);
        }
    }
}
