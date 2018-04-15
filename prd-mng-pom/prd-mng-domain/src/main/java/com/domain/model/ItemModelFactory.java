package com.domain.model;

import com.common.misc.ItemEnum;
import com.domain.form.ItemCreateForm;
import com.infra.entity.ItemListEntity;
import org.springframework.lang.NonNull;

/**
 * 商品情報モデルファクトリー
 *
 * @author kk
 */
public class ItemModelFactory {

    @NonNull
    public static ItemModel create(@NonNull final ItemCreateForm form) {
        return new ItemModel(
                form.getItemId(),
                form.getItemName(),
                form.getItemPrice(),
                null,
                null
        );
    }

    @NonNull
    public static ItemModel create(@NonNull final ItemListEntity itemList) {
        return new ItemModel(
                itemList.getItemId(),
                itemList.getItemName(),
                itemList.getItemPrice(),
                itemList.getDeletedFlg() == 0 ? ItemEnum.DeletedFlg.OFF : ItemEnum.DeletedFlg.ON,
                itemList.getVersion()
        );
    }
}
