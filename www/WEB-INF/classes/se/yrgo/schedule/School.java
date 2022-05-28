package se.yrgo.schedule;

/**
 * Represents a school of a substitute teacher,
 * with information on the name and address of the school
 * where a substitute will teach.
 */
public class School {
    private String name;
    private String address;

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String name() {
        return this.name;
    }

    public String address() {
        return this.address;
    }
}
