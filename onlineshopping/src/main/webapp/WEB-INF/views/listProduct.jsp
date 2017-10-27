<div class="container">
	<div class="row">
		<div class="col-md-3">

			<!--Would be to display side bar-->
			<%@include file="./shared/sidebar.jsp"%>
		</div>



		<!--To display the actual products-->
		<div class="col-md-9">

			<!-- Added bread crumb component  -->
			<div class="row">
				<div class="col-lg-12">


					<c:if test="${userClickShowAllProducts==true }">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="Active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickShowCategoryProducts==true }">

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="Active">Category</li>
							<li class="Active">${category.name }</li>
						</ol>
					</c:if>

				</div>
			</div>

		</div>
	</div>

</div>