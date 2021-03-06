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
         e.preventDefault()
         nomeCandidato = $("#nomeSobrenome").val()
         nascimentoCandidato = $("#dataDeNascimento").val()
         emailCandidato = $("#email").val()
         CPFCandidato = $("#CPF").val()
         paisCandidato = $("#pais").val()
         formacaoCandidato = $("#formacao").val()
         descricaoCandidato = $("#descricaoCandidato").val()
         CEPCandidato = $("#cep").val()
         passwordCandidato = $("#password").val()
         angularCandidato = $("#angular").is(':checked')
         javaCandidato = $("#java").is(':checked')
         groovyCandidato = $("#groovy").is(':checked')
         pythonCandidato = $("#python").is(':checked')
         typescriptCandidato = $("#typescript").is(':checked')
         trigger = $(".trigger").val()
         var formCandidato = $("#form-register-candidato");
         console.log("ENTREI NO AJAX")
         $.ajax({

             type: 'POST',
             url: 'http://localhost:8080/servidores_war_exploded/registerCandidatos',
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
        nomeEmpresa = $("#nomeSobrenome-empresa").val()
        emailEmpresa = $("#email-empresa").val()
        CPFEmpresa = $("#CNPJ").val()
        paisEmpresa = $("#pais-empresa").val()
        descricaoEmpresa = $("#descricao-empresa").val()
        passwordEmpresa = $("#password-empresa").val()
        CEPEmpresa = $("#cep-empresa").val()
        trigger = $(".trigger-empresa").val()
        var formEmpresa = $("#form-register-empresa")
        $.ajax({


            type: 'POST',
            url: 'http://localhost:8080/servidores_war_exploded/registerEmpresa',
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
                e.preventDefault()
                window.location.href = "../../Login/LoginCandidato/loginCandidato.html"

            },
            error: function() {
                alert("Alguma coisa deu errado ai maninho")
            }
        });
    })
});
