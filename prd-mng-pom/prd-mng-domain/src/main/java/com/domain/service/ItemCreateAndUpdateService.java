/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.service;

import com.domain.model.ItemModel;
import java.util.List;
import org.springframework.lang.NonNull;

/**
 * 商品情報登録または更新サービスのインタフェース
 *
 * @author kk
 */
public interface ItemCreateAndUpdateService {

    /**
     * 商品情報登録処理
     *
     * @param model
     */
    void create(@NonNull ItemModel model);

    /**
     * 商品情報更新処理
     *
     * @param model
     */
    void update(@NonNull ItemModel model);

    /**
     *
     * @return
     */
    public List<ItemModel> findAll();

    /**
     *
     * @param model
     * @return
     */
    public boolean findByItemIdExist(@NonNull ItemModel model);

}
