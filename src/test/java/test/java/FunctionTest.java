/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import java.util.Vector;
import static org.junit.Assert.*;
import com.demetrey.balanceavltreeonline.tree.Tree;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 1
 */
public class FunctionTest {
    
    @Test
    public void balanceLeftList() {
        Tree testtree = new Tree();
        for(int i = 1; i <= 8; i++)
            testtree.addData(i, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceRightList(){
        Tree testtree = new Tree();
        for(int i = 4; i > 1; i--)
            testtree.addData(i, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceList(){
        Tree testtree = new Tree();
        testtree.addData(10, false);
        testtree.addData(20, false);
        testtree.addData(15, false);
        testtree.addData(18, false);
        testtree.addData(17, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceEmpty(){
        Tree testtree = new Tree();
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceOneElement(){
        Tree testtree = new Tree();
        testtree.addData(69, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceLeftSmall(){
        Tree testtree = new Tree();
        for(int i = 1; i <= 3; i++)
            testtree.addData(i, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceRightSmall(){
        Tree testtree = new Tree();
        for(int i = 3; i <= 1; i--)
            testtree.addData(i, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balancedTree(){
        Tree testtree = new Tree();
        testtree.addData(5, false);
        testtree.addData(4, false);
        testtree.addData(6, false);
        testtree.addData(2, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceBigLeft(){
        Tree testtree = new Tree();
        testtree.addData(5, false);
        testtree.addData(4, false);
        testtree.addData(11, false);
        testtree.addData(12, false);
        testtree.addData(8, false);
        testtree.addData(7, false);
        testtree.addData(9, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
    
    @Test
    public void balanceBigRight(){
        Tree testtree = new Tree();
        testtree.addData(16, false);
        testtree.addData(18, false);
        testtree.addData(10, false);
        testtree.addData(12, false);
        testtree.addData(8, false);
        testtree.addData(11, false);
        testtree.addData(13, false);
        testtree.balanceNow();
        Vector<Integer> bfactors;
        bfactors = testtree.getBalanceFactors();
        for(int i = 0; i < bfactors.size(); i++)
            assertTrue("Balancing factor must be 1, -1 or 0", 
                    bfactors.get(i) == 1 || bfactors.get(i) == -1 || bfactors.get(i) == 0);
    }
}
