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
@Table(name = "vuelos", catalog = "u984447967_op2024b", schema = "")
@NamedQueries({
    @NamedQuery(name = "Vuelos.findAll", query = "SELECT v FROM Vuelos v"),
    @NamedQuery(name = "Vuelos.findByIdVuelo", query = "SELECT v FROM Vuelos v WHERE v.idVuelo = :idVuelo"),
    @NamedQuery(name = "Vuelos.findByIdentificador", query = "SELECT v FROM Vuelos v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "Vuelos.findByCiudadOrigen", query = "SELECT v FROM Vuelos v WHERE v.ciudadOrigen = :ciudadOrigen"),
    @NamedQuery(name = "Vuelos.findByCiudadDestino", query = "SELECT v FROM Vuelos v WHERE v.ciudadDestino = :ciudadDestino"),
    @NamedQuery(name = "Vuelos.findByPrecio", query = "SELECT v FROM Vuelos v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vuelos.findByNumMaxPasajeros", query = "SELECT v FROM Vuelos v WHERE v.numMaxPasajeros = :numMaxPasajeros")})
public class Vuelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVuelo", nullable = false)
    private Integer idVuelo;
    @Basic(optional = false)
    @Column(name = "identificador", nullable = false, length = 250)
    private String identificador;
    @Basic(optional = false)
    @Column(name = "ciudadOrigen", nullable = false, length = 250)
    private String ciudadOrigen;
    @Basic(optional = false)
    @Column(name = "ciudadDestino", nullable = false, length = 250)
    private String ciudadDestino;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private double precio;
    @Basic(optional = false)
    @Column(name = "numMaxPasajeros", nullable = false)
    private int numMaxPasajeros;

    public Vuelos() {
    }

    public Vuelos(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Vuelos(Integer idVuelo, String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.idVuelo = idVuelo;
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }

    public void setNumMaxPasajeros(int numMaxPasajeros) {
        this.numMaxPasajeros = numMaxPasajeros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVuelo != null ? idVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelos)) {
            return false;
        }
        Vuelos other = (Vuelos) object;
        if ((this.idVuelo == null && other.idVuelo != null) || (this.idVuelo != null && !this.idVuelo.equals(other.idVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Vuelos[ idVuelo=" + idVuelo + " ]";
    }
    
}
