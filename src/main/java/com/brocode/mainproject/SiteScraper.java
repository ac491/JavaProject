/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brocode.mainproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
import org.jsoup.*;

import org.jsoup.nodes.Document;



import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;



public class SiteScraper
       

{
     public static ArrayList<News> newlist = new ArrayList<News>();

    //fetches content from a given url

    public void siteScrape(URL url) throws IOException

    {

        String compare = url.getHost();



        //gets url from url, opens a connection to the site and parses the content

        Document doc = Jsoup.connect(url.toExternalForm()).get();



        //checking domains and fetching content using appropriate tags

        if(compare.matches("(.*)life(.*)") || compare.matches("(.*)kotaku(.*)")  || compare.matches("(.*)io9(.*)"))

        {

            String title,author,timestamp,tags,content;

            try

            {

                title = doc.title();

                author = doc.select(".meta__byline").first().text();

                timestamp = doc.select(".meta__time").first().text();

                tags = doc.select(".post-tags-container").first().text();

                content = doc.select(".post-content").first().text();

            } catch (NullPointerException ne)

            {

                return;

            }

            //News news = new News(timestamp,title,author,content,tags,url.toExternalForm());
            //newlist.add(news);

            System.out.println(title);

            System.out.println(author);

            System.out.println(timestamp);

            System.out.println(tags);

            System.out.println(content);

            //System.out.println(doc.body().text());



        }



        else if(compare.matches("(.*)anandtech(.*)"))

        {

            String title,author,timestamp,tags,content;

            try

            {

                title = doc.title();

                author = doc.select("a[class=b]").text();

                timestamp = doc.selectFirst("em").text();

                tags = doc.select(".hide_resp2 li a[href]").text();

                content = doc.select(".articleContent").text();

            } catch (NullPointerException ne)

            {

                return;

            }



            //News news = new News(timestamp,title,author,content,tags,url.toExternalForm());
            //newlist.add(news);  
            System.out.println(title);

            System.out.println(author);

            System.out.println(timestamp);

            System.out.println(tags);

            System.out.println(content);

        }



        else if(compare.matches("(.*)businessline(.*)"))

        {

            String title,author,timestamp,tags,content;

            try

            {

                title = doc.title();

                author = doc.select(".author").text();

                timestamp = doc.selectFirst(".photo-caption:contains(published on)").text();

                tags = doc.select(".related-tags a[href]").text();

                content = doc.select(".article-text p[class]").text();

            } catch (NullPointerException ne)

            {

                return;

            }

            //News news = new News(timestamp,title,author,content,tags,url.toExternalForm());
            //newlist.add(news);


            /*System.out.println(title);

            System.out.println(author);

            System.out.println(timestamp);

            timestamp = timestamp.replaceAll("[;,]","");

            String timestampArray[] = timestamp.split("(.*)published on");

            timestamp = timestampArray[1].trim().replaceAll("[)]","");

            System.out.println(timestamp);

            timestampArray = timestamp.split("\\s");



            String month = timestampArray[0];

            String date = timestampArray[1];

            String year = timestampArray[2];



            int monthInt = 0;

            //getting an int month from a given string using regex

                        {

                if (month.matches("(?i)jan(.*)"))

                    monthInt = 1;

                else if (month.matches("(?i)jfeb(.*)"))

                    monthInt = 2;

                else if (month.matches("(?i)mar(.*)"))

                    monthInt = 3;

                else if (month.matches("(?i)apr(.*)"))

                    monthInt = 4;

                else if (month.matches("(?i)may(.*)"))

                    monthInt = 5;

                else if (month.matches("(?i)jun(.*)"))

                    monthInt = 6;

                else if (month.matches("(?i)jul(.*)"))

                    monthInt = 7;

                else if (month.matches("(?i)aug(.*)"))

                    monthInt = 8;

                else if (month.matches("(?i)sep(.*)"))

                    monthInt = 9;

                else if (month.matches("(?i)oct(.*)"))

                    monthInt = 10;

                else if (month.matches("(?i)nov(.*)"))

                    monthInt = 11;

                else if (month.matches("(?i)dec(.*)"))

                    monthInt = 12;

            }



            int dateInt = Integer.parseInt(date);

            int yearInt = Integer.parseInt(year);

            System.out.println(monthInt);

            System.out.println(dateInt);

            System.out.println(yearInt);



            System.out.println(tags);

            //System.out.println(content);*/

        }



        else if(compare.matches("(.*)timesofindia(.*)"))

        {

            String title,author,timestamp,tags,content;

            try

            {

                title = doc.title();

                author = doc.select("span[itemprop=author]").text();

                timestamp = doc.selectFirst(".time_cptn span:contains(IST)").text();

                content = doc.select(".normal").text();

            } catch (NullPointerException ne)

            {

                return;

            }



            //News news = new News(timestamp,title,author,content,url.toExternalForm());
           // newlist.add(news);


            System.out.println(title);

            System.out.println(author);

            System.out.println(timestamp);

            System.out.println(content);



            /*String timestampArray[] = timestamp.replaceAll("[,;:]"," ").split("\\s");

            String month = timestampArray[0];

            String date = timestampArray[1];

            String year = timestampArray[3];

            String hour = timestampArray[5];

            String minutes = timestampArray[6];





            for(String word:timestampArray)

                System.out.println(word);

            int monthInt = 0;

            {

                if(month.matches("(?i)jan(.*)"))

                    monthInt = 1;

                else if(month.matches("(?i)jfeb(.*)"))

                    monthInt = 2;

                else if(month.matches("(?i)mar(.*)"))

                    monthInt = 3;

                else if(month.matches("(?i)apr(.*)"))

                    monthInt = 4;

                else if(month.matches("(?i)may(.*)"))

                    monthInt = 5;

                else if(month.matches("(?i)jun(.*)"))

                    monthInt = 6;

                else if(month.matches("(?i)jul(.*)"))

                    monthInt = 7;

                else if(month.matches("(?i)aug(.*)"))

                    monthInt = 8;

                else if(month.matches("(?i)sep(.*)"))

                    monthInt = 9;

                else if(month.matches("(?i)oct(.*)"))

                    monthInt = 10;

                else if(month.matches("(?i)nov(.*)"))

                    monthInt = 11;

                else if(month.matches("(?i)dec(.*)"))

                    monthInt = 12;

            }



            int dateInt = Integer.parseInt(date);

            int yearInt = Integer.parseInt(year);

            int hourInt = Integer.parseInt(hour);

            int minutesInt = Integer.parseInt(minutes);

            System.out.println(monthInt);

            System.out.println(dateInt);

            System.out.println(yearInt);

            System.out.println(hourInt);

            System.out.println(minutesInt);*/

        }



        else if(compare.matches("(.*)espn(.*)"))

        {

            String title,author,timestamp,tags,content;

            try

            {

                title = doc.title();

                author = doc.selectFirst(".author").text();

                timestamp = doc.selectFirst(".time").text();

                tags = "sports";

                content = doc.select(".article-body p").text();



            } catch (NullPointerException ne)

            {

                return;

            }



            //News news = new News(timestamp,title,author,content,tags,url.toExternalForm());
            //newlist.add(news);
            System.out.println(title);

            System.out.println(author);

            System.out.println(timestamp);

            System.out.println(tags);

            System.out.println(content);

        }

    }

}