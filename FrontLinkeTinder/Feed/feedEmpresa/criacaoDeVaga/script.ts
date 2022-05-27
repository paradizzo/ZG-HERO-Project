
let index = 2
$(document).ready(function() {
    localStorage.clear()
    // Teste de integração

    $("#form-register-vaga").submit(function(e) {
        e.preventDefault();
        var values = [];
        var skills = []
        values.push($('#nomeVaga').val())
        values.push($('#localVaga').val())
        values.push($('#salarioVaga').val())
        values.push($('#nivelVaga').val())
        values.push($('#outsideWorkVaga').val())
        values.push($('#descricaoVaga').val())
        let angularValue = $("#angular").is(":checked")
        let groovyValue = $("#groovy").is(":checked")
        let javaValue = $("#java").is(":checked")
        let pythonValue = $("#python").is(":checked")
        let typescriptValue = $("#typescript").is(":checked")
        if (angularValue){
            skills.push("Angular")
        } if (groovyValue) {
            skills.push("Groovy")
        } if (javaValue) {
            skills.push("Java")
        } if (pythonValue) {
            skills.push("Python")
        } if (typescriptValue) {
            skills.push("Typescript")
        }

        return values
    // teste

    });
})