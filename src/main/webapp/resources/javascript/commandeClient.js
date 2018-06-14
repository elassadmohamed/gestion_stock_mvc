function updateDetailCommande(data){
	detailHtml="";
	$.each(data,function(d,e){
		detailHtml+="<tr><td>"+e.idLigneCdeClt+"</td><td>"+e.quantite+"</td><td>"+e.prixUniaitre+"</td><td>"+(e.quantite*e.prixUniaitre)+"</td>";
		//console.log(d+" # "+e.quantite);
	});	
	$("#tableDetailCommande tbody").html(detailHtml);
}


$(document).ready(function(){
	$("#codeArticle_search").on("keypress",function(e){
		
		if(e.which=='13'){
			var codeArticle=$("#codeArticle_search").val();
			if(codeArticle){
				searchArticle(codeArticle);
			}
		}
	})
})



function searchArticle(codeArticle){
	
	detailHtml="";
	if(codeArticle){
		$.getJSON("detailArticle",
			{
				codeArticle:codeArticle,
				ajax:true
			},
			function(data){
					if(data){
						detailHtml+="<tr><td>"+data.codeArticle+"</td><td>1</td><td>"+e.prixUnitaireTTC+"</td><td>0</td>";
						$("#tableDetailNouvelleCommande tbody").html(detailHtml);
					}
			}
		);
	}
	
}