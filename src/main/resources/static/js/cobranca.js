$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoCliente = button.data('codigo');
	// var descricaoTitulo = button.data('descricao');
	
	alert(codigoCliente);
});