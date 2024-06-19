package Model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id produto. */
	private int idProduto;
	
	/** The nome produto. */
	private String nomeProduto;
	
	/** The tipo produto. */
	private String tipoProduto;
	
	/** The quantidade produto. */
	private int quantidadeProduto;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idProduto the id produto
	 * @param nomeProduto the nome produto
	 * @param tipoProduto the tipo produto
	 * @param quantidadeProduto the quantidade produto
	 */
	public JavaBeans(int idProduto, String nomeProduto, String tipoProduto, int quantidadeProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.tipoProduto = tipoProduto;
		this.quantidadeProduto = quantidadeProduto;
	}

	/**
	 * Gets the id produto.
	 *
	 * @return the id produto
	 */
	public int getIdProduto() {
		return idProduto;
	}
	
	/**
	 * Sets the id produto.
	 *
	 * @param idProduto the new id produto
	 */
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	/**
	 * Gets the nome produto.
	 *
	 * @return the nome produto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	/**
	 * Sets the nome produto.
	 *
	 * @param nomeProduto the new nome produto
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	/**
	 * Gets the tipo produto.
	 *
	 * @return the tipo produto
	 */
	public String getTipoProduto() {
		return tipoProduto;
	}
	
	/**
	 * Sets the tipo produto.
	 *
	 * @param tipoProduto the new tipo produto
	 */
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	/**
	 * Gets the quantidade produto.
	 *
	 * @return the quantidade produto
	 */
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	
	/**
	 * Sets the quantidade produto.
	 *
	 * @param quantidadeProduto the new quantidade produto
	 */
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
}
