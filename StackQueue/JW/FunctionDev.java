import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * FunctionDev
 * 6 점...
 */
public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
         if (progresses.length == 1){
            return new int[]{1};
        }

        List<Integer> temp = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        IntStream.range(0, progresses.length)
                .forEach(i ->{
                    progresses[i] = 100 - progresses[i];
                    queue.add((int) Math.ceil((double) progresses[i]/(double) speeds[i]));
                });

        int count = 0;
        int tempQ = 0;

        while (!queue.isEmpty()){

            count++;
            tempQ = queue.poll();

            while (!queue.isEmpty()){

                if (tempQ < queue.peek()){
                    temp.add(count);
                    break;
                }

                queue.remove();
                count++;
            }

            count = 0;

        }

        int check = progresses.length - temp.stream().mapToInt(Integer::intValue).sum();

        if( check > 0){
            temp.add(check);
        }

        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
    
}