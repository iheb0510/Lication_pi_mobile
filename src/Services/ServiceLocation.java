/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Location;
import Entities.Produit;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;


import com.codename1.ui.events.ActionListener;
import java.io.IOException;






import java.util.ArrayList;
import java.util.Date;






import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class ServiceLocation {
    
    public ArrayList<Location> tasks;
    
    public static ServiceLocation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceLocation() {
         req = new ConnectionRequest();
    }

    public static ServiceLocation getInstance() {
        if (instance == null) {
            instance = new ServiceLocation();
        }
        return instance;
    }
    
     public ArrayList<Location> parseLocation(String jsonText) {
        
             try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            for(Map<String,Object> obj : list){
                Location t = new Location();
                float id = Float.parseFloat(obj.get("idLoc").toString());
                                
                t.setId_loc((int)id);
                t.setMontant(Float.parseFloat(obj.get("montant").toString()));
                //Date d1  = Date.valueOf(obj.get("startL").toString());
               // Date d2  = Date.valueOf(obj.get("endL").toString());
               
               
               // Date d1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(obj.get("startL").toString());
                // Date d2=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(obj.get("endL").toString());
                Map<String, Object> date1 = (Map) obj.get("endL");
                
              long dateTimeStamp = (long) (Double.parseDouble(date1.get("timestamp").toString())*1000);
              Date d2 = new Date(dateTimeStamp);
              t.setEnd_l(d2);
                
               
             Map<String, Object> date2 = (Map) obj.get("startL");
                
              long dateTimeStamp2 = (long) (Double.parseDouble(date2.get("timestamp").toString())*1000);
              Date d1 = new Date(dateTimeStamp2);
              t.setStart_l(d1);
                
                
                

                
                Map<String, Object> p = (Map) obj.get("idProduit");
                Produit prod = new Produit();
                 prod.setPrix_heure(Float.parseFloat(p.get("prixHeure").toString()));
                 prod.setRef_produit(p.get("refProduit").toString());
                 t.setP(prod);
                tasks.add(t);
            }
            
             } catch (IOException ex) {
            
        }
        
        return tasks;
    }
    
    public ArrayList<Location> getAllLocations(){
        String url = Statics.BASE_URL+"/listLocation/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                    tasks = parseLocation(new String(req.getResponseData()));
               
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    public ArrayList<Location> getLocationsbyuser(int id){
        String url = Statics.BASE_URL+"/findlocation/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                    tasks = parseLocation(new String(req.getResponseData()));
               
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    public boolean addLocation(Location L) {
        String url = Statics.BASE_URL + "/addLocation/" + L.getP().getId() + "/" + L.getC().getId()+"/" + L.getEnd_l()+"/" + L.getStart_l()+"/" + L.getMontant();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     public double difference(Date start,Date end){
         
        double  diffheure=0;          
         try{
             
          long diff = end.getTime() - start.getTime();

           
           diffheure= (double) diff/3600000;
            
            System.out.println("Total heures : " +diffheure) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
          
      return  diffheure;
     }
     
         public double calculprixloc(double prix_heure ,double diff)
                 
         {
            
             
           double prixlocation= diff*prix_heure ;
             System.out.println("Prix heure location : "+prix_heure);
            System.out.println("Prix TOTAL : "+prixlocation);
            
            
       
     return prixlocation ;
         }
             
    

    
}
