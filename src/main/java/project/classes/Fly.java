package project.classes;


/**
 * Entité pour décrire les données d'un vol d'avion
 */
public class Fly {

    private FlyClass fClass;
    private String compagnyName;

    /**
     * @param compagnyName Le nom de la compagnie de ce vol
     * @param flyClass Le type de service reçu lors du vol
     */
    public Fly(String compagnyName , FlyClass flyClass){

        this.compagnyName = compagnyName;
        this.fClass = flyClass;
    }

    /**
     * @return the flyClass enum value.
     */
    public FlyClass getFlyClass() {
        return fClass;
    }

    /**
     * @return the name of the compagny of the Fly.
     */
    public String getCompagnyName() {
        return compagnyName;
    }

    @Override
    public String toString() {

        StringBuilder strbuilder = new StringBuilder();
        strbuilder.append(this.getCompagnyName()).append("(").append(this.getFlyClass()).append(")");
        return strbuilder.toString();
    }
}
