package com.example.quze.Service;

import com.example.quze.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    ArrayList<Book>array=new ArrayList<>();

    public ArrayList<Book> get(){
        return array;
    }

    public void add(Book model){
        array.add(model);
    }

    public boolean update(Book model,String id){

        for(int i=0;i<array.size();i++){
            if(array.get(i).getID().equals(id)){
                array.set(i,model);
                return true;
            }
        }
        return  false;
    }


    public boolean delete(String id){
        for(int i=0;i<array.size();i++){
            if(array.get(i).getID().equals(id)){
                array.remove(i);
                return true;
            }
        }
       return false;
    }

    public boolean bookName(String nameBook){
        for(int i=0;i<array.size();i++){
            if(array.get(i).getName().equals(nameBook)){
                return true;
            }
        }
        return false;
    }


    public ArrayList<Book>Cot(String cotgrae){

        ArrayList<Book>newarray=new ArrayList<>();
        for (Book n:array){
            if(n.getCategory().equals(cotgrae)){
                newarray.add(n);
            }
        }
        return newarray;
    }

    public ArrayList<Book>page(int number){

        ArrayList<Book>newarray=new ArrayList<>();

        for (Book n:array){
            if((n.getNumberOfPages()>=number){
                newarray.add(n);
            }
        }
        return newarray;
    }



    public boolean change(boolean status ){

        for(int i=0;i<array.size();i++){
            if(array.get(i).get)
        }
    }

}
