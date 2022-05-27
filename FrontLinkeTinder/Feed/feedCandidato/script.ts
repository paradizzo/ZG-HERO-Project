$(document).ready(function() {
    $(".container").click(function() {
        $(".stick").toggleClass(function () {
            return $(this).is('.open, .close') ? 'open close' : 'open';
        });
    });

    $(".vaga").click(function (){
        let localVaga = $(this).children('.vaga-content').children(".local-vaga").text()
        let salarioVaga = $(this).children('.vaga-content').children(".salario-vaga").text()

        $('.vaga-content-descricao')
        $('.titulo-desc').text(localVaga)
        $('.valor-desc').text(salarioVaga)
    })


});
