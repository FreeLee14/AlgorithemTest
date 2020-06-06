package com.zrwang.algorithmtest.lanqiaobei;

import java.io.File;

public class deletePath {

    public static void main(String[] args) {

        String path = ".";
        deletePath(path);
    }

    public static void deletePath(String path){

        if (path != null){
            //首先获取到当前的目录
            File file = new File(path);
            // 如果当前是目录的话，继续进入
            // 进行当前目录扫描，如果存在.svn的目录进行删除，并逐一进入当前目录中的目录

            while (file.isDirectory()){

            }
            if (path.endsWith(".svn")){
                File d = new File(path);
                boolean delete = d.delete();
            }
        }

    }
}
