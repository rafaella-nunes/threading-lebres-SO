package lebres;

public class Lebre implements Runnable{

	private String nome;
	private int tempo;

	public Lebre(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		//Thread t = new Thread(this);
		//t.start();
		//start();
	}

	@Override
	public void run() {
		System.out.println( nome + " foi iniciada");	

		try {
			for(int i = 0; i <= 5; i++) {
				System.out.println(nome + " contador: " + i);
				Thread.sleep(tempo);
			}
		}
		catch(InterruptedException e) {
			System.out.println("A lebre " + nome + "foi interrompida");
		}

		System.out.println( nome + " terminou de correr");
	}

}
