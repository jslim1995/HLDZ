import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class HashTest {

    @Test
    public void _1834(){

        int[] nums1 = {3, 1, 2, 3};
        int answer1 = 2;

        int[] nums2 = {3,3,3,2,2,4};
        int answer2 = 3;

        int[] nums3 = {3,3,3,2,2,2};
        int answer3 = 2;

        assertThat(_1834A(nums1)).isEqualTo(answer1);
        assertThat(_1834A(nums2)).isEqualTo(answer2);
        assertThat(_1834A(nums3)).isEqualTo(answer3);

    }

    public int _1834A(int[] nums){
        int answer = 1;
        int getMons = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int checkCount = getMons-set.size();

        if(checkCount<1){
            answer = getMons;
        }else {
            answer = set.size();
        }

        return answer;
    }

//    ----------------------------------------

    @Test
    public void _42577Test(){
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        boolean answer1 = false;
        String[] phone_book2 = {"123","456","789"};
        boolean answer2 = true;
        String[] phone_book3 = {"12","123","1235","567","88"};
        boolean answer3 = false;

//        assertThat(_42577A(phone_book1)).isEqualTo(answer1);
//        assertThat(_42577A(phone_book2)).isEqualTo(answer2);
//        assertThat(_42577A(phone_book3)).isEqualTo(answer3);
//
//        assertThat(_42577B(phone_book1)).isEqualTo(answer1);
//        assertThat(_42577B(phone_book2)).isEqualTo(answer2);
//        assertThat(_42577B(phone_book3)).isEqualTo(answer3);

        assertThat(_42577C(phone_book1)).isEqualTo(answer1);
        assertThat(_42577C(phone_book2)).isEqualTo(answer2);
        assertThat(_42577C(phone_book3)).isEqualTo(answer3);

//        assertThat(_42577D(phone_book1)).isEqualTo(answer1);
//        assertThat(_42577D(phone_book2)).isEqualTo(answer2);
//        assertThat(_42577D(phone_book3)).isEqualTo(answer3);
    }

    public boolean _42577A(String[] phone_book){ //효율성 테스트 3,4 실패(시간초과)
        if(phone_book.length==1){
            return true;
        }
        for (int i =0; i<phone_book.length-1; i++){
            for (int x = i+1; x<phone_book.length;x++){
                if(phone_book[x].indexOf(phone_book[i]) == 0 || phone_book[i].indexOf(phone_book[x]) == 0){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean _42577B(String[] phone_book){ //효율성 테스트 3,4 실패(시간초과)

        if(phone_book.length==1){
            return true;
        }
        for (int i =0; i<phone_book.length-1; i++){
            for (int x = i+1; x<phone_book.length;x++){
                if(phone_book[x].startsWith(phone_book[i]) || phone_book[i].startsWith(phone_book[x])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean _42577C(String[] phone_book){

        TreeSet<String> phones = new TreeSet<>(List.of(phone_book));
        String temp ="";
        for (String phone : phones){
            if(temp.isEmpty()){
                temp = phone;
                continue;
            }
            if(phone.startsWith(temp)){
                return false;
            }
            temp = phone;
        }

        return true;
    }

    public boolean _42577D(String[] phone_book) {

        if(phone_book.length==1){
            return true;
        }

        for (int i =0; i<phone_book.length-1; i++){
            for (int x = i+1; x<phone_book.length;x++){
                if(phone_book[i].length()>phone_book[x].length()){
                    String temp = phone_book[i].substring(0, phone_book[x].length());
                    if(temp.equals(phone_book[x])){
                        return false;
                    }
                }else{
                    String temp = phone_book[x].substring(0, phone_book[i].length());
                    if(temp.equals(phone_book[i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    ----------------------------------

    @Test
    public void _42579Test(){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        assertThat(_42579A(genres,plays)).isEqualTo(new int[]{4, 1, 3, 0});
    }

    @Test
    public void _42579B() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, detailClass> detailMap = new HashMap<>();

        IntStream.range(0,genres.length)
                .forEach(i -> {
                    totalMap.put(genres[i],totalMap.getOrDefault(genres[i],0)+plays[i]);
                    detailMap.put(genres[i],detailMap.getOrDefault(genres[i], new detailClass()).addArr(i, plays[i]));
                });


        List<Integer> answer = new ArrayList<>();

        for (String totalKey : totalMap.keySet()){
            detailClass detailClass = detailMap.get(totalKey);

            if (detailClass.values[0] == 0 && detailClass.indexes[0] == 0){
                int temp = detailClass.values[1];
                detailClass.values = new int[1];
                detailClass.values[0] = temp;
                temp = detailClass.indexes[1];
                detailClass.indexes = new int[1];
                detailClass.indexes[0] =temp;
            }

            Arrays.stream(detailClass.indexes).forEach(answer::add);
        }


        int[] a = new int[answer.size()];
        IntStream.range(0,answer.size())
                .forEach(i->a[i] = answer.get(i));



    }

    static class detailClass{
        int[] indexes = {0,0};
        int[] values = {0,0};

        detailClass addArr(int index, int play){

            for (int i = 1; i > -1; i--) {
                if (values[i] == 0) {
                    indexes[i] = index;
                    values[i] = play;
                    break;
                }
                if(i == 0){

                    //들어있는 순서를 내림차순으로 정리
                    if(values[0]<values[1]){
                        int temp = values[1];
                        values[1] = values[0];
                        values[0] = temp;
                        temp = indexes[1];
                        indexes[1] = indexes[0];
                        indexes[0] = temp;
                    }

                    if (values[0]-play<0){
                        values[1] = values[0];
                        values[0] = play;
                        indexes[1] = indexes[0];
                        indexes[0] = index;
                        break;
                    }

                    if (values[1]-play<0){
                        values[1] = play;
                        indexes[1] = index;
                        break;
                    }

                }
            }

            return this;
        }

    }

    public int[] _42579A(String[] genres, int[] plays){
        int[] answer;

//        Map<String, Integer> totalMap = new HashMap<>();
//        Map<String , HashMap<Integer, Integer>> indexMap = new HashMap<>();

        Map<String, _42579Movie> totalMap = new HashMap<>();

        IntStream.range(0,genres.length)
                .forEach(i->{

                    totalMap.put(genres[i], totalMap.getOrDefault(genres[i],new _42579Movie()).addList(i,plays[i]));

//                    totalMap.put(genres[i], totalMap.getOrDefault(genres[i],0) + plays[i]);
                    /*HashMap<Integer, Integer> genreMap = indexMap.getOrDefault(genres[i], new HashMap<>());
                    genreMap.put(i, plays[i]);
                    indexMap.put(genres[i], genreMap);*/ // 성능 및 재사용성 부분에서 class형식으로 처리하는게 낫다고 함
                });

        List<Integer> tempAnswers = new ArrayList<>();


        for (String key1 : totalMap.keySet()){

            int tempTotal = 0;
            String tempKey = "";

            for (String key2 : totalMap.keySet()){
                totalMap.get(key2).sortList();
                if(key1.equals(key2)){
                    totalMap.get(key1).sortList();
                    continue;
                }

                if (tempTotal == 0){
                    if (totalMap.get(key1).total > totalMap.get(key2).total){
                        tempTotal = totalMap.get(key1).total;
                        tempKey = key1;
                    }
                }

                if (tempTotal < totalMap.get(key2).total){
                    tempTotal = totalMap.get(key2).total;
                    tempKey = key2;
                }
            }

            for (int i = 0; i < 2; i++) {
                tempAnswers.addLast(totalMap.get(tempKey).indexes.indexOf(i));
                if(totalMap.get(tempKey).plays.size()==1){
                    break;
                }
            }

        }

        answer = new int[tempAnswers.size()];

        IntStream.range(0,answer.length)
                .forEach(i->answer[i]=tempAnswers.get(i));


//    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.


        return answer;
    }

    class _42579Movie{
        List<Integer> indexes;
        List<Integer> plays;
        int total;

        public _42579Movie(){
            indexes = new ArrayList<>();
            plays = new ArrayList<>();
            total = 0;
        }

        _42579Movie addList(int index, int play){
            indexes.add(index);
            plays.add(play);
            total += play;
            return this;
        }

        void sortList(){
            IntStream.range(0,plays.size()-1)
                    .forEach(i->{
                        for (int x = 1; x < plays.size() - 1; x++) {
                            int temp = 0;
                            int checkCase = plays.indexOf(i) - plays.indexOf(x);

                            if (checkCase < 0) { //뒤의 숫자가 더 큰 경우
                                temp = plays.indexOf(x);
                                plays.set(x, plays.indexOf(i));
                                plays.set(i, temp);
                                temp = indexes.indexOf(x);
                                indexes.set(x,indexes.indexOf(i));
                                indexes.set(i,temp);
                            }

                        }
                    });

//            return this;
        }

    }



    class ForTest{

        int idx;
        int play;

        ForTest (int idx, int play){
            this.idx = idx;
            this.play = play;
        }

        int Gidx(){
            return this.idx;
        }

        int Gplay(){
            return this.play;
        }

    }

    @Test
    public void 빡쳐(){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Map<String, Integer> totalMap = new TreeMap<>();
        Map<String, List<ForTest>> answerMap = new HashMap<>();

        IntStream.range(0,genres.length)
                .forEach(i -> {
                    totalMap.put(genres[i], totalMap.getOrDefault(genres[i],0)+plays[i]);

                    List<ForTest> aMDefault = answerMap.getOrDefault(genres[i], new ArrayList<>());
                    aMDefault.add(new ForTest(i,plays[i]));
                    answerMap.put(genres[i],aMDefault);
                });

//        Comparator<String> comparator = Comparator.comparing(totalMap::get, Comparator.reverseOrder());
//        Comparator<String> comparator = (k1, k2) -> totalMap.get(k2).compareTo(totalMap.get(k1));
//        Map<String, Integer> sortedTotalMap = new TreeMap<>(comparator.reversed());
//        sortedTotalMap.putAll(totalMap);

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(totalMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        Comparator<ForTest> comparator1 = Comparator.comparingInt(ForTest::Gplay).reversed();

        answerMap.replaceAll((key, value) ->
                value.stream()
                        .sorted(comparator1)
                        .collect(Collectors.toList()));

        int totalSize = answerMap.values().stream()
                .mapToInt(list -> Math.min(list.size(), 2))
                .sum();

        int[] answer = new int[totalSize];

        AtomicInteger x = new AtomicInteger(0);
//        totalMap.keySet().stream()
//                .flatMap(key -> answerMap.get(key).stream().limit(2))
//                .forEach(forTest -> answer[x.getAndIncrement()] = forTest.idx);

        totalMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> answerMap.get(entry.getKey()).stream().limit(2)
                        .forEach(forTest -> answer[x.getAndIncrement()] = forTest.idx));

        Arrays.stream(answer).forEach(v-> System.out.println(v));

        totalMap.forEach((k,v)->{
            System.out.println(k + "    "+ v);
        });


    }
}