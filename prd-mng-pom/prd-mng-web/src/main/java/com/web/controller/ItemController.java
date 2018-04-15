package com.web.controller;

import com.domain.form.ItemCreateForm;
import com.domain.model.ItemModelFactory;
import com.domain.service.ItemCreateAndUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品情報関連コントローラ
 *
 * @author kk
 */
@Controller
public class ItemController {

    @Autowired
    private ItemCreateAndUpdateService itemCreateAndUpdateService;

    /**
     * 商品登録及び更新画面表示(初期表示)登録API
     */
    @RequestMapping(value = "/createAndUpdate", params = "init", method = RequestMethod.POST)
    public String createAndUpdateInit(@ModelAttribute ItemCreateForm form, Model model) {

        return "createAndUpdate"; // 使用するテンプレートの名前を指定する
    }

    /**
     * 商品登録及び更新画面表示(初期表示)更新API
     *
     * @param form
     */
    @RequestMapping(value = "/createAndUpdate", method = RequestMethod.GET)
    public String updateInit(@ModelAttribute ItemCreateForm form, Model model,
            @RequestParam("itemid") String itemid, @RequestParam("itemname") String itemname, @RequestParam("itemprice") int itemprice) {

        form.setItemId(itemid);
        form.setItemName(itemname);
        form.setItemPrice(itemprice);

        return "createAndUpdate"; // 使用するテンプレートの名前を指定する
    }

    /**
     * 商品情報登録(登録実行)API
     *
     * @return
     */
    @RequestMapping(value = "/createAndUpdate", params = "enter", method = RequestMethod.POST)
    public String userCreateDone(@Validated @ModelAttribute ItemCreateForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", "商品ID、商品名、価格(円)を正しく入力して下さい。");
            return createAndUpdateInit(form, model);
        }
        if (itemCreateAndUpdateService.findByItemIdExist(ItemModelFactory.create(form))) {
            itemCreateAndUpdateService.update(ItemModelFactory.create(form));
        } else {
            itemCreateAndUpdateService.create(ItemModelFactory.create(form));
        }

        model.addAttribute("message", "登録しました");   // パラメタを渡す
        return "createAndUpdate"; // 使用するテンプレートの名前を指定する
    }
}
