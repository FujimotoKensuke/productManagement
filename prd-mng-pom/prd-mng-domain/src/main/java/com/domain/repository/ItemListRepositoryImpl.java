/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.repository;

import com.common.misc.ItemEnum;
import com.domain.factory.ItemListEntityFactory;
import com.domain.model.ItemModel;
import com.domain.model.ItemModelFactory;
import com.infra.entity.ItemListEntity;
import com.infra.mapper.ItemListMapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kk
 */
@Repository
public class ItemListRepositoryImpl implements ItemListRepository {

    @Autowired
    private ItemListMapper itemListMapper;

    /**
     * 商品情報登録
     *
     * @param model
     */
    @Override
    public void insertItem(ItemModel model) {
        ItemListEntity entity = ItemListEntityFactory.create(model);
        entity.setDeletedFlg(ItemEnum.DeletedFlg.OFF.getId());
        entity.setVersion(0L);

        itemListMapper.insert(entity);

    }

    /**
     * 商品情報登録
     *
     * @param model
     */
    @Override
    public void updateItem(ItemModel model) {
        ItemListEntity entity = ItemListEntityFactory.create(model);
        entity.setDeletedFlg(ItemEnum.DeletedFlg.OFF.getId());
        entity.setVersion(0L);

        itemListMapper.update(entity);

    }

    /**
     * 全商品情報を検索
     *
     * @return
     */
    @Override
    public List<ItemModel> findAll() {

        List<ItemListEntity> itemList = itemListMapper.selectAll();

        List<ItemModel> itemModelList = new ArrayList<>();
        for (ItemListEntity item : itemList) {

            ItemModel itemModelFactory = ItemModelFactory.create(item);
            itemModelList.add(itemModelFactory);
        }
        return itemModelList;
    }

    /**
     * 商品IDから商品情報を検索
     *
     * @return
     */
    @Override
    public boolean findByItemIdExist(ItemModel model) {

        // 登録済みの@NamedQueryからSQLを取得し実行
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("item");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createNamedQuery("itemlist.findByItemId");

        try {
            query.setParameter("itemId", model.getItemId());
            ItemListEntity itemList = (ItemListEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return false;
        }

        return true;
    }
}
