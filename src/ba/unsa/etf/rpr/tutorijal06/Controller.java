package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label display;
    private String result="0";
    private String operand="";
    private String operator="";
    private SimpleStringProperty resProp;

    public Controller(){
        resProp = new SimpleStringProperty();
    }

    public SimpleStringProperty resPropProperty(){
        return resProp;
    }

    public String getResProp(){
        return resProp.get();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resProp.set("0");
    }

    public void zero(ActionEvent actionEvent) {
        if(!operand.equals("")){
            operand+="0";
            resProp.set(operand);
        }
    }

    public void one(ActionEvent actionEvent) {
        operand+="1";
        resProp.set(operand);
    }

    public void nine(ActionEvent actionEvent) {
        operand+="9";
        resProp.set(operand);
    }


    public void seven(ActionEvent actionEvent) {
        operand+="7";
        resProp.set(operand);
    }

    public void six(ActionEvent actionEvent) {
        operand+="6";
        resProp.set(operand);
    }

    public void three(ActionEvent actionEvent) {
        operand+="3";
        resProp.set(operand);
    }

    public void five(ActionEvent actionEvent) {
        operand+="5";
        resProp.set(operand);
    }

    public void four(ActionEvent actionEvent) {
        operand+="4";
        resProp.set(operand);
    }

    public void eight(ActionEvent actionEvent) {
        operand+="8";
        resProp.set(operand);
    }

    public void two(ActionEvent actionEvent) {
        operand+="2";
        resProp.set(operand);
    }

    public void plus(ActionEvent actionEvent) {
        if(!operand.equals("")) {
            Double a, b;
            a = Double.parseDouble(result);
            b = Double.parseDouble(operand);
            a += b;
            result = a.toString();
            operand = "";
        }
        resProp.set("0");
        operator="+";
    }

    public void minus(ActionEvent actionEvent) {
        if(operand.equals("")){
            operand+="-";
            resProp.set(operand);
        }else{
            Double a,b;
            a=Double.parseDouble(result);
            b=Double.parseDouble(operand);
            a+=b;
            result=a.toString();
            operand="";
            resProp.set("0");
            operator="-";
        }
    }

    public void divide(ActionEvent actionEvent) {
        operator="/";
        result=operand;
        operand="";
    }

    public void mod(ActionEvent actionEvent) {
        operator="%";
        result=operand;
        operand="";
    }

    public void times(ActionEvent actionEvent) {
        operator="x";
        result=operand;
        operand="";
    }

    public void dot(ActionEvent actionEvent) {
        if(!operand.contains(".")){
            operand+=".";
            resProp.set(operand);
        }
    }

    public void equals(ActionEvent actionEvent) {

        Double a,b;
        a=Double.parseDouble(result);
        result="0";
        if(operand.equals(""))operand="0";
        b=Double.parseDouble(operand);
        operand="";
        switch (operator){
            case "+":
                /*double d=2343.5476;
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("Rounded double (DecimalFormat) : " + df.format(d));
*/
                a+=b;
                resProp.set(a.toString());
                break;
            case "-":
                a-=b;
                resProp.set(a.toString());
                break;
            case "x":
                a*=b;
                double d=a;
                DecimalFormat df=new DecimalFormat("###.##");
                resProp.set(String.valueOf(df.format(d)));
                break;
            case "/":
                if(b==0){
                    resProp.set("Infinity");
                    return;
                }
                a/=b;
                resProp.set(a.toString());
                break;
            case "%":
                a%=b;
                resProp.set(a.toString());
                break;

        }
    }
}