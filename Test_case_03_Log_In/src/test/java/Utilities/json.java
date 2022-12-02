package Utilities;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class json {
    public JSONObject json;
    public String json_file = "";
    public String path;

    public json(String path) {
        //save el path sent en our path variable
        this.path = path;
        //call read method
        read();
    }

    public void  read() {
        //read the path of our jsonfile.json
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            //auxility variable
            String Line;
            //read line by line our json file
            while ((Line = read.readLine()) != null) {
                //save each line of our json file in json_file variable
                this.json_file += Line;

            }
            /*If there is an error*/
            } catch (IOException e) {
            //json_file is empty
           this.json_file="{}";
           //display this message
           System.err.println("No pude leer esto lo siento");
        }
        //we pass the variable json_file to our JSONObject
        json=new JSONObject(this.json_file);
    }
    //method to acces to elements of our jsonfile.json
    public String getDato(String dato){

        return json.get(dato).toString();
    }
}
