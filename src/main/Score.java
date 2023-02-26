package main;

public class Score implements Comparable<Score>{
    private Integer id;
    private Double averageScore = 0.0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Score(Integer id, Double averageScore) {
        this.id = id;
        this.averageScore = averageScore;
    }

    public Score() {
    }

    @Override
    public int compareTo(Score o) {
        if (averageScore == null || o.getAverageScore() == null) {
            return 0;
        }
        Integer compare = averageScore.compareTo(o.getAverageScore());
        if (compare == 0) {
            compare = -1 * Integer.compare(id, o.getId());
        }
        return compare;
    }

    @Override

    public String toString() {
        return "Score{" +
                "id=" + id +
                ", averageScore=" + averageScore +
                '}';
    }
}
