<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>

			<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h6 class="page-header">Article</h6>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<c:url value="/article/nouveau" var="urlNouveau" scope="page" />
								<li class="breadcrumb-item"><a href="${urlNouveau}"
									class="fa fa-plus">&nbsp;Ajouter</a></li>
								<li class="breadcrumb-item"><a href="#"
									class="fa fa-download">&nbsp;Exporter</a></li>
								<li class="breadcrumb-item active"><a href="#"
									class="fa fa-upload">&nbsp;Importer</a></li>
							</ol>
						</nav>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">DataTables Advanced Tables</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<table width="100%"
									class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Code article</th>
											<th>Désignation</th>
											<th>Prix unitaire HT</th>
											<th>Taux TVA</th>
											<th>Prix unitaire TTC</th>
											<th>action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${articles}" var="article">
											<tr class="odd gradeX">
												<td class="center"><img src="${article.getCodeArticle()}" width="50px" height="50px"></td>
												<td>${article.getDesignation()}</td>
												<td>${article.getPrixUnitaireHT() }</td>
												<td class="center">${article.getTauxTva()}</td>
												<td>${article.getPrixUnitaireTTC()}</td>
												<td>
													<c:url value="/article/modifier/${article.getIdArticle()}" var="urlModif" /> 
													<a href="${urlModif}" class="fa fa-edit">&nbsp;Modifier</a>
													&nbsp;|&nbsp; 
													<a href="javascript:void(0);" class="fa fa-trash" data-toggle="modal" data-target="#modalArticle${article.getIdArticle() }">&nbsp;Supprimer</a>
													<div class="modal fade" id="modalArticle${article.getIdArticle() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																	<h4 class="modal-title" id="myModalLabel">Modal title</h4>
																</div>
																<div class="modal-body">Confirmation</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
																	<c:url value="/article/supprimer/${article.getIdArticle()}" var="urlSuppression" />"
																	<a href="${urlSuppression }" class="btn btn-primary">
																		<i class="fa fa-trash"></i>&nbsp;Confirmer
																	</a>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog -->
													</div> <!-- /.modal --></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<!-- /.table-responsive -->
								<div class="well">
									<h4>DataTables Usage Information</h4>
									<p>
										DataTables is a very flexible, advanced tables plugin for
										jQuery. In SB Admin, we are using a specialized version of
										DataTables built for Bootstrap 3. We have also customized the
										table headings to use Font Awesome icons in place of images.
										For complete documentation on DataTables, visit their website
										at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.
									</p>
									<a class="btn btn-default btn-lg btn-block" target="_blank"
										href="https://datatables.net/">View DataTables
										Documentation</a>
								</div>
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>


</body>

</html>

