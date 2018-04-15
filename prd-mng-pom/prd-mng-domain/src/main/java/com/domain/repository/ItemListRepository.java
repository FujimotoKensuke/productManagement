/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.repository;

import com.domain.model.ItemModel;
import java.util.List;

/**
 * 商品情報リポジトリ
 *
 * @author kk
 */
public interface ItemListRepository {

    void insertItem(ItemModel model);

    void updateItem(ItemModel model);

    public List<ItemModel> findAll();

    public boolean findByItemIdExist(ItemModel model);

}
