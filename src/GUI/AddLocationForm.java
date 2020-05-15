/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Location;
import Entities.Produit;
import Entities.User;
import Services.ServiceLocation;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class AddLocationForm extends BaseForm {
     
     public AddLocationForm(Form previous,Produit P ,Resources res) {
         
        setTitle("Add a new Location");
        setLayout(BoxLayout.y());
        
        TextField tfid_produit = new TextField("","Reference produit");
        tfid_produit.setText(P.getRef_produit());
        tfid_produit.setEditable(false);
        TextField tfid_client= new TextField("", "Client");
        Picker debut = new Picker();
        debut.setType(Display.PICKER_TYPE_DATE);
         Picker fin = new Picker();
        fin.setType(Display.PICKER_TYPE_DATE);
        
        TextField prix_h = new TextField("","Prix heure");
        String f = String.valueOf(P.getPrix_heure());
        prix_h.setText(f);
        prix_h.setEditable(false);
         TextField Montant = new TextField("","Montant");
        Montant.setEditable(false);
        
        Button btnValider = new Button("Add task");
        
        ServiceLocation lo = new ServiceLocation();
        
        debut.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent evt) {   
                 if((debut.getValue().toString()!= "") && (fin.getValue().toString()!= "")){
        
        double diffheure = lo.difference(debut.getDate(), fin.getDate());
           if(diffheure>0){
               
               double calcul = lo.calculprixloc(P.getPrix_heure(), diffheure);
               String c = String.valueOf(calcul);
                Montant.setText(c);
                
               
    }else{
              Montant.setText("") ; 
           }
    }
            }
        });
        fin.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent evt) {   
                 if((debut.getValue().toString()!= "") && (fin.getValue().toString()!= "")){
        
        double diffheure = lo.difference(debut.getDate(), fin.getDate());
           if(diffheure>0){
               
               double calcul = lo.calculprixloc(P.getPrix_heure(), diffheure);
               String c = String.valueOf(calcul);
                Montant.setText(c);
                
               
    }else{
              Montant.setText("") ; 
           }
    }
            }
        });
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                if ((tfid_client.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else if(Montant.getText().length() ==0){
                     Dialog.show("Alert", "erreur date", new Command("OK"));
                    
                }else
                {
                    try {
                       
                        int idc=Integer.parseInt(tfid_client.getText());
                         Date d1 = debut.getDate();
                         Date d2 = fin.getDate();
                       //  SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

                         // String dateFormat = dateformat.format(new Date(debut.getYear(), debut.getMonth(), debut.getDayOfMonth()));
                         //Date date_deb=Date.valueOf(d1);
                         //Date date_fin=Date.valueOf(d2);
                         Produit p = new Produit();
                         p.setId(P.getId());
                         User c = new User();
                         c.setId(idc);
                         double mo = Double.parseDouble(Montant.getText());
                        Location t = new Location(d1,d2,mo,p,c);
                        if( ServiceLocation.getInstance().addLocation(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfid_produit,tfid_client,debut,Montant,fin,prix_h,btnValider);
      //  getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> res.showBack());
                
    }
    

               
}
