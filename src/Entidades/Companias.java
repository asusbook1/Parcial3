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
@Table(name = "companias", catalog = "u984447967_op2024b", schema = "")
@NamedQueries({
    @NamedQuery(name = "Companias.findAll", query = "SELECT c FROM Companias c"),
    @NamedQuery(name = "Companias.findByIdCompania", query = "SELECT c FROM Companias c WHERE c.idCompania = :idCompania"),
    @NamedQuery(name = "Companias.findByNombre", query = "SELECT c FROM Companias c WHERE c.nombre = :nombre")})
public class Companias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompania", nullable = false)
    private Integer idCompania;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 250)
    private String nombre;

    public Companias() {
    }

    public Companias(Integer idCompania) {
        this.idCompania = idCompania;
    }

    public Companias(Integer idCompania, String nombre) {
        this.idCompania = idCompania;
        this.nombre = nombre;
    }

    public Integer getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Integer idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompania != null ? idCompania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companias)) {
            return false;
        }
        Companias other = (Companias) object;
        if ((this.idCompania == null && other.idCompania != null) || (this.idCompania != null && !this.idCompania.equals(other.idCompania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Companias[ idCompania=" + idCompania + " ]";
    }
    
}
