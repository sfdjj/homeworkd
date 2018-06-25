package com.qunar.fresh2017.service.impl;

import com.qunar.fresh2017.dao.ContentDao;
import com.qunar.fresh2017.model.ContentModel;
import com.qunar.fresh2017.service.CounterService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class CounterServiceImpl implements CounterService {

    @Resource
    private ContentDao contentDao;

    public void save(String articleUrl) {
        Document document = getDocument(articleUrl);
        Map<String,String> map1 = getArticle(document);
        String articleContent = map1.get("articleContent");
        Map<String,Integer> map2 = getNumber(articleContent);
        ContentModel contentModel = new ContentModel();
        contentModel.setTitle(map1.get("articleTitle"));
        contentModel.setNumber(map2.get("number"));
        contentModel.setChNumber(map2.get("cnNumber"));
        contentModel.setEnNumber(map2.get("enNumber"));
        contentModel.setPuncNumber(map2.get("puncNumber"));
        contentDao.insert(contentModel);
    }

    public void save(String title, Integer number, Integer cnNumber, Integer enNumber, Integer puncNumber) {
        ContentModel contentModel = new ContentModel();
        contentModel.setTitle(title);
        contentModel.setNumber(number);
        contentModel.setChNumber(cnNumber);
        contentModel.setEnNumber(enNumber);
        contentModel.setPuncNumber(puncNumber);
        contentDao.insert(contentModel);
    }

    public List<ContentModel> getData() {
        List<ContentModel> list = contentDao.query();
        return list;
    }

    /**
     * 根据偏移量获取结果集
     * @param offset
     * @return
     */
    public List<ContentModel> getData(int offset) {
        List<ContentModel> list = contentDao.queryByOffset(offset);
        return list;
    }

    /**
     * 获取文章所在网页 将其转化为document
     * @param articleUrl    文章url
     * @return
     */
    private Document getDocument(String articleUrl) {
        Document document = null;
        try{
            URL url = new URL(articleUrl);
            InputStream inputStream = url.openStream();
            //BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //int len = 0;
            //byte[] bytes = new byte[256];
            String str = null;
            StringBuffer html = new StringBuffer();
            while((str=bufferedReader.readLine())!=null) {
                html.append(str);
                html.append("\n");
            }
            //bufferedInputStream.close();
            inputStream.close();
           // String s = URLDecoder.decode(html.toString(),"gb2312");
           // System.out.println(s);
            document = Jsoup.parse(html.toString());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return document;
    }

    /**
     * 获取文章内容与文章标题
     * @param document
     * @return
     */
    public Map<String,String> getArticle(Document document) {
        Map<String,String> map = new HashMap<String, String>();
        StringBuffer sb = new StringBuffer();
        Elements elements = document.getElementsByAttributeValue("class","title-article");
        for(Element element:elements) {
            map.put("articleTitle",element.html());
        }
        elements = document.getElementsByTag("article");
        Stack<Element> stack = new Stack<Element>();
        Elements aaa = elements.get(0).getAllElements();
        for(int i=elements.size()-1;i>=0;i--) {
            stack.push(elements.get(i));
        }
        Element element = null;
        while(stack!=null&&!stack.isEmpty()) {
            element = stack.pop();
            if(element.tagName().equals("p")
                    || Pattern.matches("h[0-6]{1}",element.tagName())){
                if(element.text()!=null&&!element.text().equals("")) {
                    sb.append(element.text());
                    sb.append("\n");
                }
            }
            Elements es = element.children();
            for(int i=es.size()-1;i>=0;i--) {
                stack.push(es.get(i));
            }

        }
        map.put("articleContent",sb.toString());
        return map;
    }
    /**
     *  对文章各个字符进行统计，返回统计结果
     * @param str 文章内容
     * @return
     */
    private Map<String,Integer> getNumber(String str) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        int number = 0;
        int cnNumber = 0;
        int enNumber = 0;
        int puncNumber = 0;
        if(str!=null) {
            for(int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                String regex = "[`~!@#$^&*()=|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]{1}";
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
                    enNumber++;
                }
                if(Pattern.matches(regex,c+"")) {
                    puncNumber++;
                }
                if(c>=0x4E00&&c<=0x9FA5) {
                    cnNumber++;
                }
            }
        }
        number = cnNumber+enNumber+puncNumber;
        map.put("number",number);
        map.put("cnNumber",cnNumber);
        map.put("enNumber",enNumber);
        map.put("puncNumber",puncNumber);
        return map;
    }

    public int getCount() {
        return contentDao.queryCount();
    }
}
