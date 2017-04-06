package com.leisucn.xa.newsc2c.parser.bbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SL on 2017/4/6.
 */
public class Index {

    private final Logger logger = LogManager.getFormatterLogger(getClass());


    private String target = "http://www.bbc.com/";


    public Map<String, List<Map<String, String>>> parse() throws IOException{


        Document doc = Jsoup.connect(this.target).get();

        Element body = doc.body();

        final Map<String, List<Map<String, String>>> content = new HashMap();

        /*
         *  <section class="module>
         *      <h2 class="module__title"></h2>
         *      <div class="module__content">
         *          <ul class="media-list">
         *              <li class="media-list__item">
         *                  <div class="media">
         *                      <div class="media__image"><img /></div>
         *                      <div class="media__content">
         *                          <h3 class="media__title"></h3>
         *                          <p class="media__summary"></p>
         *                          <a class="media__tag"></a>
         *                      </div>
         *                      <a class="block-link__overlay-link"></a>
         *                   </div>
         *               </li>
         *          </ul>
         *       </div>
         *   </section>
         */
        Elements blockElements = body.getElementsByClass("module");

        blockElements.forEach( blockElement -> {

            Element blockTitleEle =
                    getElementByClz(blockElement, "module__title");

            if( blockTitleEle == null ){
                logger.warn("no module__title element", blockElement);
            } else{
                String blockTitle = blockTitleEle.text();

                final List<Map<String, String>> blockItems =
                        new ArrayList();

                Elements itemEles = blockElement.getElementsByClass("media");
                itemEles.forEach( itemEle -> {
                    String title = getTextByClz(itemEle, "media__title");
                    String summary = getTextByClz(itemEle, "media__summary");

                    Map<String, String> blockItem = new HashMap();
                    blockItem.put("title", title);
                    blockItem.put("summary", summary);

                    blockItems.add(blockItem);
                });

                content.put(blockTitle, blockItems);
            }

        });
        return content;
    }

    private String getTextByClz(Element element, String clz){
        Element clzElement = getElementByClz(element, clz);
        return  clzElement == null ? null : clzElement.text();
    }

    private Element getElementByClz(Element element, String clz){
        Elements elements = element.getElementsByClass(clz);
        if( elements.size() > 0 ) return elements.get(0);
        return null;
    }


}
