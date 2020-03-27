package com.zrwang.algorithmtest.LeeCode;

/**
 * 999. 车的可用捕获量
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 *  提示：
     *  board.length == board[i].length == 8
     *  board[i][j] 可以是 'R'，'.'，'B' 或 'p'
     *  只有一个格子上存在 board[i][j] == 'R'
 *解题思路
 *  看了官方题解明白了其方向数组的含义，采用深度优先搜索的话我个人感觉时间0ms诱惑力还是蛮大的，
 *  主要思路就是先找到这个棋盘中唯一的一个车（"R"），然后依照这个坐标为起点分别向北、东、南、西四个方向深搜过去，
 *  首先要判断是否是空格（"."）是的话直接继续循环，然后判断是否是象（"B"）是的话直接跳出这个方向的遍历，转而进入下一个方向深搜，
 *  最后判断是否是卒（"p"）,然后让结果计数+1，跳出当前方向深搜。
 *
 */
public class 车的可用捕获量 {

    public static void main(String[] args) {

        char[][] board = new char[][]{{},{}};

        int counts = numRookCaptures(board);
    }

    private static int numRookCaptures(char[][] board) {
        // 定义一个跳出标记
        boolean boken = false;
        // 初始化车的横坐标
        int indexi = 0;
        // 初始化车的纵坐标
        int indexj = 0;
        // 初始化车一次移动可吃多少个卒
        int counts = 0;
        //本题的思路是先找到车（因为这个题限制了只有一个车的存在），以车的坐标为起点开始进行广度优先搜索（BFS）
        for (int i = 0; i < board.length; i++){
            //内层循环已经找到车，外层循环也要停止运行，节省空间和时间
            if (boken){

                break;

            }
            for (int j = 0; j < board[i].length; j++){

                if (board[i][j] == 'R'){

                    indexi = i;
                    indexj = j;
                    boken = true;
                    break;

                }

            }
        }
        // 开始依据车的位置向东南西北四个方向循环遍历，如果遇到象则停止，遇到卒则继续
        //先向北遍历
        for (int i = 1 ; i <= indexi; i++){

            if (board[indexi-i][indexj] == '.'){

                continue;

            }
            if (board[indexi-i][indexj] == 'B'){

                break;

            }
            if (board[indexi-i][indexj] == 'p'){

                counts++;
                break;

            }


        }
        // 向东遍历
        for (int i = 1; i < board[indexi].length - indexj; i++){

            if (board[indexi][indexj+i] == '.'){

                continue;

            }

            if (board[indexi][indexj+i] == 'B'){

                break;

            }

            if (board[indexi][indexj+i] == 'p'){

                counts++;
                break;

            }

        }
        // 向南遍历
        for (int i = 1; i < board.length - indexi; i++){

            if (board[indexi+i][indexj] == '.'){

                continue;

            }

            if (board[indexi+i][indexj] == 'B'){

                break;

            }

            if (board[indexi+i][indexj] == 'p'){

                counts++;
                break;

            }

        }
        // 向西遍历
        for (int i = 1; i < indexj; i++){

            if (board[indexi][indexj-i] == '.'){

                continue;

            }

            if (board[indexi][indexj-i] == 'B'){

                break;

            }

            if (board[indexi][indexj-i] == 'p'){

                counts++;
                break;

            }

        }

        return counts;
    }
}
