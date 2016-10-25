
package com.servisotomasyon.abstracts;


public abstract class Crud extends Listeleme{
    
     abstract public boolean insert(Object obje);

    abstract public boolean delete(Object obje);

    abstract public boolean update(Object obje);
    
}
