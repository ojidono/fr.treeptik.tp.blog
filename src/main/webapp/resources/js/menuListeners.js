
$(function(){
    listes.fillListNav('#nav-articles', {Categories: listes.handler.categoryNav,Authors: listes.handler.authorNav});
    loadList(listes.handler.articleFull);
    
    $("#articleAllLink").click(function() {
        loadList(listes.handler.articleFull);
    });

    $('#authorAllLink').click(function() {
        loadList(listes.handler.authorFull);
    });

    $('#commentAllLink').click(function() {
        loadList(listes.handler.commentFull);
    });

    $('#categoryAllLink').click(function() {
        loadList(listes.handler.categoryFull);
    });
});

function loadList(handler) {
    var cible = "#list";
    $( cible ).empty();
    listes.fillList( cible , handler );
};
function loadListWithDetail ( handler , detail ){
    var temp = handler.url; 
    handler.url += detail;
    loadList(handler);
    handler.url = temp;
};