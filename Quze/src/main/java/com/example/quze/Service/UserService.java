package com.example.quze.Service;

import com.example.quze.Model.UserClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {


    ArrayList<UserClass>array=new ArrayList<>();

    public ArrayList<UserClass> get(){
        return array;
    }

    public void add(UserClass model){
        array.add(model);
    }


    public boolean update(UserClass model,String id){

        for(int i=0;i<array.size();i++){
            if(array.get(i).getId().equals(id)){
                array.set(i,model);
                return true;
            }
        }
        return false;
    }


    public boolean delete(String id){
        for(int i=0;i<array.size();i++){
            if(array.get(i).getId().equals(id)){
                array.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<UserClass> balance( int balance ){

        ArrayList<UserClass>newArray=new ArrayList<>();
        for(UserClass a:array){
            if(a.getBalance()>=balance){
                newArray.add(a);
            }
        }
        return newArray;
    }

    public ArrayList<UserClass> age(int agee){
        ArrayList<UserClass>newarray=new ArrayList<>();
        for(UserClass ageUser:array){
            if(ageUser.getAge()>=agee){
                newarray.add(ageUser);
            }
        }
        return newarray;
    }


}
