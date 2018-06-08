function updateDetailCommande(data){
	detailHtml="";
	$.each(data,function(d,e){
		detailHtml+="<tr><td>"+e.idLigneCdeClt+"</td><td>"+e.quantite+"</td><td>"+e.prixUniaitre+"</td><td>"+(e.quantite*e.prixUniaitre)+"</td>";
		//console.log(d+" # "+e.quantite);
	});	
	$("#tableDetailCommande tbody").html(detailHtml);
}
