/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demetrey.balanceavltreeonline.controllers;

import java.util.List;

/**
 *
 * @author 1
 */
public class ResponseClass {
    private String data;
    private String bfs;
    private String command;
    int treeSize;
    int hsize;
    
    public ResponseClass(String data, String bfs, String cmd, int treeSize, int hSize)
    {
        this.data = data;
        this.bfs = bfs;
        this.command = cmd;
        this.treeSize = treeSize;
        this.hsize = hSize;
    }
    public String getData()
    {
        return data;
    }
    
    public String getBfs()
    {
        return bfs;
    }
    
    public String getCommand()
    {
        return command;
    }
    
    public int getTreeSize()
    {
        return treeSize;
    }
    
    public int getHsize()
    {
        return hsize;
    }
}
