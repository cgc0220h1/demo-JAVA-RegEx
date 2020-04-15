package com.crawler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsTitleCrawler {
    public static void main(String[] args) {
        final String NEWS_REGEX = "htm\">(.*?[^&quot;])</a>\\s*</h";
        final String NEWS_REGEX_QUOT_CODE = "htm\">(.*?)&quot;(.*?)&quot;(.*?)</a>\\s+</h";
        final String SUB_NEWS_REGEX = "<b>(.*?)</b>\\s+</a>";
        final String HEADLINE_REGEX = "<li><a title=\"(.*?)\".*\">[^<]";
        final String NEWS_STREAM_REGEX = "<li>\\s+<a title=.*\">(.*?)</a>";

        Scanner scanner;
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            Pattern pattern = Pattern.compile(HEADLINE_REGEX);
            Matcher matcher = pattern.matcher(content);
            System.out.println("Danh sách tin tiêu điểm: \n");
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

            System.out.println("-------------------------------");
            pattern = Pattern.compile(NEWS_STREAM_REGEX);
            matcher = pattern.matcher(content);
            System.out.println("Dòng thời sự: \n");
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

            System.out.println("-------------------------------");
            pattern = Pattern.compile(NEWS_REGEX);
            matcher = pattern.matcher(content);
            System.out.println("Danh sách tin hôm nay: \n");
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

            pattern = Pattern.compile(NEWS_REGEX_QUOT_CODE);
            matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1)
                        + matcher.group(2)
                        + matcher.group(3));
            }

            System.out.println("-------------------------------");
            pattern = Pattern.compile(SUB_NEWS_REGEX);
            matcher = pattern.matcher(content);
            System.out.println("Danh sách tin tức hôm trước: \n");
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
