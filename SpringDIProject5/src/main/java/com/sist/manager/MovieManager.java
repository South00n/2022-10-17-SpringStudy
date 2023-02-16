package com.sist.manager;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.mongodb.util.JSON;
import com.sist.vo.MovieVO;
// https://www.kobis.or.kr/kobis/business/main/main.do
/*
 *   일일 박스오피스
 *   실시간 예매율
 * 	 좌석점유율순위
 *   온라인상영관 일일
 */
@Component("mm")
public class MovieManager {
	/*
	public static void main(String[] args) {
		MovieManager m = new MovieManager();
		List<MovieVO> list = m.movieListData(1);
		for(MovieVO vo : list) {
			System.out.println(vo.getRank() + "." + vo.getTitle() + " " + vo.getGenre());
		}
	}*/
	
	private String[] strUrl = {"","searchMainDailyBoxOffice.do","searchMainRealTicket.do",
			"searchMainDailySeatTicket.do","searchMainOnlineDailyBoxOffice.do"};
	public List<MovieVO> movieListData(int no) {
		List<MovieVO> list = new ArrayList<MovieVO>();
		/*
		try {
			URL url = new URL("https://www.kobis.or.kr/kobis/business/main/" + strUrl[no]);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			if(conn != null) { // 연결이 되었다면
				BufferedReader br =
						new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true) {
					String data = br.readLine();
					if(data == null) break;
					System.out.println(data);
				}
			}
		} catch (Exception e) {}*/
		try {
			// []
			Document doc = Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/" + strUrl[no]).get();
			String data = doc.toString();
			data = data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);
			data = data.replace("<", "");
			data = data.replace(">", "");
			//System.out.println(data);
			JSONParser jp = new JSONParser();
			JSONArray arr = (JSONArray)jp.parse(data);
			/*
			 *      JSONArray ==> [] ==> ArrayList
			 *      JSONObject ==> {} ==> 객체
			 *      [{},{},{},{},{},{}...]
			 */
			//System.out.println(doc.toString());
			// ["a", "b", "c"] => String[{}, {}, {}] JSONObject
			for(int i = 0; i < arr.size(); i++) {
				JSONObject obj = (JSONObject)arr.get(i);
				MovieVO vo = new MovieVO();
				String rank = String.valueOf((long)obj.get("rank"));
				vo.setRank(Integer.parseInt(rank));
				vo.setTitle((String)obj.get("movieNm"));
				vo.setDirector((String)obj.get("director"));
				vo.setGenre((String)obj.get("genre"));
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
