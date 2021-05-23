/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demetrey.balanceavltreeonline.usingtree;

import com.demetrey.balanceavltreeonline.tree.Tree;
import com.demetrey.balanceavltreeonline.tree.History;
/**
 *
 * @author 1
 */
public class WorkingWithData {
    private static Tree currentTree = new Tree();
    private static History treehistory = new History();
    
    public static int AddData(int data)
    {
        currentTree.addData(data, false);
        currentTree.printTree();
        treehistory.Save(currentTree);
        //System.out.println("------>HISTORY:");
        //treehistory.Print();
        return data;
    }
    
    public static void DelData(int data)
    {
        currentTree.removeData(data, false);
        currentTree.printTree();
        treehistory.Save(currentTree);
    }
    
    public static void Balance()
    {
        currentTree.balanceNow();
        currentTree.printTree();
        treehistory.Save(currentTree);
    }
    
    public static void Clear()
    {
        currentTree.ClearTree();
        currentTree.printTree();
        treehistory.Save(currentTree);
    }
    
    public static void Load()
    {
        treehistory.Load(currentTree);
    }
    
    public static String Show()
    {
        return currentTree.getTree();
    }
    
    public static String GetBfs()
    {
        return currentTree.getBalanceFactorsStr();
    }
    
    public static int GetTreeSize()
    {
        return currentTree.getSize();
    }
    
    public static int GetHistorySize()
    {
        return treehistory.GetSize();
    }
    
}
