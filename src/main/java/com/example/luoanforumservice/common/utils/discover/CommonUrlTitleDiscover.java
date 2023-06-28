package com.example.luoanforumservice.common.utils.discover;

import org.jsoup.nodes.Document;

/**
 * Description: 通用的标题解析类
 * Author: luoan
 * Date: 2023-06-27
 */
public class CommonUrlTitleDiscover extends AbstractUrlTitleDiscover {
    @Override
    public String getDocTitle(Document document) {
        return document.title();
    }
}
