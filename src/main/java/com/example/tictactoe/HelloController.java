package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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
import java.util.Optional;
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

    @FXML
    String whoseMove;//чей ход - human или computer

    Random random = new Random();

    @FXML
    void btnClick(ActionEvent event) {
        ButtonClass bc = buttonClassByButton((Button)event.getSource());//элемент ButtonClass соответствующий нажатой кнопке
        if (possiblePoints.contains(bc)){
            bc.getButton().setStyle("-fx-text-fill: #0000ff");
            bc.setText("X");
            userPoints.add(bc);
            searchEmptyButton(buttonArray.indexOf(bc));
            //whoseMove = "computer";
            if (findWinner(userPoints, bc)) {showAlertWithoutHeaderText("Вы выиграли!");
            } else {
            compStep();}
        }
    }

    //показ окна выиграл/проиграл
    private void showAlertWithoutHeaderText(String stroka) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(stroka);

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(stroka);

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            System.out.println("alert1 " + whoseMove);
            newGame();
            System.out.println("alert2 " + whoseMove);}

        //alert.showAndWait();

    }

    //@FXML
    void compStep(){
        ButtonClass compSt = possiblePoints.get(random.nextInt(possiblePoints.size()));
        compSt.getButton().setStyle("-fx-text-fill: #ff0000");
        compSt.setText("O");
        compPoints.add(compSt);
        searchEmptyButton(buttonArray.indexOf(compSt));
        if (findWinner(compPoints, compSt)) {showAlertWithoutHeaderText("Вы проиграли!");}
        //else {whoseMove = "human";}
    }

    //определение есть ли победитель
    Boolean findWinner (ArrayList<ButtonClass> arr, ButtonClass btWin){
        int buttonArrayIndex = buttonArray.indexOf(btWin);//индекс аргумента в списке buttonArray
        //first direction - horizontal
        int countWinBtn = 0;
        //массив индексов в списке buttonArray
        int[] bcArrayH = new int[] {buttonArrayIndex - 3, buttonArrayIndex - 2, buttonArrayIndex - 1, buttonArrayIndex,
                                    buttonArrayIndex + 1, buttonArrayIndex + 2, buttonArrayIndex + 3};
        for (int i = 0; i < 7; i++) {
            if (bcArrayH[i] < 0 || bcArrayH[i] > 624) break;
            if (arr.contains(buttonArray.get(bcArrayH[i]))){countWinBtn++;} else countWinBtn = 0;
            if (countWinBtn == 4) return true;
        }
        //second direction - vertical
        countWinBtn = 0;
        int[] bcArrayV = new int[] {buttonArrayIndex - 75, buttonArrayIndex - 50, buttonArrayIndex - 25, buttonArrayIndex,
                buttonArrayIndex + 25, buttonArrayIndex + 50, buttonArrayIndex + 75};
        for (int i = 0; i < 7; i++) {
            if (bcArrayV[i] < 0 || bcArrayV[i] > 624) break;
            if (arr.contains(buttonArray.get(bcArrayV[i]))){countWinBtn++;} else countWinBtn = 0;
            if (countWinBtn == 4) return true;
        }
        //third direction - left_top - right_bottom
        countWinBtn = 0;
        int[] bcArrayLT = new int[] {buttonArrayIndex - 78, buttonArrayIndex - 52, buttonArrayIndex - 26, buttonArrayIndex,
                buttonArrayIndex + 26, buttonArrayIndex + 52, buttonArrayIndex + 78};
        for (int i = 0; i < 7; i++) {
            if (bcArrayLT[i] < 0 || bcArrayLT[i] > 624) break;
            if (arr.contains(buttonArray.get(bcArrayLT[i]))){countWinBtn++;} else countWinBtn = 0;
            if (countWinBtn == 4) return true;
        }
        //third direction -  left_bottom - right_top
        countWinBtn = 0;
        int[] bcArrayLB = new int[] {buttonArrayIndex + 72, buttonArrayIndex + 48, buttonArrayIndex + 24, buttonArrayIndex,
                buttonArrayIndex - 24, buttonArrayIndex - 48, buttonArrayIndex - 72};
        for (int i = 0; i < 7; i++) {
            if (bcArrayLB[i] < 0 || bcArrayLB[i] > 624) break;
            if (arr.contains(buttonArray.get(bcArrayLB[i]))){countWinBtn++;} else countWinBtn = 0;
            if (countWinBtn == 4) return true;
        }
        return false;
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
        newGame();
    }//end of initialize()

    @FXML
    void newGame() {
        whoseMove = (whoseMove.equals("human")) ? "computer": "human";//перещелкиваем игрока
        label.setText((whoseMove.equals("human")) ? "Человек первый" : "Компьютер первый");
        System.out.println(whoseMove);
        //очищаем игровое поле
        for (ButtonClass btnC: buttonArray
             ) {
            btnC.getButton().setText("");
            btnC.getButton().setStyle("-fx-text-fill: #000000");
        }
        userPoints.clear();
        compPoints.clear();
        possiblePoints.clear();
        possiblePoints.add(buttonArray.get(338));
        searchEmptyButton(338);

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
        } else {//если первый ходит компьютер
           buttonArray.get(338).getButton().setStyle("-fx-text-fill: #ff0000");
           buttonArray.get(338).setText("O");
           compPoints.add(buttonArray.get(338));
        }
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
    void searchEmptyButton (int indeX){//на входе индекс из buttonArray
        //System.out.println("на входе " + buttonArray.get(indeX));
        //список возможных адресов вокруг целевого адреса
        int [] ints = new int[] {indeX - 26, indeX - 25, indeX - 24, indeX - 1, indeX +1, indeX + 24, indeX + 25, indeX + 26};
        for (int i = 0; i < ints.length; i++) {//перебор адресов
            if (ints[i] < 0 || ints[i] > 624) break;
            ButtonClass currentBC = buttonArray.get(ints[i]);//достаем элемент из buttonArray по текущему адресу
            //если элемент не входит в списки компьютера или человека
            if (!compPoints.contains(currentBC) && !userPoints.contains(currentBC) && !possiblePoints.contains(currentBC)) {
                possiblePoints.add(currentBC);//добавляем элемент в список возможных
            }
        }
        //System.out.println("на выходе " + possiblePoints.get(possiblePoints.indexOf(buttonArray.get(indeX))));
        //System.out.println("до " + possiblePoints.size());
        possiblePoints.remove(possiblePoints.get(possiblePoints.indexOf(buttonArray.get(indeX))));
        //System.out.println("после " + possiblePoints.size());
        for (ButtonClass b: possiblePoints
        ) {
            b.getButton().setText("A");
        }
    }

}
