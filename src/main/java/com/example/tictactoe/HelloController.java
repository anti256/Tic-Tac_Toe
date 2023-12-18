package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HelloController {
    @FXML
    private Label label;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane mainWindow;
    @FXML
    ArrayList<ButtonClass> buttonArray = new ArrayList<>();//список всех кнопок
    @FXML
    ArrayList<ButtonClass> compPoints = new ArrayList<>();//клетки компьютера
    @FXML
    ArrayList<ButtonClass> userPoints = new ArrayList<>();//клетки человека
    @FXML
    ArrayList<ButtonClass> possiblePoints = new ArrayList<>();//клетки, доступные для нажатия

    //HashMap<Integer, Integer> compPoints = new HashMap<>();
    //HashMap<Integer, Integer> userPoints = new HashMap<>();
    //ArrayList<Points> userPoints = new ArrayList<>();
    @FXML
    String whoseMove;//чей ход - human или computer

    Random random = new Random();

    @FXML
    void btnClick(ActionEvent event) {
        ButtonClass bc = buttonClassByButton((Button)event.getSource());//элемент ButtonClass соответствующий нажатой кнопке
        if (whoseMove.equals("human")){//если первый ходит человек
            bc.getButton().setStyle("-fx-text-fill: #0000ff");
            bc.setText("X");
            userPoints.add(bc);
            whoseMove = "computer";
        } else {//если первый ходит компьютер
            bc.getButton().setStyle("-fx-text-fill: #ff0000");
            bc.setText("O");
            compPoints.add(bc);
            whoseMove = "human";}
        /*if (whoseMove.equals("human")) {
            ((Button)event.getSource()).
            if (compPoints.contains())
        }*/
        //Button btnEvent = (Button)event.getSource();
        //System.out.println(btnEvent.toString());
        //buttonArray.stream().filter(x->x.getButton().equals(btnEvent)).forEach(x-> System.out.println(x.getButton()));
        //ButtonClass bc = buttonClassByButton(btnEvent);
                //buttonArray.get(buttonArray.indexOf(btnEvent));
        //bc.getButton().setText(Integer.toString(bc.getX(bc.getButton())));
        //((Button)event.getSource()).setText("O");

        /*if (((Button)event.getSource()).getText().equals("X")){
            ((Button)event.getSource()).setText("O");
       ((Button)event.getSource()).setStyle("-fx-text-fill: #ff0000");}
                else {((Button)event.getSource()).setText("X");
            ((Button)event.getSource()).setStyle("-fx-text-fill: #0000ff");}*/

    }

    @FXML
    void initialize(){
        whoseMove = (random.nextInt(100) < 50) ? "human" : "computer";//100 * (int) Math.random()) < 50
        label.setText((whoseMove.equals("human")) ? "Человек первый" : "Компьютер первый");
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Button button = new Button("");
                button.setOnAction(this::btnClick);
                grid.add(button, j, i);
                ButtonClass btnCl = new ButtonClass(button, j, i);
                buttonArray.add(btnCl);
            }
        }
        newGame(null);
    }//end of initialize()

    @FXML
    void newGame(ActionEvent event) {
        whoseMove = (whoseMove.equals("human")) ? "computer": "human";//перещелкиваем игрока
        label.setText((whoseMove.equals("human")) ? "Человек первый" : "Компьютер первый");
        //очищаем игровое поле
        for (ButtonClass btnC: buttonArray
             ) {
            btnC.getButton().setText("");
            btnC.getButton().setStyle("-fx-text-fill: #000000");
        }
        userPoints.clear();
        compPoints.clear();
        possiblePoints.clear();
        possiblePoints.add(buttonArray.get(312));
        possiblePoints.add(buttonArray.get(313));
        possiblePoints.add(buttonArray.get(314));
        possiblePoints.add(buttonArray.get(337));
        possiblePoints.add(buttonArray.get(339));
        possiblePoints.add(buttonArray.get(362));
        possiblePoints.add(buttonArray.get(363));
        possiblePoints.add(buttonArray.get(364));
        /*for (ButtonClass b: possiblePoints
             ) {
            b.getButton().setText("A");
        }*/

       if (whoseMove.equals("human")){//если первый ходит человек
           buttonArray.get(338).getButton().setStyle("-fx-text-fill: #0000ff");
           buttonArray.get(338).setText("X");
           userPoints.add(buttonArray.get(338));
           int cCurr = random.nextInt(possiblePoints.size());//случайный индекс из списка возможных
           ButtonClass posBC = possiblePoints.get(cCurr);//случайный элемент из списка возможных
           posBC.getButton().setStyle("-fx-text-fill: #ff0000");//замена цвета случайному
           posBC.getButton().setText("O");//замена текста случайному
           compPoints.add(posBC);//добавляем случайный в список компьютера
           //в список возможных добавляем элементы вокруг случайного без текста
           searchEmptyButton(buttonArray.indexOf(posBC));
           possiblePoints.remove(cCurr);//удаляем случайного из списка возможных
        } else {//если первый ходит компьютер
           buttonArray.get(338).getButton().setStyle("-fx-text-fill: #ff0000");
           buttonArray.get(338).setText("O");
           compPoints.add(buttonArray.get(338));
        }
        for (ButtonClass b: possiblePoints
        ) {
            b.getButton().setText("A");
        }
       /* buttonArray.stream()
            .filter(ButtonC -> ButtonC.getButton().equals(ButtonC.getButton(13, 13)))
            .forEach(x -> x.setText("X"));

        buttonArray.get(338).setText("O");*/


    //compPoints.add(new Points(13, 13));
    /*whoseMove = "human";
    buttonArray.get(0).getButton().setVisible(true);
    buttonArray.get(0).setText("sdf");*/
    }

    //поиск элемента в buttonArray по кнопке
    ButtonClass buttonClassByButton (Button btn){
        for (ButtonClass bc: buttonArray
             ) {
            if (bc.getButton().equals(btn)) {return bc;}
        }
        return  null;
    }

    //поиск пустых кнопок около отмеченной и добавление их в список которых можно кликнуть
    void searchEmptyButton (int indeX){
        //список возможных адресов вокруг целевого адреса
        int [] ints = new int[] {indeX - 26, indeX - 25, indeX - 24, indeX - 1, indeX +1, indeX + 24, indeX + 25, indeX + 26};
        for (int i = 0; i < ints.length; i++) {//перебор адресов
            ButtonClass currentBC = buttonArray.get(ints[i]);//достаем элемент из buttonArray по текущему адресу
            //если элемент не входит в списки компьютера или человека
            if (!compPoints.contains(currentBC) && !userPoints.contains(currentBC)) {
                possiblePoints.add(currentBC);//добавляем элемент в список возможных
            }
        }
    }

}
