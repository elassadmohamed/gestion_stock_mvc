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
						<h6 class="page-header">Nouvel article</h6>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">DataTables Advanced Tables</div>
							<!-- /.panel-heading -->
							<c:url value="/article/enregistrer" var="urlEnregister"
								scope="page" />
							<f:form modelAttribute="article"
								action="/mvc/article/enregistrer" method="post" role="form">
								<f:hidden path="idArticle" />
								<div class="panel-body">
									<div class="form-group">
										<label>Code article</label>
										<f:input path="codeArticle" class="form-control"
											placeHolder="Code article" />
									</div>
									<div class="form-group">
										<label>Désignation</label>
										<f:input path="designation" class="form-control"
											placeHolder="Désignation" />
									</div>
									<div class="form-group">
                                            <label>Catégories</label>
                                            <f:select class="form-control" path="category.idCategory" items="${categories}" itemLabel="Code" itemValue="idCategory" />
                                        </div>
									<div class="form-group">
										<label>Prix unitaire HT</label>
										<f:input path="prixUnitaireHT" class="form-control"
											placeHolder="Prix unitaire HT" />
									</div>
									<div class="form-group">
										<label>Taux TVA</label>
										<f:input path="tauxTva" class="form-control"
											placeHolder="Taux TVA" />
									</div>
									<div class="form-group">
										<label>Prix unitaire TTC</label>
										<f:input path="prixUnitaireTTC" class="form-control"
											placeHolder="Prix unitaire TTC" />
									</div>
	
								</div>
								<div class="panel-footer">
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-save">&nbsp;Enregistrer</i>
									</button>
									<a href="<c:url value="article"/>" class="btn btn-danger"><i
										class="fa fa-arrow-left">&nbsp;Annuler</i></a>
								</div>
							</f:form>
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

</body>

</html>
