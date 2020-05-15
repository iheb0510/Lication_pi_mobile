/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ServiceLocation;
import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
/**
 *
 * @author ASUS
 */
public class ListLocationForm extends Form{
    
      public ListLocationForm(Form previous) {
          
        setTitle("List tasks");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceLocation.getInstance().getAllLocations().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
