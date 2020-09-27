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
@Table(name = "VENDEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByCodVendedor", query = "SELECT v FROM Vendedores v WHERE v.codVendedor = :codVendedor"),
    @NamedQuery(name = "Vendedores.findByNombres", query = "SELECT v FROM Vendedores v WHERE v.nombres = :nombres"),
    @NamedQuery(name = "Vendedores.findByApellidos", query = "SELECT v FROM Vendedores v WHERE v.apellidos = :apellidos"),
    @NamedQuery(name = "Vendedores.findByDireccion", query = "SELECT v FROM Vendedores v WHERE v.direccion = :direccion"),
    @NamedQuery(name = "Vendedores.findByTelefono", query = "SELECT v FROM Vendedores v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "Vendedores.findByEdad", query = "SELECT v FROM Vendedores v WHERE v.edad = :edad")})
public class Vendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="vendedor_sec", sequenceName="sec_cod_vendedor", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vendedor_sec")
    @Column(name = "COD_VENDEDOR")
    private BigDecimal codVendedor;
    @Size(max = 150)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 150)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "EDAD")
    private Short edad;

    public Vendedores() {
    }

    public Vendedores(BigDecimal codVendedor) {
        this.codVendedor = codVendedor;
    }

    public BigDecimal getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(BigDecimal codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVendedor != null ? codVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.codVendedor == null && other.codVendedor != null) || (this.codVendedor != null && !this.codVendedor.equals(other.codVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.test.libros.modelo.Vendedores[ codVendedor=" + codVendedor + " ]";
    }
    
}
