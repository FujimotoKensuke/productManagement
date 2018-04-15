/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.factory;

import com.domain.model.ItemModel;
import com.infra.entity.ItemListEntity;
import org.springframework.lang.NonNull;

/**
 *
 * @author kk
 */
public class ItemListEntityFactory {

    @NonNull
    public static ItemListEntity create(@NonNull final ItemModel model) {
        ItemListEntity entity = new ItemListEntity();
        entity.setItemId(model.getItemId());
        entity.setItemName(model.getItemName());
        entity.setItemPrice(model.getItemPrice());
        return entity;
    }
}
