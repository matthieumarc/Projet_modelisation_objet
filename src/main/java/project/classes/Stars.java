package project.classes;

/**
 * Niveau d'appréciation pour une review
 */
public enum Stars {
    /**
     * 1 étoile = Atroce
     */
    ONE(1),
    /**
     * 2 étoiles = Décevant
     */
    TWO(2),
    /**
     * 3 étoiles = Bien
     */
    THREE(3),
    /**
     * 4 étoiles = Très Bien
     */
    FOUR(4),
    /**
     * 5 étoiles = Exceptionnel
     */
    FIVE(5);

    private int value;

    Stars(final int value) {
        this.value = value;
    }


    /**
     * @return la valeur de l'Étoile sur 5
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
}
