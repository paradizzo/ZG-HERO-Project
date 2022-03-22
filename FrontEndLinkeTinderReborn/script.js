"use strict";
exports.__esModule = true;

var btnEntrarEmpresa = document.querySelectorAll(".entrarComoEmpresa");
var btnEntrarCand = document.querySelectorAll(".entrarComoCand");
var loginAreaEmpresa = document.querySelectorAll(".wraperLoginBoxEmpresa");
var loginAreaCandi = document.querySelectorAll(".wraperLoginBoxCandidato");
var RegisterButtonEmpresa = document.querySelectorAll("#register-empresa");
var registerButtonCand = document.querySelectorAll("#register-cand");
var registerEmpresa = document.querySelectorAll(".registerEmpresa");
var registerCand = document.querySelectorAll(".registerCandidato");
var closeBtnEmp = document.querySelectorAll(".registerEmpresa img");
var closeBtnCand = document.querySelectorAll(".registerCandidato img");
var loginBtnEmp = document.querySelectorAll(".loginButtonBox a");
var loginBtnCand = document.querySelectorAll(".loginButtonBoxCandidato a ");
$(btnEntrarEmpresa).click(function () {
    $(loginAreaEmpresa).show();
    $(loginAreaCandi).hide();
});
$(btnEntrarCand).click(function () {
    $(loginAreaEmpresa).hide();
    $(loginAreaCandi).show();
});
$(registerButtonCand).click(function () {
    $(registerCand).show();
});
$(RegisterButtonEmpresa).click(function () {
    $(registerEmpresa).show();
});
$(closeBtnCand).click(function () {
    $(registerCand).hide();
});
$(closeBtnEmp).click(function () {
    $(registerEmpresa).hide();
});
// BOTOES DE REGISTRO
$(document.querySelectorAll("#registerBtnEmp")).click(function () {
    checaEmail();
    checaCPNJ();
    checaCEP();
    if (checaNomeEmpresa()) {
        if (checaSenhaEmpresa()) {
            if (checaEmail()) {
                if (checaCPNJ()) {
                    if (checaCEP()) {
                        criarEmpresa();
                        $(registerEmpresa).hide();
                    }
                    else {
                        window.alert("Insira CEP válido");
                    }
                }
                else {
                    window.alert("Insira CNPJ válido");
                }
            }
            else {
                window.alert("Insira Email válido");
            }
        }
    }
});
$(document.querySelectorAll("#registerBtnCand")).click(function () {
    checaCpf();
    checaTelefone();
    checaLink();
    checaEmailCand();
    if (checaEmailCand()) {
        if (checaCpf()) {
            if (checaTelefone()) {
                if (checaLink()) {
                    if (checaNomeCandidato()) {
                        if (checaSenhaCandidato()) {
                            criarPessoa();
                            $(registerCand).hide();
                        }
                    }
                }
                else {
                    window.alert("Insira um link válido");
                }
            }
            else {
                window.alert("Insira um telefone válido");
            }
        }
        else {
            window.alert("Insira um CPF válido, exemplo: XXX.XXX.XXX-XX");
        }
    }
    else {
        window.alert("Insira um email válido");
    }
});
$(loginBtnEmp).click(function () {
    if (loginEmpresa()) {
        $(document.querySelectorAll(".mainMatchEmpresa")).show();
        $(document.querySelectorAll(".main")).hide();
        $(document.querySelectorAll(".mainCandidatoBox")).hide();
        $(document.querySelectorAll(".heroMatchEmpresa")).show();
        $(document.querySelectorAll(".graficoBox")).hide();
    }
});
$(loginBtnCand).click(function () {
    if (loginCandidato()) {
        $(document.querySelectorAll(".mainCandidatoBox")).show();
        $(document.querySelectorAll(".main")).hide();
        $(document.querySelectorAll(".mainMatchEmpresa")).hide();
        $(document.querySelectorAll(".vagasBox")).show();
    }
});
function criarEmpresa() {
}
function criarPessoa() {
    var nomeCandInput = $('#nomeCand').val();
    var valuePython = $(document.querySelectorAll(".pythonInput")).is(':checked');
    var valueJava = $(document.querySelectorAll(".javaInput")).is(':checked');
    var valueGroovy = $(document.querySelectorAll(".groovyInput")).is(':checked');
    var valueAngular = $(document.querySelectorAll(".angularInput")).is(':checked');
    var newLiTag = "";
    newLiTag = '<ul>\n' +
        '                <li class="candidato">\n' +
        '                    <img src="images/AvatarFunc.png" alt="" class="avatarFunc">\n' +
        '                    <p class="nomeFunc">Anon</p>\n' +
        '                    <ul class="tecnologias" id="tecnologias-cand">\n' +
        '                    </ul>\n' +
        '                    <ul class="likeBox">\n' +
        '                        <img src="images/Like.png" alt="">\n' +
        '                        <img src="images/Deslike.png" alt="">\n' +
        '                        <img src="images/SuperLike.png" alt="">\n' +
        '                    </ul>\n' +
        '                    <p class="descFunc">Descrição</p>\n' +
        '                </li>\n' +
        '            </ul>';
    console.log(nomeCandInput);
    $(document.querySelectorAll(".heroMatchEmpresa")).last().append(newLiTag);
    if (valuePython) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append('                        <li>Python</li>\n');
    }
    if (valueJava) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append('                        <li>Java</li>\n');
    }
    if (valueGroovy) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append('                        <li>Groovy</li>\n');
    }
    if (valueAngular) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append('                        <li>Angular</li>\n');
    }
}
$(document.querySelectorAll(".menu-btn")).click(function () {
    $(document.querySelectorAll('.menuBoxEmpresa')).show();
});
$(document.querySelectorAll(".menuBoxEmpresaClose")).click(function () {
    $(document.querySelectorAll(".menuBoxEmpresa")).hide();
});
$(document.querySelectorAll(".principalEmp")).click(function () {
    $(document.querySelectorAll(".menuBoxEmpresa")).hide();
});
$(document.querySelectorAll(".barraEmp")).click(function () {
    $(document.querySelectorAll(".graficoBox")).show();
    $(document.querySelectorAll(".heroMatchEmpresa")).hide();
    $(document.querySelectorAll(".menuBoxEmpresa")).hide();
    /** GRAFICO DE BARRAS **/
    var temp = $('body').text();
    var countPython = temp.match(/Python/g);
    var countAngular = temp.match(/Angular/g);
    var countGroovy = temp.match(/Groovy/g);
    var countJava = temp.match(/Angular/g);
    var xValues = ["Python", "Angular", "Groovy", "Angular"];
    var yValues = [countPython.length - 2, countAngular.length - 2, countGroovy.length - 2, countJava.length - 2];
    var myChart = new Chart("myChart", {
        type: 'bar',
        data: {
            labels: ["Python", "Angular", "Groovy", "Angular"],
            datasets: [{
                    label: 'Pessoas por competência',
                    data: [countPython.length - 2, countAngular.length - 2, countGroovy.length - 2, countJava.length - 2],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            responsive: false,
            scales: {}
        }
    });
});
$(document.querySelectorAll(".criarVagaEmp")).click(function () {
    $(document.querySelectorAll(".criarVagaBox")).show();
    $(document.querySelectorAll(".menuBoxEmpresa")).hide();
    $(document.querySelectorAll(".graficoBox")).hide();
});
$(document.querySelectorAll(".registrarVaga")).click(function () {
    registroDeVaga();
    if (registroDeVaga()) {
        var valueCandPython = $(document.querySelectorAll(".vagaPython")).is(':checked');
        var valueCandJava = $(document.querySelectorAll(".vagaJava")).is(':checked');
        var valueCandGroovy = $(document.querySelectorAll(".vagaGroovy")).is(':checked');
        var valueCandAngular = $(document.querySelectorAll(".vagaAngular")).is(':checked');
        var nomeVaga = $(document.querySelectorAll(".nomeDaVaga")).val();
        console.log(nomeVaga);
        var newLiTagCand = "";
        newLiTagCand = "<ul id=\"".concat(nomeVaga, "\">\n                <li>\n                    <img src=\"images/empresaAnoni.png\" alt=\"\" class=\"logoEmpresa\">\n                    <p class=\"nomeVaga\">").concat(nomeVaga, "</p>\n                    <p class=\"nomeEmpresa\">Anon</p>\n                    <ul class=\"tecnologias\" id=\"tecnologias-empresa\">\n                    </ul>\n                    <ul class=\"likeBox\">\n                        <img src=\"images/Like.png\" alt=\"\">\n                        <img src=\"images/Deslike.png\" alt=\"\">\n                        <img src=\"images/SuperLike.png\" alt=\"\">\n                    </ul>\n\n                </li>\n            </ul>");
        $(document.querySelectorAll(".vagasBox")).last().append(newLiTagCand);
        if (valueCandPython) {
            $(document.querySelectorAll("#tecnologias-empresa")).last().append('                        <li>Python</li>\n');
        }
        if (valueCandJava) {
            $(document.querySelectorAll("#tecnologias-empresa")).last().append('                        <li>Java</li>\n');
        }
        if (valueCandGroovy) {
            $(document.querySelectorAll("#tecnologias-empresa")).last().append('                        <li>Groovy</li>\n');
        }
        if (valueCandAngular) {
            $(document.querySelectorAll("#tecnologias-empresa")).last().append('                        <li>Angular</li>\n');
        }
        $(document.querySelectorAll(".criarVagaBox")).hide();
        $(document.querySelectorAll(".graficoBox")).hide();
    }
});
$(document.querySelectorAll(".close-button-criar-vaga")).click(function () {
    $(document.querySelectorAll(".criarVagaBox")).hide();
    $(document.querySelectorAll(".heroMatchEmpresa")).show;
    $(document.querySelectorAll(".graficoBox")).hide();
});
$(document.querySelectorAll(".sairEmp")).click(function () {
    $(document.querySelectorAll(".mainMatchEmpresa")).hide();
    $(document.querySelectorAll(".mainCandidatoBox")).hide();
    $(document.querySelectorAll(".main")).show();
    $(document.querySelectorAll(".menuBoxEmpresa")).hide();
});
$(document.querySelectorAll('.registrarVaga, .entrarComoCand, .entrarComoEmpresa, .loginButtonBox a, .loginButtonBoxCandidato a, .register-button, .sairEmp')).click(function () {
    $('input[type="text"]').val('');
    $('input[type="password"]').val('');
    $('input[type=checkbox]').prop('checked', false);
});
$(document.querySelectorAll('.deleteEmp')).click(function () {
    var deleteWord = prompt("Digite a vaga a ser deletada usando apenas letra miniscula: ");
    deleteWord = deleteWord.toLowerCase();
    $(document.querySelectorAll("#".concat(deleteWord))).remove();
    $(document.querySelectorAll('.menuBoxEmpresa')).hide();
    $(document.querySelectorAll(".heroMatchEmpresa")).show();
});
$(document.querySelectorAll("#principalEmp")).click(function () {
    $(document.querySelectorAll('.menuBoxEmpresa')).hide();
    $(document.querySelectorAll(".graficoBox")).hide();
    $(document.querySelectorAll('.heroMatchEmpresa')).show();
    $(document.querySelectorAll(".heroMatchEmpresa")).show();
});
// REGEX
var RegexEmail = new RegExp(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/); // Por algum motivo meus regex não funcionavam de jeito nenhum, então peguei um frankestein da internet e montei
var RegexCPNJ = new RegExp(/^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/);
var RegexCPF = new RegExp(/^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}))$/);
var RegexCep = new RegExp(/^([\d]{2})\.*([\d]{3})-*([\d]{3})/);
var RegexTelefone = new RegExp(/^(?:(?:\+|00)?(55)\s?)?(?:\(?([1-9][0-9])\)?\s?)?(?:((?:9\d|[2-9])\d{3})\-?(\d{4}))$/);
var RegexLinkedin = new RegExp(/((http(s?):\/\/)*([a-zA-Z0-9\-])*\.|[linkedin])[linkedin\/~\-]+\.[a-zA-Z0-9\/~\-_,&=\?\.;]+[^\.,\s<]/);
// VALIDADORES EMPRESA REGISTRO
function checaNomeEmpresa() {
    var nomeDaEmpresa = $(document.querySelector('#nomeEmpresa')).val();
    if (nomeDaEmpresa == "") {
        window.alert("Empresa sem nome");
        return false;
    }
    else {
        return true;
    }
}
function checaSenhaEmpresa() {
    var senhaDaEmpresa = $(document.querySelector('#senhaEmpresa')).val();
    if (senhaDaEmpresa == "") {
        window.alert("Senha vazia");
        return false;
    }
    else {
        return true;
    }
}
function checaEmail() {
    var emailEmpresa = $(document.querySelector('#emailEmpresa')).val();
    return RegexEmail.test(emailEmpresa);
}
function checaCPNJ() {
    var CPNJEmpresa = $(document.querySelector('#cnpjEmpresa')).val();
    return RegexCPNJ.test(CPNJEmpresa);
}
function checaCEP() {
    var cepEmpresa = $(document.querySelector('#cepEmpresa')).val();
    return RegexCep.test(cepEmpresa);
}
// VALIDADOR CANDIDATO REGISTRO
function checaEmailCand() {
    var emailCand = $(document.querySelector('#emailCand')).val();
    return RegexEmail.test(emailCand);
}
function checaCpf() {
    var cpfCand = $(document.querySelector('#cpfCand')).val();
    return RegexCPF.test(cpfCand);
}
function checaTelefone() {
    var telefoneCand = $(document.querySelector('#telefoneCand')).val();
    return RegexTelefone.test(telefoneCand);
}
function checaLink() {
    var linkCand = $(document.querySelector('#linkedinCand')).val();
    return RegexLinkedin.test(linkCand);
}
//Login Empresa
function loginEmpresa() {
    var loginEmpresa = $(document.querySelector("#loginEmpresa")).val();
    var senhaEmpresa = $(document.querySelector('#senhaLoginEmpresa')).val();
    if (loginEmpresa == "") {
        window.alert("Login Vazio");
        return false;
    }
    if (senhaEmpresa == "") {
        window.alert("Senha vazia");
        return false;
    }
    if (RegexEmail.test(loginEmpresa)) {
        return true;
    }
    else {
        window.alert("Login Inválido");
        return false;
    }
}
//Login Candidato
function checaNomeCandidato() {
    var nomeDaCandidato = $(document.querySelector('#nomeCand')).val();
    if (nomeDaCandidato == "") {
        window.alert("Candidato sem nome");
        return false;
    }
    else {
        return true;
    }
}
function checaSenhaCandidato() {
    var Senhadocandidato = $(document.querySelector('#senhaCand')).val();
    if (Senhadocandidato == "") {
        window.alert("Candidato sem senha");
        return false;
    }
    else {
        return true;
    }
}
function loginCandidato() {
    var loginCandidato = $(document.querySelector("#loginCandidato")).val();
    var senhaCandidato = $(document.querySelector('#SenhaLoginCandidato')).val();
    if (loginCandidato == "") {
        window.alert("Login Vazio");
        return false;
    }
    if (senhaCandidato == "") {
        window.alert("Senha vazia");
        return false;
    }
    if (RegexEmail.test(loginCandidato)) {
        return true;
    }
    else {
        window.alert("Login inválido");
        return false;
    }
}
// Campos vazios
function registroDeVaga() {
    var nomeDaVaga = $(document.querySelector('.nomeDaVaga')).val();
    if (nomeDaVaga == "") {
        window.alert("Vaga sem nome");
        return false;
    }
    else {
        return true;
    }
}
