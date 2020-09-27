/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.libros.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GERSON
 */
@Entity
@Table(name = "CATEGORIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByCodCategoria", query = "SELECT c FROM Categorias c WHERE c.codCategoria = :codCategoria"),
    @NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="categoria_sec", sequenceName="sec_cod_categoria", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_sec")
    @Column(name = "COD_CATEGORIA")
    private BigDecimal codCategoria;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Lob
    @Column(name = "ILUSTRACION")
    private Serializable ilustracion;

    public Categorias() {
    }

    public Categorias(BigDecimal codCategoria) {
        this.codCategoria = codCategoria;
    }

    public BigDecimal getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(BigDecimal codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Serializable getIlustracion() {
        return ilustracion;
    }

    public void setIlustracion(Serializable ilustracion) {
        this.ilustracion = ilustracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCategoria != null ? codCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.codCategoria == null && other.codCategoria != null) || (this.codCategoria != null && !this.codCategoria.equals(other.codCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.test.libros.modelo.Categorias[ codCategoria=" + codCategoria + " ]";
    }
    
}
