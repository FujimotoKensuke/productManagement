/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.service;

import com.domain.model.ItemModel;
import com.domain.repository.ItemListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品情報登録または更新サービスの実装クラス
 *
 * @author kk
 */
@Service
public class ItemCreateAndUpdateServiceImpl implements ItemCreateAndUpdateService {

    @Autowired
    private ItemListRepository itemListRepository;

    /**
     * 商品情報登録処理
     *
     * @param model
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(@NonNull ItemModel model) {
        // 商品情報登録
        itemListRepository.insertItem(model);
    }

    /**
     * 商品情報更新処理
     *
     * @param model
     */
    @Override
    public void update(@NonNull ItemModel model) {
        // 商品情報更新
        itemListRepository.updateItem(model);
    }

    /**
     * 全商品情報検索処理
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ItemModel> findAll() {
        // 商品情報検索
        return itemListRepository.findAll();
    }

    /**
     * 商品IDから商品情報検索処理
     *
     * @param model
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean findByItemIdExist(@NonNull ItemModel model) {
        // 商品IDから商品情報検索
        return itemListRepository.findByItemIdExist(model);
    }
}
