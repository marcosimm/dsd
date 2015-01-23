<section id="contact-page" class="container">
    <div class="row-fluid">
        <div class="span6">
            <h4>Registro nuevo de usuario</h4>
            <table>
            <form id="frmUsuarioNuevo" name="frmUsuarioNuevo" method="post" action="?c=login&a=registrar">
                    <tr>
                    	<td>
							<label>Nombre completo</label>
		                   	<input type="text" name="txtNombre" id="txtNombre" class="input-block-level" required="required" placeholder="Tu nombre completo">                    		
                    	</td>                    	
                    	<td>
                    		<label>Correo electr&oacute;nico</label>
                    		<input type="email" name="txtCorreo" id="txtCorreo" class="input-block-level" required="required" placeholder="Tu correo electr&oacute;nico">
                    	</td>
                    	<td>
                    		<label>Empresa</label>
                    		<input type="text" name="txtEmpresa" id="txtEmpresa" class="input-block-level" required="required" placeholder="Tu empresa">
                    	</td>                    	
                    </tr>
                    <tr>
                    	<td>
							<label>Clave</label>
                    		<input type="password" name="txtClave" id="txtClave" class="input-block-level" required="required" placeholder="Tu clave de acceso">
                    	<td>
 							<label>Repita Clave</label>
                    		<input type="password" name="txtReClave" id="txtReClave" class="input-block-level" required="required" placeholder=" Repite tu clave">
                    	</td>
                    </tr>
                    <tr>
                    	<td colspan="3">
                         	<input type="submit" name="btnRegistrar" id="btnRegistrar" onclick="return validausuario();" class="btn btn-primary btn-large pull-left" value="Registrar">
                         </td>
                    <tr>
            </form>
            </table>
        </div>
    </div>
</section>