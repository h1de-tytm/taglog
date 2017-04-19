package com.taglog.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taglog.Shop;
import com.taglog.TagMapping;
import com.taglog.Taglog;
import com.taglog.data.ShopRepository;
import com.taglog.data.TaglogRepository;

@Controller
public class TaglogController {
	private TaglogRepository taglogRepository;
	private ShopRepository shopRepository;

	@RequestMapping(value="/taglog", method=RequestMethod.GET)
	public String returnHome() {
		System.out.println("/taglog called.");
		return "menu";
	}
	
	@Autowired
	public TaglogController(TaglogRepository taglogRepository, ShopRepository shopRepository) {
		this.taglogRepository = taglogRepository;
		this.shopRepository = shopRepository;
	}
	
	@RequestMapping(value="/tag/{tag}", method=RequestMethod.GET)
	public String showTaglogTag(@PathVariable String tag, Model model) {
		System.out.println("/tag/{tag}" + tag + "is called");
		List<Map<String, Object>> taglogMapList = taglogRepository.findByTag(tag);
		List<Taglog> taglogList = new ArrayList<Taglog>();
		
		for (Map<String, Object> taglogMap : taglogMapList) {
			
			Taglog taglog = new Taglog();
			taglog.setTaglogId((Long)taglogMap.get("taglogId"));
			taglog.setTag((String)taglogMap.get("tag"));
			taglog.setTweet((String)taglogMap.get("tweet"));
			taglog.setTweetId((Long)taglogMap.get("tweetId"));

			taglogList.add(taglog);
			
		}
				
		List<Taglog> nonDuplicatedTaglogList = getNonDuplicatedTaglogList(taglogList);				
		List<Taglog> nonDuplicatedTaglogListWithShopList = getTaglogListWithShopList(nonDuplicatedTaglogList);

		/*if we can't use Japanese character, use Mappng Class.
		  TagMapping tagMapping = new TagMapping();
		  String tagName = tagMapping.getTagName(tag);
		*/		 
		model.addAttribute("tagName", tag);
		model.addAttribute("taglogList", nonDuplicatedTaglogListWithShopList);
		
		
		return "tag";
	}
	
	@RequestMapping(value="/location/{location}", method=RequestMethod.GET)
	public String showTaglogLocation(@PathVariable String location, Model model) {
		System.out.println("/location/{" + location + "} is called");
		List<Map<String, Object>> shopMapList = shopRepository.findByLocation(location);
		
		List<Shop> shopList = new ArrayList<Shop>();
		for (Map<String, Object> shopMap : shopMapList) {
			Shop shop = new Shop();
			shop.setGenre((String)shopMap.get("genre"));
			shop.setLocation((String)shopMap.get("shop"));
			shop.setShopId((Long)shopMap.get("shopId"));
			shop.setShopName((String)shopMap.get("shopName"));
			shop.setTabelogUrl((String)shopMap.get("tabelogUrl"));
			shop.setTweetId((Long)shopMap.get("tweetId"));
			shopList.add(shop);
		}
		
		List<Taglog> taglogList = new ArrayList<Taglog>();
		for (Shop shop : shopList) {
			List<Map<String, Object>> taglogMapList = taglogRepository.findByTweetId(shop.getTweetId());
			for (Map<String, Object> taglogMap : taglogMapList) {
				Taglog taglog = new Taglog();
				taglog.setTaglogId((Long)taglogMap.get("taglogId"));
				taglog.setTag((String)taglogMap.get("tag"));
				taglog.setTweet((String)taglogMap.get("tweet"));
				taglog.setTweetId((Long)taglogMap.get("tweetId"));
				taglogList.add(taglog);
			}			
		}
		
		List<Taglog> nonDuplicatedTaglogList = getNonDuplicatedTaglogList(taglogList);		
		List<Taglog> nonDuplicatedTaglogListWithShopList = getTaglogListWithShopList(nonDuplicatedTaglogList);
		model.addAttribute("locationName", location);
		model.addAttribute("taglogList", nonDuplicatedTaglogListWithShopList);
		
		
		return "location";
	}

	@RequestMapping(value="/genre/{genre}", method=RequestMethod.GET)
	public String showTaglogGenre(@PathVariable String genre, Model model) {
		System.out.println("/genre/{" + genre + "} is called");
		List<Map<String, Object>> shopMapList = shopRepository.findByGenre(genre);
		
		List<Shop> shopList = new ArrayList<Shop>();
		for (Map<String, Object> shopMap : shopMapList) {
			Shop shop = new Shop();
			shop.setGenre((String)shopMap.get("genre"));
			shop.setLocation((String)shopMap.get("shop"));
			shop.setShopId((Long)shopMap.get("shopId"));
			shop.setShopName((String)shopMap.get("shopName"));
			shop.setTabelogUrl((String)shopMap.get("tabelogUrl"));
			shop.setTweetId((Long)shopMap.get("tweetId"));
			shopList.add(shop);
		}
		
		List<Taglog> taglogList = new ArrayList<Taglog>();
		for (Shop shop : shopList) {
			List<Map<String, Object>> taglogMapList = taglogRepository.findByTweetId(shop.getTweetId());
			for (Map<String, Object> taglogMap : taglogMapList) {
				Taglog taglog = new Taglog();
				taglog.setTaglogId((Long)taglogMap.get("taglogId"));
				taglog.setTag((String)taglogMap.get("tag"));
				taglog.setTweet((String)taglogMap.get("tweet"));
				taglog.setTweetId((Long)taglogMap.get("tweetId"));
				taglogList.add(taglog);
			}			
		}
		
		List<Taglog> nonDuplicatedTaglogList = getNonDuplicatedTaglogList(taglogList);		
		List<Taglog> nonDuplicatedTaglogListWithShopList = getTaglogListWithShopList(nonDuplicatedTaglogList);
		model.addAttribute("genreName", genre);
		model.addAttribute("taglogList", nonDuplicatedTaglogListWithShopList);
		
		
		return "genre";
	}
	
	private List<Taglog> getNonDuplicatedTaglogList(List<Taglog> taglogList) {
		List<Long> tweetIdList = new ArrayList<Long>();
		List<Taglog> nonDuplicatedTaglogList = new ArrayList<Taglog>();
		for (Taglog taglog : taglogList) {
			Long tweetId = taglog.getTweetId();
			boolean isDuplicated = false; // true: duplicate, false: not duplicate
			for (Long exeistedTweetId : tweetIdList) {
				if (tweetId.equals(exeistedTweetId)) {
					isDuplicated = true;
				}
			}
			if (!isDuplicated) {
				tweetIdList.add(tweetId);
				nonDuplicatedTaglogList.add(taglog);
			}
			
		}
		return nonDuplicatedTaglogList;
	}
	
	private List<Taglog> getTaglogListWithShopList(List<Taglog> taglogList) {
		for (Taglog taglog : taglogList) {
			Long tweetId = taglog.getTweetId();
			List<Map<String, Object>> shopMapList = shopRepository.findByTweetId(tweetId);
			List<Shop> shopList = new ArrayList<Shop>();
			for (Map<String, Object> shopMap : shopMapList) {
				Shop shop = new Shop();
				shop.setShopId((Long)shopMap.get("shopId"));
				shop.setTweetId((Long)shopMap.get("tweetId"));
				shop.setShopName((String)shopMap.get("shopName"));
				shop.setLocation((String)shopMap.get("location"));
				shop.setGenre((String)shopMap.get("genre"));
				shop.setTabelogUrl((String)shopMap.get("tabelogUrl"));
				shopList.add(shop);
			}
			taglog.setShopList(shopList);
		}
		return taglogList;
	}
	
}
