package com.iotek.util;

public class GetTotalPage {
    private  static final int pageSize=5;

    public static int getTp(int totalRows){
        if (totalRows==0){
            return 1;
        }
        return totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
    }
}
