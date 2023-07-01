package org.example;

public class Application {
    public static void main(String[] args) {
        System.out.println(
            StringHtmlCleaner.clean(
                PageDownloadingUtility.download(args[0])
            )
        );
    }
}