package lebres;

public class Lebre extends Thread{

	private String nome;
	private int tempo;

	public Lebre(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		start();
	}

	public void run() {
		try {
			for(int i = 0; i <= 5; i++) {
				System.out.println(nome + " contador: " + i);
				Lebre.sleep(tempo);
			}
		}
		catch(InterruptedException e) {
			System.out.println("A lebre " + nome + "foi interrompida");
		}
		
		System.out.println( nome + " terminou de correr");
	}

}
