package lebres;

public class Largada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lebre lebres = new Lebre();
		Corrida lebre1 = new Corrida("Lebre 1", lebres);
		Corrida lebre2 = new Corrida("Lebre 2", lebres);

		try {
			lebre1.t.join();
			lebre2.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
