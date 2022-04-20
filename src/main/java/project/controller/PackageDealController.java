package project.controller;

import project.classes.Agency;
import project.classes.PackageDeal;

/**
 * Classe permettant de faire quelques action dans un Forfait précis
 */
public class PackageDealController {

    private PackageDeal myPackageDeal;

    /**
     * Controller par défaut de la classe
     */
    public PackageDealController()
    {

    }

    /**
     * @param packageDeal Forfait que le controller fera ses actions
     */
    public void setPackageDeal(PackageDeal packageDeal)
    {
        this.myPackageDeal = packageDeal;
    }

    /** Asssigner une agence à un Forfait
     * @param agency l'Agence qui possède le Forfait
     */
    public void setAgency(Agency agency)
    {
        this.myPackageDeal.myAgency = agency;
    }
}
