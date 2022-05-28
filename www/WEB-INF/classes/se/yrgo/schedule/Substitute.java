package se.yrgo.schedule;

/**
 * Represents a substitute teacher,
 * with information on the name of the substitute.
 */
public class Substitute {
    private String name;

    public Substitute(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
