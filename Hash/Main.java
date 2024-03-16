package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Solution solution = new Solution();

        // 1. 폰켓몬
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution.solution1(nums));

        // 2. 전화번호 목록
//        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123","456","789"};
        System.out.println(solution.solution2(phone_book));

        // 3. 베스트 앨범
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution.solution3(genres, plays)));

    }


}

class Solution {
    public int solution1(int[] nums) {
        // +3
        int answer = 0;
        int max = nums.length/2;
        HashSet<Integer> type = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            type.add(nums[i]);
        }
        if (type.size() >= max){
            answer = max;
        }else{
            answer = type.size();
        }
        return answer;
    }

    public boolean solution2(String[] phone_book) {
        // +11
        boolean answer = true;

//        HashSet<String> set = new HashSet<>();
//        for (String number : phone_book) {
//            set.add(number);
//        }
        //추가
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }


        return answer;
    }


    static class Music{
        String genre;
        int play;
        int i;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.i = idx;
        }
    }
    public int[] solution3(String[] genres, int[] plays) {
        // +13
        ArrayList<Integer> answerArray = new ArrayList<>();

        // 장르 정렬
        HashMap<String,Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i],0)+plays[i]);
        }

        ArrayList<String> sortGenres = new ArrayList<>(genreMap.keySet());
        sortGenres.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        // 장르별 노래 정렬
        for (String genre : sortGenres) {
            ArrayList<Music> musicList = new ArrayList<>();

            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)){
                    musicList.add(new Music(genre,plays[i],i));
                }
            }
            musicList.sort((o1, o2) -> o2.play - o1.play);

            for (int i = 0; i < Math.min(musicList.size(), 2); i++) {
                answerArray.add(musicList.get(i).i);
            }
        }
        return answerArray.stream().mapToInt(Integer::intValue).toArray();
    }
}