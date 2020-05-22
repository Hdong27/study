package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_베스트앨범 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {
				"classic", "pop", "classic", "classic", "pop"
		}, new int[] {
				500, 600, 150, 800, 2500
		})));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		Music[] musics = new Music[genres.length];
		Map<String, Genre> hm = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			musics[i] = new Music(i, genres[i], plays[i]);
			
			if(hm.containsKey(genres[i])) {
				hm.get(genres[i]).count += plays[i];
				hm.get(genres[i]).musics.add(musics[i]);
				
				// 곡이 두 개를 초과하면 하나를 삭제한다.
				if(hm.get(genres[i]).musics.size() > 1) {
					Collections.sort(hm.get(genres[i]).musics, new Comparator<Music>() {

						@Override
						public int compare(Music o1, Music o2) {
							return o2.count - o1.count;
						}
					});
					
					if(hm.get(genres[i]).musics.size() > 2) {
						hm.get(genres[i]).musics.remove(2);
					}
				}
			} else {
				List<Music> temp = new ArrayList<>();
				temp.add(musics[i]);
				hm.put(genres[i], new Genre(plays[i], temp));
			}
		}
		
		int size = 0;
		List<Genre> list = new ArrayList<>();
		for(String key : hm.keySet()) {
			list.add(hm.get(key));
			size += hm.get(key).musics.size();
		}
		
		Collections.sort(list, new Comparator<Genre>() {

			@Override
			public int compare(Genre o1, Genre o2) {
				return o2.count - o1.count;
			}
		});
		
		int[] answer = new int[size];
		int index = 0;
		
		for (Genre g : list) {
			for (Music m : g.musics) {
				answer[index++] = m.index;
			}
		}
		
		return answer;
	}
	
	static class Genre {
		int count;	// 재생횟수
		List<Music> musics;
		
		public Genre(int count, List<Music> musics) {
			this.count = count;
			this.musics = musics;
		}
	}
	
	static class Music{
		int index;
		String genre;	// 장르
		int count;	// 재생횟수
		
		public Music(int index, String genre, int count) {
			this.index = index;
			this.genre = genre;
			this.count = count;
		}
	}
}
