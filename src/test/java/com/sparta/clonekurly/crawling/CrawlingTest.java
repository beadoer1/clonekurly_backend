package com.sparta.clonekurly.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class CrawlingTest {
    public ArrayList<Item> crawlingItems(){
        // 완료 후 List로 뽑아내려면 객체 필요
        // ArrayList<Item> itemList = new ArrayList<>();

        String targetSite = "https://www.kurly.com/shop/goods/goods_view.php?&goodsno=65548";

        try {
            Document doc = Jsoup.connect(targetSite).get();
            Elements tag = doc.select(".logo");
            System.out.println("==============================");
            System.out.println("url : " + targetSite);
            System.out.println();
            System.out.println(tag.toString());
//            System.out.println("=============================");
//            System.out.println("url : " + targetSite);
//            Document doc = Jsoup.connect(targetSite).get();
//
//            System.out.println(doc.toString());
        } catch (Exception e){}
        return null;
    }

    public static void main(String[] args) {
        CrawlingTest clt = new CrawlingTest();
        clt.crawlingItems();
    }
}

