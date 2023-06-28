package com.example.luoanforumservice.common.utils.discover;

import org.jsoup.nodes.Document;

/**
 * Description: 针对微信公众号文章的标题获取类
 * Author: luoan
 * Date: 2023-06-27
 */
public class WxUrlTitleDiscover extends AbstractUrlTitleDiscover {
    @Override
    public String getDocTitle(Document document) {
        return document.getElementsByAttributeValue("property", "og:title").attr("content");
    }
}
