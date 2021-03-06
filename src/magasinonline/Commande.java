/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magasinonline;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//ajout
    private String moy2paie;
    private Integer somme;

    public String getMoy2paie() {
        return moy2paie;
    }

    public void setMoy2paie(String moy2paie) {
        this.moy2paie = moy2paie;
    }

    public Integer getSomme() {
        return somme;
    }

    public void setSomme(Integer somme) {
        this.somme = somme;
    }

    public String getMode2livraison() {
        return mode2livraison;
    }

    public void setMode2livraison(String mode2livraison) {
        this.mode2livraison = mode2livraison;
    }

    public Integer getFrais2port() {
        return frais2port;
    }

    public void setFrais2port(Integer frais2port) {
        this.frais2port = frais2port;
    }

    public Date getDate2commande() {
        return date2commande;
    }

    public void setDate2commande(Date date2commande) {
        this.date2commande = date2commande;
    }

    public Date getDate2livraison() {
        return date2livraison;
    }

    public void setDate2livraison(Date date2livraison) {
        this.date2livraison = date2livraison;
    }

    public Statutc getStatut() {
        return statut;
    }

    public void setStatut(Statutc statut) {
        this.statut = statut;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    private String mode2livraison;
    private Integer frais2port;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date2commande;
    @Temporal(TemporalType.DATE)
    private Date date2livraison;
    @Enumerated(EnumType.ORDINAL)
    private Statutc statut;

    @Embedded
    private Adresse adresse;

    public enum Statutc {
        encours,
        terminé,
        payé
    }
    
    @ManyToOne
    //ajouter une colonne categorie_id dans Produit
    @JoinColumn(name = "client_id")//cree la cle etrangere
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magasinonline.Commande[ id=" + id + " ]";
    }

}
