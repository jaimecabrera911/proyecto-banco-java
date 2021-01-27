/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DesarrolladorWeb6
 */
@Entity
@Table(name = "adm_cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmCuentas.findAll", query = "SELECT a FROM AdmCuentas a"),
    @NamedQuery(name = "AdmCuentas.findByCodigoCuenta", query = "SELECT a FROM AdmCuentas a WHERE a.codigoCuenta = :codigoCuenta"),
    @NamedQuery(name = "AdmCuentas.findByFechaCreacion", query = "SELECT a FROM AdmCuentas a WHERE a.fechaCreacion = :fechaCreacion")})
public class AdmCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_cuenta")
    private String codigoCuenta;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "cedula_cliente", referencedColumnName = "cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Clientes cedulaCliente;
    @JoinColumn(name = "codigo_cuenta", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cuentas cuentas;

    public AdmCuentas() {
    }

    public AdmCuentas(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Clientes getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Clientes cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Cuentas getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCuenta != null ? codigoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmCuentas)) {
            return false;
        }
        AdmCuentas other = (AdmCuentas) object;
        if ((this.codigoCuenta == null && other.codigoCuenta != null) || (this.codigoCuenta != null && !this.codigoCuenta.equals(other.codigoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.model.AdmCuentas[ codigoCuenta=" + codigoCuenta + " ]";
    }
    
}
