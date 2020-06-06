package com.zrwang.algorithmtest.SideToOffer;

public class 矩阵中的路径 {
    // 定义行列值
    private static int row;
    private static int col;
    public static void main(String[] args) {
        char[][] arr =  {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "bfce";
        boolean flag = exit(arr,word);
        System.out.println(flag);
    }

    private static boolean exit(char[][] arr, String word) {
        // 如果数组为null直接返回false
        if (arr.length == 0) return false;
        row = arr.length;
        col = arr[0].length;
        for (int i = 0; i < row; i ++){
            for (int j = 0; i < col; j++){
                // 每到一个字符位置进行深搜 检测是否包含当前的字符
                // 将我们的数组，单词，还有开始遍历单词的位置，以及遍历数组的i和j作为参数传入
               if (dfsSearch(arr,word,0,i,j)) return true;
            }
        }
        return false;
    }

    private static boolean dfsSearch(char[][] arr, String word, int d, int i, int j) {
        // 如果超出了边界，并且我们当前定位到的字符不等于我们要寻找的字符串对应位置的值，剪枝返回false
        if (i < 0 || i >= row || j < 0 || j >= col || word.charAt(d) != arr[i][j]) return false;
        // 以上判断依次通过，并且当前的d已经等于字符串的最后一位索引位置，这时证明这个二维单词矩阵中包含我们要找的word
        if (d == (word.length() - 1)) return true;
        // 之后进行递归搜素
        // 首先我们还需要注意一点时我们已经访问过的位置之后就不能在此访问，所以我们在向下递归时将已经访问过的位置置0
        char temp = arr[i][j];
        arr[i][j] = '0';

        boolean flag = dfsSearch(arr,word,d + 1,i + 1, j)
                    || dfsSearch(arr,word,d + 1,i - 1, j)
                    || dfsSearch(arr,word,d + 1,i , j + 1)
                    || dfsSearch(arr,word,d + 1,i , j - 1) ;
        // 在进行回溯时将之前遍历过的字符恢复,(采用这种方式进行回溯比再开辟一个布尔二维数组存放该位置是否被访问过，要节省空间)
        arr[i][j] = temp;

        return flag;
    }
}
