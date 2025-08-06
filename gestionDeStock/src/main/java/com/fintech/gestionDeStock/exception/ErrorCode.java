package com.fintech.gestionDeStock.exception;

public enum ErrorCode {

    ARTICLE_NOT_FUND(10000),
    ARTICLE_NOT_VALID(15000),
    CATEGORY_NOT_FUND(20000),
    CLIENT_NOT_FUND(30000),
    COMMANDE_CLIENT_NOT_FUND(40000),
    COMMANDE_FOURNISSEUR_NOT_FUND(50000),
    ENTREPRISE_NOT_FUND(60000),
    FOURNISSEUR_NOT_FUND(70000),
    LIGNE_COMMANDE_CLIENT_NOT_FUND(80000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FUND(90000),
    LIGNE_VENTE_NOT_FUND(100000),
    MVT_STK_NOT_FUND(110000),
    UTILISATEUR_NOT_FUND(130000),
    VENTE_NOT_FUND(140000);

    private int code;

    ErrorCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

}
