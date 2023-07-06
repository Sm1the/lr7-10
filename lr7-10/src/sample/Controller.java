package sample;

//import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;


public class Controller{

    H2database showMeMethod = new H2database();


    int _selectId;
    public TextField getId;
    public ProgressBar progress;
    public Label showSearch;
    public ListView viewListforH2;

    public void getIdforH2(){
        String getSelectMax;
            //_selectId = Integer.valueOf(getId.getText());
           //String show = showMeMethod.accessSelectId(_selectId);
           //showSearch.setText(show);
           //System.out.print(show);
        getSelectMax = showMeMethod.selectMax();
        showSearch.setText(getSelectMax);
   }

   public void showAllTable(){
       ArrayList<String> getArrayListfromH2database = new ArrayList<String>();
       getArrayListfromH2database.add(String.valueOf(showMeMethod.selectAll()));
       viewListforH2.getItems().add(getArrayListfromH2database);
        //showSearch.setText(String.valueOf(showMeMethod.selectAll()));
   }

   public void clearList(){
       viewListforH2.getItems().clear();
   }










}
