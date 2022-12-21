package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;
import ru.appline.logic.SsModel;
import ru.appline.logic.StoronaSveta;

import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController


public class Controller {
    private static final PetModel petModel= PetModel.getInstance();
    private static final SsModel ssModel= SsModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);
    private static final AtomicInteger newId2 = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json",produces = "application/json")
    public String createPet(@RequestBody Pet pet){
        petModel.add(pet,newId.getAndIncrement());
        String a = "Вы создали питомца" ;
        return a;

    }
    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer,Pet> getAll(){
        return petModel.getAll();

    }
    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String,Integer> id){
    return petModel.getFromList(id.get("id"));
    }
    @DeleteMapping(value ="/delete",consumes = "application/json",produces = "application/json")
    public String delPet(@RequestBody Map<String,Integer> id){
        petModel.del(id.get("id"));
        String a = "Вы удалили питомца" ;
        return a;
    }
    @PutMapping(value = "/putPet", consumes = "application/json",produces = "application/json")
    public String putPet(@RequestBody Pet pet, Map<String,Integer> id){
        petModel.change(pet,id.get("id"));
        String a = "Вы изменили питомца" ;
        return a;

    }
    @PostMapping(value = "/createSs", consumes = "application/json",produces = "application/json")
    public String createSs(@RequestBody StoronaSveta storonaSveta){
        ssModel.add(storonaSveta,newId2.getAndIncrement());
        String a = "Вы указали сторону света" ;
        return a;
    }
    @GetMapping(value = "/getSs", produces = "application/json")
        public String getSs(@RequestBody Map<String,Integer> degree){
            for (int count=1;count<=ssModel.getFromList().size();count++){
                StoronaSveta ss = ssModel.getFromList(count);
                if (degree>=ss.getLow() && degree<=ss.getHigh()){
                    String s = "Storona sveta: " + ss.getName();
                    return s;
                    break;
                }
                else{
                    String z = "Ошибка";
                    return z;
                }


            }

        }




}
