package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The produto. */
	JavaBeans produto = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			adicionarProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Produtos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarProdutos();

		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Estoque.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setNomeProduto(request.getParameter("nome"));
		produto.setTipoProduto(request.getParameter("tipo"));
		produto.setQuantidadeProduto(Integer.parseInt(request.getParameter("quantidade")));

		dao.inserirProduto(produto);

		response.sendRedirect("main");
	}

	/**
	 * Listar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setIdProduto(Integer.parseInt(request.getParameter("IdProduto")));

		dao.selecionarProduto(produto);

		request.setAttribute("nome", produto.getNomeProduto());
		request.setAttribute("tipo", produto.getTipoProduto());
		request.setAttribute("quantidade", produto.getQuantidadeProduto());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setNomeProduto(request.getParameter("nome"));
		produto.setTipoProduto(request.getParameter("tipo"));
		produto.setQuantidadeProduto(Integer.parseInt(request.getParameter("quantidade")));

		dao.alterarProduto(produto);

		response.sendRedirect("main");
	}

	/**
	 * Remover produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));

		dao.deletarProduto(produto);

		response.sendRedirect("main");
	}
}
