var listes = {
    handler: {
     //Content
		articleFull: {
			url:				"article/list/all",
			prefixe:		"<table class=\"table table-striped table-bordered table-hover table-condensed\"><tbody>",
			suffixe:		"</tbody></table>",
			ligne:			function (value){		return "<tr><td><a href=\"article/detail/"+value.id+"\">"+value.title+"</a><br/><p>"+(value.subTitle!=null?value.subTitle:'')+"</p></td></tr>";	}
		},
		articleByCategory: {
			url:				"article/list/category/",
			prefixe:		"<table class=\"table table-striped table-bordered table-hover table-condensed\"><tbody>",
			suffixe:		"</tbody></table>",
			ligne:			function (value){		return "<tr><td><a href=\"article/detail/"+value.id+"\">"+value.title+"</a><br/><p>"+(value.subTitle!=null?value.subTitle:'')+"</p></td></tr>";	}
		},
		articleByAuthor: {
			url:				"article/list/author/",
			prefixe:		"<table class=\"table table-striped table-bordered table-hover table-condensed\"><tbody>",
			suffixe:		"</tbody></table>",
			ligne:			function (value){		return "<tr><td><a href=\"article/detail/"+value.id+"\">"+value.title+"</a><br/><p>"+(value.subTitle!=null?value.subTitle:'')+"</p></td></tr>";	}
		},
		authorFull: {
			url:				"author/list/all",
			prefixe:		"<table class=\"table table-striped table-bordered table-hover table-condensed\"><tbody>",
			suffixe:		"</tbody></table>",
			ligne:			function (value){		return "<tr><td><a href=\"author/detail/"+value.id+"\">"+value.firstName+" "+value.lastName+"</a></td></tr>";	}
		},
		categoryFull: {
			url:				"category/list/all",
			prefixe:		"<table class=\"table table-striped table-bordered table-hover table-condensed\"><tbody>",
			suffixe:		"</tbody></table>",
			ligne:			function (value){		return "<tr><td><a href=\"category/detail/"+value.id+"\">"+value.name+"</a></td></tr>";	}
		},
		commentFull: {
			url:				"comment/list/all",
			prefixe:		"<table class=\"table table-striped table-bordered table-hover table-condensed\"><tbody>",
			suffixe:		"</tbody></table>",
			ligne:			function (value){		return "<tr><td><a href=\"comment/detail/"+value.id+"\">"+value.name+"</a><br/><p>"+(value.content!=null?value.content:'')+"</p></td></tr>";	}
		},
        
     //Navigation 
		authorNav: {
			url:				"author/list/all",
			prefixe:		"<li role=\"presentation\">",
			suffixe:		"</li>",
            ligne:			function (value){		return "<a role=\"menuitem\" href=\"#\" onclick=\"loadListWithDetail( listes.handler.articleByAuthor , "+value.id+")\">"+value.firstName+" "+value.lastName+'</a>';	}
		},
		categoryNav: {
			url:				"category/list/all",
			prefixe:		"<li role=\"presentation\">",
			suffixe:		"</li>",
			ligne:			function (value){		return "<a role=\"menuitem\" href=\"#\" onclick=\"loadListWithDetail( listes.handler.articleByCategory , "+value.id+")\">"+value.name+'</a>';	}
		}
    },

    fillList: function (cible,content,header,footer){
        var lignes= "";
        $.ajax({
            type: "GET",
            url: content.url,
            dataType: "json",
            cache: false,
            contentType: "application/json",
            success: function(data) {
                $.each(data, function(key,value){ lignes +=content.ligne(value);});
                $(cible).append(
                        header,
                        content.prefixe + lignes + content.suffixe,
                        footer
                );
            }
        });
    },
    fillListNav: function (cible,liste){
        var index = 0;
        var size = Object.keys(liste).length;
        $.each(liste, function(key,value){
            listes.fillList(
                    cible, 
                    value, 
                    '<li role=\"presentation\" class=\"dropdown-header\">'+key+'</li>',
                    ++index<size?'<li role="presentation" class="divider"></li>':'');
        });
    }
 };