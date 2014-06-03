package gui1_1_sample;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
public class sample extends Frame { 
    //メイン
    public static void main(String[] args) {
        new sample(); 
    } 
    //コンストラクタ 
    public sample(){
        Label label1;      //ラベル宣言
        Button button1;    //ボタン宣言  
        setLayout(null);                       //レイアウトはプログラムで指定 
        setSize(200,150);                      //ウインドウのサイズ 
        label1 = new Label("Hello Java !!");   //hello Java"のラベルを作る 
        button1 = new Button("Click");         //Clickという表示のついたボタンを作る
        label1.setBounds(20,40,160,20);        //ラベルの配置 x yの位置と横縦の大きさ 
        label1.setBackground(Color.magenta);
        button1.setBounds(50,80,100,30);       //ボタンの配置とサイズ 
        button1.setBackground(Color.cyan);
        add(label1);            //ラベルをフレームに配置 
        add(button1);           //ボタンをフレームに配置
        setVisible(true);       //フレームを表示する 
    }
}