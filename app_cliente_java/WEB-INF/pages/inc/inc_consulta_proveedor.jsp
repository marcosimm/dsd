<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main">
	<div class="main-inner">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div class="widget widget-nopad">
						<div class="widget-header">
							<i class="icon-list-alt"></i>
							<h3>Consultar Proveedor</h3>
						</div>
						<!-- /widget-header -->
						<div class="widget-content">
							<div class="widget big-stats-container">
								<div class="widget-content">
									<div class="account-container register">

										<div class="content clearfix">
										
										
											<form action="SRedirecciona?go=2" id="frm_req" name="frm_req" method="post">
												<div class="login-fields">
													<div class="row">
													  <div class="span2">RUC de la empresa</div>
													  <div class="span3"><input type="text" id="ruc" name="ruc" value="${datosSunat.ruc}" placeholder="" /></div>
													  <div class="span2"><button type="submit" class="btn btn-primary">Buscar</button></div>
													</div> 
													<!-- /field -->
												</div>
												<!-- /login-fields -->
												<br>

												<div class="panel panel-default">
													<div class="panel-heading">
														<h3>Datos SUNAT</h3>
													</div>
													<div class="panel-body">
													
														<div class="row">
														  <div class="span2" style="font-weight: bold;" >Razon Social</div>
														  <div class="span4">${datosSunat.razonsocial}</div>
														</div>
														<div class="row">
														  <div class="span2" style="font-weight: bold;">Tipo Contribuyente</div>
														  <div class="span4">${datosSunat.tipo}</div>
														</div>
														<div class="row">
														  <div class="span2" style="font-weight: bold;">Fecha de Insripcion</div>
														  <div class="span4">${datosSunat.fechains}</div>
														</div>
														<div class="row">
														  <div class="span2" style="font-weight: bold;">Condicion Contribuyente</div>
														  <div class="span4">${datosSunat.condicion}</div>
														</div>
														<div class="row">
														  <div class="span2" style="font-weight: bold;">Estado de Contribuyente</div>
														  <div class="span4">${datosSunat.estado}</div>
														</div>
														<div class="row">
														  <div class="span2" style="font-weight: bold;">Dirección</div>
														  <div class="span6">${datosSunat.direccion}</div>
														</div>
														<div class="row">
														  <div class="span2" style="font-weight: bold;">Telefonos</div>
														  <div class="span4">${datosSunat.telefono1} &nbsp; | &nbsp; Anexo: &nbsp; ${datosSunat.anexo1}</div>
														</div>
														<br>
														<div class="panel-heading">
															<h3>Representates Legales</h3>
														</div>
														
														<div id="grid2">
															<table width="100%"
																style="border: 1px solid #CCCCCC; background: white"
																class="table">
																<thead>
																	<tr>
																		<th>Documento</th>
																		<th>Nro Documento</th>
																		<th>Nombre</th>
																		<th>Cargo</th>
																		<th>Fecha</th>
																	</tr>
																</thead>
																
																<c:forEach items="${datosSunat.represetantes}" varStatus="i" var="rep" >
																	<tr>
																		<td>${rep.documento}</td>
																		<td>${rep.numero}</td>
																		<td>${rep.nombre}</td>
																		<td>${rep.cargo}</td>
																		<td>${rep.fechadesde}</td>
																	</tr>
																</c:forEach>
															</table>
														</div>
													</div>
													
													<div class="panel-heading">
														<h3>Datos ADUANAS</h3>
													</div>
													<div class="row">
													  <div class="span2" style="font-weight: bold;">Estado</div>
													  <div class="span4">-</div>
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