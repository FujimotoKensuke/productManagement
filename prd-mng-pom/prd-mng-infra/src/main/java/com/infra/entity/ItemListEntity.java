/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infra.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "itemlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "itemlist.findAll", query = "SELECT u FROM ItemListEntity u")
    , @NamedQuery(name = "itemlist.findByItemId", query = "SELECT u FROM ItemListEntity u WHERE u.itemId = :itemId")
    , @NamedQuery(name = "itemlist.findByItemName", query = "SELECT u FROM ItemListEntity u WHERE u.itemName = :itemName")
    , @NamedQuery(name = "itemlist.findByItemPrice", query = "SELECT u FROM ItemListEntity u WHERE u.itemPrice = :itemPrice")
    , @NamedQuery(name = "itemlist.findByDeletedFlg", query = "SELECT u FROM ItemListEntity u WHERE u.deletedFlg = :deletedFlg")
    , @NamedQuery(name = "itemlist.findByVersion", query = "SELECT u FROM ItemListEntity u WHERE u.version = :version")
})
public class ItemListEntity implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "itemid")
    private String itemId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "itemname")
    private String itemName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itemprice")
    private int itemPrice;

    @Basic(optional = false)
    @NotNull
    @Column(name = "deletedFlg")
    private int deletedFlg;

    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;

    public ItemListEntity() {
    }

    public ItemListEntity(String itemId) {
        this.itemId = itemId;
    }

    public ItemListEntity(String itemId, String itemName, int itemPrice, int deletedFlg, long version) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.deletedFlg = deletedFlg;
        this.version = version;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemPrice
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return the deletedFlg
     */
    public int getDeletedFlg() {
        return deletedFlg;
    }

    /**
     * @param deletedFlg the deletedFlg to set
     */
    public void setDeletedFlg(int deletedFlg) {
        this.deletedFlg = deletedFlg;
    }

    /**
     * @return the version
     */
    public long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemListEntity)) {
            return false;
        }
        ItemListEntity other = (ItemListEntity) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemList[ itemId=" + itemId + " ]";
    }
}
