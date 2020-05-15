/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Magasin;

import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceMagasin {
     public ArrayList<Magasin> tasks;
    
    public static ServiceMagasin instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceMagasin() {
         req = new ConnectionRequest();
    }

    public static ServiceMagasin getInstance() {
        if (instance == null) {
            instance = new ServiceMagasin();
        }
        return instance;
    }

   

    public ArrayList<Magasin> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Magasin t = new Magasin();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setName_M(obj.get("nameM").toString());
                t.setAdresse(obj.get("adresse").toString());
                t.setTel(((int)Float.parseFloat(obj.get("tel").toString())));
                
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
    
    public ArrayList<Magasin> getAllMagasins(String name){
        String url = Statics.BASE_URL+"/map/"+name;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
}
