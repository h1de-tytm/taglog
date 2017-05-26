package com.taglog.twitter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.taglog.test.Settings;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TwitterDataCollectorTest {
	private String consumerKey = Settings.consumerKey;
	private String consumerSecret = Settings.consumerSecret;
	private String accessToken = Settings.accessToken;
	private String accessTokenSecret = Settings.accessTokenSecret;

	
	@Test
	public void getFavAndRT() {
		String sepa = "\t";
		String fileName = "tweetId.txt";
		ClassLoader loader = TwitterDataCollectorTest.class.getClassLoader();
		URL filePath = loader.getResource("com/taglog/test/" + fileName);
		System.out.println(filePath.getPath());
		
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			fr = new FileReader(filePath.getPath());
			br = new BufferedReader(fr);
			
			String line;

			while ((line = br.readLine()) != null) {
				TwitterDataCollector dataCollector = new TwitterDataCollector(consumerKey, consumerSecret, accessToken, accessTokenSecret);
				long tweetId = Long.parseLong(line);
				int fav = dataCollector.getFavoriteCountByTweetId(tweetId);
				int rt = dataCollector.getRetweetCountByTweetId(tweetId);
				
				sb.append(Integer.toString(fav) + sepa + Integer.toString(rt) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(sb.toString());
		}
		
		System.out.println(sb.toString());
		
	}
	

}
