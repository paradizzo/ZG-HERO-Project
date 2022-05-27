var index = 2;
$(document).ready(function () {
    localStorage.clear();
    // Teste de integração
    $("#form-register-vaga").submit(function (e) {
        e.preventDefault();
        var values = [];
        var skills = [];
        values.push($('#nomeVaga').val());
        values.push($('#localVaga').val());
        values.push($('#salarioVaga').val());
        values.push($('#nivelVaga').val());
        values.push($('#outsideWorkVaga').val());
        values.push($('#descricaoVaga').val());
        var angularValue = $("#angular").is(":checked");
        var groovyValue = $("#groovy").is(":checked");
        var javaValue = $("#java").is(":checked");
        var pythonValue = $("#python").is(":checked");
        var typescriptValue = $("#typescript").is(":checked");
        if (angularValue) {
            skills.push("Angular");
        }
        if (groovyValue) {
            skills.push("Groovy");
        }
        if (javaValue) {
            skills.push("Java");
        }
        if (pythonValue) {
            skills.push("Python");
        }
        if (typescriptValue) {
            skills.push("Typescript");
        }
        return values;
        // teste
    });
});
