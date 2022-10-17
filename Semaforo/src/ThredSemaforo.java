
public class ThredSemaforo implements Runnable {

	private CorSemaforo cor;
	private boolean parar;
	private boolean corMudou;

	public ThredSemaforo() {

		this.cor = CorSemaforo.vermelho;

		this.parar = false;
		this.corMudou = false;

		new Thread(this).start();

	}

	@Override
	public void run() {

		while(!parar) {
			try {
				switch (this.cor) {
				case vermelho:
					Thread.sleep(6000);
					break;
				case amarelo:	
					Thread.sleep(3000);
					break;
				case verde:	
					Thread.sleep(12000);
					break;

				default:
					break;
				}

				this.mudarCor();

			}catch(InterruptedException e) {
				e.printStackTrace();
			}


		}
	}

	private synchronized void mudarCor() {
		switch (this.cor) {
		case vermelho:
			this.cor = CorSemaforo.verde;
			break;			
		case amarelo:
			this.cor = CorSemaforo.vermelho;
			break;
		case verde:
			this.cor = CorSemaforo.amarelo;
			break;
		}
		this.corMudou = true;
		notify();
	}

	public synchronized void esperaCorMudar() {
		while (!this.corMudou) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.corMudou=false;
	}
	
	public synchronized void desligarSemaforo() {
		this.parar = true;
		
	}

	public CorSemaforo getCor() {
		return cor;
	}



}