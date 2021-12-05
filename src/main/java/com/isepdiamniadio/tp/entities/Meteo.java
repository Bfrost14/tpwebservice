/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isepdiamniadio.tp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bfrost Sama
 */
@Entity
@XmlRootElement
public class Meteo implements Serializable {

    @Id
    private String jour;
    @Column(length = 1000)
    private Double temperature;
    @Column(length = 1000)
    private Double humidite;
    @Column(length = 1000)
    private Double vitesse_vent;

    @ManyToOne
    private Localite localite;

    public Meteo() {
    }

    public Meteo(String jour, Double temperature, Double humidite, Double vitesse_vent, Localite localite) {
        this.jour = jour;
        this.temperature = temperature;
        this.humidite = humidite;
        this.vitesse_vent = vitesse_vent;
        this.localite = localite;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidite() {
        return humidite;
    }

    public void setHumidite(Double humidite) {
        this.humidite = humidite;
    }

    public Double getVitesse_vent() {
        return vitesse_vent;
    }

    public void setVitesse_vent(Double vitesse_vent) {
        this.vitesse_vent = vitesse_vent;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

}
