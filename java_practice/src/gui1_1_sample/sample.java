package gui1_1_sample;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
public class sample extends Frame { 
    //���C��
    public static void main(String[] args) {
        new sample(); 
    } 
    //�R���X�g���N�^ 
    public sample(){
        Label label1;      //���x���錾
        Button button1;    //�{�^���錾  
        setLayout(null);                       //���C�A�E�g�̓v���O�����Ŏw�� 
        setSize(200,150);                      //�E�C���h�E�̃T�C�Y 
        label1 = new Label("Hello Java !!");   //hello Java"�̃��x������� 
        button1 = new Button("Click");         //Click�Ƃ����\���̂����{�^�������
        label1.setBounds(20,40,160,20);        //���x���̔z�u x y�̈ʒu�Ɖ��c�̑傫�� 
        label1.setBackground(Color.magenta);
        button1.setBounds(50,80,100,30);       //�{�^���̔z�u�ƃT�C�Y 
        button1.setBackground(Color.cyan);
        add(label1);            //���x�����t���[���ɔz�u 
        add(button1);           //�{�^�����t���[���ɔz�u
        setVisible(true);       //�t���[����\������ 
    }
}