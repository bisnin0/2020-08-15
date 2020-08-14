package java08_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RGBEX extends JFrame implements ChangeListener{
	Font fnt = new Font("����ü", Font.BOLD, 30);
	JLabel rgbLbl = new JLabel("RGB(150,150,150)", JLabel.CENTER);
	int red=150, green=150, blue=150;
	
	//Franme�� ���Ϳ� �� �г� �����
	JPanel centerPane = new JPanel(new BorderLayout()); //�⺻�� FlowLayout
		JPanel rgbColor = new JPanel();
		JPanel rgbSlider = new JPanel(new BorderLayout()); //Red, Green, Blue
		
	//JSlider����
	JPanel colorNamePane = new JPanel(new GridLayout(3,1));
		JLabel[] colorName = {new JLabel("RED"), new JLabel("Green"), new JLabel("BLUE")}; //��ü�� ���� �ٷ� �迭�� ���� �� �ִ�.
	JPanel colorSliderPane = new JPanel(new GridLayout(3,1));
		JSlider[] colorSlider = {new JSlider(), new JSlider(), new JSlider()};
	JPanel colorPane = new JPanel(new GridLayout(3,1));
		Color[] color = {new Color(150,0,0), new Color(0,150,0), new Color(0,0,150)};
		JLabel[] colorLbl = new JLabel[3];
	
	public RGBEX() {
		super("RGB����ǥ");
		rgbLbl.setFont(fnt);
		add("North", rgbLbl);
		
		add(centerPane);
		centerPane.add(rgbColor); //���Ϳ� �������� ��ġ �Ƚᵵ �⺻���� ����.
			rgbColor.setBackground(new Color(red, green, blue));
		centerPane.add("South", rgbSlider);
			rgbSlider.add("West", colorNamePane);
			rgbSlider.add("Center", colorSliderPane);
			rgbSlider.add("East", colorPane);
		for(int i = 0; i<colorName.length; i++) { //3���� �Ȱ��� �迭�̴� �ϳ��� ���� ������ �Ѵ�. // i= 0,1,2
			colorNamePane.add(colorName[i]);
			colorSliderPane.add(colorSlider[i]);
			////����
			colorSlider[i].setMajorTickSpacing(50); //�ִ���
			colorSlider[i].setMinorTickSpacing(5); //��������
			colorSlider[i].setPaintTicks(true); //���ݺ��̱�
			colorSlider[i].setPaintLabels(true); //�󺧺��̱�
			colorSlider[i].addChangeListener(this);
			
			colorLbl[i] = new JLabel("           "); //�� ũ�⶧���� �����̽���
			colorLbl[i].setOpaque(true);
			colorLbl[i].setBackground(color[i]);
			colorPane.add(colorLbl[i]);
			
			
		}
		
		//rgbSlider�� border�����ϱ�. 
		LineBorder lb =new LineBorder(Color.ORANGE, 5, true); //true�� ����.. �ڽ� �׵θ� �ձ۰�.. ������ �⺻ false
		
		TitledBorder tb = new TitledBorder(lb, "Color Slider", TitledBorder.CENTER, TitledBorder.CENTER);
		rgbSlider.setBorder(tb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void stateChanged(ChangeEvent ce) {
		Object obj = ce.getSource();
		if(obj == colorSlider[0]) {
			red = colorSlider[0].getValue();
			colorLbl[0].setBackground(new Color(red,0,0));
		}else if(obj == colorSlider[1]) {
			green = colorSlider[1].getValue();
			colorLbl[1].setBackground(new Color(0,green,0));
		}else if(obj == colorSlider[2]) {
			blue = colorSlider[2].getValue();
			colorLbl[2].setBackground(new Color(0,0,blue));
		}
		
		rgbColor.setBackground(new Color(red, green, blue));
		rgbLbl.setText("RGB("+red+","+green+","+blue+")");
		
	}

	public static void main(String[] args) {
		new RGBEX();
	}

}