package com.global.bookproject.service;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.exception.AutherAlreadyExsistException;
import com.global.bookproject.exception.AutherMinRateException;
import com.global.bookproject.exception.AutherNotFoundException;
import com.global.bookproject.repository.AutherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutherService {

    @Autowired
    private AutherRepo autherRepo;

    public List<Auther> findALl (){
        return autherRepo.findAll();
    }
    public Auther findById(Long id){
        Optional<Auther> tempAuther=autherRepo.findById(id);
        if(tempAuther.isPresent()){
            return tempAuther.get();
        }else {
            throw new AutherNotFoundException("Couldn't found Auther with this ID " + id);
        }
    }
    public Optional<Auther> findByAutherName (String autherName){

        Optional<Auther> tempAuthern = autherRepo.findByAutherName(autherName);
        return tempAuthern;
    }


    public Auther createAuther (Auther auther){

        String authName = auther.getAutherName();
        Optional<Auther> tempAuther = autherRepo.findByAutherName(authName);

        if (auther.getAutherRate() <10){
            throw new AutherMinRateException("Auther rate can not be less than 10");
        }else if (tempAuther.isPresent()){
            throw new AutherAlreadyExsistException("This Auther name already exsits");
        }
        return  autherRepo.save(auther);
    }
    public Auther updateAuther(Auther auther){
        Auther tempAuther = findById(auther.getAutherID());
        tempAuther.setAutherName(auther.getAutherName());
        tempAuther.setAutherRate(auther.getAutherRate());
        return autherRepo.save(tempAuther);
    }
    public void deleteAuther(Long id){
        autherRepo.deleteById(id);
    }

}
