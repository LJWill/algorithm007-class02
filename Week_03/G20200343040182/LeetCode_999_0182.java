// 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
// 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
// 返回车能够在一次移动中捕获到的卒的数量。



class Solution {

    //solv1: 暴力搜索
    //Time: O(n^2)
    //Space:
    public int numRookCaptures(char[][] board) {
        int dim = board.length;
        int rI = 0, rJ = 0;
        int count = 0;

        //find rook
        for (int i=0; i<dim; i++) {
            for (int j=0; j<dim; j++) {
                if (board[i][j] == 'R') {
                    rI=i;
                    rJ=j;
                }
            }
        }

        //search row
        for (int j=0; j<dim; j++) {

            if (board[rI][j] == 'p') {
                if(j < rJ) {
                    int i = j+1; 
                    while (i!=rJ) {
                        if (board[rI][i] == '.') {
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (i==rJ)
                        count++;
                } else {
                    int i = j-1; 
                    while (i!=rJ) {
                        if (board[rI][i] == '.') {
                            i--;
                        } else {
                            break;
                        }
                    }
                    if (i==rJ)
                        count++;
                }
            }

        }

        //search col
        for (int i=0; i<dim; i++) {

            if (board[i][rJ] == 'p') {
                if(i < rI) {
                    int j = i+1;
                    while (j!=rI) {
                        if (board[j][rJ] == '.') {
                            j++;
                        }else{
                            break;
                        }
                    }

                    if (j==rI)
                        count++;
                } else {
                    int j = i-1;
                    while (j!=rI) {
                        if (board[j][rJ] == '.') {
                            j--;
                        }else{
                            break;
                        }
                    }

                    if (j==rI)
                        count++;
                }
            }

        }


        return count;

    }
}