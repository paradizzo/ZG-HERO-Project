$(document).ready(function () {
    var toggleEmpresa = $(".toggle-empresa");
    var toggleCandidato = $(".toggle-candidato");
    $(function () {
        toggleEmpresa.click(function (e) {
            e.preventDefault();
            toggleEmpresa.removeClass('focus');
            toggleCandidato.addClass('focus');
            $(this).addClass('focus');
            toggleCandidato.removeClass('focus');
            $("#login-button-candidato").hide();
            $("#form-register-candidato").hide();
            $("#form-register-empresa").show();
            $("#login-button-empresa").show();
        });
        toggleCandidato.click(function (e) {
            e.preventDefault();
            toggleCandidato.removeClass('focus');
            toggleEmpresa.addClass('focus');
            $(this).addClass('focus');
            toggleEmpresa.removeClass('focus');
            $("#login-button-candidato").show();
            $("#form-register-candidato").show();
            $("#form-register-empresa").hide();
            $("#login-button-empresa").hide();
        });
    });
    var formCandidato = $("#form-register-candidato");
    formCandidato.submit(function (e) {
        e.preventDefault();
        var emailCandidato = $("#email").val();
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        // @ts-ignore
        var valid = regex.test(emailCandidato);
        if (valid == false) {
            $('#error-email').show();
        }
        else {
            $('#error-email').hide();
        }

    });
    $(document).ready(function () {
        validate();
        $('#nomeSobrenome, #dataDeNascimento, #email , #CPF , #pais ,  #formacao, #descricaoCandidato, #cep , #password').change(validate);
    });
    function validate() {
        // @ts-ignore
        if ($('#nomeSobrenome').val().length > 0 &&
            // @ts-ignore
            $('#dataDeNascimento').val().length > 0 &&
            // @ts-ignore
            $('#CPF').val().length > 0 &&
            // @ts-ignore
            $('#pais').val().length > 0 &&
            // @ts-ignore
            $('#formacao').val().length > 0 &&
            // @ts-ignore
            $('#descricaoCandidato').val().length > 0 &&
            // @ts-ignore
            $('#cep').val().length > 0 &&
            // @ts-ignore
            $('#password').val().length > 0 &&
            // @ts-ignore
            $('#email').val().length > 0) {
            $("#login-button-candidato").prop("disabled", false);
        }
        else {
            $("#login-button-candidato").prop("disabled", true);
        }
    }

    formCandidato.submit(function (e){
        let nomeCandidato = $("#nomeSobrenome").val()
        let nascimentoCandidato = $("#dataDeNascimento").val()
        let emailCandidato = $("#email").val()
        let CPFCandidato = $("#CPF").val()
        let paisCandidato = $("#pais").val()
        let formacaoCandidato = $("#formacao").val()
        let descricaoCandidato = $("#descricaoCandidato").val()
        let CEPCandidato = $("#cep").val()
        let passwordCandidato = $("#password").val()
        let angularCandidato = $("#angular").is(':checked')
        let javaCandidato = $("#java").is(':checked')
        let groovyCandidato = $("#groovy").is(':checked')
        let pythonCandidato = $("#python").is(':checked')
        let typescriptCandidato = $("#typescript").is(':checked')
        let trigger = $(".trigger").val()
        var formCandidato = $("#form-register-candidato");

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/servidores_war_exploded/candidatos',
            data: {
                "trigger": trigger,
                "nomeSobrenome": nomeCandidato,
                "dataDeNascimento": nascimentoCandidato,
                "email": emailCandidato,
                "CPF": CPFCandidato,
                "pais": paisCandidato,
                "formacao": formacaoCandidato,
                "descricaoCandidato": descricaoCandidato,
                "cep": CEPCandidato,
                "password": passwordCandidato,
                "angular": angularCandidato,
                "java": javaCandidato,
                "groovy": groovyCandidato,
                "python": pythonCandidato,
                "typescript": typescriptCandidato
            },
            success: function () {
                window.location.href = "../../Login/LoginCandidato/loginCandidato.html"
            },
            error: function() {
                alert("Alguma coisa deu errado ai maninho")
            }
        });
    })
    let formEmpresa = $("#form-register-empresa")
    formEmpresa.submit(function (e){
        e.preventDefault()
        let nomeEmpresa = $("#nomeSobrenome-empresa").val()
        let emailEmpresa = $("#email-empresa").val()
        let CPFEmpresa = $("#CNPJ").val()
        let paisEmpresa = $("#pais-empresa").val()
        let descricaoEmpresa = $("#descricao-empresa").val()
        let passwordEmpresa = $("#password-empresa").val()
        let CEPEmpresa = $("#cep-empresa").val()
        let trigger = $(".trigger-empresa").val()
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/servidores_war_exploded/candidatos',
            data: {
                "trigger": trigger,
                "nomeSobrenomeEmpresa": nomeEmpresa,
                "emailEmpresa": emailEmpresa,
                "CNPJ": CPFEmpresa,
                "paisEmpresa": paisEmpresa,
                "descricaoEmpresa": descricaoEmpresa,
                "CEPempresa": CEPEmpresa,
                "passwordEmpresa": passwordEmpresa
            },
            success: function () {
                window.location.href = "../../Login/LoginCandidato/loginCandidato.html"
            },
            error: function() {
                alert("Alguma coisa deu errado ai maninho")
            }
        });
    })
});
