<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de estoque</title>

<link rel="icon" href="Imagens/StockIcon.png">
<link rel="stylesheet" href="style.css">

</head>

<body>

	<div class="divCadastro">
		<h1 class="tituloPaginas">Editar produto</h1>

		<form name="frmProduto" action="update" class="frmProduto">

			<table class="frmTable">
				<tr>
					<td><input type="text" name="nome" class="Caixa1"
						value="<%out.print(request.getAttribute("nome"));%>"></td>
				</tr>

				<tr>
					<td><input type="text" name="tipo" class="Caixa1"
						value="<%out.print(request.getAttribute("tipo"));%>"></td>
				</tr>

				<tr>
					<td><input type="number" name="quantidade" class="Caixa1"
						value="<%out.print(request.getAttribute("quantidade"));%>"></td>
				</tr>
			</table>

			<input type="button" value="Salvar" class="Botao1"
				onclick="validar()">

		</form>
	</div>
	<script src="scripts/validar.js"></script>

</body>
</html>