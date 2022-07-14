package com.example.mediatech.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class LigneFactureKey implements Serializable {

    private static final long serialVersionUID = 4722352116317893282L;

    @Column(name = "facture_id")
    private Integer factureId;

    @Column(name = "produit_id")
    private Integer produitId;

}
