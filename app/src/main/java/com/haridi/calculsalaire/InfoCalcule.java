package com.haridi.calculsalaire;

import java.io.Serializable;

public class InfoCalcule implements Serializable {

    Double jour,hour,prix,jourfree,jourconge,sup,prime,samdi,other,amo,cnss,igr;




    public InfoCalcule() {
    }

    public Double getJour() {
        return jour;
    }

    public void setJour(Double jour) {
        this.jour = jour;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getJourfree() {
        return jourfree;
    }

    public void setJourfree(Double jourfree) {
        this.jourfree = jourfree;
    }

    public Double getJourconge() {
        return jourconge;
    }

    public void setJourconge(Double jourconge) {
        this.jourconge = jourconge;
    }

    public Double getSup() {
        return sup;
    }

    public void setSup(Double sup) {
        this.sup = sup;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public Double getSamdi() {
        return samdi;
    }

    public void setSamdi(Double samdi) {
        this.samdi = samdi;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getAmo() {
        return amo;
    }

    public void setAmo(Double amo) {
        this.amo = amo;
    }

    public Double getCnss() {
        return cnss;
    }

    public void setCnss(Double cnss) {
        this.cnss = cnss;
    }

    public Double getIgr() {
        return igr;
    }

    public void setIgr(Double igr) {
        this.igr = igr;
    }



}
