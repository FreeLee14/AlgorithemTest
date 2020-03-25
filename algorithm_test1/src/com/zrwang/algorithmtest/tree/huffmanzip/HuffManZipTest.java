package com.zrwang.algorithmtest.tree.huffmanzip;

import java.util.*;

/**
 * 实现赫夫曼编码
 */
public class HuffManZipTest {

    public static void main(String[] args) {
        //首先定义一个字符串
        String msg = "can you can a can as a can cannner can a can";
        //将这个字符串转换为二进制数组
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编码压缩
        byte[] newByte = heffmanZip(bytes);
//        System.out.println(bytes.length);
//        System.out.println(newByte.length);
        //进行赫夫曼编码解压
        byte[] recover = deocde(newByte,codes);
        System.out.println(Arrays.toString(recover));
        System.out.println(new String(recover));
    }

    /**
     * 进行赫夫曼编码解压操作
     * @param bytes       需要解压的数组
     * @param codes   赫夫曼树编码表
     * @return
     */
    private static byte[] deocde(byte[] bytes, HashMap<Byte, String> codes) {

        //定义一个存储转换为二进制字符串的缓冲区
        StringBuilder newStr = new StringBuilder();
        //将需要解压的字节数组转换为二进制位字符串
        for(int i = 0; i < bytes.length; i++){
            //由于在进行转换时我们使用integer类型是32位，会将负数前缀补充1，而正数是正常打印（不足8位）我们可以测试打印一下看结果
            // String str = Integer.toBinaryString((int) b);
            // System.out.println(str);
            //所以我们需要定义一个方法使得我们的字节可以转换为8位的二进制位编码
            boolean flag = true;
            //如果遍历到了最后一位，那么就不会截取八位，flag位false
            String str;

            if(i == bytes.length-1){
                 str = convert(bytes[i], !flag);
            }else{
                 str = convert(bytes[i], flag);
            }

            newStr.append(str);
//            System.out.println(str);
        }
//        System.out.println(newStr.toString());
        //将我们原来的赫夫曼编码表的key与value进行颠倒,存储在一个新的编码表中
        Map<String,Byte> newCode = new HashMap<>();

        for(Map.Entry<Byte,String> map : codes.entrySet()){
            newCode.put(map.getValue(),map.getKey());
        }

        //创建一个新的byte集合，用于存储解压后的字节
        List<Byte> newByte = new ArrayList<>();

        for(int i=0; i < newStr.length();){

            int count = 1;
            boolean flag = true;

            while (flag){

                String key = newStr.substring(i, i + count);
                Byte aByte = newCode.get(key);

                if (aByte == null){
                    count++;
                }else{
                    newByte.add(aByte);
                    flag = false;
                }

            }

            i+=count;
        }
        //创建新的byte数组，长度为之前的集合的长度
        byte[] newByteArray = new byte[newByte.size()];

        for (int i=0; i < newByte.size(); i++){
            newByteArray[i] = newByte.get(i);
        }

        return newByteArray;
    }

    /**
     * 将我们的字节转换为8位的二进制位编码
     * @param b
     * @param flag  定义是否进行截取八位，由于最后一个不需要进行转换为8位
     */
    private static String convert(byte b,boolean flag) {
        int temp = b;
        if(flag){
            //与256进行或位运算  也就是与  1 0000 0000 进行或运算，这样低八位与0或都是自己本身,不足八位的也能够补齐八位
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            //如果需要进行截取的话，从倒数第八位开始截取
            return str.substring(str.length() - 8);
        }else{
            return str;
        }
    }

    /**
     * 进行赫夫曼编码流程
     * @param bytes
     * @return
     */
    private static byte[] heffmanZip(byte[] bytes) {
        //首先要计算出相同byte的个数，并存储在一个集合当中
        List<Node> nodes = getNodes(bytes);
        //将获取到的结点集合转换成赫夫曼树
        Node huffmanTree = creatHuffmanTree(nodes);
//        System.out.println(huffmanTree);
        //获取赫夫曼编码表
        Map<Byte,String> huffmanCodes = getCodes(huffmanTree);
//        System.out.println(huffmanCodes);
        //进行赫夫曼编码压缩
        byte[] huffmanzip = zip(bytes,huffmanCodes);
        return huffmanzip;
    }

    /**
     * 进行赫夫曼压缩
     * @param bytes         被压缩的数组
     * @param huffmanCodes  赫夫曼编码表
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //首先需要根据赫夫曼编码表将原来数组重新进行翻译,组成一个新的二进制字符串
        StringBuilder newByteStr = new StringBuilder();
        if(bytes!=null){
            for (byte b : bytes){
                newByteStr.append(huffmanCodes.get(b));
            }
        }
//        System.out.println(newByteStr.toString());
        //创建一新的压缩后存储数据的数组，我们需要对这个新的二进制字符串进行ASCII编码转换成新的字节，并存储在这个数组中
        //定义长度
        int len;
        if(newByteStr.length()%8 == 0){
            len = newByteStr.length()/8;
        }else{
            len = newByteStr.length()/8 + 1;
        }
        byte [] b = new byte[len];
        //开始按照8位开始截取并通过ASCII码转换为对应的字节
        String paramStr ;
        int index = 0;
        for(int i = 0; i < newByteStr.length(); i+=8){
            //判断当前的索引位置+8是否超过了长度上限
            if( (i+8) > newByteStr.length() ){
                //如果超过了，则直接从当前位置截取
                paramStr = newByteStr.substring(i);
            }else{
                //若未超过，则进行按照8位截取
                paramStr = newByteStr.substring(i,i+8);
            }
            byte param = (byte) Integer.parseInt(paramStr,2);
//            System.out.println(paramStr+":"+param);
            b[index] = param;
            index++;
        }
        return b;
    }

    //创建一个成员变量，用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    //创建一个成员变量，用于存储赫夫曼编码表
    static HashMap<Byte,String> codes = new HashMap<>();
    //获取赫夫曼编码表的方法
    private static Map<Byte, String> getCodes(Node huffmanTree) {

        if(huffmanTree == null){
            return null;
        }

        getCode(huffmanTree.left,"0",sb);
        getCode(huffmanTree.right,"1",sb);

        return codes;
    }

    //进行递归遍历创建赫夫曼编码表
    private static void getCode(Node node, String code, StringBuilder sb) {

        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);
        if(node.data == null){
            //如果结点的data为null说明该结点不是叶子结点，所以继续进行递归
            getCode(node.left,"0",stringBuilder);
            getCode(node.right,"1",stringBuilder);

        }else{
            //如存在data则证明是叶子结点，将结点的data以及路径字符串传进赫夫曼编码表
            codes.put(node.data, stringBuilder.toString());
        }

    }

    //创建赫夫曼树
    private static Node creatHuffmanTree(List<Node> nodes) {

        //开始转化为赫夫曼树
        while (nodes.size() > 1){
            //每次循环前都要进行排序集合进行排序
            Collections.sort(nodes);
            //获取到最小的两个结点
            Node leftNode = nodes.get(nodes.size() - 1);
            Node rightNode = nodes.get(nodes.size() - 2);
            //根据最小的两个结点创建新的二叉树的根结点，此时新的根结点数据为null，权值为两个孩子结点的权值之和
            Node parent = new Node(null,leftNode.value+rightNode.value);
            //将最小的两个结点作为新结点的左右孩子
            parent.left = leftNode;
            parent.right = rightNode;
            //从原来的集合中删除两个最小的孩子结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树添加到集合中
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    //获取需要转换成赫夫曼树的集合（）
    private static List<Node> getNodes(byte[] bytes) {
        //定义一个list结合用于存储一个键值对，键为byte 值为该byte的个数
        List<Node> nodes = new ArrayList<>();
        //定义一个hashmap用于存储这个键值对数据
        Map<Byte,Integer> counts = new HashMap<>();

        for (byte b : bytes){
            //首先根据当前的byte获取到对应个数
            Integer count = counts.get(b);

            if(count == null){
                //如果这个byte在该散列表中没有，则直接添加进去，个数为1
                counts.put(b,1);
            }else{
                //如果已经存在了则进行个数+1
                counts.put(b,count+1);
            }
        }
        //循环将map中的数据组装到集合中去,这里需要使用entrySet()方法先将map存放至一个set中（我们将遍历一个包含map的set集合），这样我们才可以通过这个set获取到每一个map对象的键
        for (Map.Entry<Byte,Integer> count : counts.entrySet()) {

            nodes.add(new Node(count.getKey(),count.getValue()));

        }

        return nodes;
    }
}
