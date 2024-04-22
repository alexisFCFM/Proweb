/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw1.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sadam
 */
@Entity
public class Publicaciones implements Serializable {

    
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idPublicacion")
    private int idPublicacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;
    
    @Basic
    private String titulo;
    private String descripcion;
    boolean estatus;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date fechaCreacion;
    Date fechaMovimiento;

    public Publicaciones() {
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicaciones(int idPublicacion, Usuarios usuario, String titulo, String descripcion, boolean estatus, Date fechaCreacion, Date fechaMovimiento) {
        this.idPublicacion = idPublicacion;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fechaCreacion = fechaCreacion;
        this.fechaMovimiento = fechaMovimiento;
    }

    public Publicaciones(Usuarios usuario, String titulo, String descripcion, boolean estatus, Date fechaCreacion, Date fechaMovimiento) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fechaCreacion = fechaCreacion;
        this.fechaMovimiento = fechaMovimiento;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPublicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicaciones)) {
            return false;
        }
        Publicaciones other = (Publicaciones) object;
        if (this.idPublicacion != other.idPublicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pw1.models.Publicaciones[ id=" + idPublicacion + " ]";
    }
    
}
