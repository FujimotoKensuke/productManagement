package com.web.controller;

import com.domain.model.ItemModel;
import com.domain.service.ItemCreateAndUpdateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 商品管理アプリコントローラ
 *
 * @author kk
 */
@Controller
public class ProductManagerController {

    @Autowired
    private ItemCreateAndUpdateService itemCreateAndUpdateService;

    /**
     * 初期画面表示API
     */
    @RequestMapping(value = {"", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {

        List<ItemModel> itemModelList;
        itemModelList = itemCreateAndUpdateService.findAll();

        model.addAttribute("itemList", itemModelList);

        return "index"; // 使用するテンプレートの名前を指定する
    }

}
