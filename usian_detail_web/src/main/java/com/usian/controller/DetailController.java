package com.usian.controller;

import com.usian.api.ItemFeign;
import com.usian.pojo.Item;
import com.usian.pojo.ItemDesc;
import com.usian.pojo.ItemParam;
import com.usian.pojo.ItemParamItem;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontend/detail")
public class DetailController {
    @Autowired
    private ItemFeign itemFeign;

    //查询基本商品的基本详情信息
    @RequestMapping("selectItemInfo")
    public Result selectItemInfo(@RequestParam(name = "itemId") Long itemId){
        Item item = itemFeign.selectItemInfo(itemId);
        return Result.ok(item);
    }

    //商品介绍接口
    @RequestMapping("selectItemDescByItemId")
    public Result selectItemDescByItemId(@RequestParam(name = "itemId") Long itemId){
        ItemDesc itemDesc = itemFeign.selectItemDescByItemId(itemId);
        return Result.ok(itemDesc);
    }

    //规格参数接口
    @RequestMapping("selectTbItemParamItemByItemId")
    public Result selectTbItemParamItemByItemId(@RequestParam(name = "itemId") Long itemId){
        ItemParamItem itemParamItem = itemFeign.selectTbItemParamItemByItemId(itemId);
        return Result.ok(itemParamItem);
    }
}
