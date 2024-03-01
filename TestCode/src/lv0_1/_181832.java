package lv0_1;

public class _181832 {
    public static void main(String[] args) {

        int n = 4;
        int[][] answer = new int[n][n];

        int dir = 0; // 방향 0 1 2 3

        int row = 0;
        int col = 0;
        int x = 1;

        int count = 0;

        while (count<1+2*(n-1)){
            switch (dir) {
                case 0:
                    for (int i =0; i<n-row; i++){
                        answer[row][i] = x;
                        x++;
                    }
                    row++;
                    dir++;
                    break;
                case 1:
                    for (int i = row; i<n-col; i++){
                        answer[i][n-row] = x;
                        x++;
                    }
                    col++;
                    dir++;
                    break;
                case 2:
                    for (int i = n-col; i>row-1; i--){
                        answer[n-col][i-row] = x;
                        x++;
                    }
                    row++;
                    dir++;
                    break;
                case 3:
                    for(int i = n-row; i>col-1; i--){
                        answer[i][i-col] = x;
                        x++;
                    }
                    col++;
                    dir = 0;
                    break;
            }
            count++;
        }


        for (int i =0; i< answer.length; i++){
            for (int z  = 0; z<answer[i].length; z++){
                System.out.print(answer[i][z]+"\t");
            }
            System.out.println();
        }



        /*int[][] answer = new int[n][n];

        int row = 0;
        int col = -1;
        int loopCount = n;
        int count = 1;
        int num = 1;

        while (true) {

            for (int i = 0; i < loopCount; i++) {
                col += count;
                answer[row][col] = num++;
            }
            loopCount--;
            if (loopCount == 0)
                break;

            for (int j = 0; j < loopCount; j++) {
                row += count;
                answer[row][col] = num++;
            }
            count *= -1;

        }*/

    }
}


/*
1  2  3  4
12 13 14 5
11 16 15 6
10 9  8  7

1 2 3 4
1 3 5 7
1 + 2(n-1)






*/