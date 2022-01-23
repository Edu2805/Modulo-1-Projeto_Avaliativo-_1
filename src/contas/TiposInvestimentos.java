package contas;

public enum TiposInvestimentos {

	GOLD(0.5),
	PLATINUM(1),
	BLACK(1.5);

	private final double tiposInvestimentos;
	
	TiposInvestimentos(double tiposInvestimentos) {
		this.tiposInvestimentos = tiposInvestimentos;
		
	}

	public double getTiposInvestimentos() {
		return tiposInvestimentos;
	}
}
