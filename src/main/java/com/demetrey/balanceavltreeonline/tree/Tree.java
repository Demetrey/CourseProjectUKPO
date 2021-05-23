package com.demetrey.balanceavltreeonline.tree;

import java.util.Vector;

public class Tree 
{
    Node root;
    int size;
    
    //Добавлнеие данных: 
    //data - данные
    //autobalance:
    //  true - балансировка при добавлении
    //  falce - без автобалансировки
    public boolean addData(int data, boolean autobalance)
    {
        int old = size;
        if(autobalance)
        {
            root = insertData(root, data);
        }
        else
        {
            root = insertDataNoBalance(root, data);
        }
        return (size != old);
    }
    
    //Вывод дерева в прямом обходе в консоль
    public void printTree()
    {
        if(size > 0)
            print(root);
        else
            System.out.println("Tree is empty");
    }
    
    public String getTree()
    {
        if(size > 0)
            return getNext(root);
        else
            return ("Tree is empty");
    }
    
    private String getNext (Node n)
    {
        String str = "";
        if(n != null)
        {
            str += "\tCurrent: " + (n.getData()) + "\n";
            if(n.getLeft() != null)
                str += ("Left: " + n.getLeft().getData()) + "\n";
            if(n.getRight() != null)
                str += ("Right: " + n.getRight().getData()) + "\n";
            str += getNext(n.getLeft());
            str += getNext(n.getRight());
        }
        return str;
    }
    
    //Метод принудительной балансировки
    public void balanceNow()
    {
        for(int i = 0; i < size; i++) //пробум балансировать столько, сколько элементов
                                        //нет элементов - не балансируем )
        {
            root = balanceNowHelper(root); //балансируем
            Vector<Integer> bfs = getBalanceFactors(); //получаем вектор факторов балансировки
            boolean stop = false; //флаг остановки
            for(int j = 0; j < bfs.size(); j++)
            {
                if(bfs.get(j) >= -1 && bfs.get(j) <= 1) //текущий элемент входит в [-1; 1] - ?
                {
                    stop = true; //да - флаг остановки в true
                }
                else
                {
                    stop = false; //нет - флаг остановки в false
                    break; //выходим для дальнейшей балансировки
                }
            }
            if(stop) //по флагу остановки выруаем балансировку
                break;
        }
    }
    
     //Удаление данных:
    //data - данные
    //autobalance:
    //  true - балансировка при добавлении
    //  falce - без автобалансировки
    public boolean removeData(int data, boolean autobalance)
    {
        int old = size;
        
        if(root != null)
        {
            if(autobalance)
            {
                root = delData(root, data);
            }
            else
            {
                root = delDataNoBalance(root, data);
            }
        }
        
        return (old != size);
    }
    
   //Получение всех факторов балансировки в виде списка
    public Vector<Integer> getBalanceFactors()
    {
        Vector<Integer> bfs = new Vector<Integer>();
        allBafactors(root, bfs);
        return bfs;
    }
    
    public String getBalanceFactorsStr()
    {
        String rez = "";
        Vector<Integer> bfs = getBalanceFactors();
        for(int i = 0; i < bfs.size(); i++)
        {
            rez += Integer.toString(bfs.get(i));
        }
        return rez;
    }
    
    //Возвращает кол-во элементов в дереве
    public int getSize()
    {
        return size;
    }
    
    
    
    private Node insertData(Node n, int data)
    {
        if(n == null)
        {
            n = new Node(data);
            n.setHeight(1);
            size++;
            return n;
        }
        if(data > n.getData())
            n.setLeft(insertData(n.getLeft(), data));
        else
            n.setRight(insertData(n.getRight(), data));
        return balance(n); // balance(n);
    }
    
    private Node insertDataNoBalance(Node n, int data) 
    {
        if(n == null)
        {
            n = new Node(data);
            n.setHeight(1);
            size++;
            return n;
        }
        if(data > n.getData())
            n.setLeft(insertDataNoBalance(n.getLeft(), data));
        else
            n.setRight(insertDataNoBalance(n.getRight(), data));
        fixHeight(n);
        return n; // balance(n);
    }
    
    private void print(Node n)
    {
        if(n != null)
        {
            System.out.println(n.getData());
            if(n.getLeft() != null)
                System.out.println("Left: " + n.getLeft().getData());
            if(n.getRight() != null)
                System.out.println("Right: " + n.getRight().getData());
            print(n.getLeft());
            print(n.getRight());
        }
    }
    
    private Node balance(Node n)
    {
        if(n == null)
            return n;
        
        fixHeight(n);
        
        if(bfactor(n) >= 2)
        {
            if(bfactor(n.getRight()) < 0)
            {
                n.setRight(rightRot(n.getRight()));
            }
            return leftRot(n);
        }
        if(bfactor(n) <= -2)
        {
            if(bfactor(n.getLeft()) > 0)
            {
                n.setLeft(leftRot(n.getLeft()));
            }
            return rightRot(n);
        }
        return n;
    }
    
    private int bfactor(Node n)
    {
        int fr = (n.getRight() != null) ? n.getRight().getHeight() : 0;
        int fl = (n.getLeft() != null) ? n.getLeft().getHeight() : 0;
        return (fr - fl);
    }
    
    private Node rightRot(Node n)
    {
        Node q = n.getLeft();
        n.setLeft(q.getRight());
        q.setRight(n);
        fixHeight(n);
        fixHeight(q);
        return q;
    }
    
    private Node leftRot(Node n)
    {
        Node p = n.getRight();
        n.setRight(p.getLeft());
        p.setLeft(n);
        fixHeight(n);
        fixHeight(p);
        return p;
    }
    
    private void fixHeight(Node n)
    {
        int lh = (n.getLeft() != null) ? n.getLeft().getHeight() : 0;
        int rh = (n.getRight() != null) ? n.getRight().getHeight() : 0;
        n.setHeight((lh > rh ? lh : rh) + 1);
    }
    
    private Node balanceNowHelper(Node n)
    {
        if(n != null)
        {
            if(n.getLeft() != null)
            {
                n.setLeft(balanceNowHelper(n.getLeft()));
            }
            if(n.getRight() != null)
            {
                n.setRight(balanceNowHelper(n.getRight()));
            }
            return balance(n);
        }
        else
        {
            return n;
        }
    }
    
    private Node delData(Node n, int data)
    {
        Node ln, rn, mn;
        
        if(n == null)
            return n;
        if(data == n.getData())
        {
            ln = n.getLeft();
            rn = n.getRight();
            --size;
            
            if(rn == null)
            {
                return ln;
            }
            for(mn = rn; mn.getLeft() != null; )
            {
                mn = mn.getLeft();
            }
            mn.setRight(searchMin(rn));
            mn.setLeft(ln);
            return balance(mn);
        }
        else if(data > n.getData())
        {
            n.setLeft(delData(n.getLeft(), data));
        }
        else
        {
            n.setRight(delData(n.getRight(), data));
        }
        return balance(n);
    }
    
    private Node delDataNoBalance(Node n, int data)
    {
        Node ln, rn, mn;
        
        if(n == null)
            return n;
        if(data == n.getData())
        {
            ln = n.getLeft();
            rn = n.getRight();
            --size;
            
            if(rn == null)
            {
                return ln;
            }
            for(mn = rn; mn.getLeft() != null; )
            {
                mn = mn.getLeft();
            }
            mn.setRight(searchMin(rn));
            mn.setLeft(ln);
            return (mn);
        }
        else if(data > n.getData())
        {
            n.setLeft(delDataNoBalance(n.getLeft(), data));
        }
        else
        {
            n.setRight(delDataNoBalance(n.getRight(), data));
        }
        return (n);
    }
    
    private Node searchMin(Node n)
    {
        if(n.getLeft() == null)
        {
            return n.getRight();
        }
        n.setLeft(searchMin(n.getLeft()));
        return balance(n);//balance
    }
    
    private void allBafactors(Node n, Vector<Integer> bfs)
    {
        if(n != null)
        {
            bfs.add(bfactor(n));
            allBafactors(n.getLeft(), bfs);
            allBafactors(n.getRight(), bfs);
        }
    }
    
    public void ClearTree()
    {
        if(root != null)
        {
            delAll(root);
        }
        root = null;
        size = 0;
    }
    
    private void delAll(Node n)
    {
        if(n != null)
        {
            if(n.getLeft() != null)
                delAll(n.getLeft());
            if(n.getRight() != null)
                delAll(n.getRight());
            n = null;
        }
    }
}
