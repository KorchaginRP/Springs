package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SsModel implements Serializable {
    private static final SsModel instance = new SsModel();
    private final Map<Integer,StoronaSveta> model;


    public SsModel(){

        model = new HashMap<Integer, StoronaSveta>();

    }

    public static SsModel getInstance(){

        return instance;
    }
    public void add(StoronaSveta storonaSveta, int id){

        model.put(id,storonaSveta);
    }



    public Map<Integer, StoronaSveta> getFromList(){
        return model;
    }
    public StoronaSveta getFromList(int id){
        return model.get(id);

    }
    public Map<Integer, StoronaSveta> getAll(){

        return model;
    }


}
