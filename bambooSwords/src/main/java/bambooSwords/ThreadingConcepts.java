package bambooSwords;

public class ThreadingConcepts {

	public static void main(String[] args) {
		Chat m = new Chat();
		new T1(m);
		new T2(m);
	}

}


class Chat {
	boolean flag = false;

	public synchronized void printQuestion(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void printAnswer(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(msg);
		flag = false;
		notify();
	}
}

class T1 implements Runnable {
	Chat m;
	String[] s1 = { "T1 : Hi", "T1 : How are you ?", "T1 : I am also doing fine!" };

	public T1(Chat m1) {
		this.m = m1;
		new Thread(this, "Question").start();
	}

	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.printQuestion(s1[i]);
		}
	}
}

class T2 implements Runnable {
	Chat m;
	String[] s2 = { "T2 : Hi", "T2 : I am good, what about you?", "T2 : Great!" };

	public T2(Chat m2) {
		this.m = m2;
		new Thread(this, "Answer").start();
	}

	public void run() {
		for (int i = 0; i < s2.length; i++) {
			m.printAnswer(s2[i]);
		}
	}
}

