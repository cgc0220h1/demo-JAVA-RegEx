package com.crawler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongNameCrawler {
    public static void main(String[] args) {
        Scanner scanner;
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            Pattern pattern = Pattern.compile("title=\"([^Nghe bài hát]..*?)\"\\sonclick=\"lt\\(\\['genre','list-song'");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        } catch (MalformedURLException e) {
            System.out.println("Không kết nối được với trang Web");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
