package lebres;

public class Lebre {

	private boolean proximaLebre;
	
	
	synchronized void lebre1(boolean checarCorrida) {
		if(!checarCorrida) {
			proximaLebre = true;
			notify();
			return;
		}
		System.out.println("Lebre 1 está correndo");
		proximaLebre = true;
		notify();
		
		try {
			while(proximaLebre) {
				wait();
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized void lebre2(boolean checarCorrida) {
		if(!checarCorrida) {
			proximaLebre = false;
			notify();
			return;
		}
		System.out.println("Lebre 2 está correndo");
		proximaLebre = false;
		notify();
		
		try {
			while(!proximaLebre) {
				wait();
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
