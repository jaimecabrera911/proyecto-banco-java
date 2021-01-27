/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DesarrolladorWeb6
 */
@Entity
@Table(name = "movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m"),
    @NamedQuery(name = "Movimientos.findById", query = "SELECT m FROM Movimientos m WHERE m.movimientosPK.id = :id"),
    @NamedQuery(name = "Movimientos.findByCedulaCliente", query = "SELECT m FROM Movimientos m WHERE m.movimientosPK.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "Movimientos.findByCodigoCuenta", query = "SELECT m FROM Movimientos m WHERE m.movimientosPK.codigoCuenta = :codigoCuenta"),
    @NamedQuery(name = "Movimientos.findByFechaMov", query = "SELECT m FROM Movimientos m WHERE m.fechaMov = :fechaMov"),
    @NamedQuery(name = "Movimientos.findByTipoMov", query = "SELECT m FROM Movimientos m WHERE m.tipoMov = :tipoMov"),
    @NamedQuery(name = "Movimientos.findBySaldo", query = "SELECT m FROM Movimientos m WHERE m.saldo = :saldo")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovimientosPK movimientosPK;
    @Column(name = "fecha_mov")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMov;
    @Size(max = 8)
    @Column(name = "tipo_mov")
    private String tipoMov;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @JoinColumn(name = "cedula_cliente", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes clientes;
    @JoinColumn(name = "codigo_cuenta", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuentas cuentas;

    public Movimientos() {
    }

    public Movimientos(MovimientosPK movimientosPK) {
        this.movimientosPK = movimientosPK;
    }

    public Movimientos(int id, String cedulaCliente, String codigoCuenta) {
        this.movimientosPK = new MovimientosPK(id, cedulaCliente, codigoCuenta);
    }

    public MovimientosPK getMovimientosPK() {
        return movimientosPK;
    }

    public void setMovimientosPK(MovimientosPK movimientosPK) {
        this.movimientosPK = movimientosPK;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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
        hash += (movimientosPK != null ? movimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.movimientosPK == null && other.movimientosPK != null) || (this.movimientosPK != null && !this.movimientosPK.equals(other.movimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.model.Movimientos[ movimientosPK=" + movimientosPK + " ]";
    }
    
}
