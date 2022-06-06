$(document).ready(function () {
    $(".container").click(function () {
        $(".stick").toggleClass(function () {
            return $(this).is('.open, .close') ? 'open close' : 'open';
        });
    });
    $(".candidato").click(function () {
        var formacaoCandidato = $(this).children(".formacao-candidato").text();
        var descricaoCandidato = $(this).children(".descricao-candidato").text();
        $('.formacao-candidato-descricao').text(formacaoCandidato);
        $('.descricao-candidato-box').children('p').text(descricaoCandidato);
    });
    $(document).ready(function () {
        var progress = $('.progressbar .progress');
        // Ele checa a totalidade de skills e declaração de variaveis
        var angularCount = 0;
        var javaCount = 0;
        var groovyCount = 0;
        var pythonCount = 0;
        var typeScriptCount = 0;
        // @ts-ignore
        var arraySkills = Array.from($('.skills'), function (e) { return e.innerText; });
        var totalSkills = $('.skills').length;
        // Ele faz a contagem geral no documento e adiciona ao contador
        arraySkills.forEach(function (element) {
            if (element === "Angular") {
                angularCount += 1;
            }
            else if (element === "Java") {
                javaCount += 1;
            }
            else if (element === "Groovy") {
                groovyCount += 1;
            }
            else if (element === 'Python') {
                pythonCount += 1;
            }
            else if (element === "TypeScript") {
                typeScriptCount += 1;
            }
        });
        function counterInit(count, name) {
            var counter_value = (count / totalSkills) * 200;
            $('.bracket-box').append(" <li class=\"bracket-skills\">\n                            <p class=\"count-skills\">".concat(name, "</p>\n                        <div class=\"progressbar\">\n                            <span class=\"progress\" id='").concat(name, "'></span>\n                        </div>\n                            <p class=\"count-skills\">Quantidade: ").concat(count, "</p>\n                    </li>"));
            var nomeReal = $('#' + name);
            nomeReal.css({ 'width': counter_value });
        }
        counterInit(angularCount, "Angular");
        counterInit(javaCount, "Java");
        counterInit(groovyCount, "Groovy");
        counterInit(pythonCount, "Python");
        counterInit(typeScriptCount, "Typescript");
    });
});
