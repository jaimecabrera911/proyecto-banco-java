/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DesarrolladorWeb6
 */
@Entity
@Table(name = "cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c"),
    @NamedQuery(name = "Cuentas.findByCodigo", query = "SELECT c FROM Cuentas c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cuentas.findByNombreCta", query = "SELECT c FROM Cuentas c WHERE c.nombreCta = :nombreCta"),
    @NamedQuery(name = "Cuentas.findByEstado", query = "SELECT c FROM Cuentas c WHERE c.estado = :estado")})
public class Cuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 25)
    @Column(name = "nombre_cta")
    private String nombreCta;
    @Column(name = "estado")
    private Boolean estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cuentas", fetch = FetchType.LAZY)
    private AdmCuentas admCuentas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentas", fetch = FetchType.LAZY)
    private List<Movimientos> movimientosList;

    public Cuentas() {
    }

    public Cuentas(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCta() {
        return nombreCta;
    }

    public void setNombreCta(String nombreCta) {
        this.nombreCta = nombreCta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public AdmCuentas getAdmCuentas() {
        return admCuentas;
    }

    public void setAdmCuentas(AdmCuentas admCuentas) {
        this.admCuentas = admCuentas;
    }

    @XmlTransient
    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.model.Cuentas[ codigo=" + codigo + " ]";
    }
    
}
