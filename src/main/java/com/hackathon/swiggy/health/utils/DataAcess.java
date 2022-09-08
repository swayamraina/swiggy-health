package com.hackathon.swiggy.health.utils;
import java.io.File;

import java.io.IOException;

import com.hackathon.swiggy.health.vo.TimeSeries;

import com.fasterxml.jackson.databind.*;

public class DataAcess {
    public TimeSeries GetDataObject(String path) throws IOException {

        TimeSeries t=null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                 t = objectMapper.readValue(new File(path), TimeSeries.class);
            }catch (Exception e) {
                System.out.println(e);
            }

             return t;

    }
    public static void main(String args[]) throws IOException {

        DataAcess d=new DataAcess();
        TimeSeries t=d.GetDataObject("/Users/chandu.chebrolu/Documents/GitHub/swiggy-health/src/main/java/com/hackathon/swiggy/health/mockdata/googlefit.json");
        System.out.println("hello");
        System.out.println(t.dayData);

    }

}
