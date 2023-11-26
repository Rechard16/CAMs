package model;

/**
 * The Faculty enum represents the various faculties or schools within a
 * university, which is used to restrct the visibility of camps.
 */

public enum Faculty {
    /*
     * The Facuty School allows all students to view the camp.
     */
    SCHOOL,
    /*
     * The Facuty SCSE allows only students from the School of Computer Science
     * and Engineering to view the camp.
     */
    SCSE,
    /*
     * The Facuty NBS allows only students from the Nanyang Business School to
     * view the camp.
     */
    NBS,
    /*
     * The Facuty MAE allows only students from the School of Mechanical and
     * Aerospace Engineering to view the camp.
     */
    ADM,
    /*
     * The Facuty MAE allows only students from the School of Mechanical and
     * Aerospace Engineering to view the camp.
     */
    SSS,
    /*
     * The Facuty MAE allows only students from the School of Mechanical and
     * Aerospace Engineering to view the camp.
     */
    EEE
}