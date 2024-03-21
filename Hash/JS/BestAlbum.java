package Hash.JS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * BestAlbum
 */
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashSet hsGenres = new HashSet<String>(Arrays.asList(genres));
        Iterator<String> it = hsGenres.iterator();
        HashSet save = new HashSet<>();
        HashMap mapGenre = new HashMap<String, HashSet<Integer>>();
        while(it.hasNext()) {
            mapGenre.put(it.next(), new HashSet<>());
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(it)) {
                    // 동일한 장르 재생 횟수 저장
                    mapGenre.put(it, ((HashSet) mapGenre.get(it)).add(plays[i]));
                }
            }
        }
        while(it.hasNext()) {
            
        }
        for(String genre : hsGenres)


        for(int i = 0; i < hsGenres.size(); i++) {
            hsGenres.contains(hsGenres);
        }
        int[] answer = {};
        return answer;
    }
}