package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbestoque?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "adm123";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {

		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir produto.
	 *
	 * @param produto the produto
	 */
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produtos (nomeProduto,tipoProduto,quantidadeProduto) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getTipoProduto());
			pst.setInt(3, produto.getQuantidadeProduto());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar produtos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produtos order by tipoProduto";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int idProduto = rs.getInt(1);
				String nomeProduto = rs.getString(2);
				String tipoProduto = rs.getString(3);
				int quantidadeProduto = rs.getInt(4);
				produtos.add(new JavaBeans(idProduto, nomeProduto, tipoProduto, quantidadeProduto));
			}
			con.close();
			return produtos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar produto.
	 *
	 * @param produto the produto
	 */
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produtos where idProduto = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, produto.getIdProduto());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				produto.setIdProduto(rs.getInt(1));
				produto.setNomeProduto(rs.getString(2));
				produto.setTipoProduto(rs.getString(3));
				produto.setQuantidadeProduto(rs.getInt(4));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar produto.
	 *
	 * @param produto the produto
	 */
	public void alterarProduto(JavaBeans produto) {
		String update = "update produtos set nomeProduto=?,tipoProduto=?,quantidadeProduto=? where idProduto=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getTipoProduto());
			pst.setInt(3, produto.getQuantidadeProduto());
			pst.setInt(4, produto.getIdProduto());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar produto.
	 *
	 * @param produto the produto
	 */
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from produtos where idProduto=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, produto.getIdProduto());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
