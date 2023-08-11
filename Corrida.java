package lebres;

public class Corrida {

	public static void main(String[] args) {

		Lebre querida = new Lebre("Querida", 500);
		Thread t1 = new Thread(querida);
		t1.start();
		Lebre fofa = new Lebre("fofa", 1000);
		Thread t2 = new Thread(fofa);
		t2.start();
		Lebre vandinha = new Lebre("vandinha", 800);
		Thread t3 = new Thread(vandinha);
		t3.start();
		Lebre soninho = new Lebre("soninho", 1200);
		Thread t4 = new Thread(soninho);
		t4.start();
		Lebre dunga = new Lebre("dunga", 200);
		Thread t5 = new Thread(dunga);
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A corrida terminou!");	
		//Thread t2 = new Thread(fofa);
		//t1.start();
		//t2.start();
	}

}
