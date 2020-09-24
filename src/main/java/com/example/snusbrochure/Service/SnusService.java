package com.example.snusbrochure.Service;


import com.example.snusbrochure.Models.Snus;
import com.example.snusbrochure.Repositories.SnusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnusService {

    @Autowired //binder service layer sammen med repository
            SnusRepository snusrepository;

    public void create(Snus snus){
        snusrepository.create(snus);
    }

    public Boolean update(Snus snusfromPost){
        snusrepository.update(snusfromPost);

        return false;

    }

    public List readall(){

        ArrayList<Snus> snusArrayList = new ArrayList<>();
        for(Snus snus : snusrepository.readAll()){
            snusArrayList.add(snus);
        }
        return snusArrayList;
    }



    public void delete(int snusId){snusrepository.delete(snusId);}

    public Snus read2(int snusId){snusrepository.read2(snusId);

    Snus snustoreturn = snusrepository.read2(snusId);

    return snustoreturn;

    }

    public String imagegetter(int snusId){
        String imagelink = snusrepository.readimage(snusId);
        return  imagelink;
    }



}
