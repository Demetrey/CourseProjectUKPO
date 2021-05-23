/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demetrey.balanceavltreeonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demetrey.balanceavltreeonline.usingtree.WorkingWithData;
/**
 *
 * @author 1
 */
@RestController
@RequestMapping("/public/rest/data")
public class DataController {
    
    String cmd = "";

    @RequestMapping(value = "/{data}", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@PathVariable("data") Integer data) {
        cmd = "ADD";
        return ResponseEntity.ok(WorkingWithData.AddData(data));
    }
    
    /*@RequestMapping(value="/", method={RequestMethod.GET})
    public int getData(){
        //WorkingWithData.Show();
        return 0;
    }*/
    
    @RequestMapping(value="/{data}", method = RequestMethod.DELETE)
    public void deleteData(@PathVariable("data") Integer data) {
        cmd = "DELETE";
        WorkingWithData.DelData(data);
    }
    
    @RequestMapping(value="/", method = RequestMethod.DELETE)
    public void clearData() {
        cmd = "CLEAR";
        WorkingWithData.Clear();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void balanceTree() {
        cmd = "BALANCE";
        WorkingWithData.Balance();
    }
    
    @RequestMapping(value = "/back", method = RequestMethod.POST)
    public void back() {
        cmd = "BACK";
        WorkingWithData.Load();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ResponseClass> getTree() {
        //System.out.println("-----------");
        //System.out.println(WorkingWithData.Show());
        //System.out.println("-----------");
        ResponseClass rc = new ResponseClass(WorkingWithData.Show(), WorkingWithData.GetBfs(), cmd, 
                WorkingWithData.GetTreeSize(), WorkingWithData.GetHistorySize());
        return ResponseEntity.ok(rc);
        //return ResponseEntity.ok(WorkingWithData.Show());
    }
}
