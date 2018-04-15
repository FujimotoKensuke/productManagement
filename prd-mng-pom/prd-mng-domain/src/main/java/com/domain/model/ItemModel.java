/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.model;

import com.common.misc.ItemEnum;
import java.io.Serializable;

/**
 * 商品情報モデル
 *
 * @author kk
 */
public class ItemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    private final String itemId;

    /**
     * 商品名
     */
    private final String itemName;

    /**
     * 商品の価格
     */
    private final int itemPrice;

    /**
     * 削除フラグ
     */
    private final ItemEnum.DeletedFlg deletedFlg;

    /**
     * バージョン
     */
    private final Long version;

    public ItemModel(
            String userId,
            String userName,
            int itemPrice,
            ItemEnum.DeletedFlg deletedFlg,
            Long version) {
        this.itemId = userId;
        this.itemName = userName;
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
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the itemPrice
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * @return the deletedFlg
     */
    public ItemEnum.DeletedFlg getDeletedFlg() {
        return deletedFlg;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

}
