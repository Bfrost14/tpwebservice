/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isepdiamniadio.tp.facades;

import com.isepdiamniadio.tp.entities.Localite;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bfrost Sama
 */
@Stateless
public class LocaliteFacade extends AbstractFacade<Localite>{
    @PersistenceContext(unitName = "meteo")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocaliteFacade() {
        super(Localite.class);
    }
}
