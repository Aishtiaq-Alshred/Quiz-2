package com.example.quze.Controller;

import com.example.quze.APiResponse.ApiResponse;
import com.example.quze.Model.UserClass;
import com.example.quze.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/User")
@RequiredArgsConstructor
public class UserController {

    private final UserService servise;

    @GetMapping("/get")
    public ResponseEntity get(){

        ArrayList<UserClass>a=servise.get();
        return ResponseEntity.status(200).body(a);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid UserClass model, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        servise.add(model);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }


    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid UserClass model,Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate=servise.update(model,id);

        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }
        else return ResponseEntity.status(400).body(new ApiResponse("not found id"));
    }


    @DeleteMapping("/delet/{id}")
    public ResponseEntity delete(@PathVariable String id){

        boolean isDelete=servise.delete(id);

        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }
        else return ResponseEntity.status(400).body(new ApiResponse("not found id"));
    }


    @GetMapping("balance/{b}")
    public ResponseEntity bal(@PathVariable int b){

        ArrayList<UserClass>a=servise.balance(b);
        return ResponseEntity.status(200).body(new ApiResponse("this balance or above"+a));

    }

    @GetMapping("/searchAge/{ageU}")
    public ResponseEntity age(@PathVariable int ageU){

        ArrayList<UserClass>New=servise.age(ageU);
        return ResponseEntity.status(200).body(new ApiResponse("this age or above" +New));
    }
}
