/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demetrey.balanceavltreeonline.tree;

import java.util.ArrayDeque;
import com.demetrey.balanceavltreeonline.tree.Tree;
import com.demetrey.balanceavltreeonline.tree.Node;


/**
 *
 * @author 1
 */
public class History {
    private ArrayDeque<Tree> history = new ArrayDeque<Tree>();
    
    /*public void Print()
    {
        history.getFirst().printTree();
    }*/
    
    public void Save(Tree currentTree)
    {
        history.addFirst(new Tree());
        if(currentTree.size > 0)
            SaveMe(currentTree.root);
        if(history.size() > 11)
            history.removeLast();
    }
    
    private void SaveMe(Node cur)
    {
        history.getFirst().addData(cur.getData(), false);
        if(cur.getLeft() != null)
            SaveMe(cur.getLeft());
        if(cur.getRight() != null)
            SaveMe(cur.getRight());
    }
    
    public void Load(Tree currentTree)
    {
        currentTree.ClearTree();
        history.removeFirst();
        if(!(history.isEmpty()) && history.getFirst().size > 0)
            LoadMe(history.getFirst().root, currentTree);
    }
    
    private void LoadMe(Node cur, Tree currentTree)
    {
        currentTree.addData(cur.getData(), false);
        if(cur.getLeft() != null)
            LoadMe(cur.getLeft(), currentTree);
        if(cur.getRight() != null)
            LoadMe(cur.getRight(), currentTree);
    }
    
    public int GetSize()
    {
        return history.size();
    }
}
