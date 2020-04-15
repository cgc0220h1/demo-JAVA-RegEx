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
        String regexTitleOnly = "'title']\\);\"\\s>(..*?)</a>";
        String regexTitleAndArtist = "title=\"([^Nghe bài hát]..*?)\"\\sonclick=\"lt\\(\\['genre','list-song'";
        Scanner scanner;
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            Pattern pattern = Pattern.compile(regexTitleOnly);
            Matcher matcher = pattern.matcher(content);
            System.out.println("Danh sách bài hát: \n");
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

            pattern = Pattern.compile(regexTitleAndArtist);
            matcher = pattern.matcher(content);
            System.out.println("--------------------------------------------");
            System.out.println("Danh sách tên bài hát và ca sĩ: \n");
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
