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
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class AjouterLocation extends BaseForm {
     
     public AjouterLocation(Form previous,Produit P ,Resources res,User u) {
         super("Newsfeed", BoxLayout.y());

               Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Détails Produits");
        getContentPane().setScrollVisible(false);
              tb.addSearchCommand(e -> {});
        super.addSideMenu(res,u);
         tb.addSearchCommand(e -> {});
        
        Tabs swipe = new Tabs();

        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("b1.jpg"), spacer1, "15 Likes  ", "85 Comments", "Integer ut placerat purued non dignissim neque. ");
        addTab(swipe, res.getImage("lo.jpg"), spacer2, "100 Likes  ", "66 Comments", "Dogs are cute: story at 11");
                
        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();
        
        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for(int iter = 0 ; iter < rbs.length ; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }
                
        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if(!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
        
        Component.setSameSize(radioContainer, spacer1, spacer2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));
        
        ButtonGroup barGroup = new ButtonGroup();
        RadioButton all = RadioButton.createToggle("Ajouter Location", barGroup);
        all.setUIID("SelectBar");
        
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
        
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(1, all),
                FlowLayout.encloseBottom(arrow)
        ));
        
        all.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
           
        });
        
      
        
        // special case for rotation
        addOrientationListener(e -> {
            
        });
         
           
//       String url="http://127.0.0.1/pide/web/images/"+P.getImage();
//            Image imgs = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE);
//           ImageViewer  img = new ImageViewer(imgs);
          
           
       
               
          
            
              setTitle("Add a new Location");
        setLayout(BoxLayout.y());
        
        TextField tfid_produit = new TextField("","Reference produit");
        tfid_produit.setText(P.getRef_produit());
        tfid_produit.setEditable(false);
        TextField tfid_client= new TextField("", "Client");
        
        tfid_client.setText(u.getUsername());
        tfid_client.setEditable(false);
        tfid_produit.setEditable(false);
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
        
        Button btnValider = new Button("Ajouter");
        
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
                Date today = new Date( );
                
                if ((tfid_client.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else if(Montant.getText().length() ==0 ||(debut.getDate().getTime()-today.getTime()<0)){
                     Dialog.show("Alert", "erreur date", new Command("OK"));
                    
                }else
                {
                    try {
                       
                        
                         Date d1 = debut.getDate();
                         Date d2 = fin.getDate();
                       //  SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

                         // String dateFormat = dateformat.format(new Date(debut.getYear(), debut.getMonth(), debut.getDayOfMonth()));
                         //Date date_deb=Date.valueOf(d1);
                         //Date date_fin=Date.valueOf(d2);
                         Produit p = new Produit();
                         p.setId(P.getId());
                         User c = new User();
                         c.setId(u.getId());
                         double mo = Double.parseDouble(Montant.getText());
                        Location t = new Location(d1,d2,mo,p,c);
                       
                           
                           new PaiementOrder(t).show();
                            
                            
                       
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfid_produit,tfid_client,debut,fin,prix_h,Montant,btnValider);
       
       
    }
      
       
   private void addTab(Tabs swipe, Image img, Label spacer, String likesStr, String commentsStr, String text) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        if(img.getHeight() < size) {
            img = img.scaledHeight(size);
        }
        Label likes = new Label(likesStr);
        Style heartStyle = new Style(likes.getUnselectedStyle());
        heartStyle.setFgColor(0xff2d55);
        FontImage heartImage = FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, heartStyle);
        likes.setIcon(heartImage);
        likes.setTextPosition(RIGHT);

        Label comments = new Label(commentsStr);
        FontImage.setMaterialIcon(comments, FontImage.MATERIAL_CHAT);
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 2) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        ScaleImageLabel image = new ScaleImageLabel(img);
        image.setUIID("Container");
        image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Label overlay = new Label(" ", "ImageOverlay");
        
        Container page1 = 
            LayeredLayout.encloseIn(
                image,
                overlay,
                BorderLayout.south(
                    BoxLayout.encloseY(
                            new SpanLabel(text, "LargeWhiteText"),
                            FlowLayout.encloseIn(likes, comments),
                            spacer
                        )
                )
            );

        swipe.addTab("", page1);
    }
           
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    } 
     private void bindButtonSelection(Button b, Label arrow) {
        b.addActionListener(e -> {
            if(b.isSelected()) {
                
            }
        });
    }
    
}
