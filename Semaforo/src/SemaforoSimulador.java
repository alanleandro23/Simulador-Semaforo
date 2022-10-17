
public class SemaforoSimulador {

	public static void main(String[] args) {

		ThredSemaforo semafaro = new ThredSemaforo();

		for (int i=0; i<20; i++) {
			System.out.println(semafaro.getCor());
			semafaro.esperaCorMudar();
		 }
		semafaro.desligarSemaforo();
       }
	}