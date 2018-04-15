package com.infra.mapper;

import com.infra.entity.ItemListEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author kk
 */
@Mapper
public interface ItemListMapper {

    void insert(ItemListEntity entity);

    void update(ItemListEntity entity);

    List<ItemListEntity> selectAll();
}
