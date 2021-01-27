/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DesarrolladorWeb6
 */
@Embeddable
public class MovimientosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cedula_cliente")
    private String cedulaCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_cuenta")
    private String codigoCuenta;

    public MovimientosPK() {
    }

    public MovimientosPK(int id, String cedulaCliente, String codigoCuenta) {
        this.id = id;
        this.cedulaCliente = cedulaCliente;
        this.codigoCuenta = codigoCuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (cedulaCliente != null ? cedulaCliente.hashCode() : 0);
        hash += (codigoCuenta != null ? codigoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientosPK)) {
            return false;
        }
        MovimientosPK other = (MovimientosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.cedulaCliente == null && other.cedulaCliente != null) || (this.cedulaCliente != null && !this.cedulaCliente.equals(other.cedulaCliente))) {
            return false;
        }
        if ((this.codigoCuenta == null && other.codigoCuenta != null) || (this.codigoCuenta != null && !this.codigoCuenta.equals(other.codigoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.model.MovimientosPK[ id=" + id + ", cedulaCliente=" + cedulaCliente + ", codigoCuenta=" + codigoCuenta + " ]";
    }
    
}
