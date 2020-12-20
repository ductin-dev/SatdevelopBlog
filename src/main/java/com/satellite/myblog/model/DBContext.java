package com.satellite.myblog.model;
//Author: Doan Duc Tin

import java.util.ArrayList;

public abstract class DBContext<T> {

    public abstract ArrayList<T> selectAll() throws Exception;

    public abstract T selectById(int id) throws Exception;

    public abstract int add(T a) throws Exception;

    public abstract int delete(int id) throws Exception;

    public abstract int update(T a) throws Exception;

}
