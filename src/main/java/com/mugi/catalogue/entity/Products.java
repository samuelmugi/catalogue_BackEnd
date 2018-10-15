/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author @SaQlever
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByProdId", query = "SELECT p FROM Products p WHERE p.prodId = :prodId")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_id")
    private Integer prodId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prod_name")
    private String prodName;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Category catId;

    public Products() {
    }

    public Products(Integer prodId) {
        this.prodId = prodId;
    }

    public Products(Integer prodId, String prodName) {
        this.prodId = prodId;
        this.prodName = prodName;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mugi.catalogue.entity.Products[ prodId=" + prodId + " ]";
    }
    
}
