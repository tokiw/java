package ex22_15;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Calculator extends JFrame implements ActionListener, MouseListener {
	private GridBagLayout basicCalLayout = new GridBagLayout();
	private GridBagLayout numbersLayout = new GridBagLayout();
	private GridBagLayout textFieldsLayout = new GridBagLayout();

	
	private JPanel basicCalculatorPanel = new JPanel(basicCalLayout);
	private JPanel methodsPanel = new JPanel();
	private JPanel numbersPanel = new JPanel(numbersLayout);
	private JPanel textFieldsPanel = new JPanel(textFieldsLayout);
	
	private JLabel result = new JLabel("結果");
	private JLabel methodType = new JLabel();
	private JTextField leftNumber = new JTextField("");
	private JTextField rightNumber = new JTextField("");
	
	private DefaultListModel methodsModel = new DefaultListModel();
	private JList<String> methodsList = new JList<>(methodsModel);
	private JScrollPane spMethods = new JScrollPane();
	private Method[] methods;
	private JButton zero = new JButton("0");
	private JButton one = new JButton("1");
	private JButton two = new JButton("2");
	private JButton three = new JButton("3");
	private JButton four = new JButton("4");
	private JButton five = new JButton("5");
	private JButton six = new JButton("6");
	private JButton seven = new JButton("7");
	private JButton eight = new JButton("8");
	private JButton nine = new JButton("9");
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton multiplication = new JButton("×");
	private JButton division = new JButton("÷");
	private JButton equal = new JButton("=");
	private JButton surplus = new JButton("%");
	private JButton allClear = new JButton("AC");
	private JButton dot = new JButton(".");
	private JButton goLeft = new JButton("←");
	private JButton goRight = new JButton("→");
	
	private JTextField focusField = leftNumber;
	private static Method actionMethod;
	
	
	private Calculator() {
		setSize(new Dimension(580, 300));
		setLocationRelativeTo(null);
		GridBagLayout frameLayout = new GridBagLayout();
		GridBagConstraints frameConstraints = new GridBagConstraints();
		GridBagConstraints basicCalConstraints = new GridBagConstraints();
		
		setLayout(frameLayout);
		setResizable(false);
		initializeMethodsList();
				
		basicCalculatorPanel.setPreferredSize(new Dimension(250, 250));
		setConstraints(frameConstraints, 0, 0);
		frameLayout.setConstraints(basicCalculatorPanel, frameConstraints);
		
		initializeTextFieldsPanel();
		initializeNumbersPanel();
		
		setConstraints(basicCalConstraints, 0, 0);
		basicCalLayout.setConstraints(textFieldsPanel, basicCalConstraints);
		basicCalculatorPanel.add(textFieldsPanel);
		
		setConstraints(basicCalConstraints, 0, 1);
		basicCalLayout.setConstraints(numbersPanel, basicCalConstraints);
		basicCalculatorPanel.add(numbersPanel);
		
		methodsPanel.setPreferredSize(new Dimension(320, 250));
		spMethods.setPreferredSize(new Dimension(320, 240));
		setConstraints(frameConstraints, 1, 0);
		frameLayout.setConstraints(methodsPanel, frameConstraints);
		
		spMethods.getViewport().setView(methodsList);
		methodsList.addMouseListener(this);
		methodsPanel.add(spMethods);
		
		add(basicCalculatorPanel);
		add(methodsPanel);
		
		this.addWindowListener(new myWindowAdapter());
	}
	
	
	@Override
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == zero) {
			focusField.setText(focusField.getText() + zero.getText());
		}else if (obj == one) {
			focusField.setText(focusField.getText() + one.getText());
		}else if (obj == two) {
			focusField.setText(focusField.getText() + two.getText());
		}else if (obj == three) {
			focusField.setText(focusField.getText() + three.getText());
		}else if (obj == four) {
			focusField.setText(focusField.getText() + four.getText());
		}else if (obj == five) {
			focusField.setText(focusField.getText() + five.getText());
		}else if (obj == six) {
			focusField.setText(focusField.getText() + six.getText());
		}else if (obj == seven) {
			focusField.setText(focusField.getText() + seven.getText());
		}else if (obj == eight) {
			focusField.setText(focusField.getText() + eight.getText());
		}else if (obj == nine) {
			focusField.setText(focusField.getText() + nine.getText());
		}else if (obj == goLeft) {
			focusField = leftNumber;
			leftNumber.setBorder(new LineBorder(Color.red, 2, true));
			rightNumber.setBorder(new LineBorder(Color.gray, 1, true));
		}else if (obj == goRight) {
			focusField = rightNumber;
			leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
			rightNumber.setBorder(new LineBorder(Color.red, 2, true));
		}else if (obj == allClear) {
			focusField.setText("");
		}else if (obj == dot) {
			focusField.setText(focusField.getText() + dot.getText());
		}else if (obj == minus) {
			if (focusField.getText().equals("")) {
				focusField.setText(minus.getText());
			}else {
				methodType.setText(minus.getText());
				focusField = rightNumber;
				leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
				rightNumber.setBorder(new LineBorder(Color.red, 2, true));
				goRight.setEnabled(true);
			}
		}else if (obj == plus) {
			methodType.setText(plus.getText());
			focusField = rightNumber;
			leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
			rightNumber.setBorder(new LineBorder(Color.red, 2, true));
			goRight.setEnabled(true);
		}else if (obj == multiplication) {
			methodType.setText(multiplication.getText());
			focusField = rightNumber;
			leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
			rightNumber.setBorder(new LineBorder(Color.red, 2, true));
			goRight.setEnabled(true);
		}else if (obj == surplus) {
			methodType.setText(surplus.getText());
			focusField = rightNumber;
			leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
			rightNumber.setBorder(new LineBorder(Color.red, 2, true));
			goRight.setEnabled(true);
		}else if (obj == division) {
			methodType.setText(division.getText());
			focusField = rightNumber;
			leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
			rightNumber.setBorder(new LineBorder(Color.red, 2, true));
			goRight.setEnabled(true);
		}else if (obj == equal) {
			callMethod();
		}
	}
	
	private void initializeNumbersPanel() {
		GridBagConstraints numbersConstraints = new GridBagConstraints();
		
		setConstraints(numbersConstraints, 0, 0);
		numbersLayout.setConstraints(goLeft, numbersConstraints);
		
		setConstraints(numbersConstraints, 1, 0);
		numbersLayout.setConstraints(goRight, numbersConstraints);
		
		setConstraints(numbersConstraints, 2, 0);
		numbersConstraints.gridwidth = 2;
		numbersLayout.setConstraints(allClear, numbersConstraints);
		
		setConstraints(numbersConstraints, 0, 1);
		numbersConstraints.gridwidth = 1;
		numbersLayout.setConstraints(seven, numbersConstraints);
		
		setConstraints(numbersConstraints, 1, 1);
		numbersLayout.setConstraints(eight, numbersConstraints);
		
		setConstraints(numbersConstraints, 2, 1);
		numbersLayout.setConstraints(nine, numbersConstraints);
		
		setConstraints(numbersConstraints, 3, 1);
		numbersLayout.setConstraints(surplus, numbersConstraints);
		
		setConstraints(numbersConstraints, 0, 2);
		numbersLayout.setConstraints(four, numbersConstraints);
		
		setConstraints(numbersConstraints, 1, 2);
		numbersLayout.setConstraints(five, numbersConstraints);
		
		setConstraints(numbersConstraints, 2, 2);
		numbersLayout.setConstraints(six, numbersConstraints);
		
		setConstraints(numbersConstraints, 3, 2);
		numbersLayout.setConstraints(division, numbersConstraints);
		
		setConstraints(numbersConstraints, 0, 3);
		numbersLayout.setConstraints(one, numbersConstraints);
		
		setConstraints(numbersConstraints, 1, 3);
		numbersLayout.setConstraints(two, numbersConstraints);
		
		setConstraints(numbersConstraints, 2, 3);
		numbersLayout.setConstraints(three, numbersConstraints);
		
		setConstraints(numbersConstraints, 3, 3);
		numbersLayout.setConstraints(multiplication, numbersConstraints);
		
		setConstraints(numbersConstraints, 0, 4);
		numbersConstraints.gridwidth = 2;
		numbersLayout.setConstraints(zero, numbersConstraints);
		
		setConstraints(numbersConstraints, 2, 4);
		numbersConstraints.gridwidth = 1;
		numbersLayout.setConstraints(dot, numbersConstraints);
		
		setConstraints(numbersConstraints, 3, 4);
		numbersLayout.setConstraints(minus, numbersConstraints);
		
		setConstraints(numbersConstraints, 0, 5);
		numbersConstraints.gridwidth = 3;
		numbersLayout.setConstraints(equal, numbersConstraints);
		
		setConstraints(numbersConstraints, 3, 5);
		numbersConstraints.gridwidth = 1;
		numbersLayout.setConstraints(plus, numbersConstraints);
		
		
		goLeft.setPreferredSize(new Dimension(50,30));
		goRight.setPreferredSize(new Dimension(50,30));
		allClear.setPreferredSize(new Dimension(100,30));
		zero.setPreferredSize(new Dimension(100,30));
		one.setPreferredSize(new Dimension(50,30));
		two.setPreferredSize(new Dimension(50,30));
		three.setPreferredSize(new Dimension(50,30));
		four.setPreferredSize(new Dimension(50,30));
		five.setPreferredSize(new Dimension(50,30));
		six.setPreferredSize(new Dimension(50,30));
		seven.setPreferredSize(new Dimension(50,30));
		eight.setPreferredSize(new Dimension(50,30));
		nine.setPreferredSize(new Dimension(50,30));
		equal.setPreferredSize(new Dimension(150,30));
		dot.setPreferredSize(new Dimension(50,30));
		plus.setPreferredSize(new Dimension(50,30));
		minus.setPreferredSize(new Dimension(50,30));
		multiplication.setPreferredSize(new Dimension(50,30));
		division.setPreferredSize(new Dimension(50,30));
		surplus.setPreferredSize(new Dimension(50,30));
		
		
		numbersPanel.add(goLeft);
		numbersPanel.add(goRight);
		numbersPanel.add(allClear);
		numbersPanel.add(zero);
		numbersPanel.add(one);
		numbersPanel.add(two);
		numbersPanel.add(three);
		numbersPanel.add(four);
		numbersPanel.add(five);
		numbersPanel.add(six);
		numbersPanel.add(seven);
		numbersPanel.add(eight);
		numbersPanel.add(nine);
		numbersPanel.add(dot);
		numbersPanel.add(equal);
		numbersPanel.add(surplus);
		numbersPanel.add(division);
		numbersPanel.add(multiplication);
		numbersPanel.add(minus);
		numbersPanel.add(plus);
		
		goLeft.addActionListener(this);
		goRight.addActionListener(this);
		allClear.addActionListener(this);
		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		dot.addActionListener(this);
		equal.addActionListener(this);
		surplus.addActionListener(this);
		division.addActionListener(this);
		multiplication.addActionListener(this);
		minus.addActionListener(this);
		plus.addActionListener(this);
		
	}
	
	private void initializeTextFieldsPanel() {
		GridBagConstraints textFieldsConstraints = new GridBagConstraints();

		result.setPreferredSize(new Dimension(200, 40));
		setConstraints(textFieldsConstraints, 0, 0);
		textFieldsConstraints.gridwidth = 3;
		textFieldsLayout.setConstraints(result, textFieldsConstraints);
		result.setBorder(new LineBorder(Color.blue, 1, true));
		
		
		leftNumber.setPreferredSize(new Dimension(80, 30));
		leftNumber.setHorizontalAlignment(JTextField.RIGHT);
		leftNumber.setEditable(false);
		leftNumber.setBorder(new LineBorder(Color.red, 2, true));
		setConstraints(textFieldsConstraints, 0, 1);
		textFieldsConstraints.gridwidth = 1;
		textFieldsLayout.setConstraints(leftNumber, textFieldsConstraints);
		
		methodType.setPreferredSize(new Dimension(40, 30));
		methodType.setHorizontalAlignment(JLabel.CENTER);
		setConstraints(textFieldsConstraints, 1, 1);
		textFieldsLayout.setConstraints(methodType, textFieldsConstraints);
		
		rightNumber.setPreferredSize(new Dimension(80, 30));
		rightNumber.setHorizontalAlignment(JTextField.RIGHT);
		rightNumber.setEditable(false);
		rightNumber.setBorder(new LineBorder(Color.gray, 1, true));
		setConstraints(textFieldsConstraints, 2, 1);
		textFieldsLayout.setConstraints(rightNumber, textFieldsConstraints);
		
		textFieldsPanel.add(result);
		textFieldsPanel.add(methodType);
		textFieldsPanel.add(leftNumber);
		textFieldsPanel.add(rightNumber);
	}
	
	private void initializeMethodsList() {
		methods = Math.class.getMethods();
		Arrays.sort(methods, new MemberComparator());
		for (Method m : methods) {
			String str = Modifier.toString(m.getModifiers()) + " ";
			str += m.getReturnType().getSimpleName() + " " + m.getName() + " (";
			
			if(m.getParameterTypes().length > 0) {
				for(Class<?> a : m.getParameterTypes()){
					str += a;
					str += ", ";
				}
				str = str.substring(0, str.length()-2);
			}
			str += ")";
			methodsModel.addElement(str);
		}
	}
	
	void setConstraints(GridBagConstraints constraints, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
	}
	
	private static long addNumber(long left, long right) { 
		return left + right;
	}
	
	private static double addNumber(double left, double right) { 
		return left + right;
	}
	
	private static long substractNumber(long left, long right) { 
		return left - right;
	}
	
	private static double substractNumber(double left, double right) { 
		return left - right;
	}
	
	private static long multipleNumber(long left, long right) { 
		return left * right;
	}
	
	private static double multipleNumber(double left, double right) { 
		return left * right;
	}
	
	private static long divideNumber(long left, long right) { 
		return left / right;
	}
	
	private static double divideNumber(double left, double right) { 
		return left / right;
	}
	
	private static long surplusNumber(long left, long right) { 
		return left % right;
	}
	
	private static double surplusNumber(double left, double right) { 
		return left % right;
	}
	
	private void callMethod() {
		String str = methodType.getText();
		if (str.equals("+") || str.equals("-") || str.equals("×") || str.equals("÷") || str.equals("%")) {
			result.setText(callBasicMethod(str).toString());
		}else {
			try {
				Class<?>[] argTypes = actionMethod.getParameterTypes();
				Object[] args = new Object[argTypes.length];
				for (int i = 0; i < argTypes.length; i++) {
					if (argTypes[i].equals(double.class)) {
						if (i == 0) {
							args[i] = Double.valueOf(leftNumber.getText());
						}else {
							args[i] = Double.valueOf(rightNumber.getText());
						}
					}else if (argTypes[i].equals(float.class)) {
						if (i == 0) {
						args[i] = Float.valueOf(leftNumber.getText());
					}else {
							args[i] = Float.valueOf(rightNumber.getText());
						}
					}else if(argTypes[i].equals(int.class)) {
						if (i == 0) {
						args[i] = Integer.valueOf(leftNumber.getText());
					}else {
							args[i] = Integer.valueOf(rightNumber.getText());
						}
					}
				}
			result.setText(actionMethod.invoke(null, args).toString());
		} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NullPointerException e) {
				// TODO 自動生成された catch ブロック
				result.setText("エラー");
			}
		}
	}
	
	private Object callBasicMethod(String method) {
		switch (method) {
			case "+":
				return addNumber(Double.valueOf(leftNumber.getText()), Double.valueOf(rightNumber.getText()));
			case "-":
				return substractNumber(Double.valueOf(leftNumber.getText()), Double.valueOf(rightNumber.getText()));
			case "×":
				return multipleNumber(Double.valueOf(leftNumber.getText()), Double.valueOf(rightNumber.getText()));
			case "÷":
				return divideNumber(Double.valueOf(leftNumber.getText()), Double.valueOf(rightNumber.getText()));
			case "%":
				return surplusNumber(Double.valueOf(leftNumber.getText()), Double.valueOf(rightNumber.getText()));
			default:
				return null;	
		}
	}
		
	public static void main(String args[]){
		Calculator calculator = new Calculator();
		calculator.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getClickCount() == 2) {
			Method method = methods[methodsList.getSelectedIndex()];
			methodType.setText(method.getName());
			actionMethod = method;
			if (method.getParameterTypes().length == 1) {
				goRight.setEnabled(false);
				focusField = leftNumber;
				leftNumber.setBorder(new LineBorder(Color.red, 2, true));
				rightNumber.setBorder(new LineBorder(Color.white, 1, true));
			}else {
				goRight.setEnabled(true);
				focusField = rightNumber;
				leftNumber.setBorder(new LineBorder(Color.gray, 1, true));
				rightNumber.setBorder(new LineBorder(Color.red, 2, true));
			}
			
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}

class myWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}

class MemberComparator implements Comparator<Member> {
	public int compare(Member member1, Member member2) {
		String menberName1 = member1.getName();
		String menberName2 = member2.getName();
		return menberName1.compareTo(menberName2);
	}
}
