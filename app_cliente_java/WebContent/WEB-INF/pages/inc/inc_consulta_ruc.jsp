<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main">
	<div class="main-inner">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div class="widget widget-nopad">
						<div class="widget-header">
							<i class="icon-list-alt"></i>
							<h3>Consultar Por RUC</h3>
						</div>
						<!-- /widget-header -->
						<div class="widget-content">
							<div class="widget big-stats-container">
								<div class="widget-content">
									<div class="account-container register">

										<div class="content clearfix">
										
										
											<form action="SRedirecciona?go=4" id="frm_req" name="frm_req" method="post">
												<div class="login-fields">
													<div class="row">
													  <div class="span2">RUC de la empresa</div>
													  <div class="span3"><input type="text" id="ruc" name="ruc" value="${ruc}" placeholder="" /></div>
													  <div class="span2"><button type="submit" class="btn btn-primary">Buscar</button></div>
													</div> 
													<!-- /field -->
												</div>
												<!-- /login-fields -->
												<br>

												<div class="panel panel-default">
													<div class="panel-heading">
														<h3>Datos Central de Riesgos</h3>
													</div>
													<div class="panel-body">
														<div id="grid2">
															<table width="100%"
																style="border: 1px solid #CCCCCC; background: white"
																class="table">
																<thead>
																	<tr>
																		<th>Items</th>
																		<th>Score</th>
																		<th>Monto Total</th>
																		<th>Variacion</th>
																		<th>Actual</th>
																		<th>6 Meses</th>
																		<th>12 Meses</th>
																	</tr>
																</thead>
																<c:set var="sum" value="0"></c:set>
																<c:forEach items="${lstRiesgoDTO}" varStatus="i" var="r" >
																	<tr>
																		<td>${r.item}</td>
																		<td align="center">${r.score}</td>
																		<td align="center">${r.montoTotal}</td>
																		<td align="center">
																			<c:if test="${r.variacion eq 1}">Positiva</c:if>
																			<c:if test="${r.variacion eq 0}">Negativa</c:if>
																		</td>
																		<td align="center">
																			<img alt="" src="${pageContext.request.contextPath}/img/bullet/${r.actual}.png">
																		</td>
																		<td align="center">
																			<img alt="" src="${pageContext.request.contextPath}/img/bullet/${r.semestre}.png">
																		</td>
																		<td align="center">
																			<img alt="" src="${pageContext.request.contextPath}/img/bullet/${r.anual}.png">
																		</td>
																	</tr>
																	<c:if test="${sum eq 0}">
																		<c:if test="${r.score  gt 0}">
																			<c:set var="sum" value="${sum+1}"></c:set>
																		</c:if>
																		<c:if test="${r.actual  ne 'V'}">
																			<c:set var="sum" value="${sum+1}"></c:set>
																		</c:if>
																		<c:if test="${r.semestre  ne 'V'}">
																			<c:set var="sum" value="${sum+1}"></c:set>
																		</c:if>
																		<c:if test="${r.anual  ne 'V'}">
																			<c:set var="sum" value="${sum+1}"></c:set>
																		</c:if>
																	</c:if>
																</c:forEach>
															</table>
														</div>
													</div>
													
													<div class="panel-heading">
														<h3>Situación</h3>
													</div>
													<div class="row">
													  <div class="span2" style="font-weight: bold;">Estado</div>
													  <div class="span4">
													  	<c:if test="${!empty ruc}">
														  	<c:if test="${sum eq 0}">Posible Exportador</c:if>
														  	<c:if test="${sum ne 0}">Exportador no favorable</c:if>
													  	</c:if>
													  </div>
													</div>
												</div>
												</form>
												<!-- .actions -->
										</div>
										<!-- /content -->

									</div>
									<!-- /account-container -->

								</div>
								<!-- /widget-content -->

							</div>
						</div>
					</div>
					<!-- /widget -->
					<!-- /widget -->
					<!-- /widget -->
				</div>
				<!-- /span6 -->
				<!-- /span6 -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /main-inner -->
</div>
<script type="text/javascript">
function newServer(){
	document.location.href='SRedirecciona?go=3&proyecto='+$("#proyecto").val();
}
function quitarServer(id){
	if(confirm("Are you sure to remove this server?")){
		document.location.href='SRedirecciona?go=6&id='+id;	
	}
}
function editarServer(id){
	document.location.href='SRedirecciona?go=7&id='+id;	
}
function grabarRequerimiento(){
	if(confirm("Are you sure to add the server (s)?")){
		$.ajax({
  		  type: "POST",
  		  url: "SRedirecciona?go=8",
  		  data: $( "#frm_req" ).serialize(),
  		  success: function(data) {
  			  if(data == "1"){
  				  document.location.href="SRedirecciona?go=1";
  			  }else{
  				  alert(data);
  			  }
  		  	}
  		});
	}
}
function procesarRequerimiento(){
	if(confirm("Are you sure to process this request?")){
		document.location.href='SRedirecciona?go=12&id=${requerimiento.id}';	
	}
}
</script>