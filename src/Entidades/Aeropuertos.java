/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author juanb
 */
@Entity
@Table(name = "aeropuertos", catalog = "u984447967_op2024b", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aeropuertos.findAll", query = "SELECT a FROM Aeropuertos a"),
    @NamedQuery(name = "Aeropuertos.findByIdAeropuerto", query = "SELECT a FROM Aeropuertos a WHERE a.idAeropuerto = :idAeropuerto"),
    @NamedQuery(name = "Aeropuertos.findByNombre", query = "SELECT a FROM Aeropuertos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aeropuertos.findByCiudad", query = "SELECT a FROM Aeropuertos a WHERE a.ciudad = :ciudad"),
    @NamedQuery(name = "Aeropuertos.findByPais", query = "SELECT a FROM Aeropuertos a WHERE a.pais = :pais"),
    @NamedQuery(name = "Aeropuertos.findByPrivado", query = "SELECT a FROM Aeropuertos a WHERE a.privado = :privado"),
    @NamedQuery(name = "Aeropuertos.findByPublico", query = "SELECT a FROM Aeropuertos a WHERE a.publico = :publico"),
    @NamedQuery(name = "Aeropuertos.findBySubvencion", query = "SELECT a FROM Aeropuertos a WHERE a.subvencion = :subvencion")})
public class Aeropuertos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAeropuerto", nullable = false)
    private Integer idAeropuerto;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 250)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ciudad", nullable = false, length = 250)
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "pais", nullable = false, length = 250)
    private String pais;
    @Basic(optional = false)
    @Column(name = "privado", nullable = false)
    private int privado;
    @Basic(optional = false)
    @Column(name = "publico", nullable = false)
    private int publico;
    @Basic(optional = false)
    @Column(name = "subvencion", nullable = false)
    private double subvencion;

    public Aeropuertos() {
    }

    public Aeropuertos(Integer idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public Aeropuertos(Integer idAeropuerto, String nombre, String ciudad, String pais, int privado, int publico, double subvencion) {
        this.idAeropuerto = idAeropuerto;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.privado = privado;
        this.publico = publico;
        this.subvencion = subvencion;
    }

    public Integer getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(Integer idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getPrivado() {
        return privado;
    }

    public void setPrivado(int privado) {
        this.privado = privado;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }

    public double getSubvencion() {
        return subvencion;
    }

    public void setSubvencion(double subvencion) {
        this.subvencion = subvencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAeropuerto != null ? idAeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuertos)) {
            return false;
        }
        Aeropuertos other = (Aeropuertos) object;
        if ((this.idAeropuerto == null && other.idAeropuerto != null) || (this.idAeropuerto != null && !this.idAeropuerto.equals(other.idAeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Aeropuertos[ idAeropuerto=" + idAeropuerto + " ]";
    }
    
}
