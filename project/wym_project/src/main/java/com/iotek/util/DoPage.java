package com.iotek.util;

import java.util.ArrayList;
import java.util.List;

public class DoPage {
    public static<T> List<T> getCurrentPage(List<T> list,int currentPage,int PageSize){
        if(list==null){
            return null;
        }
        List<T> newList = new ArrayList<T>();
        for (int i = 0; i <PageSize ; i++) {
            if((currentPage-1)*PageSize+i>list.size()-1){
                break;
            }
            newList.add(list.get((currentPage-1)*PageSize+i));
        }
        return newList;
    }

}
