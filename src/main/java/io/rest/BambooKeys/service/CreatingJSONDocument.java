
package io.rest.BambooKeys.service;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CreatingJSONDocument {

   private Logger log ;

   public CreatingJSONDocument(Logger log){
      this.log = log ;
   }

   public void overWriteToJsonFile(String putName,Object objectm, String filename){

      JSONObject jsonObject = new JSONObject();
      //Inserting key-value pairs into the json object
      jsonObject.put(putName, objectm);
      log.info("******************************");
      try {
         FileWriter file = new FileWriter(filename);
         
         file.write("\n" + jsonObject.toString());
         log.info("*****************************");
         file.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      log.info("JSON file created: "+jsonObject);
   }
   
}