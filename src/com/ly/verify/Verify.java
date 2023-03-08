package com.ly.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Verify {
	public static  String drawRandomText(int width,int height,BufferedImage verifyImg) {
		Graphics2D graphics = (Graphics2D)verifyImg.getGraphics();
		graphics.setColor(Color.WHITE);//���û�����ɫ-��֤�뱳��ɫ
		graphics.fillRect(0, 0, width, height);//��䱳��
		graphics.setFont(new Font("΢���ź�", Font.BOLD, 40));
		//���ֺ���ĸ�����
		String baseNumLetter= "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
 
        StringBuffer sBuffer = new StringBuffer();
        int x = 10;  //��תԭ��� x ����
        String ch = "";
        Random random = new Random();
        for(int i = 0;i < 4;i++){
                 graphics.setColor(getRandomColor());
            //����������ת�Ƕ�
            int degree = random.nextInt() % 30;  //�Ƕ�С��30��
            int dot = random.nextInt(baseNumLetter.length());
            ch = baseNumLetter.charAt(dot) + "";
            sBuffer.append(ch);
            //������ת
            graphics.rotate(degree * Math.PI / 180, x, 45);
            graphics.drawString(ch, x, 45);
            //������ת
            graphics.rotate(-degree * Math.PI / 180, x, 45);
            x += 48;
        }
        //��������
        for (int i = 0; i <6; i++) {
            	// ���������ɫ
                 graphics.setColor(getRandomColor());
                 // �������
                 graphics.drawLine(random.nextInt(width), random.nextInt(height),
                                    random.nextInt(width), random.nextInt(height));
        }
        //������
        for(int i=0;i<30;i++){
                 int x1 = random.nextInt(width);
                 int y1 = random.nextInt(height);
                 graphics.setColor(getRandomColor());
                 graphics.fillRect(x1, y1, 2,2);
                 }
        return sBuffer.toString();
    }
    /**
     * ���ȡɫ
 
     */
    private static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }
}
