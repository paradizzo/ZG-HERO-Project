import $ = require("jquery");
import {  Chart, ChartType} from 'chart.js';


const btnEntrarEmpresa = document.querySelectorAll(".entrarComoEmpresa")
const  btnEntrarCand = document.querySelectorAll(".entrarComoCand")
const loginAreaEmpresa = document.querySelectorAll(".wraperLoginBoxEmpresa")
const loginAreaCandi = document.querySelectorAll(".wraperLoginBoxCandidato")
const RegisterButtonEmpresa = document.querySelectorAll("#register-empresa")
const registerButtonCand = document.querySelectorAll("#register-cand")
const registerEmpresa = document.querySelectorAll(".registerEmpresa")
const registerCand = document.querySelectorAll(".registerCandidato")
const closeBtnEmp = document.querySelectorAll(".registerEmpresa img")
const closeBtnCand = document.querySelectorAll(".registerCandidato img")
const  loginBtnEmp = document.querySelectorAll(".loginButtonBox a")
const  loginBtnCand = document.querySelectorAll(".loginButtonBoxCandidato a ")

$( btnEntrarEmpresa ).click(function() {
    $(loginAreaEmpresa).show();
    $(loginAreaCandi).hide();
});
$( btnEntrarCand ).click(function() {
    $(loginAreaEmpresa).hide();
    $(loginAreaCandi).show();
});

$(registerButtonCand).click(function () {
    $(registerCand).show()
})
$(RegisterButtonEmpresa).click(function () {
    $(registerEmpresa).show()
})

$(closeBtnCand).click(function (){
    $(registerCand).hide()
})
$(closeBtnEmp).click(function (){
    $(registerEmpresa).hide()
})

// BOTOES DE REGISTRO
$(document.querySelectorAll("#registerBtnEmp")).click(function (){
    $(registerEmpresa).hide()
    criarEmpresa()
})
$(document.querySelectorAll("#registerBtnCand")).click(function (){
    $(registerCand).hide()
    criarPessoa()
})

$(loginBtnEmp).click(function (){
    $(document.querySelectorAll(".mainMatchEmpresa")).show()
    $(document.querySelectorAll(".main")).hide()
    $(document.querySelectorAll(".mainCandidatoBox")).hide()
    $(document.querySelectorAll(".heroMatchEmpresa")).show()
    $(document.querySelectorAll(".graficoBox")).hide()


})
$(loginBtnCand).click(function (){
    $(document.querySelectorAll(".mainCandidatoBox")).show()
    $(document.querySelectorAll(".main")).hide()
    $(document.querySelectorAll(".mainMatchEmpresa")).hide()
    $(document.querySelectorAll(".vagasBox")).show()

})
function criarEmpresa(){

}
function criarPessoa() {
    let nomeCandInput = $('#nomeCand').val();
    let valuePython = $(document.querySelectorAll(".pythonInput")).is(':checked')
    let valueJava = $(document.querySelectorAll(".javaInput")).is(':checked')
    let valueGroovy = $(document.querySelectorAll(".groovyInput")).is(':checked')
    let valueAngular = $(document.querySelectorAll(".angularInput")).is(':checked')
    let newLiTag = "";
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
        '            </ul>'
    console.log(nomeCandInput)

    $(document.querySelectorAll(".heroMatchEmpresa")).last().append(newLiTag)
    if (valuePython) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append(
            '                        <li>Python</li>\n'
        )
    }
    if (valueJava) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append(
            '                        <li>Java</li>\n'
        )
    }
    if (valueGroovy) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append(
            '                        <li>Groovy</li>\n'
        )
    }
    if (valueAngular) {
        $(document.querySelectorAll("#tecnologias-cand")).last().append(
            '                        <li>Angular</li>\n'
        )
    }


}

$(document.querySelectorAll(".menu-btn")).click(function (){
    $(document.querySelectorAll('.menuBoxEmpresa')).show()
})
$(document.querySelectorAll(".menuBoxEmpresaClose")).click(function (){
  $(document.querySelectorAll(".menuBoxEmpresa")).hide()
})
$(document.querySelectorAll(".principalEmp")).click(function (){
    $(document.querySelectorAll(".menuBoxEmpresa")).hide()
})
$(document.querySelectorAll(".barraEmp")).click(function (){
    $(document.querySelectorAll(".graficoBox")).show()
    $(document.querySelectorAll(".heroMatchEmpresa")).hide()
    $(document.querySelectorAll(".menuBoxEmpresa")).hide()
    /** GRAFICO DE BARRAS **/

    var temp = $('body').text();
    var countPython = temp.match(/Python/g);
    var countAngular = temp.match(/Angular/g);
    var countGroovy = temp.match(/Groovy/g);
    var countJava = temp.match(/Angular/g);
    var xValues = ["Python", "Angular", "Groovy", "Angular"];
    var yValues = [countPython.length-2, countAngular.length-2, countGroovy.length-2, countJava.length-2];


    var myChart = new Chart("myChart", {
        type: 'bar',
        data: {
            labels: ["Python", "Angular", "Groovy", "Angular"],
            datasets: [{
                label: 'Pessoas por competência',
                data: [countPython.length-2, countAngular.length-2, countGroovy.length-2, countJava.length-2],
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
            }
        }
    });
})
$(document.querySelectorAll(".criarVagaEmp")).click(function () {
    $(document.querySelectorAll(".criarVagaBox")).show()

    $(document.querySelectorAll(".menuBoxEmpresa")).hide()
    $(document.querySelectorAll(".graficoBox")).hide()

})
$(document.querySelectorAll(".registrarVaga")).click(function (){
    let valueCandPython = $(document.querySelectorAll(".vagaPython")).is(':checked')
    let valueCandJava = $(document.querySelectorAll(".vagaJava")).is(':checked')
    let valueCandGroovy = $(document.querySelectorAll(".vagaGroovy")).is(':checked')
    let valueCandAngular = $(document.querySelectorAll(".vagaAngular")).is(':checked')
    let nomeVaga = $(document.querySelectorAll(".nomeDaVaga")).val()
    console.log(nomeVaga)
    let newLiTagCand = "";
    newLiTagCand = `<ul id=\"${nomeVaga}\">\n                <li>\n                    <img src=\"images/empresaAnoni.png\" alt=\"\" class=\"logoEmpresa\">\n                    <p class=\"nomeVaga\">${nomeVaga}</p>\n                    <p class=\"nomeEmpresa\">Anon</p>\n                    <ul class=\"tecnologias\" id=\"tecnologias-empresa\">\n                    </ul>\n                    <ul class=\"likeBox\">\n                        <img src=\"images/Like.png\" alt=\"\">\n                        <img src=\"images/Deslike.png\" alt=\"\">\n                        <img src=\"images/SuperLike.png\" alt=\"\">\n                    </ul>\n\n                </li>\n            </ul>`
    $(document.querySelectorAll(".vagasBox")).last().append(newLiTagCand)
    if (valueCandPython) {
        $(document.querySelectorAll("#tecnologias-empresa")).last().append(
            '                        <li>Python</li>\n'
        )
    }
    if (valueCandJava) {
        $(document.querySelectorAll("#tecnologias-empresa")).last().append(
            '                        <li>Java</li>\n'
        )
    }
    if (valueCandGroovy) {
        $(document.querySelectorAll("#tecnologias-empresa")).last().append(
            '                        <li>Groovy</li>\n'
        )
    }
    if (valueCandAngular) {
        $(document.querySelectorAll("#tecnologias-empresa")).last().append(
            '                        <li>Angular</li>\n'
        )
    }
    $(document.querySelectorAll(".criarVagaBox")).hide()
    $(document.querySelectorAll(".graficoBox")).hide()
})
$(document.querySelectorAll(".close-button-criar-vaga")).click(function (){
    $(document.querySelectorAll(".criarVagaBox")).hide()
    $(document.querySelectorAll(".heroMatchEmpresa")).show
    $(document.querySelectorAll(".graficoBox")).hide()

})
$(document.querySelectorAll(".sairEmp")).click(function (){
    $(document.querySelectorAll(".mainMatchEmpresa")).hide()
    $(document.querySelectorAll(".mainCandidatoBox")).hide()
    $(document.querySelectorAll(".main")).show()
    $(document.querySelectorAll(".menuBoxEmpresa")).hide()

})
$(document.querySelectorAll('.registrarVaga, .entrarComoCand, .entrarComoEmpresa, .loginButtonBox a, .loginButtonBoxCandidato a, .register-button, .sairEmp')).click(function (){
    $('input[type="text"]').val('');
    $('input[type="password"]').val('');
    $('input[type=checkbox]').prop('checked', false);
})
$(document.querySelectorAll('.deleteEmp')).click(function () {
    let deleteWord = prompt(`Digite a vaga a ser deletada usando apenas letra miniscula: `)
    deleteWord = deleteWord.toLowerCase()
    $(document.querySelectorAll(`#${deleteWord}`)).remove()
    $(document.querySelectorAll('.menuBoxEmpresa')).hide()
    $(document.querySelectorAll(".heroMatchEmpresa")).show()


})
$(document.querySelectorAll("#principalEmp")).click(function () {
    $(document.querySelectorAll('.menuBoxEmpresa')).hide()
    $(document.querySelectorAll(".graficoBox")).hide()
    $(document.querySelectorAll('.heroMatchEmpresa')).show()
    $(document.querySelectorAll(".heroMatchEmpresa")).show()

})





