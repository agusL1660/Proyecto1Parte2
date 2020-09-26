package Grafo;

public class ArcoD{
	
	
	
		private DVertice origen, destino;
		
		
		public ArcoD( DVertice origen, DVertice destino) {
			this.origen=origen;
			this.destino=destino;
			
		}
		
		
		public DVertice getV1() {
			return origen;
		}
		
		public DVertice getV2() {
			return destino;
		}
		
		
		public void setV1(DVertice origen) {
			this.origen=origen;
		}
		
		public void setV2(DVertice destino) {
			this.destino=destino;
		}
		
		
	}

