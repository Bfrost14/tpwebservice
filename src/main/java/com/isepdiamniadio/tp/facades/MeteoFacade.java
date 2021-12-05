/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isepdiamniadio.tp.facades;

import com.isepdiamniadio.tp.entities.Meteo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bfrost Sama
 */
@Stateless
public class MeteoFacade extends AbstractFacade<Meteo>{
    @PersistenceContext(unitName = "meteo")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MeteoFacade() {
        super(Meteo.class);
    }
}
