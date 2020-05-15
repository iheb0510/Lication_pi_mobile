package com.codename1.uikit.cleanmodern;

import Entities.Location;
import Entities.User;
import Services.ServiceLocation;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;


import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author arche
 */
public class Detail extends BaseForm {
      public Detail(Form previous,Location P, Resources res,User u) throws IOException {

            
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
        RadioButton all = RadioButton.createToggle("Blog List", barGroup);
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
          
           
       
               
          
            
               Label Description = new Label(P.getP().getPrix_heure()+"  ");
               Label LieuEvenement = new Label(P.getP().getRef_produit()+ "");
               Label Etat = new Label(P.getMontant()+ "");
               Label start = new Label(P.getStart_l()+ "");
               Label end = new Label(P.getEnd_l()+ "");
               //Label email = new Label(P.getEmail()+ "");
               // Label date  = new Label(P.getDate()+ "");
                         Container C = new Container(BoxLayout.yCenter());
                         C.add(Description).add(LieuEvenement).add(Etat).add(start).add(end);
                         
                        // c1.add(img).add(C);
 
                     //  Button valide = new Button("Telecharger");
//                          Button rec = new Button("PasserReclamation");
    getToolbar().addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());


   //valide.addPointerPressedListener(e -> {
    //System.out.println("aa");
          ////  Dialog.show("Alert", "http://localhost/pidev_integration/web/uploads/brochures/"+P.getLien(),new Command("OK"));
                      //   ServiceProduits.getInstance().Contacter(P); 
                        //   previous.showBack();
                      //  Form hi = new Form("Browser", new BorderLayout());
//BrowserComponent browser = new BrowserComponent();
//browser.setURL("http://localhost/pidev_integration/web/uploads/brochures/bf8205a380b9b9a109c3dba3189410fa-5e5711dc7540d.pdf");
//Form hi = new Form("PDF Viewer", BoxLayout.y());
//  FileSystemStorage fs = FileSystemStorage.getInstance();
//    String fileName = fs.getAppHomePath() + "pdf-sample.pdf";
//    if(!fs.exists(fileName)) {
//        Util.downloadUrlToFile("http://localhost/pidev_integration/web/uploads/brochures/"+P.getLien(), fileName, true);
//    }
//    Display.getInstance().execute(fileName);
//   
//     
     //} );                         
add(C);
       
       
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


