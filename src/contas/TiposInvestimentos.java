package contas;

public enum TiposInvestimentos {

	GOLD(0.08),
	PLATINUM(0.10),
	BLACK(0.15);

	private double tiposInvestimentos;
	
	TiposInvestimentos(double tiposInvestimentos) {
		this.tiposInvestimentos = tiposInvestimentos;
		
	}

	public double getTiposInvestimentos() {
		return tiposInvestimentos;
	}
}
