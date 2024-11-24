package com.example.quze.Controller;

import com.example.quze.APiResponse.ApiResponse;
import com.example.quze.Model.Book;
import com.example.quze.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/get")
    public ResponseEntity get(){
        ArrayList<Book>a=service.get();
        return ResponseEntity.status(200).body(a);
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book model, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        service.add(model);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid Book model,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate=service.update(model,id);
        if(isUpdate){
        return ResponseEntity.status(200).body("updated");}
        else return ResponseEntity.status(400).body(new ApiResponse("not found id"));
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        boolean isDelete=service.delete(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }
        else  return ResponseEntity.status(400).body(new ApiResponse("not found id"));
    }

    @GetMapping("/searchName/{name}")

    public ResponseEntity searchName(@PathVariable String name){

        boolean isFound=service.bookName(name);

        if(isFound){
            return ResponseEntity.status(200).body(new ApiResponse("found Name book"));
        }
        else return ResponseEntity.status(400).body(new ApiResponse("not found name book"));
    }

    @GetMapping("/getcategory/{category}")
    public ResponseEntity category(@PathVariable String category){
        ArrayList<Book>a=service.Cot(category);
        return ResponseEntity.status(200).body(new ApiResponse("the match category " +a));

    }

    public ResponseEntity numberpage(@PathVariable int number){

        ArrayList<Book>a=service.page(number);
        return ResponseEntity.status(200).body(new ApiResponse(" this number of pages or above"+ a));

    }
}
