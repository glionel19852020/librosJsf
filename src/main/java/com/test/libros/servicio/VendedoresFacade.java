/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.libros.servicio;

import com.test.libros.modelo.Vendedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GERSON
 */
@Stateless
public class VendedoresFacade extends AbstractFacade<Vendedores> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedoresFacade() {
        super(Vendedores.class);
    }
    
}
