<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>

<!DOCTYPE html lang="pt-br">

<html>

<head>

<meta charset="UTF-8">
<title>Sistema de estoque</title>

<link rel="icon" href="Imagens/StockIcon.png">
<link rel="stylesheet" href="style.css">

</head>

<body>

	<div class="divMain">
		<h1 class="tituloPaginas">Sistema de Estoque</h1>
		<a href="Cadastro.html" class="Botao1">Novo Produto</a>
		<table id="tabela">
			<thead>
				<tr>
					<th>Tipo</th>
					<th>Nome</th>
					<th>Quantidade</th>
					<th>Funções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getTipoProduto()%></td>
					<td><%=lista.get(i).getNomeProduto()%></td>
					<td><%=lista.get(i).getQuantidadeProduto()%></td>
					<td><a
						href="select?IdProduto=<%=lista.get(i).getIdProduto()%>"
						class="Botao1">Editar</a> <a
						href="javascript: confirmar(<%=lista.get(i).getIdProduto()%>)"
						class="Botao2">Excluir</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<script src="scripts/confirmador.js"></script>

</body>
</html>