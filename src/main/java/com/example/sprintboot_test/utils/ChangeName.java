package com.example.sprintboot_test.utils;

import java.io.File;
import java.util.HashSet;

public class ChangeName {
    public static void main(String[] args) {
        HashSet<String> typeSet = new HashSet<>();
        for (int i = 10; i <=12 ; i++) {
            File file = new File("C:\\Users\\CharmingZ1e\\Documents\\WeChat Files\\wxid_q9ufy9jc8eeu21\\FileStorage\\File\\2023-01\\2022年"+i+"月份桐乡累计热点网格");
            File[] files = file.listFiles();
            for (int i1 = 0; i1 < files.length; i1++) {
                String newName="sum_grid_";
                String[] split = files[i1].getName().split("-");
                String date = split[0].substring(0, split[0].length() - 2);
                if(files[i1].getName().indexOf("PM2_5")==-1){
                    String[] s = files[i1].getName().split("_");
                    String type=s[s.length-2];
                    newName+=date;
                    newName+="_";
                    newName+=type;
                    typeSet.add(type);
                }else{
                    newName+=date;
                    newName+="_";
                    newName+="PM2_5";
                    typeSet.add("PM2_5");
                }
                String[] split1 = files[i1].getName().split("\\.");
                String suffix = split1[split1.length - 1];
                newName+=".";
                newName+=suffix;
                rename(files[i1],newName);
            }
        }
        for (String type:typeSet) {
            String dirStr = "C:\\Users\\CharmingZ1e\\Desktop\\"+type;
            File directory = new File(dirStr);
            if(!directory.exists()){
                directory.mkdir();
            }
        }
        for (int i = 10; i <=12 ; i++) {
            File file = new File("C:\\Users\\CharmingZ1e\\Documents\\WeChat Files\\wxid_q9ufy9jc8eeu21\\FileStorage\\File\\2023-01\\2022年" + i + "月份桐乡累计热点网格");
            File[] files = file.listFiles();
            for (int i1 = 0; i1 < files.length; i1++) {
                for (String index:typeSet) {
                    if(files[i1].getName().indexOf(index)!=-1){
                        files[i1].renameTo(new File("C:\\Users\\CharmingZ1e\\Desktop\\" + index+"\\"+files[i1].getName()));
                    }
                }
            }
        }
    }
    public static boolean rename(final File file, final String newName) {
        // file is null then return false
        if (file == null) return false;
        // file doesn't exist then return false
        if (!file.exists()) return false;
        // the new name is space then return false
        // the new name equals old name then return true
        if (newName.equals(file.getName())) return true;
        File newFile = new File(file.getParent() + File.separator + newName);
        // the new name of file exists then return false
        return !newFile.exists()
                && file.renameTo(newFile);
    }
}
