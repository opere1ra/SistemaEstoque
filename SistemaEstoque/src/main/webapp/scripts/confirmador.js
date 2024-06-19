/**
 * Confirmação de exclusão de um contato
 * @author Alessandro Pereira
 * @param idProduto
 */

 function confirmar(idProduto){
	let resposta = confirm("Deseja excluir este produto?");
	
	if(resposta === true){
		window.location.href = "delete?idProduto=" + idProduto;
	}
 }