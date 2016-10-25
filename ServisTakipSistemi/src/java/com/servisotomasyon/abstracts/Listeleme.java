/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servisotomasyon.abstracts;

import java.util.List;

/**
 *
 * @author samet
 */
public abstract class Listeleme {

    abstract public List list(List<Object> param);
    abstract public Object select(List<Object> param);
}
