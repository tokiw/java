package Interpreter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Interpreter extends JFrame implements  ActionListener, MouseListener {
	//private static Thread th = new Thread(interpreter);
	private JPanel panelLeft = new JPanel(new FlowLayout());
	private JPanel panelRight = new JPanel(new FlowLayout());
	private JPanel panelNewObject = new JPanel(new FlowLayout());
	private JPanel panelArray = new JPanel(new FlowLayout());
	private JPanel panelMethod = new JPanel(new FlowLayout());
	private JPanel panelField = new JPanel(new FlowLayout());
	private JTabbedPane constructorTab = new JTabbedPane();
	private JTabbedPane listTab = new JTabbedPane();
	
	private final JTextField className = new JTextField(19);
	private final JTextField arrayClass = new JTextField(19);
	private final JTextField arrayNum = new JTextField(10);
	private final JTextField arraySetElement = new JTextField(19);
	private final JTextField constructorArgument = new JTextField(19);
	private final JTextField methodArgument = new JTextField(19);
	private final JTextField fieldValue = new JTextField(19);
	
	private final JLabel msgOfClassInput = new JLabel("クラス名を入力してください");
	private final JLabel msgOfArrayClass = new JLabel("クラス名");
	private final JLabel msgOfArrayNumInput = new JLabel("　要素数");
	private final JLabel msgOfArrayElementInput = new JLabel("値を入力してください");
	private final JLabel msgOfcArgumentsInput = new JLabel("引数を入力してください");
	private final JLabel msgOfmArgumentsInput = new JLabel("引数を入力してください");
	private final JLabel msgOfFieldInput = new JLabel("値を入力してください");
	private final JLabel msgListObject = new JLabel("生成オブジェクト");
	private final JLabel msgSelectObject = new JLabel("選択中のオブジェクト");
	private final JLabel msgListMethod = new JLabel("メソッドを選択してください");
	private JLabel dispSelectObject = new JLabel();
	
	private final JButton btn1 = new JButton("検索");
	private final JButton btn2 = new JButton("生成");
	private final JButton btn3 = new JButton("実行");
	private final JButton btn4 = new JButton("生成");
	private final JButton btn5 = new JButton("変更");
	private final JButton btn6 = new JButton("変更");
	
	private DefaultListModel modelConstructor = new DefaultListModel();
	private DefaultListModel modelArray = new DefaultListModel();
	private DefaultListModel modelMethod = new DefaultListModel();
	private DefaultListModel modelField = new DefaultListModel();
	private DefaultListModel modelObject = new DefaultListModel();
	
	private JList<String> listConstructor = new JList<>(modelConstructor);
	private JList<String> listArray = new JList<>(modelArray);
	private JList<String> listMethod = new JList<>(modelMethod);
	private JList<String> listField = new JList<>(modelField);
	private JList<String> listObject = new JList<>(modelObject);

	private final JScrollPane spConstructor = new JScrollPane();
	private final JScrollPane spArray = new JScrollPane();
	private final JScrollPane spMethod = new JScrollPane();
	private final JScrollPane spField = new JScrollPane();
	private final JScrollPane spObject = new JScrollPane();
	
	private Class<?> createdClass;
	private Constructor<?>[] keepConstructors;
	private Method[] keepMethods;
	private Field[] keepFields;
	private HashMap createdObjects = new HashMap();
	private Object selectObject;
	private int objNum = 0;
	private static Interpreter interpreter = new Interpreter();

	
	public Interpreter() {
		setSize(660, 500);
		setLocationRelativeTo(null);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		setLayout(gbl);
		setResizable(false);
		
		initializePanels();
		initializeLabels();
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn4.setPreferredSize(new Dimension(92, 25));
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(panelLeft, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbl.setConstraints(panelRight, gbc);
		add(panelLeft);
		add(panelRight);

		this.addWindowListener(new myWindowAdapter());

		setVisible(true);
	}
	
	public static void main(String[] args) {
		
	}
	
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == interpreter.btn1) {
			showConstructors(className.getText());
		}
		if(obj == interpreter.btn2) {
			createInstance();
		}
		if(obj == interpreter.btn3) {
			callMethod();
		}
		if(obj == interpreter.btn4) {
			createArray();
		}
		if(obj == interpreter.btn5) {
			setFieldValue();
		}
		if(obj == interpreter.btn6) {
			setArrayElements();
		}
	}
	
	public void initializeLabels() {
		msgOfClassInput.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgOfClassInput.setPreferredSize(new Dimension(290, 20));
		msgOfcArgumentsInput.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgOfcArgumentsInput.setPreferredSize(new Dimension(290, 20));
		msgOfArrayElementInput.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgOfArrayElementInput.setPreferredSize(new Dimension(290, 20));
		msgOfmArgumentsInput.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgOfmArgumentsInput.setPreferredSize(new Dimension(290, 20));
		msgOfFieldInput.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgOfFieldInput.setPreferredSize(new Dimension(290, 20));
		msgListObject.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgListObject.setPreferredSize(new Dimension(290, 20));
		msgListMethod.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgListMethod.setPreferredSize(new Dimension(290, 20));
		dispSelectObject.setPreferredSize(new Dimension(270, 40));
		dispSelectObject.setBorder(new LineBorder(Color.blue, 1, true));
		dispSelectObject.setHorizontalAlignment(JLabel.CENTER);
		msgSelectObject.setFont(new Font("ゴシック", Font.BOLD, 14));
		msgSelectObject.setPreferredSize(new Dimension(290, 20));
	}
	
	public void initializePanels() {
		panelLeft.setPreferredSize(new Dimension(320, 440));
		panelRight.setPreferredSize(new Dimension(320, 440));
		panelNewObject.setPreferredSize(new Dimension(295, 250));
		panelArray.setPreferredSize(new Dimension(295, 250));
		panelMethod.setPreferredSize(new Dimension(295, 300));
		panelField.setPreferredSize(new Dimension(295, 300));
		spConstructor.getViewport().setView(listConstructor);
		spArray.getViewport().setView(listArray);
		spMethod.getViewport().setView(listMethod);
		spField.getViewport().setView(listField);
		spObject.getViewport().setView(listObject);
		listObject.addMouseListener(this);
		listArray.addMouseListener(this);
		
		spConstructor.setPreferredSize(new Dimension(280, 120));
		spArray.setPreferredSize(new Dimension(280, 120));
		spMethod.setPreferredSize(new Dimension(280, 200));
		spField.setPreferredSize(new Dimension(280, 200));
		spObject.setPreferredSize(new Dimension(280, 70));

		panelNewObject.add(msgOfClassInput);
		panelNewObject.add(className);
		panelNewObject.add(btn1);
		panelNewObject.add(spConstructor);
		panelNewObject.add(msgOfcArgumentsInput);
		panelNewObject.add(constructorArgument);
		panelNewObject.add(btn2);
		
		panelArray.add(msgOfArrayClass);
		panelArray.add(arrayClass);
		panelArray.add(msgOfArrayNumInput);
		panelArray.add(arrayNum);
		panelArray.add(btn4);
		panelArray.add(spArray);
		panelArray.add(msgOfArrayElementInput);
		panelArray.add(arraySetElement);
		panelArray.add(btn6);
		
		panelMethod.add(spMethod);
		panelMethod.add(msgOfmArgumentsInput);
		panelMethod.add(methodArgument);
		panelMethod.add(btn3);
		
		panelField.add(spField);
		panelField.add(msgOfFieldInput);
		panelField.add(fieldValue);
		panelField.add(btn5);
		
		constructorTab.addTab("オブジェクト", panelNewObject);
		constructorTab.addTab("配列", panelArray);
		
		listTab.addTab("メソッド", panelMethod);
		listTab.addTab("フィールド", panelField);
		
		panelLeft.add(constructorTab);
		panelLeft.add(msgListObject);
		panelLeft.add(spObject);

		panelRight.add(msgSelectObject);
		panelRight.add(dispSelectObject);
		panelRight.add(listTab);
	}
	
	public void showConstructors(String className) {
		modelConstructor.clear();
		try {
			createdClass = Class.forName(className);
			//System.out.println(createdClass.toString());
			keepConstructors = createdClass.getConstructors();
			for(Constructor<?> c : keepConstructors)
				modelConstructor.addElement(c);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			JOptionPane.showMessageDialog(this, convertMessage(e.toString()));
			//e.printStackTrace();
		}
	}
	
	public void showMethods(Object obj) {
		keepMethods = obj.getClass().getMethods();
		Arrays.sort(keepMethods, new MemberComparator());

		modelMethod.clear();
		for(Method m : keepMethods) {
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
			modelMethod.addElement(str);
		}
	}
	
	public void showFields(Object obj) {
		keepFields = obj.getClass().getDeclaredFields();
		Arrays.sort(keepFields, new MemberComparator());

		modelField.clear();
		for(Field f : keepFields) {
			try {
				f.setAccessible(true);
				modelField.addElement(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName() + " = " + f.get(selectObject));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				//e.printStackTrace();
			}
		}
	}
	
	public void createInstance(){
		if(!listConstructor.isSelectionEmpty()) {
			String obj;
			Constructor constructor = keepConstructors[listConstructor.getSelectedIndex()];
			String arguments = constructorArgument.getText();
			createNewObject(constructor, arguments);
		}else {
			JOptionPane.showMessageDialog(this, "エラー：選択してください");
		}
	}
	
	public void createNewObject(Constructor<?> constructor, String argument) {
		Class<?>[] argsType = constructor.getParameterTypes();
		modelArray.clear();
		try {	
			Object[] cArgs = new Object[argsType.length];
			if(argsType.length > 0) {								//	引数チェック、引数がString以外のときも実装
				if(argument.length() == 0) {
					throw new IllegalArgumentException();
				}
				String[] argStrings = argument.split(",");
				if(cArgs.length != argsType.length) {
					throw new IllegalArgumentException();
				}
				for(int i = 0; i < argStrings.length; i++) {
					cArgs[i] = convertProperArgument(argsType[i], argStrings[i]);
					if(cArgs[i] == null) {
						throw new IllegalArgumentException();
					}
				}
			}else {
				if(argument.length() > 0) {
					throw new IllegalArgumentException();
				}
			}
			
			Object objValue = constructor.newInstance(cArgs);
			Object objKey = "obj" + objNum++;
			selectObject = objValue;
			createdObjects.put(objKey, objValue);
			if(objValue.getClass() == String.class) {
				JOptionPane.showMessageDialog(this, "成功しました\n\"" + objValue + "\"");
			}else {
				JOptionPane.showMessageDialog(this, "成功しました\n" + objValue);
			}
			modelObject.addElement(objKey + " " + objValue.getClass());
			listObject.setSelectedIndex(objNum-1);
			listObject.ensureIndexIsVisible(objNum-1);
			showMethods(selectObject);
			showFields(selectObject);
			dispSelectObject.setText(listObject.getSelectedValue());
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			if(e.toString().indexOf("java.lang.reflect.InvocationTargetException") >= 0) {
				JOptionPane.showMessageDialog(this, convertMessage(e.getCause().toString()));
			}else {
				JOptionPane.showMessageDialog(this, convertMessage(e.toString()));
			}
			//e.printStackTrace();
		}
	}
	
	public void createArray() {
		try {
			Object objKey = "obj" + objNum++;
			if(arrayNum.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "配列数を入力してください");
			}else {
				Object objValue = Array.newInstance(Class.forName(arrayClass.getText()), Integer.valueOf(arrayNum.getText()));
				selectObject = objValue;
				createdObjects.put(objKey, objValue);
				modelObject.addElement(objKey + " " + objValue.getClass());
				listObject.setSelectedIndex(objNum-1);
				listObject.ensureIndexIsVisible(objNum);
				showArrayElements(selectObject);
				dispSelectObject.setText(listObject.getSelectedValue());
				showMethods(selectObject);
				showFields(selectObject);
			}
		} catch (NumberFormatException | NegativeArraySizeException
				| ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			JOptionPane.showMessageDialog(this, convertMessage(e.toString()));
			//e.printStackTrace();
		}
	}
	
	public void showArrayElements(Object obj) {
		modelArray.clear();
		for(int i = 0; i < Array.getLength(obj); i++) {
			modelArray.addElement("arr" + i + " = " + Array.get(obj, i));
		}
	}
	
	public void setArrayElements() {
		if(!listArray.isSelectionEmpty()) {
			try {
				String[] objKey = dispSelectObject.getText().split(" ");
				Object obj = createdObjects.get(objKey[0]);
				if(obj.getClass().isArray()) {
					Object setValue = convertProperArgument(obj.getClass().getComponentType(), arraySetElement.getText());
					if(setValue == null) {
						throw new IllegalArgumentException();
					}else {
						Array.set(obj, listArray.getSelectedIndex(), setValue);
						showArrayElements(obj);
					}
				}
				arraySetElement.setText("");
			}catch(java.lang.NullPointerException | IllegalArgumentException e) {
				if(e.toString().indexOf("java.lang.NullPointerException") >= 0) {
					JOptionPane.showMessageDialog(this, "変更する要素を選択してください");
				}else {
					JOptionPane.showMessageDialog(this, convertMessage(e.toString()));
					//e.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(this, "エラー：選択してください");
		}
	}
	
	public void showHashMap() {
		System.out.println(createdObjects.size());
		
	}
	
	public void callMethod() {
		System.out.println(methodArgument.getText());
		if(!listMethod.isSelectionEmpty()) {
			Method method = keepMethods[listMethod.getSelectedIndex()];
			Class<?>[] argsType = method.getParameterTypes();
			System.out.println(argsType.length);
			try {
				Object[] mArgs = new Object[argsType.length];
				if(argsType.length > 0) {		//	引数チェック、引数がString以外のときも実装
					String[] argStrings = methodArgument.getText().split(",");
					if(mArgs.length != argStrings.length) {
						throw new IllegalArgumentException();
					}
					for(int i = 0; i < argStrings.length; i++) {
						mArgs[i] = convertProperArgument(argsType[i], argStrings[i]);
						if(mArgs[i] == null) {
							throw new IllegalArgumentException();
						}
					}
				}else {
					if(methodArgument.getText().length() > 0) {
						throw new IllegalArgumentException();
					}
				}
				Object returnObj = method.invoke(selectObject, mArgs);
				if(returnObj == null) {
					JOptionPane.showMessageDialog(this, "成功しました\n" + "void");
				}else {
					JOptionPane.showMessageDialog(this, "成功しました\n" + returnObj);
				}
				
				showFields(selectObject);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO 自動生成された catch ブロック
				if(e.toString().indexOf("java.lang.reflect.InvocationTargetException") >= 0) {
					JOptionPane.showMessageDialog(this, convertMessage(e.getCause().toString()));
				}else {
					JOptionPane.showMessageDialog(this, convertMessage(e.toString()));
				}
				//e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(this, "エラー：選択してください");
		}
	}
	
	public void setFieldValue() {
		if(!listField.isSelectionEmpty()) {
			Field field = keepFields[listField.getSelectedIndex()];
			System.out.println(selectObject.toString());
			try {
				field.set(selectObject, convertProperArgument(field.getType(), fieldValue.getText()));
				showFields(selectObject);
				String[] objKey = dispSelectObject.getText().split(" ");
				Object obj = createdObjects.get(objKey[0]);
				if(obj.getClass().isArray()) {
					showArrayElements(obj);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				JOptionPane.showMessageDialog(this, convertMessage(e.toString()));
				//e.printStackTrace();
			}
			fieldValue.setText("");
		}else {
			JOptionPane.showMessageDialog(this, "エラー：選択してください");
		}
	}
	
	public String convertMessage(String msg) {
		if(msg.indexOf("java.lang.ClassNotFoundException") >= 0)
			return "エラー：そのようなクラスはありません\njava.lang.ClassNotFoundException";
		if(msg.indexOf("java.lang.IllegalArgumentException") >= 0)
			
			return "エラー：入力値が正しくありません\njava.lang.IllegalArgumentException";
		return msg;
	}
	
	public Object convertProperArgument(Class<?> type, String argument) {
		//Pattern p = Pattern.compile("^[0-9]*$");
		//if(p.matcher(argument).find()) {
		if(argument.indexOf('\"') != 0) {
			try {
				if(argument.indexOf("obj") >= 0) {
					return createdObjects.get(argument);
					
				}else if(type.equals(boolean.class) || type.equals(Boolean.class) || type.equals(boolean[].class) || type.equals(Boolean.class)) {
					return Boolean.valueOf(argument);
					
				}else if(type.equals(Integer.class) || type.equals(int.class) || type.equals(Integer[].class) || type.equals(int[].class)) {
					return Integer.valueOf(argument);
				
				}else if(type.equals(Byte.class) || type.equals(byte.class) || type.equals(Byte[].class) || type.equals(byte[].class)) {
					return Byte.valueOf(argument);
				
				}else if(type.equals(Short.class) || type.equals(short.class) || type.equals(Short[].class) || type.equals(short[].class)) {
					return Short.valueOf(argument);
				
				}else if(type.equals(Long.class) || type.equals(long.class) || type.equals(Long[].class) || type.equals(long[].class)) {
				
					if(argument.charAt(argument.length()-1) == 'l' || argument.charAt(argument.length()-1) == 'L') {
						System.out.println("long");
						return Long.valueOf(argument.substring(0, argument.length()-1));
					}
					return Long.valueOf(argument);
				
				}else if(type.equals(Float.class) || type.equals(float.class) || type.equals(Float[].class) || type.equals(float[].class)) {
					return Float.valueOf(argument);
				
				}else if(type.equals(Double.class) || type.equals(double.class) || type.equals(Double[].class) || type.equals(double[].class)) {
					return Double.valueOf(argument);
				}
			}catch(NumberFormatException e) {
				throw new IllegalArgumentException();
			}
		}else {
			if(argument.indexOf('\"') == 0 && argument.indexOf('\"', 1) == argument.length()-1) {
				if(type.equals(String.class) || type.equals(String[].class)) {
					return argument.substring(1, argument.length()-1);
				
				}else if(type.equals(Character.class) || type.equals(char.class) ) {
					char[] c = argument.substring(1, argument.length()-1).toCharArray();
					System.out.println(c);
					if(c.length == 1) {
						return c[0];
					}else {
						return null;
					}
					
				
				}else if(type.equals(Character[].class) || type.equals(char[].class)) {
					System.out.println("char");
					return argument.substring(1, argument.length()-1).toCharArray();
					
				}
			}
		}
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getClickCount() == 2) {
			if(e.getSource() == listObject) {
				modelArray.clear();
				String[] str = listObject.getSelectedValue().split(" ");
				selectObject = createdObjects.get(str[0]);
				dispSelectObject.setText(listObject.getSelectedValue());
				if(selectObject.getClass().isArray()) {
					showArrayElements(selectObject);
				}
				showMethods(selectObject);
				showFields(selectObject);
			}else if(e.getSource() == listArray) {
				String[] objKey = dispSelectObject.getText().split(" ");
				Object obj = createdObjects.get(objKey[0]);
				Object arrayElementObj = Array.get(obj, listArray.getSelectedIndex());
				if(arrayElementObj == null) {
					JOptionPane.showMessageDialog(this, "選択できません\n配列の要素は空です");
				}else {
					selectObject = arrayElementObj;
					dispSelectObject.setText(objKey[0] + " " + obj.getClass().toString() + "[" + listArray.getSelectedIndex() + "]");
					showMethods(selectObject);
					showFields(selectObject);
				}
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
	public void windowClosing(WindowEvent e) {   //×を押されたときの処理
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