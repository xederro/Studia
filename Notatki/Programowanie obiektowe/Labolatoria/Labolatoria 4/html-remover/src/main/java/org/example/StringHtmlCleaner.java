package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StringHtmlCleaner {
    public StringHtmlCleaner(){}

    public static String clean(String text) {
        Document document = Jsoup.parse(text);
        return document.text();
    }
}
