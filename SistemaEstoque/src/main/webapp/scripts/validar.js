/**
 *  Validação de formulário
 *  @author Alessandro Pereira
 */

function validar() {
	let nome = frmProduto.nome.value;
	let tipo = frmProduto.tipo.value;
	let quantidade = frmProduto.quantidade.value;

	if (nome === "") {
		alert('Preencha o campo Nome');
		frmProduto.nome.focus();
		return false;
	} else if (tipo === "") {
		alert('Preencha o campo Tipo');
		frmProduto.tipo.focus();
		return false;
	} else if (quantidade === "") {
		alert('Preencha o campo Quantidade');
		frmProduto.quantidade.focus();
		return false;
	}
	else {
		document.forms["frmProduto"].submit();
	}

}
