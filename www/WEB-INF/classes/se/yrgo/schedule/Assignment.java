package se.yrgo.schedule;

/**
 * Represents an assignment for a substitute teacher,
 * with information on the date of the assignment (including
 * start time), the teacher's name and the school of the
 * assignment (the school where the substitute will teach).
 */
public class Assignment {
    private Substitute teacher;
    private String date;
    private School school;

    /**
     * Creates a new Assignment
     *
     * @param teacher This assignment's teacher's name
     * @param date    The date of this Assignment
     * @param school  The school of this Assignment
     */
    public Assignment(Substitute teacher, String date, School school) {
        this.teacher = teacher;
        this.date = date;
        this.school = school;
    }

    /**
     * Returns this Assignment's teacher's name
     *
     * @return This Assignment's teacher's name
     */
    public Substitute teacher() {
        return this.teacher;
    }

    /**
     * Returns the date of this Assignment
     *
     * @return The date of this Assignment
     */
    public String date() {
        return this.date;
    }

    /**
     * Returns this Assignment's school
     *
     * @return This Assignment's school
     */
    public School school() {
        return this.school;
    }

    /**
     * This Assignment, represented as a String
     *
     * @return This Assignment represented as a String
     */
    @Override
    public String toString() {
        return new StringBuilder(date)
                .append(" (").append(teacher.name()).append(")")
                .append(" at ").append(school.name()).append(")")
                .append(" at ").append(school.address())
                .toString();
    }

}
