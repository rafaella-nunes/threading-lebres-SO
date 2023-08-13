package lebres;

public class Corrida implements Runnable {

	Lebre lebres;
	Thread t;

	final int num = 20;

	public Corrida(String nome, Lebre lebre) {
		this.lebres = lebre;
		t = new Thread(this, nome);
		t.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if (t.getName().equalsIgnoreCase("Lebre")){
			for (int i=0; i<num; i++){
				lebres.lebre1(true);
			}
			lebres.lebre1(false);
		} else {
			for (int i=0; i<num; i++){
				lebres.lebre2(true);
			}
			lebres.lebre2(false);
		}

	}

}
