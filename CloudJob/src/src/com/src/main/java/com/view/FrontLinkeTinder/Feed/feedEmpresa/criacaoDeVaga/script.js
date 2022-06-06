$(document).ready(function () {
    var formVaga = $("#form-register-vaga");
    formVaga.submit(function (e) {
        e.preventDefault();
        var nomeVaga = $("#nomeVaga").val();
        var localVaga = $("#localVaga").val();
        var estadoVaga = $("#estadoVaga").val();
        var salarioVaga = $("#salarioVaga").val();
        var nivelVaga = $("#nivelVaga").val();
        var OutsideWork = $("#outsideWorkVaga").val();
        var descricaoVaga = $("#descricaoVaga").val();
        var angularVaga = $("#angular").is(':checked');
        var javaVaga = $("#java").is(':checked');
        var groovyVaga = $("#groovy").is(':checked');
        var pythonVaga = $("#python").is(':checked');
        var typescriptVaga = $("#typescript").is(':checked');
        console.log("ENTREI NO AJAX");
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/servidores_war_exploded/registerVagas',
            data: {
                "nomeVaga": nomeVaga,
                "localVaga": localVaga,
                "estado": estadoVaga,
                "salario": salarioVaga,
                "nivel": nivelVaga,
                "outsideWork": OutsideWork,
                "descricaoVaga": descricaoVaga,
                "angular": angularVaga,
                "java": javaVaga,
                "groovy": groovyVaga,
                "python": pythonVaga,
                "typescript": typescriptVaga
            },
            success: function () {
                window.location.href = "../feedEmpresa.html";
            },
            error: function () {
                alert("Alguma coisa deu errado ai maninho");
            }
        });
    });
});
