
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			<c:url value="/home/" var="home" />
			<li><a href="${home}"><i class="fa fa-dashboard fa-fw"></i>Tableau de bord</a></li>
			<c:url value="/article/" var="article" />
			<li><a href="${article}"><i class="fa fa-dashboard fa-fw"></i>Articles</a></li>
			<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
					Clients<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:url value="/client/" var="client" />
					<li><a href="${client}">Clients</a></li>
					<c:url value="/commandeClient/" var="cdeClient" />
					<li><a href="${cdeClient}">Commandes clients</a></li>
				</ul> <!-- /.nav-second-level -->
			</li>
			<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
					Fournisseurs<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:url value="/fournisseur/" var="fournisseur" />
					<li><a href="${fournisseur}">Fournisseurs</a></li>
					<c:url value="/commandeFournisseur/" var="commandeFournisseur" />
					<li><a href="${commandeFournisseur}">Commandes fournisseurs</a></li>
				</ul> <!-- /.nav-second-level -->
			</li>
			<c:url value="/stock/" var="stock" />
			<li><a href="${stock}"><i class="fa fa-dashboard fa-fw"></i>Stock</a></li>
			<c:url value="/vente/" var="vente" />
			<li><a href="${vente}"><i class="fa fa-dashboard fa-fw"></i>Ventes</a></li>
			<li><a href="#"><i class="fa fa-wrench fa-fw"></i>Paramtétrage<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/utilisateur/" var="user" />
					<li><a href="${user}">Utilisateurs</a></li>
				<c:url value="/category/" var="category" />
					<li><a href="${category}">Catégorie</a></li>
				</ul> <!-- /.nav-second-level -->
			</li>

			
			
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>