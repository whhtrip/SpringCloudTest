package com.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:WangHongHao
 * @date:19-11-6创建
 * @date：修改
 * @description：读取javaDoc中的Tree结构
 */
public class ClassTree {
    public static void readFile() throws IOException {
        String fileName = "C:\\zkrWhh\\我的文档\\新建文件夹\\quartzTree.txt";
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        Map<String, Map> stringMapHashMap = new HashMap<>();
        List<Integer> treeSize = new ArrayList<>();
        String maxLevel = null;
        Map<String, List<String>> stringListHashMap = null;
        while (s != null) {
            int numSpace = 0;
            int level = 0;
            while (s.startsWith(" ")) {
                s = s.substring(1);
                numSpace++;
            }
            level = numSpace / 4;
            if (level == 0) {
                stringListHashMap = new HashMap<>();
                stringMapHashMap.put(s, stringListHashMap);
                maxLevel = s;
            }
            if (!treeSize.contains(level)) {
                treeSize.add(level);
                ArrayList<String> strings = new ArrayList<>();
                strings.add(s);
                stringListHashMap = stringMapHashMap.get(maxLevel);
                stringListHashMap.put(level + "", strings);
            } else {
                stringListHashMap = stringMapHashMap.get(maxLevel);
                List<String> strings = stringListHashMap.get(level + "");
                strings.add(s);
            }

            System.out.println(s);
            s = bufferedReader.readLine();
        }
        System.out.println(treeSize);
        for (String key : stringMapHashMap.keySet()) {
            System.out.println(key + "==================================");
            Map<String, List> map = stringMapHashMap.get(key);
            for (String subkey : map.keySet()) {
                List<String> strings = stringListHashMap.get(subkey);
                System.out.println(subkey + "  " + strings.size());
                System.out.println(strings);
            }
        }
        System.out.println(stringListHashMap);
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
