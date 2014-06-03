package ex05_2;

import java.util.ArrayList;
import java.util.Iterator;

public class BankAccount {
	private long number;		//口座番号
	private long balance;		//現在の残高
	private Action lastAct;		//最後に行われた処理
	private final int HISTORY_SIZE = 10;
	private History history = new History();
	
	BankAccount(long number, long balance) {
		this.number = number;
		this.balance = balance;
	}
	
	public class Action {
		private String act;
		private long amount;	//金額
		
		/* コンストラクタ */
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}
	}
	
	public class History {
		private ArrayList<Action> historyList = new ArrayList<Action>();
		private Iterator<Action> iter;

		
		public void save(Action act) {
			//System.out.println(act.act);
			if(historyList.size() < HISTORY_SIZE) {
				historyList.add(act);
			}else{
				historyList.remove(0);
				historyList.add(act);
			}
		}
		
		public Action next(){
			if(iter == null){
				iter = historyList.iterator();
			}
			if(this.iter.hasNext()){
				return iter.next();
			}else{
				return null;
			}
		}
	}
	
	/* 入金 */
	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.save(lastAct);
	}
	
	/* 引出 */
	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		history.save(lastAct); 
	}
	
	public History history() {
		return history;
	}
	
	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount(12345, 10000); 
		myAccount.deposit(1000);
		myAccount.withdraw(9000);
		System.out.println(myAccount.history.next());
		System.out.println(myAccount.history.next());
		System.out.println(myAccount.history.next());
	}
}
