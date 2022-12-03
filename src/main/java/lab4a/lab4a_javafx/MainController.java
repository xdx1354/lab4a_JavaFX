package lab4a.lab4a_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController {


    public ObservableList<PieChart.Data> oList = FXCollections.observableArrayList();
    public ObservableList<Integer> listViewList = FXCollections.observableArrayList();

    @FXML
    TextField textField;
    @FXML
    ListView <Integer> list;
    @FXML
    PieChart pieChart;
    public void  initialize(URL url, ResourceBundle resourceBundle){

    }


    public void addClick(ActionEvent e){ //TODO: trycatch
        System.out.println("add");
        String input = textField.getText();
        Integer number = Integer.valueOf(input);
        oList.add(new PieChart.Data(input,number));

        list.setItems( listViewList);

        textField.setText("");
        createChart();

//        list.getItems().add(list.getItems().size(), number);
//        System.out.println(list.getItems().size());
//        list.edit(list.getItems().size() - 1);

        generateListView(oList,listViewList);
    }

    public void deleteClick(ActionEvent e){ //TODO: trycatch
        int id = list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(id);
        oList.remove(id);
        generateListView(oList,listViewList);
    }


    public void editClick (ActionEvent e){
        int id = list.getSelectionModel().getSelectedIndex();
        String input = textField.getText();
        Integer number = Integer.valueOf(input);


        oList.get(id).setName(input);
        oList.get(id).setPieValue(number);

        generateListView(oList,listViewList);
    }

    public void printList(ActionEvent e){
        System.out.println(oList);
    }

    public void createChart(){
        pieChart.setData(oList);
    }

    public void generateListView (ObservableList<PieChart.Data> oList, ObservableList<Integer> listViewList){
        listViewList.clear();
        for(int i =0; i< oList.size();i++){
            listViewList.add(oList.get(i).pieValueProperty().intValue());

        }
        System.out.println(listViewList);
    }
}

    /*@Override
    public String toString(){
        return PieChart.Data.pieValue;
    }
}*/

