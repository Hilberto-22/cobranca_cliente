$(document).ready(function () {
    // Manipulador de evento para o clique no botão
    $("#btnSalvar").click(function () {
        // Obtenha os dados do input
        var inputData = $("#dataInput").val();

        // Faça a solicitação Ajax
        $.ajax({
            type: "POST",
            url: "/clientes/salvar",
            data: { data: inputData }, // Dados a serem enviados para o servidor
            success: function (response) {
                // Manipule a resposta bem-sucedida do servidor
                console.log(response);
            },
            error: function (error) {
                // Manipule erros de solicitação
                console.log(error);
            }
        });
    });