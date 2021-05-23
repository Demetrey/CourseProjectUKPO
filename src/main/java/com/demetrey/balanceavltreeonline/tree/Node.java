package com.demetrey.balanceavltreeonline.tree;

public class Node 
{
    private int data;
    private int height;
    private Node left;
    private Node right;
    
    public Node(int data)
    {
        this.data = data;
    }
    
    public void setData(int data)
    {
        this.data = data;
    }
    
    public void setLeft(Node left)
    {
        this.left = left;
    }
    
    public void setRight(Node right)
    {
        this.right = right;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public int getData()
    {
        return this.data;
    }
    
    public Node getLeft()
    {
        return left;
    }
    
    public Node getRight()
    {
        return right;
    }
    
    public int getHeight()
    {
        return height;
    }
}
