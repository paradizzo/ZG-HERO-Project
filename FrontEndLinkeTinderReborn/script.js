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
    $(registerEmpresa).hide();
    criarEmpresa();
});
$(document.querySelectorAll("#registerBtnCand")).click(function () {
    $(registerCand).hide();
    criarPessoa();
});
$(loginBtnEmp).click(function () {
    $(document.querySelectorAll(".mainMatchEmpresa")).show();
    $(document.querySelectorAll(".main")).hide();
    $(document.querySelectorAll(".mainCandidatoBox")).hide();
    $(document.querySelectorAll(".heroMatchEmpresa")).show();
    $(document.querySelectorAll(".graficoBox")).hide();
});
$(loginBtnCand).click(function () {
    $(document.querySelectorAll(".mainCandidatoBox")).show();
    $(document.querySelectorAll(".main")).hide();
    $(document.querySelectorAll(".mainMatchEmpresa")).hide();
    $(document.querySelectorAll(".vagasBox")).show();
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
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
});
$(document.querySelectorAll(".criarVagaEmp")).click(function () {
    $(document.querySelectorAll(".criarVagaBox")).show();
    $(document.querySelectorAll(".menuBoxEmpresa")).hide();
    $(document.querySelectorAll(".graficoBox")).hide();
});
$(document.querySelectorAll(".registrarVaga")).click(function () {
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
    var deleteWord = prompt("Digite a vaga a ser deletada usando apenas letras miniscúlas: ");
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
